import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MenuController extends ProfileController{

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
            
            File file = new File("CurrentUser.txt");
            if(file.exists())
            {
            	Scanner reader = new Scanner(file);
            	String user = reader.nextLine();
            	String pass = reader.nextLine();
            	String phNum = reader.nextLine();
            	System.out.println(user);
            	System.out.println(phNum);
            	
            	userName2.setText(user);
            	Enter();
            
            	//phoneNumber.setText(phNum);
            }
            else
            {
            	System.out.println("Failed to Load User Data");
            		//print an error message
            }
            primaryStage.show();
            
            
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
