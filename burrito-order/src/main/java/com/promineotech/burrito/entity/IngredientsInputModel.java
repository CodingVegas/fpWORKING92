package com.promineotech.burrito.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class IngredientsInputModel {
    private String meat;
    private String rice;
    private String beans;
   
    public String getMeat() {
      return meat;
    }

    public IngredientsInputModel setMeat(String meat) {
      this.meat = meat;
      return this;
    }

    public String getRice() {
      return rice;
    }

    public IngredientsInputModel setRice(String rice) {
      this.rice = rice;
      return this;
    }
   
    public String getBeans() {
      return beans;
    }

    public IngredientsInputModel setBeans(String beans) {
      this.beans = beans;
      return this;
    }
    @JsonIgnore
    public boolean isValid() {
      return (getMeat() != null) && (! getMeat().isEmpty()) &&
             (getRice() != null) && (! getRice().isEmpty()) &&
             (getBeans() != null) && (! getBeans().isEmpty());
    }
  }
