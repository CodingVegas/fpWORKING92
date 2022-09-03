package com.promineotech.burrito.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.burrito.entity.Customer;
import com.promineotech.burrito.entity.CustomerInputModel;


@Repository
public class CustomerJDBCRepository implements CustomerRepository {
  private NamedParameterJdbcTemplate provider;
  
  public CustomerJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }
  
  @Override
  public Optional<Customer> get(String id) {
    String sql = "SELECT customer_pk, first_name, last_name, phone "
        +"FROM customers "
        + "WHERE customer_pk = :customer_pk;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("customer_pk", id);
    
    List<Customer> customer = provider.query(sql, parameters, (rs, rowNum) -> {
      return new Customer(rs.getString("customer_pk"), rs.getString("first_name"), 
        rs.getString("last_name"), rs.getString("phone"));
    });
    if (customer.isEmpty()) {
      return Optional.empty();
    }

  return Optional.of(customer.get(0));
  }

  @Override
  public Optional<Customer> create(CustomerInputModel input) {
    if ((input == null) || (! input.isValid())) {
      return Optional.empty();
    }
    String sql = "INSERT INTO customers (customer_pk, first_name, last_name, phone) "
        +"Values (:customer_pk, :first_name, :last_name, :phone);";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String first_name = input.getFirstName();
    String last_name = input.getLastName();
    String phone = input.getPhoneNumber();
    String customer_pk = last_name+"_"+first_name;
    parameters.addValue("customer_pk", customer_pk); //NEED number generator?
    parameters.addValue("first_name", first_name);
    parameters.addValue("last_name", last_name);
    parameters.addValue("phone", phone);

    int rows = provider.update(sql, parameters);
    if (rows > 0) {
     return get(customer_pk);
    }
    return Optional.empty();
  }
  
  //@ResponseStatus(code = HttpStatus.CREATED)
  @Override
  public Optional<Customer> update(CustomerInputModel input) { 
    if ((input == null) || (! input.isValid())) {
      return Optional.empty();
    }
    String sql = "UPDATE customers SET phone = :phone WHERE customer_pk = :customer_pk; ";
       
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    String first_name = input.getFirstName();
    String last_name = input.getLastName();
    String phone = input.getPhoneNumber();
    String customer_pk = last_name+"_"+first_name;
    parameters.addValue("phone", phone);
    parameters.addValue("customer_pk", customer_pk); 
    parameters.addValue("first_name", first_name);
    parameters.addValue("last_name", last_name);
    
    int rows = provider.update(sql, parameters);
    if (rows > 0) {
     return get(customer_pk);
    }
    return Optional.empty();
  }
  
  @Override
  public Optional<Customer> delete(String id) {
    if ((id == null) || (id.isEmpty())) {
      return Optional.empty();
    }
    
    Optional<Customer> existing = get(id);
    if (existing.isPresent()) {
      String sql = "DELETE FROM customers WHERE customer_pk = :customer_pk";
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("customer_pk", id);

      int rows = provider.update(sql, parameters);
      if (rows > 0) {
        return existing;
      }  
    }
 
    return Optional.empty();
  }
 }

