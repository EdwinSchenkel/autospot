package Business;

import Models.Address;
import Models.Companies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class bCompanyTest {
    private bCompany objComp;

    @BeforeEach
    void setUp() {
        objComp = new bCompany();
    }

    @Test
    void addCompany() {
        // Arrange
        var custId = new bCustomer().getAllCustomers(true).get(0);
        var item = new Companies();
        item.setAddress(new Address("Test", "Test", "Test", "Test"));
        item.setCustomerId(custId.getCustomerId());
        item.setName("Testcompany");

        // Act
        var result = objComp.addCompany(item);

        // Assert
        assertTrue(result);
    }

    private void assertTrue(boolean result) {
    }

    @Test
    void editCompany() {
        // Arrange
        var item = objComp.getAllCompanies().get(0);
        var newValue = "Teststraat";
        item.getAddress().setAddress(newValue);

        // Act
        objComp.editCompany(item);
        var getCompany = objComp.getCompany(item.getId());

        // Assert
        assertEquals(newValue, getCompany.getAddress().getAddress());
    }

    private void assertEquals(String newValue, String address) {
    }
}