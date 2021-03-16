package main.java.recipeApp;

public class Ingredient {

  private String name;
  private String unit;
  private int price;
  private int measure;

   /**
   * Creates a new ingredient.
   */
  public Ingredient(String name, String unit, int measure, int price) {
    this.name = name;
    this.unit = unit;
    this.measure = measure;
    this.price = price;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public String getunit() {
    return unit;
  }

  /**
   * Returns the measure of the ingredient.
   */
  public int getMeasure() {
    return measure;
  }

  /**
   * Returns the name of the ingredient.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the price of the ingredient.
   */
  public int getPrice() {
    return price;
  }



}
