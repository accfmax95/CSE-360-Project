import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class CheckOutController
{

    @FXML
    private TextField cardName;

    @FXML
    private TextField cardNumber;

    @FXML
    private TextField contactInfoInput;

    @FXML
    private TextField cvcInput;

    @FXML
    private TextField expCard;

    @FXML
    void confirmPayment(ActionEvent event)
    {

        try
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Success.fxml")));

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
    void returnToCart(MouseEvent event) 
    {

        try
        {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Cart.fxml")));

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
    void saveCardInfo(ActionEvent event)
    {
    	try
    	{
    		File orgfile = new File("CurrentUser.txt");
        	if(orgfile.exists())
        	{
        		Scanner reader = new Scanner(orgfile);
        		String user = reader.nextLine();
        		String fileName = user + "CardInfo.txt";
        		File file = new File(fileName);
        		if(file.exists() == false)
        		{
        			CreditCard card = new CreditCard(cardName.getText(), expCard.getText(), cardNumber.getText(), Integer.parseInt(cvcInput.getText()));
        			FileWriter write = new FileWriter(fileName);
        			write.write(user);
        			write.write("\n");
        			write.write(card.getName());
        			write.write("\n");
        			write.write(card.getDate());
        			write.write("\n");
        			write.write(card.getNumber());
        			write.write("\n");
        			write.close();
        		}
        		else
        		{
        			 Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CardDataAlreadySavedError.fxml")));

                     Stage primaryStage = new Stage();
                     Scene scene = new Scene(root);
                     primaryStage.setScene(scene);
                     primaryStage.initModality(Modality.NONE);
                     primaryStage.show();
        		}
        	}
        	else
        	{
        		System.out.println("There was an error grabbing user data");
        		//print an error message
        	}

    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}    	
    }

    @FXML
    void saveContactInfo(ActionEvent event)
    {
    	try
    	{
    		File file = new File("CurrentUser.txt");
    		if(file.exists())
    		{
    			Scanner reader = new Scanner(file);
    			String user = reader.nextLine();
    			String pass = reader.nextLine();
    			String phNum = contactInfoInput.getText();
    			file.delete();
    			FileWriter write = new FileWriter("CurrentUser.txt");
    			write.write(user);
    			write.write("\n");
    			write.write(pass);
    			write.write("\n");
    			write.write(phNum);
    			write.write("\n");
    			write.close();
    		}
    		else
    		{
    			System.out.println("There was an error grabbing user data");
        		//print an error message
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

}
