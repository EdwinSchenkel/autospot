package Business;

import Models.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bCarTest {
    private bUser objbUser;
    private bCar objCar;
    @BeforeEach
    void setUp() {
        objCar = new bCar();
        objbUser = new bUser();
        objbUser.loginUser("Test", "testPw");
    }

    @Test
    void addCar() {
        // Arrange
        var item = new Cars();
        item.setCustomerId(1);
        item.setBrand("Audi");
        item.setType("A4");
        item.setColor("Rood");

        // Act
        var carAdded = objCar.addCar(item);

        // Assert
        assertEquals(true, carAdded);
    }

    @Test
    void editCar() {
    }

    @Test
    void deleteCar() {
    }

    @Test
    void getCar() {
    }

    @Test
    void getAllCars() {
    }

    @Test
    void getFilteredCars() {
    }
}