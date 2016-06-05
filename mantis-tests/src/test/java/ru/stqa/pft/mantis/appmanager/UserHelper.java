package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class UserHelper extends HelperBase {

  public UserHelper(ApplicationManager app){
    super(app);
  }

  public void loginAsAdmin() {
   type(By.name("username"), app.getProperty("web.adminLogin"));
   type(By.name("password"), app.getProperty("web.adminPassword"));
   click(By.className("button"));
  }

  public void logout(){
    click(By.linkText("Logout"));
  }

  public void resetPassword(UserData user) {
    click(By.linkText("Manage"));
    click(By.linkText("Manage Users"));
    selectUserById(user.getId());
    resetPass();
  }

  private void selectUserById(int id) {
    wd.findElement(By.xpath("//*[@href='manage_user_edit_page.php?user_id=" + id + "']")).click();
  }

  private void resetPass(){
    wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
  }

  public UserData newPassword(String confirmationLink, String password, UserData user) {
    UserData changedUser = user.withPassword(password).withId(user.getId()).withEmail(user.getEmail()).setUsername(user.getUsername());
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
    return changedUser;
  }
}
