package main.java.recipeApp;

import java.util.ArrayList;

public class RecipeApp {
  private ConsoleUi ui;
  private IngredientHandler ingredientHandler;
  private RecipeHandler recipeHandler;

  RecipeApp() {
    ui = new ConsoleUi();
    ingredientHandler = new IngredientHandler();
    recipeHandler = new RecipeHandler();
  }

  private void startApp() {
    ingredientHandler.readFromFile();
    recipeHandler.readFromFile();
    mainMenu();
  }

  private void mainMenu() {
    char option = ui.mainMenu();
    switch (option) {
      case 'R': recipeMenu(); break;
      case 'I': ingredientMenu(); break;
      case 'C': closeApp(); break;
      default: break;
    }
  }

  private void recipeMenu() {
    ConsoleUi.Option option = ui.recipeMenu();
    switch (option) {
      case LIST: list("recipe"); break;
      case ADD: add("recipe"); break;
      case SEARCH: searchRecipe(); break;
      case QUIT: closeApp(); break;
      case BACK: mainMenu(); break;
      default: break;
    }
  }

  private void ingredientMenu() {
    ConsoleUi.Option option = ui.ingredientMenu();
    switch (option) {
      case LIST: list("ingredient"); break;
      case ADD: add("ingredient"); break;
      case QUIT: closeApp(); break;
      case BACK: mainMenu(); break;
      default: break;
    }
  }

  private void viewDetails(String type) {
    if(type.equals("ingredient")) {
      String i = ui.enterName("ingredient");
      Ingredient ingredient = ingredientHandler.getIngredient(i);
      ConsoleUi.Option option = ui.viewIngredientDetails(ingredient);
      switch (option) {
        case DELETE: deleteIngredient(i); break;
        case BACK: mainMenu(); break;
        case QUIT: closeApp(); break;
        default: break;
      }
    } else if(type.equals("recipe")) {
      String r = ui.enterName("recipe");
      Recipe recipe = recipeHandler.getRecipe(r);
      ConsoleUi.Option option = ui.viewRecipeDetails(recipe);
      switch (option) {
        case DELETE: deleteRecipe(r); break;
        case EDIT: editPortions(recipe); break;
        case BACK: mainMenu(); break;
        case QUIT: closeApp(); break;
        default: break;
      }
    }
  }

  /**
   * Calls method to delete recipe and return to main menu.
   */
  private void editPortions(Recipe recipe) {
    int portions = ui.getNumOfPortions();
    recipe.editPortions(portions);
    ConsoleUi.Option option = ui.viewRecipeDetails(recipe);

    switch (option) {
      case DELETE: deleteRecipe(recipe.getName()); break;
      case EDIT: editPortions(recipe); break;
      case BACK: mainMenu(); break;
      case QUIT: closeApp(); break;
      default: break;
    }
  }

  /**
   * Calls method to delete ingredient and return to main menu.
   */
  private void deleteIngredient(String ingredient) {
    ingredientHandler.delete(ingredient);
    mainMenu();
  }

  /**
   * Calls method to delete recipe and return to main menu.
   */
  private void deleteRecipe(String recipe) {
    recipeHandler.delete(recipe);
    mainMenu();
  }

  /**
   * Prints out searched recipes.
   */
  private void searchRecipe() {
     int choice = ui.search();
     String input = "";
     if(choice == 1) {
      recipeHandler.setStrategy(new SearchByIngredient(recipeHandler.getRecipes()));
      input = ui.enterName("ingredient");

     } else if (choice == 2) {
      recipeHandler.setStrategy(new SearchByPrice(recipeHandler.getRecipes()));
      input = ui.enterName("max price");
     }

     ArrayList<Recipe> searchedRecipes = recipeHandler.search(input);
     for (int counter = 0; counter < searchedRecipes.size(); counter++) {
      Recipe recipe = searchedRecipes.get(counter);
      System.out.println(recipe.getName()); 		
    }   	
    ConsoleUi.Option option = ui.list();
    switch (option) {
      case VIEW: viewDetails("recipe"); break;
      case BACK: recipeMenu(); break;
      case QUIT: closeApp(); break;
      default: break;
  } 
    } 
  
  /**
   * Calls method to list recipes or ingredients.
   */
  private void list(String type) {
    if(type.equals("ingredient")) {
      ingredientHandler.list();

    } else if (type.equals("recipe")) {
      recipeHandler.list();
      }
      ConsoleUi.Option option = ui.list();
      switch (option) {
        case VIEW: viewDetails(type); break;
        case BACK: recipeMenu(); break;
        case QUIT: closeApp(); break;
        default: break;
    } 
  }

  /**
   * Calls method to add ingredient or recipe.
   */
  private void add(String type) {
    if(type.equals("ingredient")) {
      Ingredient ingredient = ui.addIngredient();
      ingredientHandler.addIngredient(ingredient);

    } else if (type.equals("recipe")) {
      Recipe recipe = ui.addRecipe();
      recipeHandler.addRecipe(recipe);
      ArrayList<RecipeIngredient> ingredients = recipe.getIngredients();

      for (int counter = 0; counter < ingredients.size(); counter++) {
        RecipeIngredient ri = ingredients.get(counter);
        Ingredient i = new Ingredient(ri.getName(), ri.getUnit(), ri.getPrice(), ri.checkIfDividable());
        ingredientHandler.addIngredient(i);
      }
    }
    
    mainMenu();
  }

  /**
   * Close app.
   */
  private void closeApp() {
    ingredientHandler.writeToFile();
    recipeHandler.writeToFile();
    ui.closeApp();
  }

  public static void main(String[] args) {
    RecipeApp r = new RecipeApp();
    r.startApp();
    
  }
}

