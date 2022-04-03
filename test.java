/*
This is a test program to run through creating customer objects, items, orders, and
calculating and viewing cart price and contents, as well as creating an order with a
specific wait time, id and number of users ahead
 */


import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        //test user 1
        Customer user = new Customer("aeedgewo", "secretPassword", 1111111);
        System.out.println();
        System.out.println(user.toString());

        Menu menu = new Menu();

        //TEST Items
        LinkedList<String> ing = new LinkedList<>();
        ing.add("Beans");
        ing.add("Cheese");
        Item item1 = new Item("Burrito",10.00, ing,  2);

        ing = new LinkedList<>();
        ing.add("Bread");
        ing.add("Peanut Butter");
        ing.add("Jelly");
        Item item2 = new Item("PBJ",3.20, ing,  2);

        ing = new LinkedList<>();
        ing.add("Pepporoni");
        ing.add("Cheese");
        ing.add("Ham");
        Item item3 = new Item("Pizza",12.25, ing,  15);

        //add items to customer cart
        user.addItemToCart(item1);
        user.addItemToCart(item2);
        user.addItemToCart(item1);
        user.addItemToCart(item3);


        //print customer to string, shows user information and current cart and order contents
        //cart should be filled with items, orders should be empty
        user.printCartContents();

        System.out.println();
        System.out.println(user.toString());

        //create order
        user.sendCartToOrder(false);

        //set customer credit card info
        CreditCard newCard = new CreditCard("cardName", "1/1/22", "11248274121", 123);
        user.setCreditCard(newCard);

        System.out.println();


        //SECOND TEST CUSTOMER
        Customer user2 = new Customer("dude", "password", 1234566);

        //MORE ITEMS
        ing = new LinkedList<>();
        ing.add("Chips");
        ing.add("Cheese");
        ing.add("Peppers");
        ing.add("Sour Cream");
        ing.add("Guac");
        ing.add("Salsa");
        Item item4 = new Item("Nachos", 9.99, ing,  8);

        ing = new LinkedList<>();
        ing.add("Pasta Sauce");
        ing.add("Meatballs");
        ing.add("Seasoning");
        ing.add("Parmesean Cheese");
        ing.add("Angel Hair Pasta");
        Item item5 = new Item("Spaghetti",13.50, ing,  13);

        ing = new LinkedList<>();
        ing.add("Chicken");
        ing.add("Sauce");
        ing.add("Fried Rice");
        Item item6 = new Item("Orange Chicken and Rice",8.25, ing ,  5);

        //add items to user2 cart
        user2.addItemToCart(item4);
        user2.addItemToCart(item3);
        user2.addItemToCart(item2);
        user2.removeItemFromCart(item2);
        user2.addItemToCart(item5);
        user2.addItemToCart(item6);

        //add items to user 1 cart
        user.addItemToCart(item3);
        user.addItemToCart(item5);

        //create orders for each user
        user2.sendCartToOrder(false);
        user.sendCartToOrder(false);

        //print user to strings to see orders
        user.printOrders();
        user2.printOrders();

        System.out.println();
    }
}
