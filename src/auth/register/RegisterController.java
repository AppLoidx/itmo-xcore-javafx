package auth.register;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import jdk.nashorn.api.scripting.JSObject;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author Arthur Kupriyanov
 */
public class RegisterController {

    @FXML
    private ProgressIndicator indicator;

    @FXML
    private WebView webView;

    @FXML
    void initialize() {
        Stage stage = new Stage();
        WebEngine engine = webView.getEngine();
        engine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    public void changed(ObservableValue ov, State oldState, State newState) {
                        if (newState == State.SUCCEEDED) {
                            stage.setTitle(engine.getLocation());
                        }
                    }
                });
        //engine.load("register.html");
        URL url = getClass().getResource("register.html");
        engine.load(url.toExternalForm());

    }
    class eagler {
        public void open(URI url) {
            try {
                java.awt.Desktop.getDesktop().browse(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
