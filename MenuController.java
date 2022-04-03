import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.awt.image.ImageWatched;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;
import java.util.Objects;

public class MenuController {

    @FXML
    private ScrollPane menuPane;

    @FXML
    private TextField searchedItem;

    @FXML
    void accessCart(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Cart.fxml")));

            Stage primaryStage = new Stage();
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    void plusButtonIcon(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PromptUser.fxml")));

            Stage primaryStage = new Stage();
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    void viewOptionsForFilter(MouseEvent event) {

    }

    @FXML
    void viewOptionsForThreeLines(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Profile.fxml")));

            Stage primaryStage = new Stage();
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    //fill Menu
    public void fillMenu() throws IOException {
        LinkedList<Item> inventory = new LinkedList<>();
        LinkedList<String> tempIngredients = new LinkedList<>();
        File file = new File("items.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
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
                inventory.add(tempItem);
                tempIngredients = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
