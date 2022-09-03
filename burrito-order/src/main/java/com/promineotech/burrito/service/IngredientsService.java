package com.promineotech.burrito.service;

import com.promineotech.burrito.entity.Ingredients;
import com.promineotech.burrito.entity.IngredientsInputModel;

public interface IngredientsService {

  /**
   * @param input
   * @return
   */
  Ingredients createIngredients(IngredientsInputModel input);

  /**
   * @param ingredientsPK
   * @return
   */
  Ingredients getIngredients(String ingredientsPK);

  /**
   * @param ingredientsPK
   * @return
   */
  Ingredients deleteIngredients(String ingredientsPK);
  
  

}

