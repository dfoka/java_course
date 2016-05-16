package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class UserModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().userPage();
    if ( app.user().all().size() == 0) {
      app.user().create(new UserData().
              withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345").withGroup("test1"));
    }
  }

  @Test
  public void testUserModification(){
    Users before = app.user().all();
    UserData modifiedUser = before.iterator().next();
    UserData user = new UserData().
            withId(modifiedUser.getId()).withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345").withGroup("test1");
    app.user().modify(user);
    Users after = app.user().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedUser).withAdded(user)));

  }
}
