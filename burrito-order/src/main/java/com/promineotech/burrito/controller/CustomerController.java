package com.promineotech.burrito.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.burrito.entity.Customer;
import com.promineotech.burrito.entity.CustomerInputModel;
import com.promineotech.burrito.service.CustomerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@OpenAPIDefinition(info = @Info(title = "Burrito Orders"))
@Tag(name = "Customers")
@RequestMapping("/customer")
public class CustomerController {
  private CustomerService service;
  
  public CustomerController(CustomerService service) {
    this.service = service;
  }
  
  @GetMapping(value ="{id}")
  public Customer get(@PathVariable String id) {
    Customer customer = service.getCustomer(id);
    if (customer != null) {
      return customer;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,
              "The requested customer was not found.");   
  }

@PostMapping(value ="{input}")
//@ResponseStatus(code = HttpStatus.CREATED)
public Customer create(@Valid @RequestBody CustomerInputModel input) {
  if (input != null) {
    //Should this have .getLastName & .getPhoneNumber??? getCustomer
    //if ((input.getFirstName() == null) || (input.getFirstName().isEmpty())) {
  //if ((input.getPhoneNumber() == null) || (input.getPhoneNumber().isEmpty())) {
    if (! input.isValid()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
    }
    Customer result = service.createCustomer(input);
      if (result != null) {
        return result;
      }
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error.");
      }
  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
  }



@PutMapping
 //public Customer update(@PathVariable CustomerInputModel input) {
  public Customer update(@RequestBody CustomerInputModel input) {
  if (input != null) {
    //Should this have .getLastName & .getPhoneNumber??? 
    //if ((input.getFirstName() == null) || (input.getFirstName().isEmpty())) {
    if (! input.isValid()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
    }
    Customer result = service.updateCustomer(input);
      if (result != null) {
        return result;
      }
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error.");
      }
  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
  }



@DeleteMapping(value ="{id}")
public Customer delete(@PathVariable String id) {
 if ((id != null) && (! id.isEmpty())) {
   Customer existing = service.getCustomer(id);
   if (existing != null) {
     return service.deleteCustomer(id);
   }
   throw new ResponseStatusException(HttpStatus.NOT_FOUND,
       "The requested customer was not found."); 
 }
 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No ID specified.");
}
}
