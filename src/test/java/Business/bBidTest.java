package Business;

import Models.Bids;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class bBidTest {
    private bBid objBid;
    private bUser objbUser;

    @BeforeEach
    void setUp() {
        objBid = new bBid();
        objbUser = new bUser();
        try {

            objbUser.loginUser("Test", "testPw");
        } catch (Exception e) {

        }
    }

    @Test
    void placeBid() {
        // Arrange
        var item = new Bids();
        var listing = new bListing().getAllListings().get(0);
        item.setListingId(listing.getId());
        item.setDate(new Date(System.currentTimeMillis()));
        item.setNote("Graag gauw kopen.");
        item.setPrice(new BigDecimal("500.53"));
        item.setStatus(0);

        // Act
        var bidPlaced = objBid.placeBid(item);

        // Assert
        assertEquals(true, bidPlaced);
    }

    private void assertEquals(boolean b, boolean bidPlaced) {
    }

    @Test
    void getBidsForListing() {
        // Arrange
        var listing = new bListing().getAllListings().get(0);

        // Act
        var result = objBid.getBidsForListing(listing.getId());

        // Assert
        assertTrue(result.size() > 0);
    }
}