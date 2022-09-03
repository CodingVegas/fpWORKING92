package com.promineotech.burrito.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.burrito.entity.Ingredients;
import com.promineotech.burrito.entity.IngredientsInputModel;
import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.service.IngredientsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@OpenAPIDefinition(info = @Info(title = "Burrito Orders"))
@Tag(name = "Ingredients")
@RequestMapping("/burritos")

public class IngredientsController {
  private IngredientsService service;
  
  public IngredientsController(IngredientsService service) {
    this.service = service;
  }
  
  /**
   * Returns the ingredients matching a specific ingredientsPK
   * @param the ingredientsPK
   * @return The ingredients if found, otherwise null.
   */
  @GetMapping(value = "{ingredientsPK}")
  public Ingredients get(@PathVariable String ingredientsPK) {
    Ingredients ingredients = service.getIngredients(ingredientsPK);
    if (ingredients != null) {
      return ingredients;
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                "The requested ingredients were not found.");
  }
  /**
   * Creates new ingredients
   * @param input the new ingredients
   * @return the created ingredients if successful, otherwise returns null
   */
  @PostMapping(value = "{ingredientsPK}")
  public Ingredients create(@RequestBody IngredientsInputModel input) {
    if (input != null) {
      if (! input.isValid()) {  
        
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ingredients are required for ingredients.");
      }
      Ingredients result = service.createIngredients(input);
      if (result != null) {
        return result;
      }
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error. Ick!");
    }
     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The input was empty or null.");
  }
  @DeleteMapping(value = "{ingredientsPK}")
  public Ingredients delete(@PathVariable String ingredientsPK) {
    if ((ingredientsPK != null) && (! ingredientsPK.isEmpty())) {  
      Ingredients existing = service.deleteIngredients(ingredientsPK);
      if (existing != null) {
        return service.deleteIngredients(ingredientsPK);
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested order not found.");
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no id specified.");
  }
}

