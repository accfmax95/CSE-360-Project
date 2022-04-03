//Each customer has an empty list of order which is populated with instances of this class
//when they move the items in their current cart into an order

import java.util.LinkedList;

public class Order {

    //member variables
    private LinkedList<Item> shoppingCart;
    private int curOrderId;
    private double orderPrice;
    private int estimatedTime;
    private int usersAhead;
    private static int orderId = 0;

    //constructor
    public Order(LinkedList<Item> shoppingCart, double orderPrice, int estimatedTime, int usersAhead) {
        this.shoppingCart = shoppingCart;
        this.orderPrice = orderPrice;
        this.estimatedTime = estimatedTime;
        this.usersAhead = usersAhead;
        this.curOrderId = orderId;
        orderId++;
    }

    public LinkedList<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(LinkedList<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getOrderId() {
        return curOrderId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double newPrice) {
        this.orderPrice = newPrice;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public int getUsersAhead() {
        return usersAhead;
    }

    public String toString() {
        return "Order{" +
                "shoppingCart=" + shoppingCart +
                ", curOrderId=" + curOrderId +
                ", orderPrice=" + orderPrice +
                ", estimatedTime=" + estimatedTime +
                ", usersAhead=" + usersAhead +
                '}';
    }
}
