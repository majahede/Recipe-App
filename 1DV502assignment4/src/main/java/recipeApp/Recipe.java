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
  public int getportions() {
    return portions;
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