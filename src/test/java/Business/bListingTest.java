package Business;

import Models.Listings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class bListingTest {
    private bListing objListing;
    @BeforeEach
    void setUp() {
        objListing = new bListing();
    }

    @Test
    void addListing() {
        // Arrange
        var objCar = new bCar();
        var carId = objCar.getAllCars().get(0).getId();

        var item = new Listings();
        item.setCarId(carId);
        item.setExpirationDate(new Date(System.currentTimeMillis()));
        item.setPlacementDate(new Date(System.currentTimeMillis()));
//        item.setPrice(new BigDecimal("5002.32"));

        // Act
        var result = objListing.addListing(item);

        // Assert
        assertTrue(result);
    }

    @Test
    void getAllListings() {
        // Arrange
        var geenResultaat = 0;

        // Act
        var result = objListing.getAllListings().size();

        // Assert
        assertTrue(result > geenResultaat);
    }

    @Test
    void getListing() {
        // Arrange
        var item = objListing.getAllListings().get(0);
        var id = item.getId();

        // Act
        var result = objListing.getListing(id);

        // Assert
        assertEquals(item, result);
    }

    private void assertEquals(Listings item, Listings result) {
    }

    @Test
    void getListingByCarType() {
        // Arrange
        var expect = true;
        var objCar = new bCar();
        var type = objCar.getAllCars().get(0).getType();

        // Act
        var result = objListing.getListingByCarType(type);
        if(result.size() > 0) {
            for(var rec : result){
                if(!objCar.getCar(rec.getCarId()).getType().equals(type)) expect = false;
            }
        }
        else expect = false;

        // Assert
        assertTrue(expect);

    }

    @Test
    void editListing() {
        // Arrange
        var item = objListing.getAllListings().get(0);
        Listings newPrice = new Listings("5156.32");
//        item.setPrice(newPrice);

        // Act
        objListing.editListing(item);
        var result = objListing.getListing(item.getId());

        // Assert
//        assertEquals(newPrice, result.getPrice());
    }
}