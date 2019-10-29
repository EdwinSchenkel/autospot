import Business.bAdmin;
import Business.bUser;

import Support.Gui.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Startup extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    public void start(Stage stage)
    {
        StageManager.setStage(stage);

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            stage.setTitle("AUTOSPOT");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("AutoSpot testing");
            System.out.println(e);
        }





//        System.out.println("Start");
//        var usr = new bUser();
//        usr.loginUser("Test", "testPw");
//        var admin = new bAdmin();
//        admin.deleteUser(53);
//        addUser();
//        System.out.println("Stop");


    }



    public static void addUser()
    {
//        try(var db = new DataConnection()){
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
//            var lijst = db.getObjectFromQuery(new Users(), "SELECT u FROM Users u WHERE Id = 50");
//
//            var json = JsonHelper.toJson(lijst);
//            var helper = new FileWriterHelper();
//            var data = helper.OpenFile("test.json");
//            var dat = JsonHelper.fromJson(data, new Users());
//            System.out.println(dat.getUserName());
            //helper.WriteToFile(json);
            //var dat = mapper.readValue(json, lijst.getClass());
//            var obj = JsonHelper.fromJson(json, new Users());
//            //var js = JsonHelper.toJson(obj);
//            //System.out.println(js);
//            //System.out.println(obj.getUserName());
//            //System.out.println(json);
//            //System.out.println(lijst.size());
//            if(lijst != null) {
//                //System.out.println(lijst.getId() + " | " + lijst.getUserName());
//                //db.deleteItem(lijst);
//                //for(var item : lijst)
//                //    System.out.println(item.getId() + " | " + item.getUserName());
//            }




//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//            System.out.println("==========================================================================");
//            ex.printStackTrace();
//            Logging.HandleError(ex);
//        }
    }
}
