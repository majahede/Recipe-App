package main.java.recipeApp;

public class RecipeApp {
  private ConsoleUi ui;


  RecipeApp() {
    ui = new ConsoleUi();
  }

  private void start() {
    int option = ui.mainMenu();
    switch (option) {
      case 1: ui.recipeMenu();
      case 2: ui.ingredientMenu();
      // case 3: quit();
      default: break;
  }
  }
  
  public static void main(String[] args) {
    RecipeApp r = new RecipeApp();
    r.start();

   
  }
}

