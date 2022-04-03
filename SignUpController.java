import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;



public class SignUpController {
    boolean check = false;
    @FXML
    private PasswordField passInput;

    @FXML
    private TextField userInput;

    @FXML
    void agreeToTOS(ActionEvent event) {
        check = true;
    }

    @FXML
    void signIn(ActionEvent event) {

        try
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));

            Stage primaryStage = new Stage();
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        try
        {

            boolean write = false;
            File preFile = new File("SignUpData.txt");
            if(preFile.exists())
            {
                //check for duplicates
                Scanner reader = new Scanner(preFile);
                boolean success = false;
                while(reader.hasNextLine())
                {
                    String uIn = reader.nextLine();
                    String pIn = reader.nextLine();
                    if(uIn.equals(userInput.getText()) && pIn.equals(passInput.getText()))
                    {
                        success = true;
                        break;
                    }
                }

                if(success == false)
                {
                    FileWriter file = new FileWriter("SignUpData.txt", true);
                    file.write(userInput.getText());
                    file.write("\n");
                    file.write(passInput.getText());
                    file.write("\n");
                    write = true;
                    file.close();

                }
                else
                {
                    System.out.println("The user is already registered");
                    //The user is already registered
                }
            }
            else
            {
                FileWriter file = new FileWriter("SignUpData.txt");
                file.write(userInput.getText());
                file.write("\n");
                file.write(passInput.getText());
                file.write("\n");
                write = true;
                file.close();
            }

            if(write == true && check == true)
            {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));

                Stage primaryStage = new Stage();
                primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

            } else {

                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUpError.fxml")));

                    Stage primaryStage = new Stage();
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.initModality(Modality.NONE);
                    primaryStage.show();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }

        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

}