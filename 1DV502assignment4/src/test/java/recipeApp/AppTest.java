package test.java.recipeApp;

import java.util.ArrayList;

import org.junit.Test;

import main.java.recipeApp.Recipe;
import main.java.recipeApp.RecipeIngredient;
import static org.junit.Assert.*;

public class AppTest {
  @Test 
	public void testSetPrice() {
    ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
    RecipeIngredient milk = new RecipeIngredient("milk", "unit", 2, "", 6, true);
    RecipeIngredient sugar = new RecipeIngredient("milk", "tbsp", 2, "", 4, true);
    RecipeIngredient cocoa = new RecipeIngredient("milk", "tbsp", 4, "", 5, true);
    ingredients.add(milk);
    ingredients.add(sugar);
    ingredients.add(cocoa);

    Recipe recipe = new Recipe("Hot chocolate", 2, ingredients, "mix ingredients" );
   
    assertEquals(40.0, recipe.setPrice(), 0);
    ingredients.remove(sugar);
    assertEquals(32.0, recipe.setPrice(), 0);
	 } 
}
