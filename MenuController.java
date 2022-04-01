import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    @FXML
    private TextField searchedItem;

    @FXML
    void accessCart(MouseEvent event) {

    }

    @FXML
    void plusButtonIcon(MouseEvent event) {

    }

    @FXML
    void viewOptionsForFilter(MouseEvent event) {

    }

    @FXML
    void viewOptionsForThreeLines(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));

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