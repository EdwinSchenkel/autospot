package Controllers;

import Business.bUser;
import Exceptions.NonExistantUserException;
import Support.Gui.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button loginButton;
    @FXML private Button registratieButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void clickLoginButton(ActionEvent event) {

        try {
            var usr = new bUser();
            usr.loginUser(usernameField.getText(), passwordField.getText());

            StageManager.getStage().setScene(StageManager.scene(StageManager.HOME_SCENE));
        } catch (NonExistantUserException e) {
            showIncorrectUsernameDialog();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void clickRegistratieButton(ActionEvent event){

        try{
            StageManager.getStage().setScene(StageManager.scene(StageManager.CREATE_SCENE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showIncorrectUsernameDialog()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Deze username bestaat niet");
        alert.setHeaderText("Deze username bestaat niet");
        alert.setContentText("De ingevulde username komt niet overeen met een gebruiker in ons systeem!");

        alert.showAndWait();
    }


}
