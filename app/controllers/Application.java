package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

  // Login class for login form
  public static class Login {
      public String username;
      public String password;

      public String validate() {
          if(User.authenticate(username, password) == null)
              return "Invalid username or password";
          return null;
      }
  }

  // GET '/'
  public static Result index() {
      return ok(index.render(form(Login.class)));
  }

  // POST '/login'
  public static Result login() {
      Form<Login> filledForm = form(Login.class).bindFromRequest();
      if(filledForm.hasErrors()) {
          flash("error", filledForm.globalError().message());
          return badRequest(index.render(form(Login.class)));
      }
      session("loggedInUser", filledForm.get().username);
      return redirect(controllers.routes.SkillsForm.index());
  }

  // GET '/register'
  public static Result register() {
      return ok(register.render(form(User.class)));
  }

  // POST '/register'
  public static Result doRegister() {
      Form<User> filledForm = form(User.class).bindFromRequest();
      if(filledForm.hasErrors()) {
          return badRequest(register.render(filledForm));
      }
      User user = filledForm.get();
      if(!User.isUnique(user)) {
          flash("error", "That username is already taken");
          return badRequest(register.render(filledForm));
      }
      User.create(user);
      session("loggedInUser", user.username);
      return redirect(controllers.routes.SkillsForm.index());
  }


  
}
