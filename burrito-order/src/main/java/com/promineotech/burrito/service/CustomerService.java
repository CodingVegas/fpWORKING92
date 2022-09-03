package com.promineotech.burrito.service;

import com.promineotech.burrito.entity.Customer;
import com.promineotech.burrito.entity.CustomerInputModel;

public interface CustomerService {
  Customer getCustomer(String id);

  Customer createCustomer(CustomerInputModel input);
  
  Customer updateCustomer(CustomerInputModel input);
  
  Customer deleteCustomer(String id);
}

