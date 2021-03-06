package ui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.PrintAppUtil;
//import library.assistant.database.DatabaseHandler;
//import library.assistant.util.LibraryAssistantUtil;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/login/login.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Print Application");

        PrintAppUtil.setStageIcon(stage);
        
//        new Thread(() -> {
//            DatabaseHandler.getInstance();
//        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
