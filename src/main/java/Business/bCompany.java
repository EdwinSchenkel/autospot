package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Companies;

import java.util.ArrayList;

public class bCompany {
    public boolean addCompany(Companies company) {
        try (var db = new DataConnection()) {
            return db.insertObject(company.getClass(), company);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return false;
    }

    public void editCompany(Companies company) {
        try (var db = new DataConnection()) {
            db.editObject(company.getClass(), company, company.getId());
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }
    }

    public ArrayList<Companies> getAllCompanies() {
        try (var db = new DataConnection()) {
            return db.getListFromQuery(new Companies(), "SELECT c FROM Companies c");
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }

    public Companies getCompany(int id) {
        try (var db = new DataConnection()) {
            return db.getObjectFromQuery(new Companies(), "SELECT c FROM Companies c WHERE Id = " + id);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return null;
    }

    public boolean deleteCompany(int id) {
        try (var db = new DataConnection()) {
            var item = db.getObjectFromQuery(new Companies(), "SELECT c FROM Companies c WHERE Id = " + id);
            return db.deleteItem(item);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return false;
    }
}
