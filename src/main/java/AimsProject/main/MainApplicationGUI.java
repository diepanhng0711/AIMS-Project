package AimsProject.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplicationGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationGUI.class.getResource("AimsMainGUIController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("An Internet Media Store(AIMS)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}