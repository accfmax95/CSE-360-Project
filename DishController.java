import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DishController implements Initializable {

    @FXML
    private Label dishName;

    @FXML
    private Label dishPrice;

    @FXML
    private Text ingredientList;

    @FXML
    void addToCart(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
