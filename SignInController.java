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

public class SignInController 
{

    @FXML
    private PasswordField passInput;

    @FXML
    private TextField userInput;

    @FXML
    void signUp(ActionEvent event)
    {
        try 
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));

            Stage primaryStage = new Stage();
            primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) 
        {

            e.printStackTrace();
        }
    }

    @FXML
    void verifyLogin(ActionEvent event)
    {

        try 
        {
        	
        	File file = new File("SignUpData.txt");
        	boolean success = false;
        	if(file.exists())
        	{
              	Scanner reader = new Scanner(file);
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
        	}
        	
        	if(success == true)
        	{
        		File file2 = new File("CurrentUser.txt");
        		if(file2.exists())
        		{
        			file2.delete();
        		}
        		
    			FileWriter write = new FileWriter("CurrentUser.txt");
    			write.write(userInput.getText());
    			write.write("\n");
    			write.write(passInput.getText());
    			write.write("\n");
    			write.write("XXXXXXXXXX");
    			write.write("\n");
    			write.close();
    			
        		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));

                Stage primaryStage = new Stage();
                primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

        	}
        	else
        	{
        		System.out.println("Please enter a valid ID and password");
        		//print an error message
        	}
   }
        catch (IOException e) 
        {

            e.printStackTrace();
        }
     }
}