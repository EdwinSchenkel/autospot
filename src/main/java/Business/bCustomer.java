package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Customer;

import java.util.ArrayList;

public class bCustomer
{
    public boolean addCustomer(Customer cust)
    {
        try(var db = new DataConnection())
        {
            return db.insertObject(cust.getClass(), cust);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public Customer getCustomer(int id)
    {
        try (var db = new DataConnection())
        {
            return db.getObjectFromQuery(new Customer(), "SELECT c FROM Customer c WHERE Id = " + id);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers(Boolean actief)
    {
        var custList = new ArrayList<Customer>();

        try (var db = new DataConnection())
        {
            if (actief != null)
                custList = db.getListFromQuery(new Customer(), "SELECT c FROM Customer c JOIN Users u ON c.userId = c.Id WHERE c.Actief = '" + actief + "'");
            else
                custList = db.getListFromQuery(new Customer(), "SELECT c FROM Customer c");

            return custList;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }
}
