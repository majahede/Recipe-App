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

public class IngredientHandler {

  private TreeMap<String, Ingredient> ingredients = new TreeMap<String, Ingredient>();

 /** 
  * Add ingredient to ingredient list.
  */
  public void addIngredient(Ingredient ingredient) {
    ingredients.put(ingredient.getName(), ingredient);
  }

 /**
  * List ingredients.
  */
  public void list() {
    Set<String> keys = ingredients.keySet();
    for(String key: keys){
      System.out.println(key);
    }
  }


  /**
   * Get ingredient.
   */
  public Ingredient getIngredient(String ingredient) {
    Ingredient i = ingredients.get(ingredient);
    return i;
  }

 /**
  * Delete ingredient.
  */
  public void delete(String name) {
    ingredients.remove(name);
  }

 /**
  * Read ingredientfile.
  */
   public void readFromFile() {
    try {
      FileInputStream f = new FileInputStream(new File("ingredients1.txt"));
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

  /**
   * Write ingredients to file.
   */
  public void writeToFile() {
     
    try {
      FileOutputStream f = new FileOutputStream(new File("ingredients1.txt"));
      ObjectOutputStream o = new ObjectOutputStream(f);

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