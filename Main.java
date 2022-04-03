import java.io.IOException;
import java.util.Objects;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;



public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {

        try 
        {
        	
        	File file = new File("SignUpData.txt");
        	boolean success = false;
        	if(file.exists() == false)
        	{
        		FileWriter writer = new FileWriter("SignUpData.txt");
        		writer.write("admin");
        		writer.write("\n");
        		writer.write("1234");
        		writer.write("\n");
        		writer.close();
        	}
        	
        	success = true;
        	
        	if(success == true)
        	{
        		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignIn.fxml")));

                Scene scene = new Scene(root, 335, 600);
                primaryStage.setScene(scene);
                primaryStage.show();
        	}
            
        } 
        catch (IOException e) 
        {
            Parent root = null;
			try {
				root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FailedToLoadManager.fxml")));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

            Stage primaryStage2 = new Stage();
            Scene scene = new Scene(root);
            primaryStage2.setScene(scene);
            primaryStage2.initModality(Modality.NONE);
            primaryStage2.show();
            e.printStackTrace();
        }
    }


 
    public static void main(String[] args)
    {
        
        launch(args);
    }
}