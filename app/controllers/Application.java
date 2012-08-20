package controllers;

import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

  static Form<User> userForm = form(User.class);
  
  public static Result index() {
      return ok(index.render(userForm));
  }

  public static Result login() {
      Form<User> filledForm = userForm.bindFromRequest();
      if(filledForm.hasErrors()) {
          return badRequest(index.render(filledForm));
      }
      User user = filledForm.get();
      if(User.exists(user)) {
        return redirect(controllers.routes.Application.editUser(user.username));
      } else {
        User.create(user);
        return ok("User added successfully");
      }
  }

  public static Result editUser(String username) {
      User user = User.find.byId(username);
      Form<User> filledForm = userForm.fill(user);
      return ok(edit.render(user, filledForm));
  }

  public static Result doEditUser() {
      return TODO;
  }
  
}
