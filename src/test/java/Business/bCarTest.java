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
        item.setVarnish("Metalic");

        // Act
        var carAdded = objCar.addCar(item);

        // Assert
        assertTrue(carAdded);
    }

    @Test
    void editCar() {
        // Arrange
        var item = objCar.getAllCars().get(0);
        var carId = item.getId();
        var expectedNewType = "A5";

        // Act
        item.setType(expectedNewType);
        objCar.editCar(item);
        var newItem = objCar.getCar(carId);

        // Assert
        assertEquals(expectedNewType, newItem.getType());
    }

    @Test
    void deleteCar() {
        // Arrange
        var item = objCar.getAllCars().get(0);
        var carId = item.getId();

        // Act
        objCar.deleteCar(carId);
        var getCar = objCar.getCar(carId);

        // Assert
        assertNull(getCar);
    }

    @Test
    void getFilteredCars() {
        // Arrange
        var item = objCar.getAllCars();
        var filter = "Rood";
        int amount = 0;
        for(var rec : item)
            if(rec.getColor().equals(filter)) amount++;

        // Act
        var filteredList = objCar.getFilteredCars(filter);
        var filteredAmount = filteredList.size();

        // Assert
        assertEquals(amount, filteredAmount);
    }
}