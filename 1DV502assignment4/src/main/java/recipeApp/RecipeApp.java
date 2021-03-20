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
  }

  private void ingredientMenu() {
    ConsoleUi.Option option = ui.ingredientMenu();
    switch (option) {
      case LIST: list(); break;
      case ADD: add(); break;
      case QUIT: closeApp(); break;
      case BACK: mainMenu(); break;
      default: break;
    }
  }

  private void list() {
    ingredientHandler.listIngredients();
    ConsoleUi.Option option = ui.list();
    switch (option) {
      //case VIEW: 
      case BACK: ingredientMenu(); break;
      case QUIT: closeApp(); break;
      default: break;
    }
  }

  private void add() {
    Ingredient ingredient = ui.add();
    ingredientHandler.addIngredient(ingredient);
    mainMenu();
  }

  private void closeApp() {
    ingredientHandler.writeToFile();
    ui.closeApp();
  }

  public static void main(String[] args) {
    RecipeApp r = new RecipeApp();
    r.startApp();
    
  }
}

