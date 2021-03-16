package main.java.recipeApp;

public class RecipeApp {
  private ConsoleUi ui;


  RecipeApp() {
    ui = new ConsoleUi();
  }

  private void start() {
    ui.mainMenu();
  }
  
  public static void main(String[] args) {
    RecipeApp r = new RecipeApp();
    r.start();
  }
}

