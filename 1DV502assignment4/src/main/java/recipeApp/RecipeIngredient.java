package main.java.recipeApp;


public class RecipeIngredient extends Ingredient {
  private static final long serialVersionUID = 1L;
  private double amount;
  private String comment;


   /**
   * Creates a new ingredient.
   */
  public RecipeIngredient(String name, String unit, double amount, String comment, double price, boolean isDividable) {
    super(name, unit, price, isDividable);
    this.comment = comment;
    this.amount = amount;

  }

   /**
   * Returns the unit of the ingredient.
   */
  public double getAmount() {
    return amount;
  }

   /**
   * Returns the unit of the ingredient.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

   /**
   * Returns the comment of the ingredient.
   */
  public String getComment() {
    return comment;
  }

  

  @Override
  public String toString() {
      return getName() + ","  + getUnit() + "," + amount + "," + comment + "," + getPrice() + ";";
  } 

}
