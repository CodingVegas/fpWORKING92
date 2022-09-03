package com.promineotech.burrito.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrdersInputModel {
  private String customer;
 
  public String getCustomer() {
    return customer;
  }

  public OrdersInputModel setCustomer(String customer) {
    this.customer = customer;
    return this;
  }
  /** 
   * Checks to make sure the data is valid.
   * @return True if valid, false if otherwise.
   */
  @JsonIgnore
  public boolean isValid() {
    return (getCustomer() != null) && (! getCustomer().isEmpty());
  }
}
