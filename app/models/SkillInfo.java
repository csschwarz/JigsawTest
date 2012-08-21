package models;

import play.db.ebean.Model;
import play.data.validation.Constraints.*;
import javax.persistence.*;
import java.util.List;

@Entity
public class SkillInfo extends Model {

    @Required
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    @Required
    public String name;

    @Required
    public String category;

    public static Finder<Integer, SkillInfo> find = new Finder<Integer, SkillInfo>(Integer.class, SkillInfo.class);

    public static List<SkillInfo> all() {
        return find.where().findList();
    }

    public static List<SkillInfo> findByCategory(String category) {
        return find.where().eq("category", category).findList();
    }
}
