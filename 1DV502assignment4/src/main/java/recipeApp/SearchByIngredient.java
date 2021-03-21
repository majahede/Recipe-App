package main.java.recipeApp;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SearchByIngredient implements SearchInterface{
  private TreeMap<String, Recipe> recipes;

 /**
   * Creates a new SearchStrategy.
   */
  public SearchByIngredient(TreeMap <String, Recipe> recipes) {
    this.recipes = recipes;
  }

  /**
   * Creates a new list with recipes that include a specified ingredient.
   */
  public ArrayList<Recipe> searchStrategy(String input) {
    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    for(Map.Entry<String,Recipe> entry : recipes.entrySet()) {
     
      Recipe r = entry.getValue();

      ArrayList<RecipeIngredient> ingredients = r.getIngredients();
      for (int counter = 0; counter < ingredients.size(); counter++) {
        RecipeIngredient ri = ingredients.get(counter);
        if(input.equals(ri.getName())) {
          recipeList.add(r);
        }
      }
    }
    return recipeList;
  }
}
