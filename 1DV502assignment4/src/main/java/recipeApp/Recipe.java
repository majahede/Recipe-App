package main.java.recipeApp;

import java.util.ArrayList;
import java.io.Serializable;

public class Recipe implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;
  private int portions;
  private ArrayList<RecipeIngredient> ingredients;
  private String instructions;

   /**
   * Creates a new recipe.
   */
  public Recipe(String name, int portions, ArrayList<RecipeIngredient> ingredients, String instructions) {
    this.name = name;
    this.portions = portions;
    this.ingredients = ingredients;
    this.instructions = instructions;
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
        int amount = ri.getAmount();
        int one = amount / oldNum;
        int newAmount = one * num;
        ri.setAmount(newAmount);
      }
  }


  /**
   * Returns the price of the recipe.
   */
 /* public int getPrice() {
    return price;
  }*/

  @Override
  public String toString() {
      return "Recipe: " + name + "\nPortions: " + portions + "\nIngredients: " + ingredients + "\nInstructions: " + instructions;
  } 

}