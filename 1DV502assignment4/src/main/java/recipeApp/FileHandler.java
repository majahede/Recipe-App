package main.java.recipeApp;

/**
 * Interface to implement for file handlers.
 */
public interface FileHandler {

 /**
  * List objects.
  */
  public void list(); 

 /**
  * Delete an object.
  */
  public void delete(String name);

 /**
  * Read objects in a TreeMap to file.
  */
  public void readFromFile();

 /**
  * Writes objects from a file to a TreeMap.
  */
  public void writeToFile();
}