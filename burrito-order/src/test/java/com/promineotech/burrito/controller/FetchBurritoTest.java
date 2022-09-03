package com.promineotech.burrito.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.promineotech.burrito.controller.support.FetchBurritoTestSupport;
// creating a class hierarchy. Test is at the top level then a support class then a 
//baseTest class thats used by all the test classes underneath that.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchBurritoTest extends FetchBurritoTestSupport {

  @Test
  void testThatBurritosAreReturnedWhenValidIngredientsAreSupplied() {

  }

}
