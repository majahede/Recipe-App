package main.java.recipeApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
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

  private void addToTree() {
    Ingredient ingredient = addIngredient();
    ingredients.put(ingredient.getName(), ingredient);
   }

   public void readFromFile() {
    try {
      FileInputStream f = new FileInputStream(new File("lib//ingredients.txt"));
      ObjectInputStream o = new ObjectInputStream(f);
     
      boolean isAvailable = true;
      while(isAvailable){
        if(f.available() != 0){
         Ingredient ingredient = (Ingredient) o.readObject();    
         ingredients.put(ingredient.getName(), ingredient);
        }
        else {
        isAvailable = false;
        }
    }
      o.close();
      f.close();

  } catch (FileNotFoundException e) {
      System.out.println("File not found");
  } catch (IOException e) {
      e.printStackTrace();
  } catch (ClassNotFoundException e) {
      e.printStackTrace();
  }
  }

  public void writeToFile() {
     
    try {
      FileOutputStream f = new FileOutputStream(new File("lib//ingredients.txt"));
      ObjectOutputStream o = new ObjectOutputStream(f);
      // Write objects to file
      Set<Map.Entry<String, Ingredient> > entries 
      = ingredients.entrySet(); 
      for (Map.Entry<String, Ingredient> entry : entries) { 
        o.writeObject(entry.getValue());
    } 
      o.close();
      f.close();

    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}