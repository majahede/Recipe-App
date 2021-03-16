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
  public void mainMenu() {
    System.out.println("***Main Menu***");
    System.out.println("1. Manage recipes");
    System.out.println("2. Manage ingredients");
    System.out.println("3. Save and exit");

    int option = getInputNumber();
    System.out.println(option);
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
