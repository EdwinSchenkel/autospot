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
            var result = db.insertObject(car.getClass(), car);
            return result;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public void editCar(Cars car)
    {

    }

    public boolean deleteCar(int id)
    {
        return false;
    }

    public Cars getCar(int id)
    {
        try(var db = new DataConnection())
        {
            var result = db.getObjectFromQuery(new Cars(), "SELECT c FROM Cars WHERE Id = " + id);
            return result;
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
            var result = db.getListFromQuery(new Cars(), "SELECT c FROM Cars");
            return result;
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
            var result = db.getListFromQuery(new Cars(), "SELECT c FROM Cars WHERE brand LIKE '%" + searchQuery + "%'");
            return result;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }
}
