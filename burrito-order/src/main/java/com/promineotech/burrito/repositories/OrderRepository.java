package com.promineotech.burrito.repositories;

import java.util.Optional;
import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.entity.OrdersInputModel;
//Gets a order by its orderPK
//return the order if found, otherwise an empty optional.
public interface OrderRepository {
  Optional<Orders> get(String orderPK);

  /**
   * create a new order
   * @param input The new order
   * @return the new order if successful otherwise an empty optional.
   */
  Optional<Orders> create(OrdersInputModel input);

  /**
   * Deletes an Order
   * @param The unique orderPK
   * @return the deleted order if successful, otherwise and empty optional.
   */
  Optional<Orders> delete(String orderPK);

  /**
   * updates an order
   * @param orderPK the orderPK
   * @return the updated order
   */
  //Optional<Orders> put(String orderPK);
}
