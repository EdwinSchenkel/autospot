package Support.Gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StageManager {

    private static Stage stage;

    public static final String LOGIN_SCENE = "/fxml/login.fxml";
    public static final String HOME_SCENE = "/fxml/home.fxml";
    public static final String CREATE_SCENE = "/fxml/registratie.fxml";

    public static void setStage(Stage input)
    {
        stage = input;
    }

    public static Stage getStage()
    {
        return stage;
    }

    public static Scene scene(String path) throws IOException {
        Parent root = FXMLLoader.load(StageManager.class.getResource(path));

        return new Scene(root);
    }

}
