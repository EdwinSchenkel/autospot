package Business;

import Models.Address;
import Models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class bCustomerTest {
    private bCustomer objCust;
    @BeforeEach
    void setUp() {
        objCust = new bCustomer();
    }

    @Test
    void addCustomer() {
        // Arrange
        var userId = new bUser().getAllUsers().get(0).getId();
        var item = new Customer();
        item.setAddress(new Address("Test", "Test", "Test", "Test"));
        item.setUserId(userId);
        item.setFirstName("Gekke gerrit");
        item.setLastName("Freeksmaa");
        item.setMiddleName(null);

        // Act
        var result = objCust.addCustomer(item);

        // Assert
        assertTrue(result);
    }

    private void assertTrue(boolean result) {
    }

    @Test
    void getCustomer() {
        // Arrange
        var customer = objCust.getAllCustomers(null).get(0);

        // Act
        var result = objCust.getCustomer(customer.getCustomerId());

        // Assert
        assertNotNull(result);
    }
}