package com.promineotech.burrito.entity;

public class Ingredients extends Model{
  private String ingredientsPK;
  private String meat;
  private String rice;
  private String beans;
  
  public Ingredients(String ingredientsPK, String meat, String rice, String beans) { 
  //in the video at 50:11 GH said you have to have a name but might not know the other info.
  //public Ingredients(String ingredientsPK) {
    setIngredientsPK(ingredientsPK);
    setMeat(meat);
    setRice(rice);
    setBeans(beans);
  }
  
  public String getIngredientsPK() {
    return ingredientsPK;
  }

  public Ingredients setIngredientsPK(String ingredientsPK) {
    this.ingredientsPK = ingredientsPK;
    return this;
  }

  public String getMeat() {
    return meat;
  }

  public Ingredients setMeat(String meat) {
    this.meat = meat;
    return this;
  }

  public String getRice() {
    return rice;
  }

  public Ingredients setRice(String rice) {
    this.rice = rice;
    return this;
  }
 
  public String getBeans() {
    return beans;
  }

  public Ingredients setBeans(String beans) {
    this.beans = beans;
    return this;
  }

}
