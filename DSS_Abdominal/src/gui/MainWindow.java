package gui;

import dss_abdominal.Disease;
import dss_abdominal.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    @FXML
    private BorderPane main_window;

    @FXML
    protected Button button_prev;

    @FXML
    protected Button button_next;


    protected static Patient patient;

    private int page_num = 0;
    private final int MAX_PAGE = 4;

    private QuestionPanel current_panel;

    @Override
    public void initialize (URL url, ResourceBundle rb){

        patient = new Patient();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Questions" + page_num + ".fxml"));

        Parent root = null;
        try {
            root = loader.load();
            current_panel = loader.getController();
            current_panel.initComponents(this, patient);
            main_window.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        button_next.setDisable(true);
        button_prev.setDisable(true);

    }
        
    
    @FXML
    public void button_pressed(ActionEvent event) throws Exception {

        if ( event.getSource() == button_next ) {
            page_num++;
            // Will not be enabled until the questions of the new current panel are all selected
            button_prev.setDisable(false);
            button_next.setDisable(true);
        } else {
            page_num--;
            // If we are going back that means this panel already has all the information
            button_next.setDisable(false);
            if( page_num == 0 ){
                button_prev.setDisable(true);
            }
        }
        changeQuestionPanel();
    }

    public void changeQuestionPanel() throws IOException {
        System.out.println(patient);
        current_panel.getQuestionValues();
        System.out.println(patient);

        if ( page_num <= MAX_PAGE) {
            FXMLLoader loader;
            Parent root;

            loader = new FXMLLoader(getClass().getResource("Questions" + page_num + ".fxml"));

            root = loader.load();
            current_panel = loader.getController();
            current_panel.initComponents(this, patient);
            main_window.setCenter(root);

        }
    }
}
