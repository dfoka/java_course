package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTests extends TestBase {

    @Test
    public void UserCreationTests() {

        app.getUserHelper().goToPage();
        app.getUserHelper().fillUserForm(new UserData("test1", "test2", "test3", "test4", "12345","test1"), true);
        app.getUserHelper().submitUserCreation();
        app.getNavigationHelper().gotoHomePage();
    }

}
