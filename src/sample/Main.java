package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("SkyFarm Basic Application - Group H");
        primaryStage.setScene(new Scene(root, 750, 550));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}