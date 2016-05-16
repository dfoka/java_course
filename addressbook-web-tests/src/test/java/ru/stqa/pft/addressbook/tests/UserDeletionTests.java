package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().userPage();
    if ( app.user().all().size() == 0) {
      app.user().create(new UserData().
              withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345").withGroup("test1"));
    }
  }

  @Test
  public void testDeletionUser() {

    Users before = app.user().all();
    UserData deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    Users after = app.user().all();
    assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deletedUser)));
  }
}
