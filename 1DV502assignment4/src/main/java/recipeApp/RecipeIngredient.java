package main.java.recipeApp;

import java.io.Serializable;

public class RecipeIngredient implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;
  private String unit;
  private double amount;
  private String comment;
  private double price;
  private boolean isDividable;

   /**
   * Creates a new ingredient.
   */
  public RecipeIngredient(String name, String unit, double amount, String comment, double price, boolean isDividable) {
    this.name = name;
    this.unit = unit;
    this.amount = amount;
    this.price = price;
    this.isDividable = isDividable;
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
   * Returns the name of the ingredient.
   */
  public boolean checkIfDividable() {
    return isDividable;
  }

   /**
   * Returns the unit of the ingredient.
   */
  public double getAmount() {
    return amount;
  }

   /**
   * Returns the unit of the ingredient.
   */
  public void setAmount(double amount) {
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
  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
      return name + ","  + unit + "," + amount + "," + comment + "," + price + ";";
  } 

}
