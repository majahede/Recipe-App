package main.java.recipeApp;

public class RecipeApp {
  private ConsoleUi ui;
  private IngredientHandler ingredientHandler;

  RecipeApp() {
    ui = new ConsoleUi();
    ingredientHandler = new IngredientHandler();
  }

  private void startApp() {
    ingredientHandler.readFromFile();
    ui.mainMenu();
  }

  
  
  public static void main(String[] args) {
    RecipeApp r = new RecipeApp();
    r.startApp();
  }
}

