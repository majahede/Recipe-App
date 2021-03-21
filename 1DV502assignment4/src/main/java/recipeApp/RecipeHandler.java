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

public class RecipeHandler {

  TreeMap<String, Recipe> recipes = new TreeMap<String, Recipe>();

  /*
  * Add recipe to recipe list.
  */
  public void addRecipe(Recipe recipe) {
    recipes.put(recipe.getName(), recipe);
  }

  /*
  * List recipes.
  */
  public void listRecipes() {
    Set<String> keys = recipes.keySet();
    for(String key: keys){
      System.out.println(key);
    }
  }

   /*
  * Get recipe.
  */
  public Recipe getRecipe(String recipe) {
    Recipe r = recipes.get(recipe);
    return r;
  }

  /*
  * Delete recipe.
  */
  public void deleteRecipe(String recipe) {
    recipes.remove(recipe);
  }

  /*
  * Read recipefile.
  */
   public void readFromFile() {
    try {
      FileInputStream f = new FileInputStream(new File("test.txt"));
      ObjectInputStream o = new ObjectInputStream(f);
     
      boolean isAvailable = true;
      while(isAvailable){
        if(f.available() != 0){
          Recipe recipe = (Recipe) o.readObject();    
          recipes.put(recipe.getName(), recipe);
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

  /*
  * Write recipes to file.
  */
  public void writeToFile() {
     
    try {
      FileOutputStream f = new FileOutputStream(new File("test.txt"));
      ObjectOutputStream o = new ObjectOutputStream(f);
      // Write objects to file
      Set<Map.Entry<String, Recipe> > entries 
      = recipes.entrySet(); 
      for (Map.Entry<String, Recipe> entry : entries) { 
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