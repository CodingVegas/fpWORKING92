package com.promineotech.burrito.repositories;

import java.util.Optional;
import com.promineotech.burrito.entity.Customer;
import com.promineotech.burrito.entity.CustomerInputModel;

public interface CustomerRepository {
  Optional<Customer> get (String id);

  Optional<Customer> create(CustomerInputModel input);
  
  Optional<Customer> update(CustomerInputModel input);
  
  Optional<Customer> delete(String id);
  
}

