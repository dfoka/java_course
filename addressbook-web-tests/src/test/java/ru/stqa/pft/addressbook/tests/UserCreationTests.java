package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class UserCreationTests extends TestBase {

    @Test
    public void UserCreationTests() {
        Users before = app.user().all();
        app.goTo().userPage();
        UserData user = new UserData().withFirstname("test1").withLastname("test2").withCompany("test3").withAddress("test4").withHomePhone("12345").withGroup("test1");
        app.user().create(user);
        Users after = app.user().all();
        app.goTo().homePage();
        assertThat(after.size(), equalTo(before.size() +1));

        assertThat(after, equalTo
              (before.withAdded(user.withId(after.stream().mapToInt(g->g.getId()).max().getAsInt()))));

    }
}
