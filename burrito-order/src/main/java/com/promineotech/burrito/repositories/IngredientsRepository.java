package com.promineotech.burrito.repositories;

import java.util.Optional;
import com.promineotech.burrito.entity.Ingredients;
import com.promineotech.burrito.entity.IngredientsInputModel;

public interface IngredientsRepository {
  
  Optional<Ingredients> get (String ingredients_pk);
  
  Optional<Ingredients> create(IngredientsInputModel input);
  
  Optional<Ingredients> delete(String ingredients_pk);

}
