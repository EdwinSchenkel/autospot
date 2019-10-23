package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Users;

public class bAdmin
{
    public void editUser(Users user)
    {
        try (var db = new DataConnection())
        {
            db.editObject(user.getClass(), user, user.getId());
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
    }

    public boolean deleteUser(int id)
    {
        try (var db = new DataConnection())
        {
            var item = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE Id = " + id);
            return db.deleteItem(item);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return false;
    }

    public boolean isAdmin(int id)
    {
        try(var db = new DataConnection())
        {
            var admin = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE Id = " + id);
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
