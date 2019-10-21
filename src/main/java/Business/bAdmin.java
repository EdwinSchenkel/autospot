package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Users;

public class bAdmin
{
    public void editUser(Users user)
    {

    }

    public boolean isAdmin(int id)
    {
        try(var db = new DataConnection())
        {
            var admin = db.getObjectFromQuery(new Users(), "SELECT u FROM Users WHERE Id = " + id);
            if(admin != null)
                return admin.isAdmin();
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
        return false;
    }
}
