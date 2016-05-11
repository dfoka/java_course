package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;


public class UserModificationTests extends TestBase {
  @Test (enabled = false)
  public void testUserModification(){
    app.getUserHelper().goToUserPage();
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("test1", "test2", "test3", "test4", "12345","test1"));
    }
    List<UserData> before = app.getUserHelper().getUserList();
    app.getUserHelper().selectUser(before.size() -1);
    app.getUserHelper().initUserModification();
    UserData user = new UserData(before.get(before.size() - 1).getId(), "test1", "test2", "test3", "test4", "12345", null);
    app.getUserHelper().fillUserForm(user, false);
    app.getUserHelper().submitUserModification();
    app.goTo().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
