import java.io.*;
import java.util.LinkedList;

public class Menu {

    //member variables
    private LinkedList<Item> menuItems;

    //constructor
    public Menu() {
        //will take a text file and read all menu items and add
        //them to the menu queue
        menuItems = new LinkedList<Item>();
        try {
            fillMenuList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //fill Menu
    public void fillMenuList() throws IOException {
        File file = new File("items.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                LinkedList<String> tempIngredients = new LinkedList<>();
                //split the string
                String[] stringarray = st.split(":");
                String name = stringarray[0];
                double price = Double.parseDouble(stringarray[1]);
                String[] ingredients = stringarray[2].split(",");
                for (int i = 0; i < ingredients.length; i++) {
                    tempIngredients.add(ingredients[i]);
                }
                int time = Integer.parseInt(stringarray[3]);

                Item tempItem = new Item(name, price, tempIngredients, time);
                menuItems.add(tempItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
