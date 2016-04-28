package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTests extends TestBase {

  @Test
  public void testDeletionUser() {
    app.getUserHelper().goToUserPage();
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("test1", "test2", "test3", "test4", "12345","test1"));
    }
    app.getUserHelper().selectUser();
    app.getUserHelper().confirmDeletion();
    app.getNavigationHelper().gotoHomePage();
  }
}
