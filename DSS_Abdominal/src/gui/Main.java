package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author AdriCortellucci
 */
public class Main extends Application {

    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            this.window = stage;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainWindow.fxml"));
            Parent root = loader.load();
            this.window.setScene(new Scene(root));
            this.window.setResizable(true);
            this.window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}