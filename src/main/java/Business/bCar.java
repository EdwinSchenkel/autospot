package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Cars;

import java.util.ArrayList;

public class bCar
{
    public boolean addCar(Cars car)
    {
        try(var db = new DataConnection())
        {
            return db.insertObject(car.getClass(), car);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public void editCar(Cars car)
    {
        try (var db = new DataConnection())
        {
            db.editObject(car.getClass(), car, car.getId());
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
    }

    public boolean deleteCar(int id)
    {
        try (var db = new DataConnection())
        {
            var item = db.getObjectFromQuery(new Cars(), "SELECT c FROM Cars c WHERE Id = " + id);
            return db.deleteItem(item);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public Cars getCar(int id)
    {
        try(var db = new DataConnection())
        {
            return db.getObjectFromQuery(new Cars(), "SELECT c FROM Cars c WHERE Id = " + id);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
        return null;
    }

    public ArrayList<Cars> getAllCars()
    {
        try(var db = new DataConnection())
        {
            return db.getListFromQuery(new Cars(), "SELECT c FROM Cars c");
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
        return new ArrayList<>();
    }

    public ArrayList<Cars> getFilteredCars(String searchQuery)
    {
        try(var db = new DataConnection())
        {
            return db.getListFromQuery(new Cars(), "SELECT c FROM Cars c WHERE (brand LIKE '%" + searchQuery + "%' OR color LIKE '%" + searchQuery + "%' OR varnish LIKE '" + searchQuery + "')");
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }
}
