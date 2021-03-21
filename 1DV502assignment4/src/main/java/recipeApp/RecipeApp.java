package main.java.recipeApp;

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
      case LIST: list(); break;
      case ADD: add("recipe"); break;
      //case SEARCH: search(); break;
      case QUIT: closeApp(); break;
      case BACK: mainMenu(); break;
      default: break;
    }
  }

  private void ingredientMenu() {
    ConsoleUi.Option option = ui.ingredientMenu();
    switch (option) {
      case LIST: list(); break;
      case ADD: add("ingredient"); break;
      case QUIT: closeApp(); break;
      case BACK: mainMenu(); break;
      default: break;
    }
  }

  private void viewDetails() {
    String i = ui.enterIngredient();
    Ingredient ingredient = ingredientHandler.getIngredient(i);
    ConsoleUi.Option option = ui.viewDetails(ingredient);
    switch (option) {
      case DELETE: delete(i); break;
      case BACK: mainMenu(); break;
      case QUIT: closeApp(); break;
      default: break;
    }
  }


  private void delete(String ingredient) {
    ingredientHandler.deleteIngredient(ingredient);
    mainMenu();
  }

  private void list() {
    ingredientHandler.listIngredients();
    ConsoleUi.Option option = ui.list();
    switch (option) {
      case VIEW: viewDetails(); break;
      case BACK: ingredientMenu(); break;
      case QUIT: closeApp(); break;
      default: break;
    }
  }

  private void add(String type) {
    if(type.equals("ingredient")) {
      Ingredient ingredient = ui.addIngredient();
      ingredientHandler.addIngredient(ingredient);
    } else if (type.equals("recipe")) {
      Recipe recipe = ui.addRecipe();
      recipeHandler.addRecipe(recipe);
    }
    
    mainMenu();
  }

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

