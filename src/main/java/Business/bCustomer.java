package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Customer;

import java.util.ArrayList;

public class bCustomer extends Customer {
    public bCustomer()
    {

    }

    public boolean addCustomer(Customer cust)
    {
        try(var db = new DataConnection())
        {
            var result = db.insertObject(cust.getClass(), cust);
            return result;
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
            var cust = db.getObjectFromQuery(new Customer(), "SELECT c FROM Customer WHERE Id = " + id);
            return cust;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers(Boolean actief)
    {
        if(actief != null)
        {

        }

        return new ArrayList<>();
    }
}
