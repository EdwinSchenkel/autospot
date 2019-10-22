import Business.bAdmin;
import Business.bUser;
import Helpers.DataConnection;
import Helpers.FileWriterHelper;
import Helpers.JsonHelper;
import Logging.Logging;
import Models.Customer;
import Models.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.Date;

public class Startup {
    public static void main(String[] args)
    {
        System.out.println("Start");
        var usr = new bUser();
        usr.loginUser("Test", "testPw");
        var admin = new bAdmin();
        admin.deleteUser(51);
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
            var lijst = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE Id = 50");

            var json = JsonHelper.toJson(lijst);
            var helper = new FileWriterHelper();
            var data = helper.OpenFile("test.json");
            var dat = JsonHelper.fromJson(data, new Users());
            System.out.println(dat.getUserName());
            //helper.WriteToFile(json);
            //var dat = mapper.readValue(json, lijst.getClass());
            var obj = JsonHelper.fromJson(json, new Users());
            //var js = JsonHelper.toJson(obj);
            //System.out.println(js);
            //System.out.println(obj.getUserName());
            //System.out.println(json);
            //System.out.println(lijst.size());
            if(lijst != null) {
                //System.out.println(lijst.getId() + " | " + lijst.getUserName());
                //db.deleteItem(lijst);
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
