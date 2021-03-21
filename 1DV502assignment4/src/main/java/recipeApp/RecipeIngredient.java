package main.java.recipeApp;

import java.io.Serializable;

public class RecipeIngredient implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;
  private String unit;
  private int amount;
  private String comment;
  private int price;

   /**
   * Creates a new ingredient.
   */
  public RecipeIngredient(String name, String unit, int amount, String comment, int price) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
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
  public String getUnit() {
    return unit;
  }

   /**
   * Returns the unit of the ingredient.
   */
  public int getAmount() {
    return amount;
  }

   /**
   * Returns the unit of the ingredient.
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }

   /**
   * Returns the comment of the ingredient.
   */
  public String getComment() {
    return comment;
  }

  /**
   * Returns the price of the ingredient.
   */
  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
      return name + ","  + unit + "," + amount + "," + comment + "," + price + ";";
  } 

}
