/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Results implements Initializable {

    @FXML
    protected Button button_view;
    @FXML
    private BorderPane results_window;
    @FXML
    private TextField disease_solution;
    @FXML
    private TextField disease_treatment; 
    @FXML
    private Hyperlink medline; 
    
    
    public void button_pressed2(Stage stage,ActionEvent event) throws Exception {
            if ( event.getSource() == button_view ) {
            Parent root = FXMLLoader.load(getClass().getResource("BarChartSample.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        }
    }
     public void gobackques4(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions4.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

    }
        
     
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
