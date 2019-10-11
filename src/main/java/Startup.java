import Helpers.DataConnection;
import Models.Customer;
import Models.Users;
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
            Users user = new Users();
            user.setUserName("Henkooooo");
            user.setUserPassword("Test");
            user.setUserMail("Test@test.nl");
            user.setDatumGeregistreerd(new Date());
            user.setActief(true);

            var data = db.InsertObject(user.getClass(), user);
            if(data)
                System.out.println("Gelukt");


            Customer data2 = (Customer) db.GetObjectFromQuery(new Customer(), "SELECT u FROM Customer u WHERE Id = 1");

            if(data2 != null)
                System.out.println(data2.getAddress().getAddress());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("==========================================================================");
            ex.printStackTrace();
        }
    }
}
