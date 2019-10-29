package Controllers;

import Business.bBid;
import Business.bCar;
import Business.bListing;
import Business.bUser;
import Models.Bids;
import Models.Cars;
import Models.Users;
import Support.Gui.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private Cars car1;
    private Cars car2;
    private Cars car3;

    @FXML
    private Button logoutButton;

    @FXML
    private Label carName1;
    @FXML
    private Label carName2;
    @FXML
    private Label carName3;

    @FXML
    private Label carKleur1;
    @FXML
    private Label carKleur2;
    @FXML
    private Label carKleur3;

    @FXML
    private Label carVarnish1;
    @FXML
    private Label carVarnish2;
    @FXML
    private Label carVarnish3;

    @FXML
    private Label carType1;
    @FXML
    private Label carType2;
    @FXML
    private Label carType3;

    @FXML
    private Label currentUsername;

    @FXML
    private Label listingsCar1;
    @FXML
    private Label listingsCar2;
    @FXML
    private Label listingsCar3;


    @FXML
    private TextField listingPrice1;
    @FXML
    private TextField listingPrice2;
    @FXML
    private TextField listingPrice3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        var user = new Users();

        var car = new bCar();

        car1 = car.getCar(2);
        car2 = car.getCar(3);
        car3 = car.getCar(4);

        System.out.println("Test" + user.getUserName());

        currentUsername.setText(bUser.UserLoggedIn.getUserName());

        updateUi();
    }


    public void postListing1(ActionEvent event) {
        this.doBid(car1.getId(), listingPrice1.getText());
    }

    public void postListing2(ActionEvent event) {
        this.doBid(car2.getId(), listingPrice2.getText());
    }

    public void postListing3(ActionEvent event) {
        this.doBid(car3.getId(), listingPrice3.getText());
    }

    private void doBid(int id, String price) {
        var objBid = new bBid();

        var bid = new Bids();
        bid.setDate(new Date(System.currentTimeMillis()));
        bid.setStatus(0);
        bid.setPrice(new BigDecimal(price));
        bid.setNote("Test");
        bid.setListingId(new bListing().getMostRecentByCarId(id).get(0).getId());

        objBid.placeBid(bid);

        updateUi();
    }

    @FXML
    public void logout(ActionEvent event) {
        System.out.println("TEST");

        bUser.UserLoggedIn = null;
        try {
            StageManager.getStage().setScene(StageManager.scene(StageManager.LOGIN_SCENE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUi() {
        carName1.setText(car1.getBrand());
        carName2.setText(car2.getBrand());
        carName3.setText(car3.getBrand());

        carKleur1.setText(car1.getColor());
        carKleur2.setText(car2.getColor());
        carKleur3.setText(car3.getColor());

        carVarnish1.setText(car1.getVarnish());
        carVarnish2.setText(car2.getVarnish());
        carVarnish3.setText(car3.getVarnish());

        carType1.setText(car1.getType());
        carType2.setText(car2.getType());
        carType3.setText(car3.getType());

        var listings = new bListing();
        var listingCar1 = listings.getMostRecentByCarId(car1.getId());
        var listingCar2 = listings.getMostRecentByCarId(car2.getId());
        var listingCar3 = listings.getMostRecentByCarId(car3.getId());

        if (listingCar1.size() > 0) {
            listingsCar1.setText(Double.toString(listingCar1.get(0).getPrice()));
        } else {
            listingsCar1.setText("Nog geen listing");
        }

        if (listingCar2.size() > 0) {
            listingsCar2.setText(Double.toString(listingCar2.get(0).getPrice()));
        } else {
            listingsCar2.setText("Nog geen listing");
        }

        if (listingCar3.size() > 0) {
            listingsCar3.setText(Double.toString(listingCar3.get(0).getPrice()));
        } else {
            listingsCar3.setText("Nog geen listing");
        }
    }
}
