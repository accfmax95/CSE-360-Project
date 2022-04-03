import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.io.File;
import java.util.Scanner;

public class PromptUserController
{

    boolean access = false;
	
	@FXML
    void addItem(ActionEvent event)
	{

        try {
        	
        	control();
        	
        	if(access == true)
        	{
        		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddItem.fxml")));

                Stage primaryStage = new Stage();
                primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

        	}
       	}
        catch (IOException e) 
        {

            e.printStackTrace();
        }
    }

    @FXML
    void removeItem(ActionEvent event)
    {

        try
        {
        	
        	control();
        	
        	if(access == true)
        	{
        		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RemoveItem.fxml")));

                Stage primaryStage = new Stage();
                primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

        	}
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
    }

    @FXML
    void returnToMenu(ActionEvent event) 
    {

        try 
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));

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
    
    void control()
    {
    	try
    	{
    		File file = new File("CurrentUser.txt");
        	if(file.exists())
        	{
        		Scanner reader = new Scanner(file);
        		String user = reader.nextLine();
        		if(user.equals("admin"))
        		{
        			access = true;
        		}
        		else
        		{
        			try {
        	            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ManagerOnlyError.fxml")));

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

    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }

}
