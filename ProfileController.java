import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProfileController implements Initializable {

    @FXML
    private Label phoneNumber =  new Label();

    @FXML
    private ScrollPane previousOrders;

    @FXML
    private Label userName = new Label();

    @FXML
    void returnToMenu(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));

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
    void signOutButton(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));

            Stage primaryStage = new Stage();
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("CurrentUser.txt");
        if(file.exists())
        {
            Scanner reader = null;
            try {
                reader = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String user = reader.nextLine();
            String pass = reader.nextLine();
            String phNum = reader.nextLine();
            
            String fileName = user + "PhoneInfo.txt";
            File contact = new File(fileName);
            if(contact.exists() == true)
            {
            	try {
					reader = new Scanner(contact);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	user = reader.nextLine();
            	phNum = reader.nextLine();
            }

            userName.setText(user);
            phoneNumber.setText(phNum);

            //phoneNumber.setText(phNum);
        }
        else
        {
    		Parent root = null;
			try {
				root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GrabDataError.fxml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.NONE);
            primaryStage.show();                

        }
    }
}