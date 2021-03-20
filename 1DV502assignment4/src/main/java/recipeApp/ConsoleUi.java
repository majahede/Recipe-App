package main.java.recipeApp;

import java.util.Scanner;

public class ConsoleUi {

  private IngredientHandler ingredientHandler;
  private Scanner scan;

  ConsoleUi() {
    ingredientHandler = new IngredientHandler();
    scan = new Scanner(System.in);
  }
  
  /**
   * Represents the options a player has.
   */
  public enum Option {
    LIST,
    ADD,
    DELETE,
    SEARCH,
    QUIT,
    VIEW,
    BACK,
    None
  }

  /**
   * Adds a main menu.
   */
  public void mainMenu() {
    System.out.println("***Main Menu***\n");
    System.out.println("1. Manage recipes (R)");
    System.out.println("2. Manage ingredients (I)");
    System.out.println("3. Save and exit (C)");

    char option = getInput(scan);
    switch (option) {
      case 'R': recipeMenu(); break;
      case 'I': ingredientMenu(); break;
      case 'C': closeApp(); break;
      default: break;
  }
  }

  public void recipeMenu() {
    System.out.println("***Recipes***\n");
    System.out.println("List recipes (L)");
    System.out.println("New recipe (A)");
    System.out.println("Search recipe (S)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");
  }

  public void ingredientMenu() {
    System.out.println("***Ingredients***\n");
    System.out.println("List ingredients (L)");
    System.out.println("New ingredient (A)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");
  
    Option option = getOption();
    switch (option) {
      //case VIEW: 
      case ADD: ingredientHandler.addIngredient(); break;
      case QUIT: closeApp(); break;
      case BACK: mainMenu(); break;
      default: break;
    }
  }

  public void list () {
    ingredientHandler.listIngredients();
    System.out.println("View details (V)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");
    
    Option option = getOption();
    switch (option) {
      //case VIEW: 
      case ADD: ingredientHandler.addIngredient(); break;
      case QUIT: closeApp(); break;
      case BACK: ingredientMenu(); break;
      default: break;
  }
}

  public void viewDetails() {

  }

  /**
   * Close app.
   */
  public void closeApp() {
    ingredientHandler.writeToFile();
    System.out.println("Goodbye!");
  }

  /**
   * Get option.
   */
  public Option getOption() {
    char c;

    do {
      c = getInput(scan);
    } while (!(c == 'L' || c == 'A' || c == 'D' || c == 'S' || c == 'C' || c == 'V'|| c == 'B'));
      switch (c) {
        case 'L': return Option.LIST;
        case 'A': return Option.ADD;
        case 'D': return Option.DELETE;
        case 'S': return Option.SEARCH;
        case 'C': return Option.QUIT;
        case 'V': return Option.VIEW;
        case 'B': return Option.BACK;
        default: break;
    }
    return Option.None;
  }

  /**
   * Get input from user.
   */
  private char getInput(Scanner scan) {
    System.out.print("Pick an option: ");
   
    char option = scan.next().charAt(0);
   
    System.out.print("\n\n");
    return option;
  }

}
