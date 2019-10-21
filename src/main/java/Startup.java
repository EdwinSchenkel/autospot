import Helpers.DataConnection;
import Logging.Logging;
import Models.Customer;
import Models.Users;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.Date;

public class Startup {
    public static void main(String[] args)
    {
        System.out.println("Start");
        addUser();
        System.out.println("Stop");

    }

    public static void addUser()
    {
        try(var db = new DataConnection()){
            //Users user = new Users();
            //user.setUserName("Henkooooo");
            //user.setUserPassword("Test");
            //user.setUserMail("Test@test.nl");
            //user.setDatumGeregistreerd(new Date());
            //user.setActief(true);

            //var data = db.insertObject(user.getClass(), user);
            //if(data)
             //   System.out.println("Gelukt");


            //Customer data2 = db.getObjectFromQuery(new Customer(), "SELECT u FROM Customer u WHERE Id = 1");
            var lijst = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE Id = 52");
            //System.out.println(lijst.size());
            if(lijst != null) {
                System.out.println(lijst.getId() + " | " + lijst.getUserName());
                db.deleteItem(lijst);
                //for(var item : lijst)
                //    System.out.println(item.getId() + " | " + item.getUserName());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("==========================================================================");
            ex.printStackTrace();
            Logging.HandleError(ex);
        }
    }
}
