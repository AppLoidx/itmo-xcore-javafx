package auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author Arthur Kupriyanov
 */
public class AuthController {
    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button regusterBtn;

    @FXML
    private TextField loginField;

    @FXML
    void register(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) {
        System.out.println("Login " + loginField.textProperty().getValue());
        System.out.println("Password " + passwordField.textProperty().getValue());
    }
}
