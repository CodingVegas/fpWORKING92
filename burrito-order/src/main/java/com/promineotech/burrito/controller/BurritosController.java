package com.promineotech.burrito.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.entity.OrdersInputModel;
import com.promineotech.burrito.service.BurritoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@OpenAPIDefinition(info = @Info(title = "Burrito Orders"))
@Tag(name = "Orders")
@RequestMapping("/orders")

public class BurritosController {
  private BurritoService service;
  
  public BurritosController(BurritoService service) {
    this.service = service;
  }
  
  /**
   * Returns the order matching a specific orderPK
   * @param the orderPK
   * @return The order if found, otherwise null.
   */
  @GetMapping(value = "{orderPK}")
  public Orders get(@PathVariable String orderPK) {
    Orders orders = service.getOrder(orderPK);
    if (orders != null) {
      return orders;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                "The requested order was not found.");
  }
    /**Creates a new order.
     * @param input the new order to create.
     * @return The created order if successful, otherwise returns null.
     * 
     */
    @PostMapping(value = "{orderPK}")
    public Orders create(@RequestBody OrdersInputModel input) {
      if (input != null) {
        //if ((input.getCustomer() == null) || (input.getCustomer().isEmpty())) {
        if (! input.isValid()) {
          
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The customer is required for an order.");
        }
   
        Orders result = service.createOrder(input);
        if (result != null) {
          return result;
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.");
      }
      
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
  }
    /**Updates an order.
     * @param 
     * @return The updated order if successful, otherwise returns null.
     * 
     */
//    @PutMapping()
//    public Orders put(@RequestBody OrdersInputModel input) {
//      if (input != null) {
//        //if ((input.getCustomer() == null) || (input.getCustomer().isEmpty())) {
//        if (! input.isValid()) {
//          
//          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The customer is required for an order.");
//        }
//   
//        Orders result = service.createOrder(input);
//        if (result != null) {
//          return result;
//        }
//        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error.");
//      }
//      
//      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
//  }
    @DeleteMapping(value = "{orderPK}")
    public Orders delete(@PathVariable String orderPK) {
      if ((orderPK != null) && (! orderPK.isEmpty())) {  
        Orders existing = service.getOrder(orderPK);
        if (existing != null) {
          return service.deleteOrder(orderPK);
          
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested order not found.");
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no id specified.");
    }
}
