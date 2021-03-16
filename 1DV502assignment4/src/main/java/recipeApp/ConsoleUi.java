package main.java.recipeApp;

import java.util.Scanner;

public class ConsoleUi {
  
  Scanner scan = new Scanner(System.in);

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
    System.out.print("Pick an option: ");
    // int option = scan.nextInt();
  }

 // scan.close();


}
