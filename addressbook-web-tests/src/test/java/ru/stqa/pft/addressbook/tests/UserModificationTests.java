package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;


public class UserModificationTests extends TestBase {
  @Test
  public void testUserModification(){
    app.getUserHelper().goToUserPage();
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserForm(new UserData("test1", "test2", "test3", "test4", "12345"));
    app.getUserHelper().submitUserModification();
    app.getUserHelper().returnToMainPage();


  }
}
