package main.java.recipeApp;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SearchByPrice implements SearchInterface {
  private TreeMap<String, Recipe> recipes;

 /**
   * Creates a new SearchStrategy.
   */
  public SearchByPrice(TreeMap <String, Recipe> recipes) {
    this.recipes = recipes;
  }
  
  /**
   * Creates a new list with recipes that has a cost below users max price.
   */
  public ArrayList<Recipe> searchStrategy(String input) {
    double maxPrice = Double.parseDouble(input);

    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    for(Map.Entry<String,Recipe> entry : recipes.entrySet()) {
     
      Recipe r = entry.getValue();
      double price = r.getPrice();

      if (price <= maxPrice) {
        recipeList.add(r);
      }
    }
    return recipeList;
  }
}
