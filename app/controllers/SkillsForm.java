package controllers;

import models.*;
import play.mvc.Controller;
import play.mvc.*;

import views.html.*;

public class SkillsForm extends Controller {



    public static Result index() {
        return ok(skillsForm.render(SkillInfo.all()));
    }
}
