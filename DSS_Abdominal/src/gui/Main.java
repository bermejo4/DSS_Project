package gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            this.window = stage;
            this.window.setOnCloseRequest(e->System.exit(0));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
            Parent root = loader.load();
            this.window.setScene(new Scene(root));
            this.window.setTitle("Decision Support System");
            this.window.setHeight(1000);
            this.window.setWidth(1000);

            //this.window.setResizable(false);
            this.window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}