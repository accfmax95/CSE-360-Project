import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class CheckOutController implements Initializable
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
        	if(cvcInput.getText().equals("") || expCard.getText().equals("") || contactInfoInput.getText().equals("") || 
        			cardNumber.getText().equals("") || cardName.getText().equals(""))
        	{
        		System.out.println("Please fill all fields");
        		//print an error message
        	}
        	else
        	{
        		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Success.fxml")));

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
        		  Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GrabDataError.fxml")));

                  Stage primaryStage = new Stage();
                  Scene scene = new Scene(root);
                  primaryStage.setScene(scene);
                  primaryStage.initModality(Modality.NONE);
                  primaryStage.show();
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
    			
    			//save for permanent use
    			String fileName = user + "PhoneInfo.txt";
    			File contact = new File(fileName);
    			if(contact.exists() == false)
    			{
    				FileWriter writer = new FileWriter(fileName);
    				writer.write(user);
    				writer.write("\n");
    				writer.write(phNum);
    				writer.write("\n");
    				writer.close();
    			}
    			else
    			{
    				contact.delete();
    				FileWriter writer = new FileWriter(fileName);
    				writer.write(user);
    				writer.write("\n");
    				writer.write(phNum);
    				writer.write("\n");
    				writer.close();
    			}
    		}
    		else
    		{
    			  Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GrabDataError.fxml")));

    	            Stage primaryStage = new Stage();
    	            Scene scene = new Scene(root);
    	            primaryStage.setScene(scene);
    	            primaryStage.initModality(Modality.NONE);
    	            primaryStage.show();
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		File file = new File("CurrentUser.txt");
		if(file.exists())
		{
			Scanner reader = null;
			try {
				reader = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String user = reader.nextLine();
			String contactFileName = user + "PhoneInfo.txt";
			String cardFileName = user + "CardInfo.txt";
			File contact = new File(contactFileName);
			File card = new File(cardFileName);
			if(contact.exists())
			{
				try {
					reader = new Scanner(contact);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String temp = reader.nextLine();
				String phNum = reader.nextLine();
				contactInfoInput.setText(phNum);
			}
			
			if(card.exists())
			{
				try {
					reader = new Scanner(card);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String temp = reader.nextLine();
				String name = reader.nextLine();
				String date = reader.nextLine();
				String number = reader.nextLine();
				cardName.setText(name);
				cardNumber.setText(number);
				expCard.setText(date);
			}
		}
		else
		{
			System.out.println("Failed to grab user data");
			//print an error message
		}
		
	}

}
