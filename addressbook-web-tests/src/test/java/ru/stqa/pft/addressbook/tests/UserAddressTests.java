package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().userPage();
    if ( app.user().all().size() == 0) {
      app.user().create(new UserData().
              withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345"));
    }
  }

  @Test
  public void testUserAddress() {
    app.goTo().homePage();
    UserData user = app.user().all().iterator().next();
    UserData userInfoFromEditForm = app.user().infoFromEditForm(user);

    assertThat(user.getAddress(), equalTo(cleaned(userInfoFromEditForm.getAddress())));

  }

  public static String cleaned(String address) {
    return address.replaceAll("\\s", "");
  }
}
