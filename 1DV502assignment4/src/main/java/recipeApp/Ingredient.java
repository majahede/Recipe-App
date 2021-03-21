package main.java.recipeApp;

import java.io.Serializable;

public class Ingredient implements Serializable{

  private static final long serialVersionUID = 1L;
  private String name;
  private String unit;
  private double price;
  private boolean isDividable;

  /**
   * Creates a new ingredient.
   */
  public Ingredient(String name, String unit, double price, boolean isDividable) {
    this.name = name;
    this.unit = unit;
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
   * Checks if the ingredient is dividable.
   */
  public boolean checkIfDividable() {
    return isDividable;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Returns the price of the ingredient.
   */
  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Ingredient: " + name + "\nUnit: " + unit + "\nPrice: " + price;
  } 
}
