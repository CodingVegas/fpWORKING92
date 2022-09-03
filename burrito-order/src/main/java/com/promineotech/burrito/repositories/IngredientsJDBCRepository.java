package com.promineotech.burrito.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.burrito.entity.Ingredients;
import com.promineotech.burrito.entity.IngredientsInputModel;

@Repository
public class IngredientsJDBCRepository implements IngredientsRepository {
  private NamedParameterJdbcTemplate provider;
  private Random random = new Random();
  
  public IngredientsJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;    
  }
  
  @Override
  public Optional<Ingredients> create(IngredientsInputModel input) {
    if ((input == null) || (! input.isValid())) {
      return Optional.empty();
    }
   
   String sql = "INSERT INTO ingredients (ingredients_pk, meat, rice, beans) " +
                           "VALUES (:ingredients_pk, :meat, :rice, :beans);"; 
   

    String meat = input.getMeat();
    String rice = input.getRice();
    String beans = input.getBeans();
    /* Bill's changes:
    String sql = "INSERT INTO ingredients (meat, rice, beans) " +
        "VALUES (:meat, :rice, :beans);"; 
   */ 
   String ingredients_pk = String.format("%05d", random.nextInt(99999));
   MapSqlParameterSource parameters = new MapSqlParameterSource();
   //parameters.addValue("ingredients_pk", ingredients_pk);
   parameters.addValue("meat",meat);
   parameters.addValue("rice",rice);
   parameters.addValue("beans",beans);
   int rows = provider.update(sql, parameters);
   if (rows > 0) {
     //return get(ingredients_pk);
     
   }
   return Optional.empty();
  }
  
  @Override
    public Optional<Ingredients> get(String ingredientsPK) {
    /* Amy's original code 
    String sql = "SELECT ingredientsPK, meat, rice, beans "
        + "From ingredients "
        + "WHERE ingredientsPK= :ingredientsPK, meat = :meat; rice = :rice, beans = :beans";
    */
   // Bill's changes:
    String sql = "SELECT ingredients_pk, meat, rice, beans "
        + "From ingredients "
        //+ "WHERE ingredients_pk= :ingredientsPK, meat = :meat; rice = :rice, beans = :beans";
        + "WHERE ingredients_pk = :ingredientsPK";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ingredientsPK", ingredientsPK);
        //parameters.addValue("meat", meat);
        //parameters.addValue("rice", rice);
        //parameters.addValue("beans", beans);
        
   
        List<Ingredients> ingredients = provider.query(sql, parameters,(rs, rowNum) -> {
          return new Ingredients(rs.getString("ingredients_pk"), rs.getString("meat"), rs.getString("rice"), rs.getString("beans")); 
          //return new Ingredients(rs.getString("ingredients_pk"));      
        });
          
        if (ingredients.isEmpty()) {
          return Optional.empty();
        }
        
        return Optional.of(ingredients.get(0));
    }

  @Override
  public Optional<Ingredients> delete(String ingredientsPK) {
      if ((ingredientsPK == null) || (ingredientsPK.isEmpty())) {
      return Optional.empty();
    }
    
    Optional<Ingredients> existing = get(ingredientsPK);
    if (existing.isPresent()) {
      //Amy's original code 
      String sql = "DELETE FROM ingredients WHERE ingredients_pk = :ingredients_pk;";
      
      // Bill's changes:
      //String sql = "DELETE FROM ingredients WHERE ingredients_pk="+ingredientsPK;
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("ingredients_pk", ingredientsPK);
      
      int rows = provider.update(sql, parameters);
      if (rows > 0) {
        return existing; 
      } 
    }
    
    return Optional.empty();
  }

  /**
   * @param ingredientsPK
   * @return
   */
  private Optional<Ingredients> getPK(String ingredientsPK) {
   return null;
  }  
}
