package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;

public class UserDeletionTests extends TestBase {

  @Test
  public void testDeletionUser() {
    app.getUserHelper().goToUserPage();
    app.getUserHelper().selectUser();
    app.getUserHelper().confirmDeletion();
    app.getUserHelper().returnToMainPage();


  }
}
