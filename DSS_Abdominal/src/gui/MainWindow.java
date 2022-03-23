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
    private  Button button_prev;

    @FXML
    private Button button_next;
         
    private ToggleGroup smoker;
    private ToggleGroup gender;
    private ToggleGroup age;

    private static Patient patient;

    private int page_num = 0;

    @Override
    public void initialize (URL url, ResourceBundle rb){

        patient = new Patient();

        smoker = new ToggleGroup();
        gender = new ToggleGroup();
        age = new ToggleGroup();

        this.smoker_yes.setToggleGroup(smoker);
        this.smoker_no.setToggleGroup(smoker);
        this.male.setToggleGroup(gender);
        this.female.setToggleGroup(gender);
//        this.age_one.setToggleGroup(age);
//        this.age_two.setToggleGroup(age);
//        this.age_three.setToggleGroup(age);
//        this.age_four.setToggleGroup(age);



    }
        
    
    @FXML
    public void goToQuestions(ActionEvent event) throws Exception {

        Toggle smokes_selected = smoker.getSelectedToggle();
        System.out.println("smokes_selected: "+smokes_selected);
        boolean smokes = false;
        if (smokes_selected == smoker_yes){
            smokes = true;
        } else if (smokes_selected == smoker_no){
            smokes = false;
        }

        Toggle gender_toggle = gender.getSelectedToggle();
        Patient.Gender gender = Patient.Gender.MALE;
        if (gender_toggle == male){
            gender = Patient.Gender.MALE;
        } else if ( gender_toggle == female ){
            gender = Patient.Gender.FEMALE;
        }

//        Toggle age_toggle = age.getSelectedToggle();
//        Disease.AgeRange age;
//        if (gender_toggle == age_one){
//            age = Disease.AgeRange.ADULT;
//        } else if ( gender_toggle == age_two ){
//            age = Disease.AgeRange.YOUNGADULT;
//        } else if ( gender_toggle == age_three ){
//            age = Disease.AgeRange.YOUNG;
//        } else if ( gender_toggle == age_four ){
//            age = Disease.AgeRange.CHILD;
//        }

        // patient.setAge(age);
        patient.setGender(gender);
        patient.setTobacco(smokes);
    }

    public void next() throws IOException {
        page_num++;
        FXMLLoader loader;
        Parent root;

        switch ( page_num ){
            case 1:
                loader = new FXMLLoader(getClass().getResource("Questions1.fxml"));
                root = loader.load();
                Questions1 q1 = loader.getController();

                //Scene scene = new Scene(root);
                main_window.setCenter(root);
                // Remove the next buttom at the bottom
                main_window.setBottom(null);
                break;
            case 2:
                loader = new FXMLLoader(getClass().getResource("Questions2.fxml"));
                root = loader.load();
                Questions2 q2 = loader.getController();

                //Scene scene = new Scene(root);
                main_window.setCenter(root);
                // Remove the next buttom at the bottom
                main_window.setBottom(null);
        }
    }
}
