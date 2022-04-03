import java.util.LinkedList;

public class Item {

    //member variables
    private String itemName;
    private String ingredients;
    private double itemPrice;
    private int timeToComplete;
    private String image;

    //constructor
    public Item(String itemName, double itemPrice, String ingredients,  int timeToComplete, String image) {
        this.itemName = itemName;
        this.ingredients = ingredients;
        this.itemPrice = itemPrice;
        this.timeToComplete = timeToComplete;
        this.image = image;
    }

    //set item name
    public void setItemName(String name) {
        this.itemName = name;
    }

    //get item name
    public String getItemName() {
        return this.itemName;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


    //get item price
    public double getItemPrice() {
        return this.itemPrice;
    }

    //set an item's price
    public void setItemPrice(double price) {
        this.itemPrice = price;
    }

    public int getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", ingredients=" + ingredients +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
