package controllers;

import models.*;
import play.mvc.Controller;
import play.mvc.*;
import static play.mvc.Http.*;

import views.html.*;

import java.util.List;

public class SkillsForm extends Controller {

    // GET '/skillsform'
    public static Result index() {
        List<Skill> userSkills = User.find.byId(session("loggedInUser")).skills; // match this with skillsList
        List<SkillInfo> skillsList = SkillInfo.all();
        return ok(skillsForm.render(skillsList));
    }

    // POST '/skillsform'
    public static Result processForm() {
        RequestBody body = request().body();
        return ok(""+Integer.parseInt(body.asFormUrlEncoded().get("Java")[0]));
    }
}
