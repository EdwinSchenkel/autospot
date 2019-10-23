package Business;

import Helpers.DataConnection;
import Models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class bAdminTest {
    private bAdmin objbAdmin;
    private bUser objbUser;
    @BeforeEach
    void setUp() {
        objbAdmin = new bAdmin();
        objbUser = new bUser();
        objbUser.loginUser("Test", "testPw");
    }

    @Test
    void editUser() {
            // Arrange
            var item = objbUser.getUser(2);
            var newName = UUID.randomUUID().toString();

            // Act
            item.setUserName(newName);
            objbAdmin.editUser(item);
            var newItem = objbUser.getUser(2);
            // Assert
            assertEquals(newName, newItem.getUserName());
    }

    @Test
    void deleteUser() {
        // Arrange
        var item = objbUser.getUser(5);

        // Act
        boolean result = false;
        if(item != null)
            result = objbAdmin.deleteUser(item.getId());

        // Assert
        assertEquals(true, result);
    }

    @Test
    void isAdmin() {
        // Arrange
        var item = objbUser.getUser(1);

        // Act
        boolean result = false;
        if(item != null)
            result = objbAdmin.isAdmin(item.getId());

        // Assert
         assertEquals(true, result);
    }
}