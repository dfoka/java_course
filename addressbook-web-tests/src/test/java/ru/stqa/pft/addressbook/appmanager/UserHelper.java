package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase{

  public UserHelper(WebDriver wd) {
    super(wd);
  }



  public void submitUserCreation() {
   click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillUserForm(UserData userData, boolean creation) {
    type(By.name("firstname"), userData.getFirstname());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("company"), userData.getCompany());
    type(By.name("company"), userData.getAddress());
    type(By.name("home"), userData.getTelephone());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void goToPage() {
    click(By.linkText("add new"));
  }

  public void selectUser() {
    click(By.name("selected[]"));
  }

  public void confirmDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void goToUserPage() {
    click(By.linkText("home"));
  }

  public void initUserModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitUserModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
