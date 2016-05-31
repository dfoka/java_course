package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;


public class AddUserInGroupTests extends TestBase{
  @BeforeMethod
  private void ensurePreconditionsGroupExists(){
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test 1"));
    }

  }

  @BeforeMethod
  private void ensurePreconditionsUserExists(){
    app.goTo().homePage();
    if (app.db().users().size() == 0) {
      app.user().create(new UserData()
              .withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345").withMobilePhone("112233")
              .withWorkPhone("332211").withFirstEmail("email1@test.com").withSecondEmail("email2@test.com").withThirdEmail("email3@test.com"));
    }
  }

  @Test
  public void testAddUserInGroup(){
    app.goTo().homePage();
    Users users = app.db().users();
    Groups groups = app.db().groups();
    UserData user = users.iterator().next();
    GroupData group = groups.stream().iterator().next();
    app.user().addToGroup(user, group);
    app.goTo().homePage();
  }
}
