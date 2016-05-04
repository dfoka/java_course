package ru.stqa.pft.addressbook.model;

public class UserData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String company;
  private final String address;
  private final String telephone;
  private String group;

  public UserData(int id, String firstname, String lastname, String company, String address, String telephone, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.company = company;
    this.address = address;
    this.telephone = telephone;
    this.group = group;
  }

  public UserData(String firstname, String lastname, String company, String address, String telephone, String group) {
    this.id = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.company = company;
    this.address = address;
    this.telephone = telephone;
    this.group = group;
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

  public String getTelephone() {
    return telephone;
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

