package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserDeletionTests extends TestBase {

  @Test (enabled = false)
  public void testDeletionUser() {
    app.getUserHelper().goToUserPage();
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("test1", "test2", "test3", "test4", "12345","test1"));
    }
    List<UserData> before = app.getUserHelper().getUserList();
    app.getUserHelper().selectUser(before.size() -1);
    app.getUserHelper().confirmDeletion();
    app.goTo().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(before.size() -1);
    Assert.assertEquals(before, after);
  }
}
