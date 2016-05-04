package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserCreationTests extends TestBase {

    @Test
    public void UserCreationTests() {
        List<UserData> before = app.getUserHelper().getUserList();
        app.getUserHelper().goToPage();
        UserData user = new UserData("test1", "test2", "test3", "test4", "12345", "test1");
        app.getUserHelper().createUser(user);
        List<UserData> after = app.getUserHelper().getUserList();
        app.getNavigationHelper().gotoHomePage();
        Assert.assertEquals(after.size(), before.size() +1);

        before.add(user);
        Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
