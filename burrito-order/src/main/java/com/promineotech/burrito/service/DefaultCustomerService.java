package com.promineotech.burrito.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.burrito.entity.Customer;
import com.promineotech.burrito.entity.CustomerInputModel;
import com.promineotech.burrito.repositories.CustomerRepository;

@Service
public class DefaultCustomerService implements CustomerService {
  private CustomerRepository repository;
  
  public DefaultCustomerService(CustomerRepository repository) {
    this.repository = repository;
    
    
  }
  
  @Override
  public Customer getCustomer(String id) {
    if ((id == null) || (id.isEmpty())) {
      return null;
    }
    Optional<Customer> customer = repository.get(id);
    if (customer.isEmpty()) {
      return null;
    }
   return customer.get();
  }

  @Override
  public Customer createCustomer(CustomerInputModel input) {
    if ((input != null) && (input.isValid())) {
      Optional<Customer> result = repository.create(input);
      //return repository.create(input);
      if (result.isPresent()) {
        return result.get();
      }
    }
    return null;
  }
  
  
  
  @Override
  public Customer updateCustomer(CustomerInputModel input) {
    if ((input != null) && (input.isValid())) {
      Optional<Customer> result = repository.update(input);
      //return repository.create(input);
      if (result.isPresent()) {
        return result.get();
      }
    }
    return null;
  }
  
  
  
  
  @Override
  public Customer deleteCustomer(String id) {
    if ((id == null) || (id.isEmpty())) {
      return null;      
    }
    Optional<Customer> deleted = repository.delete(id);
    if (deleted.isPresent()) {
      return deleted.get();
    }
    return null;
  }



}
