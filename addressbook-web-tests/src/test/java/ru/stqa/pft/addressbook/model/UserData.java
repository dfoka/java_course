package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
@XStreamAlias("user")
@Entity
@Table (name = "addressbook")
public class UserData {

  @XStreamOmitField
  @Id
  @Column (name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column (name = "firstname")
  private String firstname;

  @Expose
  @Column (name = "lastname")
  private String lastname;

  @Expose
  @Column (name = "company")
  private String company;

  @Expose
  @Column (name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column (name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Expose
  @Column (name = "work")
  @Type(type = "text")
  private String workPhone;

  @Expose
  @Column (name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Transient
  private String group;

  @Transient
  private String allPhones;

  @Expose
  @Column (name = "email")
  @Type(type = "text")
  private String firstEmail;

  @Expose
  @Column (name = "email2")
  @Type(type = "text")
  private String secondEmail;

  @Expose
  @Column (name = "email3")
  @Type(type = "text")
  private String thirdEmail;

  @Expose
  @Transient
  private String allEmails;
  @Transient
  private String data;

  @Transient
  private String photo = "" ;

  public File getPhoto() {
    if (photo == null){
      photo = "";
    }
    return new File (photo);
  }

  public UserData withPhoto(File photo) {
    this.photo = photo.getAbsolutePath();
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
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", group='" + group + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", firstEmail='" + firstEmail + '\'' +
            ", secondEmail='" + secondEmail + '\'' +
            ", thirdEmail='" + thirdEmail + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", data='" + data + '\'' +
            ", photo='" + photo + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (id != userData.id) return false;
    if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
    if (lastname != null ? !lastname.equals(userData.lastname) : userData.lastname != null) return false;
    if (company != null ? !company.equals(userData.company) : userData.company != null) return false;
    if (address != null ? !address.equals(userData.address) : userData.address != null) return false;
    if (mobilePhone != null ? !mobilePhone.equals(userData.mobilePhone) : userData.mobilePhone != null) return false;
    if (workPhone != null ? !workPhone.equals(userData.workPhone) : userData.workPhone != null) return false;
    if (homePhone != null ? !homePhone.equals(userData.homePhone) : userData.homePhone != null) return false;
    if (firstEmail != null ? !firstEmail.equals(userData.firstEmail) : userData.firstEmail != null) return false;
    if (secondEmail != null ? !secondEmail.equals(userData.secondEmail) : userData.secondEmail != null) return false;
    return thirdEmail != null ? thirdEmail.equals(userData.thirdEmail) : userData.thirdEmail == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (firstEmail != null ? firstEmail.hashCode() : 0);
    result = 31 * result + (secondEmail != null ? secondEmail.hashCode() : 0);
    result = 31 * result + (thirdEmail != null ? thirdEmail.hashCode() : 0);
    return result;
  }
}

