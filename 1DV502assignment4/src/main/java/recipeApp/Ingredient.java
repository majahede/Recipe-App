package main.java.recipeApp;

import java.io.Serializable;

public class Ingredient implements Serializable{

  private static final long serialVersionUID = 1L;
  private String name;
  private String unit;
  private int price;

   /**
   * Creates a new ingredient.
   */
  public Ingredient(String name, String unit, int price) {
    this.name = name;
    this.unit = unit;
    this.price = price;
  }

  /**
   * Returns the name of the ingredient.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public String getunit() {
    return unit;
  }

  /**
   * Returns the price of the ingredient.
   */
  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
      return "Ingredient: " + name + "\nUnit: " + unit + "\nPrice: " + price;
  } 

}
