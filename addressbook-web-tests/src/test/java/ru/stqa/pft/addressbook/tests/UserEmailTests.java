package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserEmailTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().userPage();
    if ( app.user().all().size() == 0) {
      app.user().create(new UserData().
              withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345").withThirdEmail("dima@mail.ru").withGroup("test1"));
    }
  }

  @Test
  public void testUserAddress() {
    app.goTo().homePage();
    UserData user = app.user().all().iterator().next();
    UserData userInfoFromEditForm = app.user().infoFromEditForm(user);

    assertThat(user.getAllEmails(), equalTo(mergeEmails(userInfoFromEditForm)));
  }

  private String mergeEmails(UserData user) {
    return Arrays.asList(user.getFirstEmail(), user.getSecondEmail(), user.getThirdEmail())
            .stream().filter((s) -> ! s.equals(""))
            .map(UserEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String email){
    return email.replaceAll("\\s", "");
  }
}
