package com.promineotech.burrito.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerInputModel {

  private String firstName;
  private String lastName;
  private String phoneNumber;
  
  public String getFirstName() {
    return firstName;
  }
  public CustomerInputModel setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  public String getLastName() {
    return lastName;
  }
  public CustomerInputModel setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public CustomerInputModel setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }
  
  @JsonIgnore
  public boolean isValid( ) {
    return (getFirstName() != null) && (! getFirstName().isEmpty()) &&
           (getLastName() != null) && (! getLastName().isEmpty()) &&
          (getPhoneNumber() != null) && (! getPhoneNumber().isEmpty());
  }
}

