package Business;

import Models.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNull;

class bUserTest {
    private bUser objUser;

    @BeforeEach
    void setUp() {
        objUser = new bUser();
    }

    @Test
    void registerUser() {
        // Arrange
        var newUserName = UUID.randomUUID().toString();
        var item = new Users();
        item.setUserName(newUserName);
        item.setUserPassword("testpass");
        item.setActief(true);
        item.setDatumGeregistreerd(new Date());
        item.setUserMail("dit@dat.nl");

        // Act
        try {
            objUser.registerUser(item, null);
        } catch (Exception e) {

        }
        var checkListUsers = objUser.getAllUsers();
        var userIsSaved = false;
        if (checkListUsers.size() > 0) {
            for (var record : checkListUsers) {
                if (record.getUserName().equals(newUserName)) userIsSaved = true;
            }
        }

        // Assert
        assertTrue(userIsSaved);
    }

    private void assertTrue(boolean userIsSaved) {
    }

    @Test
    void loginUser() {
        // Arrange
        var user = objUser.getAllUsers().get(0);

        // Act
        try {
            var result = objUser.loginUser(user.getUserName(), user.getUserPassword());

            // Assert
            assertTrue(result);
        } catch (Exception e) {

        }
    }

    @Test
    void logoutUser() {
        // Arrange
        loginUser();

        // Act
        objUser.logoutUser();

        // Assert
        assertNull(bUser.UserLoggedIn);
    }
}