package Business;

import Helpers.DataConnection;
import Models.Users;

import java.util.Date;

public class bUser {
    public bUser()
    {

    }

    public boolean registerUser(Users user, String message)
    {
        try (var db = new DataConnection())
        {
            if(user.getUserName() != null && user.getUserPassword() != null && user.getUserMail() != null)
            {
                user.setActief(true);
                user.setDatumGeregistreerd(new Date());
                return db.InsertObject(user.getClass(), user);
            }
            else
            {
                message = "Niet alle benodigde informatie is aanwezig! | bUser.registerUser";
                bLogging.LogMessage(message);
                return false;
            }
        }
        catch(Exception ex)
        {
            bLogging.HandleError(ex);
        }

        return false;
    }
}
