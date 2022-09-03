package com.promineotech.burrito.entity;

public class Orders extends Model {
  private String orderPK;
  private String customer;

  public Orders(String orderPK, String customer) {
    setOrderPK(orderPK);
    setCustomer(customer);  
  }
  
  public String getOrderPK() {
    return orderPK;
  }
  
  public Orders setOrderPK(String orderPK) {
    this.orderPK = orderPK;
    return this; 
  }
 
  public String getCustomer() {
    return customer;
  }

  public Orders setCustomer(String customer) {
    this.customer = customer;
    return this;
  }
}

