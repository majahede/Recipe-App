package main.java.recipeApp;

import java.util.ArrayList;
import java.io.Serializable;

public class Recipe implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;
  private int portions;
  private ArrayList<RecipeIngredient> ingredients;
  private String instructions;
  private double price;

   /**
   * Creates a new recipe.
   */
  public Recipe(String name, int portions, ArrayList<RecipeIngredient> ingredients, String instructions) {
    this.name = name;
    this.portions = portions;
    this.ingredients = ingredients;
    this.instructions = instructions;
    this.price = setPrice();
  }

  /**
   * Returns the name of the ingredient.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the name of the ingredient.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public int getPortions() {
    return portions;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public void setPortions(int portions) {
    this.portions = portions;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public ArrayList<RecipeIngredient> getIngredients() {
    return ingredients;
  }

  /**
   * Returns the unit of the ingredient.
   */
  public String getInstruction() {
    return instructions;
  }

  public void editPortions(int num) {
    int oldNum = this.portions;
    this.portions = num;
      for (int counter = 0; counter < this.ingredients.size(); counter++) {
        RecipeIngredient ri = ingredients.get(counter);
        double amount = ri.getAmount();
        double one = amount / oldNum;
        double newAmount = one * num;

        if (!ri.checkIfDividable()) {
          newAmount = Math.round(newAmount);
          ri.setAmount(newAmount);
        } else {
          newAmount = (double) Math.round(newAmount * 100) / 100;
          ri.setAmount(newAmount);
        }
      }
      this.price = setPrice();
  }


  /**
   * Returns the price of the recipe.
   */
 public  double setPrice() {
  double price = 0;
  for (int counter = 0; counter < this.ingredients.size(); counter++) {
    RecipeIngredient ri = ingredients.get(counter);
    double ingredientPrice = ri.getPrice();
    double amount = ri.getAmount();
    double total = ingredientPrice * amount;
     price += total;
    } 
    return price;
  }

  @Override
  public String toString() {
      return "Recipe: " + name + "\nPortions: " + portions + "\nIngredients: " + ingredients + "\nInstructions: " + instructions + "\nPrice: " + price;
  } 

}