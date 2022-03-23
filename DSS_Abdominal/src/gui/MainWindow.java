package gui;

import dss_abdominal.Disease;
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

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    @FXML
    private BorderPane main_window;

    @FXML
    private  RadioButton smoker_yes;
    
    @FXML
    private  RadioButton smoker_no;
     
    @FXML
    private  RadioButton female;
    
    @FXML
    private  RadioButton male;
     
    @FXML
    private  RadioButton age_one;
    
    @FXML
    private  RadioButton age_two;
     
    @FXML
    private  RadioButton age_three;
    
    @FXML
    private  RadioButton age_four;
    
    @FXML
    private  RadioButton anxiety_depress_no;

    @FXML
    private Button button_next;
         
    private ToggleGroup smoker;
    private ToggleGroup gender;
    private ToggleGroup age;

    @Override
    public void initialize (URL url, ResourceBundle rb){

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
        boolean smokes = false;
        if (smokes_selected == smoker_yes){
            smokes = true;
        } else if (smokes_selected == smoker_no){
            smokes = false;
        }

        Toggle gender_toggle = gender.getSelectedToggle();
        Disease.Gender gender;
        if (gender_toggle == male){
            gender = Disease.Gender.MALE;
        } else if ( gender_toggle == female ){
            gender = Disease.Gender.FEMALE;

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

        if ( smokes ){
            System.out.println("Is a smoker!");

        }

        Parent root = FXMLLoader.load(getClass().getResource("Questions1.fxml"));
        
        //Scene scene = new Scene(root);
        main_window.setCenter(root);
        main_window.autosize();
        // Remove the next buttom at the bottom
        main_window.setBottom(null);
    }


}
