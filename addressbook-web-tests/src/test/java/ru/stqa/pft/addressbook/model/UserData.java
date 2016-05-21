package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
@XStreamAlias("user")
public class UserData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String lastname;
  @Expose
  private String company;
  @Expose
  private String address;
  @Expose
  private String mobilePhone;
  @Expose
  private String workPhone;
  @Expose
  private String homePhone;
  @Expose
  private String group;
  private String allPhones;
  @Expose
  private String firstEmail;
  @Expose
  private String secondEmail;
  @Expose
  private String thirdEmail;
  @Expose
  private String allEmails;
  private String data;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public UserData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getData() {
    return data;
  }

  public UserData withData(String data) {
    this.data = data;
    return this;
  }


  public String getAllEmails() {
    return allEmails;
  }

  public UserData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public UserData withThirdEmail(String thirdEmail) {
    this.thirdEmail = thirdEmail;
    return this;
  }


  public UserData withSecondEmail(String secondEmail) {
    this.secondEmail = secondEmail;
    return this;
  }


  public UserData withFirstEmail(String firstEmail) {
    this.firstEmail = firstEmail;
    return this;
  }

  public UserData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public UserData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public UserData withCompany(String company) {
    this.company = company;
    return this;
  }

  public UserData withAddress(String address) {
    this.address = address;
    return this;
  }

  public UserData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public UserData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public UserData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public UserData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getFirstEmail() {
    return firstEmail;
  }

  public String getSecondEmail() {
    return secondEmail;
  }

  public String getThirdEmail() {
    return thirdEmail;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (id != userData.id) return false;
    if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
    return lastname != null ? lastname.equals(userData.lastname) : userData.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}

