package main.java.recipeApp;

import java.util.TreeMap;
import java.util.Scanner;

public class IngredientHandler {

  TreeMap<String, Ingredient> ingredients = new TreeMap<String, Ingredient>();

  public Ingredient addIngredient() {
    Scanner scan = new Scanner(System.in);

    System.out.print("Name:");
    String name = scan.nextLine();

    System.out.print("Unit:");
    String unit = scan.nextLine();

    System.out.println("Price:");
    int price = scan.nextInt();

    Ingredient person = new Ingredient(name, unit, price);
    scan.close();
    return person;
    
  }

}