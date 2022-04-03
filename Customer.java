import java.text.NumberFormat;
import java.util.LinkedList;

public class Customer extends User {
    //member variables
    private CreditCard creditCard;
    private boolean isFrequent;
    private double couponPrice;
    private int numberOfOrders = 0;
    private LinkedList<Order> orders;
    private LinkedList<Item> curCart;

    //static variables for estimated wait time and users ahead
    private static int estimatedTime = 10;
    private static int usersAhead = 0;

    //customer type id is 1
    public Customer(String username, String password, int phoneNum) {
        super(username, password, phoneNum, 1);
        curCart = new LinkedList<Item>();
        orders = new LinkedList<>();
        isFrequent = false;
    }
    //more constructors may be needed if the user has shopping cart data


    public LinkedList<Item> getCurCart() {
        return this.curCart;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    //returns whether the user gets a coupon or not
    /*it can just calculate the number of items in the orders list
    and if it reaches a certain threshold, gives them a coupon discount
     */
    public boolean isFrequent() {
        return isFrequent;
    }

    public void applyCoupon(double couponDiscount) {
        Order tempOrder = orders.remove();
        double oldPrice = tempOrder.getOrderPrice();
        double newPrice = oldPrice - couponDiscount;
        if (newPrice < 0) {
            newPrice = 0;
        }
        Order modifiedOrder = new Order(tempOrder.getShoppingCart(), newPrice, tempOrder.getEstimatedTime(), tempOrder.getUsersAhead());
        orders.add(modifiedOrder);
    }
    public int getNumberOfOrders() {
        return this.numberOfOrders;
    }
    //adds item to user's cart
    public void addItemToCart(Item newItem) {
        curCart.add(newItem);
    }
    //removes item from users cart if found
    public boolean removeItemFromCart(Item item) {
        return curCart.remove(item);
    }
    //calculates the total price of items currently in the user's cart
    public double getCartPrice() {
        //total price
        double totalPrice = 0;
        int i;
        LinkedList<Item> temp = new LinkedList<>();
        //current cart
        while (!curCart.isEmpty()) {
            Item n = curCart.remove();
            totalPrice = totalPrice + n.getItemPrice();
            temp.add(n);
        }
        //restore list
        while (!temp.isEmpty()) {
            curCart.add(temp.remove());
        }
        //return total price
        return totalPrice;
    }
    //prints cart price with currency format
    public String getCartPriceCurrency() {
        double price = this.getCartPrice();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String currencyPrice = formatter.format(price);
        return currencyPrice;
    }

    //this function empties what is currently in the cart and creates an order which is added to the list of user orders
    public void sendCartToOrder() {
        int timeToComplete = 0;
        double cartPrice = this.getCartPrice();
        String price = this.getCartPriceCurrency();
        LinkedList<Item> temp = new LinkedList<>();
        while (!curCart.isEmpty()) {
            Item tempItem = curCart.remove();
            timeToComplete = timeToComplete + tempItem.getTimeToComplete();
            temp.add(tempItem);
        }
        estimatedTime = estimatedTime + timeToComplete;
        Order order = new Order(temp, cartPrice, estimatedTime, usersAhead);
        //each time order is created, estimated time is increased by 10
        //users ahead increased by 1
        usersAhead = usersAhead + 1;
        orders.add(order);
        System.out.println("\nOrder id "+ order.getOrderId() + " made by " + this.getUsername() + " totalling " + price + " processed\n");
        numberOfOrders++;
    }

    //returns orders
    public LinkedList<Order> getOrders() {
        return orders;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCart() {
        return creditCard;
    }

    public void printCartContents() {
        System.out.println("\n"+this.getUsername()+"'s cart");
        LinkedList<Item> temp = new LinkedList<>();

        while (!curCart.isEmpty()) {
            Item n = curCart.remove();
            System.out.println("     Item Name: " + n.getItemName());
            System.out.println("     Item Price: " + n.getItemPrice() + "\n");
            temp.add(n);
        }
        //restore list
        while (!temp.isEmpty()) {
            curCart.add(temp.remove());
        }
    }

    public void printOrders() {
        System.out.println("\n"+this.getUsername()+"'s orders");
        LinkedList<Order> temp = new LinkedList<>();

        while (!orders.isEmpty()) {
            Order n = orders.remove();
            System.out.println("     Order id: " + n.getOrderId());
            System.out.println("     Order Price: " + n.getOrderPrice());
            System.out.println("     Wait time: " + n.getEstimatedTime() + " minutes");
            System.out.println("     There are " + n.getUsersAhead() + " customers ahead\n");
            temp.add(n);
        }
        //restore list
        while (!temp.isEmpty()) {
            orders.add(temp.remove());
        }

    }

    //toString
    public String toString() {
        return "Customer{" +
                "username=" + this.getUsername() +
                ", password=" + this.getPassword() +
                ", userType=" + "Customer" +
                ", creditCard=" + creditCard +
                ", isFrequent=" + isFrequent +
                ", orders=" + orders +
                ", curCart=" + curCart +
                '}';
    }
}
