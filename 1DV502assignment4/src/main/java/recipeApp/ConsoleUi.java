package main.java.recipeApp;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUi {

  private Scanner scan;

  ConsoleUi() {
    scan = new Scanner(System.in);
  }
  
  /**
   * Represents the options the user has.
   */
  public enum Option {
    LIST,
    ADD,
    DELETE,
    EDIT,
    SEARCH,
    QUIT,
    VIEW,
    BACK,
    None
  }

  /**
   * Prints a main menu.
   */
  public char mainMenu() {
    System.out.println("***Main Menu***\n");
    System.out.println("1. Manage recipes (R)");
    System.out.println("2. Manage ingredients (I)");
    System.out.println("3. Save and exit (C)");

    char option = getInput(scan);
    return option;
  }

  /**
   * Prints a recipe menu.
   */
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

  /**
   * Prints ingredient menu.
   */
  public Option ingredientMenu() {
    System.out.println("***Ingredients***\n");
    System.out.println("List ingredients (L)");
    System.out.println("New ingredient (A)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");
  
    Option option = getOption();
    return option;
  }

  /**
   * Print options in list menu.
   */
  public Option list () {
    System.out.println("View details(V)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");

    Option option = getOption();
    return option;
}

 /**
   * Get ingredient or recipe name from user.
   */
  public String enterName(String type) {
    System.out.print("Enter " + type + ": ");
    String input = scan.nextLine();
    return input;
  }

 /**
   * Search.
   */
  public int search() {
    System.out.println("Search by ingredient (1)");
    System.out.println("Search by price (2)");
    System.out.print("Pick an option: ");
    int type = scan.nextInt();
    scan.nextLine();
    return type;
  }

  /**
   * Prints detail of an ingredient.
   */
  public Option viewIngredientDetails(Ingredient ingredient) {
    System.out.println(ingredient);
    System.out.println();
    System.out.println("Delete (D)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");

    Option option = getOption();
    return option;
  }

  /**
   * Prints detail of an ingredient.
   */
  public Option viewRecipeDetails(Recipe recipe) {
    System.out.println(recipe);
    System.out.println();
    System.out.println("Delete (D)");
    System.out.println("Edit portions (E)");
    System.out.println("Back (B)");
    System.out.println("Save and exit (C)");

    Option option = getOption();
    return option;
  }

   /**
   * Prints detail of an ingredient.
   */
  public int getNumOfPortions() {
    System.out.print("Enter number of portions: ");
    int portions = scan.nextInt();
    scan.nextLine();
    return portions;
  }


  public Ingredient addIngredient() {
    System.out.print("Name: ");
    String name = scan.nextLine();

    System.out.print("Unit: ");
    String unit = scan.nextLine();

    System.out.print("Price: ");
    double price = scan.nextDouble();
    scan.nextLine();

    boolean isDividable = true;
    System.out.print("Is ingredient dividable? (Y/N): ");
    char c = scan.next().charAt(0);
    scan.nextLine();
    if (c == 'Y') {
     isDividable = true;
    } else if(c == 'N') {
      isDividable = false;
    }

    Ingredient ingredient = new Ingredient(name, unit, price, isDividable);
    return ingredient;
  }

  public Recipe addRecipe() {
    ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();

    System.out.print("Name: ");
    String name = scan.nextLine();

    System.out.print("Portions: ");
    int portions = scan.nextInt();
    scan.nextLine();

    do {
    System.out.print("New ingredient(Y/N): ");
    char newIngredient = scan.next().charAt(0);
    scan.nextLine();
    if (newIngredient == 'Y') {
     RecipeIngredient i = addRecipeIngredient();
     ingredients.add(i);
    } else if(newIngredient == 'N') {
      break;
    }
    } while(true);
    

    System.out.print("Instructions: ");
    String instructions = scan.nextLine();
  
    Recipe recipe = new Recipe(name, portions, ingredients, instructions);
    
    return recipe;
  }

  public RecipeIngredient addRecipeIngredient() {
    System.out.print("Name: ");
    String name = scan.nextLine();

    System.out.print("Unit: ");
    String unit = scan.nextLine();

    System.out.print("Amount: ");
    double amount = scan.nextDouble();
    scan.nextLine();
    
    System.out.print("Comment: ");
    String comment = scan.nextLine();
   /* if(comment == null) {
      comment = "...";
    }*/

    System.out.print("Price: ");
    double price = scan.nextDouble();
    scan.nextLine();

    boolean isDividable = true;

    char c;
    do {
      System.out.print("Is ingredient dividable? (Y/N): ");
      c = scan.next().charAt(0);
      scan.nextLine();
    } while (!(c == 'Y' || c == 'N'));
       switch (c) {
        case 'Y': isDividable = true; break;
        case 'N': isDividable = false; break;
      }
     
    RecipeIngredient ingredient = new RecipeIngredient(name, unit, amount, comment, price, isDividable);
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
    } while (!(c == 'L' || c == 'A' || c == 'D' || c == 'E' || c == 'S' || c == 'C' || c == 'V'|| c == 'B'));
      switch (c) {
        case 'L': return Option.LIST;
        case 'A': return Option.ADD;
        case 'D': return Option.DELETE;
        case 'E': return Option.EDIT;
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
