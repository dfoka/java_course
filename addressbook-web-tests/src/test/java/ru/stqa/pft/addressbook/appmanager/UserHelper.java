package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase{

  public UserHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToMainPage() {
    click(By.name("searchstring"));
  //  wd.findElement(By.name("searchstring")).sendKeys("\\9");
  }

  public void submitUserCreation() {
   click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillUserForm(UserData userData) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("company"), userData.getCompany());
    type(By.name("company"), userData.getCompany());
    type(By.name("home"), userData.getTelephone());
  }

  public void goToPage() {
    click(By.linkText("add new"));
  }
}
