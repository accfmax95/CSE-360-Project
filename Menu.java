import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Menu {
    private LinkedList<Item> menuItems = new LinkedList();

    public Menu() {
        try {
            this.fillMenuList();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public LinkedList<Item> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(LinkedList<Item> menuItems) {
        this.menuItems = menuItems;
    }

    public void fillMenuList() throws IOException {
        File file = new File("items.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while((st = br.readLine()) != null) {
                LinkedList<String> tempIngredients = new LinkedList();
                String[] stringarray = st.split(":");
                String name = stringarray[0];
                double price = Double.parseDouble(stringarray[1]);
                String[] ingredients = stringarray[2].split(",");

                int time;
                for(time = 0; time < ingredients.length; ++time) {
                    tempIngredients.add(ingredients[time]);
                }

                time = Integer.parseInt(stringarray[3]);
                Item tempItem = new Item(name, price, tempIngredients, time, "/");
                this.menuItems.add(tempItem);
            }
        } catch (FileNotFoundException var12) {
            var12.printStackTrace();
        }


    }
}
