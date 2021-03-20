package main.java.recipeApp;

import java.util.Scanner;

public class ConsoleUi {

 // private IngredientHandler ingredientHandler;
  private Scanner scan;

  ConsoleUi() {
  //  ingredientHandler = new IngredientHandler();
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
  public char mainMenu() {
    System.out.println("***Main Menu***\n");
    System.out.println("1. Manage recipes (R)");
    System.out.println("2. Manage ingredients (I)");
    System.out.println("3. Save and exit (C)");

    char option = getInput(scan);
    return option;
  }

  public Option recipeMenu() {
    System.out.println("***Recipes***\n");
    System.out.println("List recipes (L)");
    System.out.println("New recipe (A)");
    System.out.println("Search recipe (S)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");
    Option option = getOption();
    return option;
  }

  public Option ingredientMenu() {
    System.out.println("***Ingredients***\n");
    System.out.println("List ingredients (L)");
    System.out.println("New ingredient (A)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");
  
    Option option = getOption();
    return option;
  }

  public Option list () {
    System.out.println("View details(V)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");

    Option option = getOption();
    return option;
}

  public String enterIngredient() {
    System.out.print("Enter ingredient: ");
    String ingredient = scan.nextLine();
    return ingredient;
  }

  public Option viewDetails(Ingredient ingredient) {
    System.out.println(ingredient);
    System.out.println();
    System.out.println("Delete (D)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");

    Option option = getOption();
    return option;
  }

  public Ingredient add() {
    System.out.print("Name: ");
    String name = scan.nextLine();

    System.out.print("Unit: ");
    String unit = scan.nextLine();

    System.out.print("Price: ");
    int price = scan.nextInt();
    scan.nextLine();

    Ingredient ingredient = new Ingredient(name, unit, price);
    return ingredient;
  }

  /**
   * Close app.
   */
  public void closeApp() {
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
    scan.nextLine();
    return option;
  }

}
