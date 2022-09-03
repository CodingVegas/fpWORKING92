package com.promineotech.burrito.service;

import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.entity.OrdersInputModel;

/**
 * The minimal implementation for getting or setting burrito information
 */
public interface BurritoService {
  /**
   * Gets a order by it's orderPK
   * @param orderPK
   * @return The title if found, otherwise null
   */
  Orders getOrder(String orderPK);
/**
 * Creates a new order
 * @param input The new order
 * @return the order if successful, otherwise returns null
 */
  Orders createOrder(OrdersInputModel input);
  
  /**
   * updates an order
   * 
   */
  //Orders putOrder(String orderPK);
  /**
   * Deletes or removes an order
   * @param orderPK
   * @return The deleted order if successful, otherwise returns null.
   */
  
  Orders deleteOrder(String orderPK);
}
