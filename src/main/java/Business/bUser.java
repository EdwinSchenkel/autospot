package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Users;

import java.util.Date;

public class bUser
{
    public boolean registerUser(Users user, String message)
    {
        try (var db = new DataConnection())
        {
            if(user.getUserName() != null && user.getUserPassword() != null && user.getUserMail() != null)
            {
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
            var user = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE name = " + userName);

            if(password.equals(user.getUserPassword()))
                return true;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }
}
