package models;

import play.db.ebean.*;
import play.data.validation.Constraints.*;
import javax.persistence.*;

@Entity
public class User extends Model {

    @Required
    @Id
    public String username;

    @Required
    public String password;

    public String firstName;
    public String lastName;

    public static Finder<String, User> find = new Finder(String.class, User.class);

    public static void create(User user) {
        user.save();
    }

    public static boolean exists(User user) {
        return (find.byId(user.username) != null);
    }

    @Override
    public String toString() {
        return username + ":" + password;
    }
}
