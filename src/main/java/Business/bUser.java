package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Users;

import java.util.ArrayList;
import java.util.Date;

public class bUser
{
    public static Users UserLoggedIn;

    public boolean registerUser(Users user, String message)
    {
        try (var db = new DataConnection())
        {
            if(user.getUserName() != null && user.getUserPassword() != null && user.getUserMail() != null)
            {
                var checkUserName = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE name = '" + user.getUserName() + "'") == null;

                if(!checkUserName) return false;

                user.setActief(true);
                user.setDatumGeregistreerd(new Date());
                return db.insertObject(user.getClass(), user);
            }
            else
            {
                message = "Niet alle benodigde informatie is aanwezig! | bUser.registerUser";
                Logging.LogMessage(message);
                return false;
            }
        }
        catch(Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public boolean loginUser(String userName, String password)
    {
        try(var db = new DataConnection())
        {
            var user = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE name = '" + userName + "'");

            if(password.equals(user.getUserPassword()))
            {
                UserLoggedIn = user;
                return true;
            }

            if(UserLoggedIn != null) UserLoggedIn = null;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public Users getUser(int Id)
{
    try(var db = new DataConnection())
    {
        return db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE Id = " + Id);
    }
    catch (Exception ex)
    {
        Logging.HandleError(ex);
    }

    return null;
}

    public ArrayList<Users> getAllUsers()
    {
        try(var db = new DataConnection())
        {
            return db.getListFromQuery(new Users(), "SELECT u FROM Users u");
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return null;
    }

    public void logoutUser()
    {
        UserLoggedIn = null;
    }
}
