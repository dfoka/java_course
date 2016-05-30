package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import javax.jws.soap.SOAPBinding;
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
    type(By.name("address"), userData.getAddress());
    type(By.name("home"), userData.getHomePhone());
    type(By.name("work"), userData.getWorkPhone());
    type(By.name("mobile"), userData.getMobilePhone());
    type(By.name("email"), userData.getFirstEmail());
    type(By.name("email2"), userData.getSecondEmail());
    type(By.name("email3"), userData.getThirdEmail());
    attatch(By.name("photo"), userData.getPhoto());

    if (creation) {
      if (userData.getGroups().size() > 0) {
        Assert.assertTrue(userData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroups().iterator().next().getName());
      }
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

  public void selectUserToGetInfo(int id) {
    wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
  }

  public void submitUserModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));

  }

  public void selectUserById(int id) {
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
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      users.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
    }
    return users;
  }

  public UserData infoFromEditForm(UserData user) {
    selectUserToEdit(user.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lasttname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homephone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workphone = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
    String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
    String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new UserData().
            withFirstname(firstname).withLastname(lasttname).withAddress(address)
            .withHomePhone(homephone).withMobilePhone(mobilephone).withWorkPhone(workphone)
            .withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
  }

  public void goToModification() {
    wd.findElement(By.name("modifiy")).click();
  }

  public UserData infoFromModifyForm(UserData user) {
    selectUserToGetInfo(user.getId());
    goToModification();
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lasttname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homephone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workphone = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
    String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
    String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    wd.navigate().back();
    return new UserData().
            withFirstname(firstname).withLastname(lasttname).withAddress(address).withCompany(company)
            .withHomePhone(homephone).withMobilePhone(mobilephone).withWorkPhone(workphone)
            .withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
  }
  public UserData infoFromDetailsForm (UserData userData){
    String userInfo;
    selectUserToGetInfo(userData.getId());
    String data = wd.findElement(By.id("content")).getText();
    if(isElementPresent(By.xpath(".//i"))){
      String group = wd.findElement(By.xpath(".//i")).getText();
      userInfo = data.replace(group, "");
    }
    else {
      userInfo = data;
    }
    wd.navigate().back();
    return new UserData().withData(userInfo);

  }
}
