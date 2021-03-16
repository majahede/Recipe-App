package main.java.recipeApp;

import java.util.Scanner;

public class ConsoleUi {
  
  /**
   * Represents the options a player has.
   */
  public enum Option {
    LIST,
    ADD,
    DELETE,
    SEARCH,
    QUIT,
    None
  }


  /**
   * Adds a main menu.
   */
  public int mainMenu() {
    System.out.println("***Main Menu***");
    System.out.println("1. Manage recipes");
    System.out.println("2. Manage ingredients");
    System.out.println("3. Save and exit");

    int option = getInputNumber();
    return option;
  }

  public void recipeMenu() {
    System.out.println("1. List recipes");
    System.out.println("2. New recipe");
    System.out.println("3. Search recipe");
    System.out.println("4. Save and exit");
  }

  public void ingredientMenu() {
    System.out.println("1. List ingredients");
    System.out.println("2. New ingredient");
    System.out.println("3. Save and exit");
  }

  
  public Option getOption() {
    int n;

    do {
      n = getInputNumber();
    } while (n < 1 || n > 5);
      switch (n) {
        case 1: return Option.LIST;
        case 2: return Option.ADD;
        case 3: return Option.DELETE;
        case 4: return Option.SEARCH;
        case 5: return Option.QUIT;
        default: break;
    }
    return Option.None;
  }


  private int getInputNumber() {
    System.out.print("Pick an option: ");
    Scanner scan = new Scanner(System.in);

    int option = scan.nextInt();
    scan.close();
    return option;
  }

}
