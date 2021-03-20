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
// import java.util.Scanner;

public class IngredientHandler {

  TreeMap<String, Ingredient> ingredients = new TreeMap<String, Ingredient>();

  /*
  * Add ingredient to ingredient list.
  */
  public void addIngredient(Ingredient ingredient) {
    
    ingredients.put(ingredient.getName(), ingredient);
   
  }

  /*
  * List ingredients.
  */
  public void listIngredients() {
    Set<String> keys = ingredients.keySet();
    for(String key: keys){
      System.out.println(key);
    }
  }

  /*
  * Delete ingredient.
  */
  public void deleteIngredient(String ingredient) {
    ingredients.remove(ingredient);
  }

  /*
  * Read ingredientfile.
  */
   public void readFromFile() {
    try {
      FileInputStream f = new FileInputStream(new File("lib//test.txt"));
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
      FileOutputStream f = new FileOutputStream(new File("lib//test.txt"));
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