package models;

import play.db.ebean.Model;
import play.data.validation.Constraints.*;
import javax.persistence.*;

@Entity
public class Skill extends Model {

    @Required
    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    @Required
    @OneToOne
    public SkillInfo skillInfo;

    @Required
    public int rating;
}
