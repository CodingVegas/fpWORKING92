package com.promineotech.burrito.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.burrito.entity.Ingredients;
import com.promineotech.burrito.entity.IngredientsInputModel;
import com.promineotech.burrito.repositories.IngredientsRepository;

@Service
public class DefaultIngredientsService implements IngredientsService{
  private IngredientsRepository repository;
  
  public DefaultIngredientsService(IngredientsRepository repository) {
    this.repository = repository;  
  }
  
  @Override
  public Ingredients getIngredients(String ingredientsPK) {
    if ((ingredientsPK == null) || (ingredientsPK.isEmpty())) {
      return null;
    }
    
    Optional<Ingredients> Ingredients = repository.get(ingredientsPK);
    if (Ingredients.isEmpty()) {
      return null;
    }
    return Ingredients.get();
  }

  @Override
  public Ingredients createIngredients(IngredientsInputModel input) {
    if ((input != null) && (input.isValid())) { 
      Optional<Ingredients> result = repository.create(input);
      if (result.isPresent()) {
        return result.get();
      }
    }
   return null;
  }

  @Override
  public Ingredients deleteIngredients(String ingredientsPK) {
    if ((ingredientsPK == null) || (ingredientsPK.isEmpty()) ) {
      return null;
    }
    Optional<Ingredients> deleted = repository.delete(ingredientsPK);
    if (deleted.isPresent()) {
      return deleted.get();
    }
    return null;
  }

//  @Override
//  public Ingredients getIngredients(String ingredientsPK, String meat, String rice, String beans) {
//    // TODO Auto-generated method stub
//    return null;
//  }


}
