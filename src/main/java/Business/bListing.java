package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Listings;

import java.util.ArrayList;

public class bListing {
    public boolean addListing(Listings listing) {
        try (var db = new DataConnection()) {
            return db.insertObject(listing.getClass(), listing);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return false;
    }

    public ArrayList<Listings> getAllListings() {
        try (var db = new DataConnection()) {
            return db.getListFromQuery(new Listings(), "SELECT l FROM Listings l");
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }

    public Listings getListing(int id) {
        try (var db = new DataConnection()) {
            return db.getObjectFromQuery(new Listings(), "SELECT l FROM Listings l WHERE Id = " + id);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return null;
    }

    public ArrayList<Listings> getListingByCarType(String carType) {
        try (var db = new DataConnection()) {
            return db.getListFromQuery(new Listings(), "SELECT l FROM Listings l JOIN Cars c ON l.carId = c.id WHERE c.type LIKE '%" + carType + "%'");
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }

    public boolean deleteListing(int id) {
        try (var db = new DataConnection()) {
            var item = db.getObjectFromQuery(new Listings(), "SELECT l FROM Listings l WHERE Id = " + id);
            return db.deleteItem(item);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return false;
    }

    public void editListing(Listings listing) {
        try (var db = new DataConnection()) {
            db.editObject(listing.getClass(), listing, listing.getId());
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }
    }

    public ArrayList<Listings> getMostRecentByCarId(int id) {
        try (var db = new DataConnection()) {
            return db.getListFromQuery(new Listings(), "SELECT l FROM Listings l WHERE carId = " + id + " ORDER BY id DESC");
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }
}
