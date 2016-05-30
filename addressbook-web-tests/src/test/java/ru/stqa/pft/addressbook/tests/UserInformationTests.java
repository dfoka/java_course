package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserInformationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().userPage();
    if ( app.user().all().size() == 0) {
      app.user().create(new UserData().
              withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345"));
    }
  }

  @Test
  public void testUserInformation() {
    app.goTo().homePage();
    UserData user = app.user().all().iterator().next();
    UserData userInfoFromDetailsForm = app.user().infoFromDetailsForm(user);
    UserData userInfoFromModifyForm = app.user().infoFromModifyForm(user);

    assertThat(cleaned(userInfoFromDetailsForm.getData()), equalTo(mergeInformation(userInfoFromModifyForm)));
  }

  private String mergeInformation(UserData user) {
    return  Arrays.asList(user.getFirstname(),user.getLastname(),user.getCompany(),user.getAddress(),
            user.getHomePhone(), user.getMobilePhone(), user.getWorkPhone(),
            user.getFirstEmail(),user.getSecondEmail(),user.getThirdEmail())
            .stream().filter((s) -> ! s.equals(""))
            .map(UserInformationTests::cleaned)
            .collect(Collectors.joining(""));
  }


  public static String cleaned(String information){
    return information.replaceAll("\\s", "").replaceAll("[-:HMW]", "").replaceAll("\\(.*?\\) ?", "");
  }
}

