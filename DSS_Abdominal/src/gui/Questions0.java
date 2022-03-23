package gui;

import dss_abdominal.Disease;
import dss_abdominal.Patient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Questions0 implements Initializable, QuestionPanel {
    @FXML
    private RadioButton smoker_yes;

    @FXML
    private  RadioButton smoker_no;

    @FXML
    private  RadioButton female;

    @FXML
    private  RadioButton male;

    @FXML
    private  RadioButton age_adult;

    @FXML
    private  RadioButton age_young_adult;

    @FXML
    private  RadioButton age_young;

    @FXML
    private  RadioButton age_child;


    private ToggleGroup smoker;
    private ToggleGroup gender;
    private ToggleGroup age;

    private MainWindow main;
    private Patient patient;

    @Override
    public void initialize (URL url, ResourceBundle rb){

        smoker = new ToggleGroup();
        gender = new ToggleGroup();
        age = new ToggleGroup();

        this.smoker_yes.setToggleGroup(smoker);
        this.smoker_no.setToggleGroup(smoker);
        this.male.setToggleGroup(gender);
        this.female.setToggleGroup(gender);
        this.age_adult.setToggleGroup(age);
        this.age_young_adult.setToggleGroup(age);
        this.age_young.setToggleGroup(age);
        this.age_child.setToggleGroup(age);



    }

    @Override
    public void initComponents(MainWindow main, Patient patient){
        this.main = main;
        this.patient = patient;
        if (patient.getAge() != null ) {
            if (patient.getAge() == Patient.AgeRange.ADULT) {
                smoker.selectToggle(age_adult);
            } else if (patient.getAge() == Patient.AgeRange.YOUNGADULT) {
                smoker.selectToggle(age_young_adult);
            } else if (patient.getAge() == Patient.AgeRange.YOUNG) {
                smoker.selectToggle(age_young);
            } else if (patient.getAge() == Patient.AgeRange.CHILD) {
                smoker.selectToggle(age_child);
            }
        }

        if ( patient.getGender() != null ) {
            if (patient.getGender() == Patient.Gender.FEMALE) {
                gender.selectToggle(female);
            } else {
                gender.selectToggle(male);
            }
        }

        if ( patient.isTobacco() ) {
            smoker.selectToggle(smoker_yes);
        } else {
            smoker.selectToggle(smoker_no);
        }

    }

    @Override
    public void getQuestionValues() {
        Toggle smokes_selected = smoker.getSelectedToggle();
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

        Toggle age_toggle = age.getSelectedToggle();
        Patient.AgeRange age = Patient.AgeRange.ADULT;
        if (gender_toggle == age_adult){
            age = Patient.AgeRange.ADULT;
        } else if ( gender_toggle == age_young_adult){
            age = Patient.AgeRange.YOUNGADULT;
        } else if ( gender_toggle == age_young){
            age = Patient.AgeRange.YOUNG;
        } else if ( gender_toggle == age_child){
            age = Patient.AgeRange.CHILD;
        }

        patient.setAge(age);
        patient.setGender(gender);
        patient.setTobacco(smokes);
    }

    @FXML
    private void checkRadialButtons(ActionEvent evnt){
        Toggle smokes_selected = smoker.getSelectedToggle();
        Toggle gender_toggle = gender.getSelectedToggle();
        Toggle age_toggle = age.getSelectedToggle();

        if ( smokes_selected == null || gender_toggle == null || age_toggle == null ) {
            main.button_next.setDisable(true);
        } else {
            main.button_next.setDisable(false);
        }

    }

}
