package models;

import play.db.ebean.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;
import java.util.List;

@Entity
public class User extends Model {

    @Required
    @Id
    public String username;

    @Required
    public String password;

    @Required
    public String firstName;

    @Required
    public String lastName;

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    public List<Skill> skills;

    public static Finder<String, User> find = new Finder(String.class, User.class);

    public static void create(User user) {
        user.save();
    }

    public static boolean isUnique(User user) {
        return (find.byId(user.username) == null);
    }

    public static User authenticate(String username, String password) {
        return find.byId(username);
    }

    @Override
    public String toString() {
        return username + ":" + password;
    }
}
