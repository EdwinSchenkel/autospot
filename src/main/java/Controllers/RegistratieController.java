package Controllers;

import Business.bCar;
import Business.bListing;
import Business.bUser;
import Exceptions.NonExistantUserException;
import Exceptions.UserRegistrationException;
import Models.Cars;
import Models.Listings;
import Models.Users;
import Support.Gui.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.ResourceBundle;

public class RegistratieController implements Initializable {

    @FXML private TextField usernameFieldRegistratie;
    @FXML private TextField passwordFieldRegistratie;
    @FXML private TextField emailFieldRegistratie;

    @FXML private Button registratieSubmitknop;

    @FXML private Button backToLoginButton;

    protected bUser userRepository;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userRepository = new bUser();
    }

    @FXML
    protected void registratieSubmitknop(ActionEvent event){


    }

    @FXML
    public void submitRegistratie(ActionEvent event) {

        var user = new Users();
        user.setUserName(usernameFieldRegistratie.getText());
        user.setUserPassword(passwordFieldRegistratie.getText());
        user.setUserMail(emailFieldRegistratie.getText());
        user.setDatumGeregistreerd(new Date());
        user.setActief(true);
        user.setAdmin(true);

        try {
            userRepository.registerUser(user, null);
        } catch (UserRegistrationException e) {
            showIncorrectUsernameDialog();
        }

    }

    @FXML
    public void backToLoginScreen(ActionEvent event){

        try{

            StageManager.getStage().setScene(StageManager.scene(StageManager.LOGIN_SCENE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showIncorrectUsernameDialog()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Oops");
        alert.setHeaderText("Oops");
        alert.setContentText("You done goofed!");

        alert.showAndWait();
    }
}
