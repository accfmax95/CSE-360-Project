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

public class CheckOutController {

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
    void confirmPayment(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Success.fxml")));

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
    void returnToCart(MouseEvent event) {

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
    void saveCardInfo(ActionEvent event) {

    }

    @FXML
    void saveContactInfo(ActionEvent event) {

    }

}
