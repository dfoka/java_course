package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {

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

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void goToPage() {
    click(By.linkText("add new"));
  }

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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
  public void selectUserToEdit(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

  public void submitUserModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));

  }
  public void selectUserById(int id){
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }
  public void create(UserData user) {
    fillUserForm(user, true);
    submitUserCreation();
    goToUserPage();
  }

  public void modify(UserData user) {
    selectUserToEdit(user.getId());
    fillUserForm(user, false);
    submitUserModification();
    goToUserPage();
  }

  public void delete(UserData user) {
    selectUserById(user.getId());
    confirmDeletion();
    goToUserPage();
  }



  public boolean isThereAUser() {
    return isElementPresent((By.name("selected[]")));
  }


  public Users all() {
    Users users = new Users();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      users.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return users;
  }
}
