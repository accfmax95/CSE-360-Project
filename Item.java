import java.util.LinkedList;

public class Item {

    //member variables
    private String itemName;
    private LinkedList<String> ingredients;
    private double itemPrice;

    //constructor
    public Item(String itemName, LinkedList<String> ingredients, double itemPrice) {
        this.itemName = itemName;
        this.ingredients = ingredients;
        this.itemPrice = itemPrice;
    }

    //set item name
    public void setItemName(String name) {
        this.itemName = name;
    }

    //get item name
    public String getItemName() {
        return this.itemName;
    }

    public LinkedList<String> getIngredients() {
        return this.ingredients;
    }

    //add ingredient
    public void addIngredient(String ing) {
        this.ingredients.add(ing);
    }
    //remove ingredient
    public boolean removeIngredient(String ing) {
        return this.ingredients.remove(ing);
    }

    //get item price
    public double getItemPrice() {
        return this.itemPrice;
    }

    //set an item's price
    public void setItemPrice(double price) {
        this.itemPrice = price;
    }

    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", ingredients=" + ingredients +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
