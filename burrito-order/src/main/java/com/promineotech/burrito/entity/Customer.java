package com.promineotech.burrito.entity;

public class Customer {
  private String id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  
  public Customer(String id, String firstName, String lastName, String phoneNumber) {
    setId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setPhoneNumber(phoneNumber);
  }
  
  public String getId() {
    return id;
  }
  public Customer setId(String id) {
    this.id = id;
    return this;
  }
  public String getFirstName() {
    return firstName;
  }
  public Customer setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }
  public Customer setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public Customer setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }
}