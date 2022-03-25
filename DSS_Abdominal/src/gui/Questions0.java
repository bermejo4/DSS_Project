package gui;

import dss_abdominal.Disease;
import dss_abdominal.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

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
    
    @FXML
    private  RadioButton genetic_yes;
    
    @FXML
    private  RadioButton genetic_no;
    
    @FXML
    private  RadioButton ulcers_yes;
    
    @FXML
    private  RadioButton ulcers_no;
    


    private ToggleGroup smoker;
    private ToggleGroup gender;
    private ToggleGroup age;
    private ToggleGroup genetic;
    private ToggleGroup ulcers;

    private MainWindow main;
    private Patient patient;

    @Override
    public void initialize (URL url, ResourceBundle rb){

        smoker = new ToggleGroup();
        gender = new ToggleGroup();
        age = new ToggleGroup();
        genetic = new ToggleGroup();
        ulcers= new ToggleGroup();

        this.smoker_yes.setToggleGroup(smoker);
        this.smoker_no.setToggleGroup(smoker);
        this.male.setToggleGroup(gender);
        this.female.setToggleGroup(gender);
        this.age_adult.setToggleGroup(age);
        this.age_young_adult.setToggleGroup(age);
        this.age_young.setToggleGroup(age);
        this.age_child.setToggleGroup(age);
        this.genetic_yes.setToggleGroup(genetic);
        this.genetic_no.setToggleGroup(genetic);
        this.ulcers_yes.setToggleGroup(ulcers);
        this.ulcers_no.setToggleGroup(ulcers);


    }

    @FXML
    public void checkRadialButtons(ActionEvent event) throws Exception{
        Toggle smokes_selected = smoker.getSelectedToggle();
        Toggle gender_toggle = gender.getSelectedToggle();
        Toggle age_toggle = age.getSelectedToggle();

        if ( smokes_selected == null || gender_toggle == null || age_toggle == null ) {
            main.button_next.setDisable(true);
        } else {
            main.button_next.setDisable(false);
        }

    }

    @Override
    public void initComponents(MainWindow main, Patient patient){
        this.main = main;
        this.patient = patient;
        if (patient.getAge() != null ) {
            if (patient.getAge() == Patient.AgeRange.ADULT) {
                age.selectToggle(age_adult);
            } else if (patient.getAge() == Patient.AgeRange.YOUNGADULT) {
                age.selectToggle(age_young_adult);
            } else if (patient.getAge() == Patient.AgeRange.YOUNG) {
                age.selectToggle(age_young);
            } else if (patient.getAge() == Patient.AgeRange.CHILD) {
                age.selectToggle(age_child);
            }
        }

        if ( patient.getGender() != null ) {
            if (patient.getGender() == Patient.Gender.FEMALE) {
                gender.selectToggle(female);
            } else {
                gender.selectToggle(male);
            }
        }
        if ( patient.isTobacco() != null) {
            if (patient.isTobacco()) {
                smoker.selectToggle(smoker_yes);
            } else {
                smoker.selectToggle(smoker_no);
            }
        }
        if ( patient.isGenetic() != null) {
            if (patient.isGenetic()) {
                genetic.selectToggle(genetic_yes);
            } else {
                genetic.selectToggle(genetic_no);
            }
        }
        if ( patient.isUlcers() != null) {
            if (patient.isGenetic()) {
                ulcers.selectToggle(ulcers_yes);
            } else {
                ulcers.selectToggle(ulcers_no);
            }
        }

        try {
            checkRadialButtons(null);
        } catch ( Exception e ){
            e.printStackTrace();
            System.out.println("Error checking if radials already have buttons.");
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
        
        Toggle genetic_selected = genetic.getSelectedToggle();
        boolean genetics = false;
        if (genetic_selected == genetic_yes){
            genetics = true;
        } else if (genetic_selected  == genetic_no){
            genetics = false;
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
        if (age_toggle == age_adult){
            age = Patient.AgeRange.ADULT;
        } else if ( age_toggle == age_young_adult){
            age = Patient.AgeRange.YOUNGADULT;
        } else if ( age_toggle == age_young){
            age = Patient.AgeRange.YOUNG;
        } else if ( age_toggle == age_child){
            age = Patient.AgeRange.CHILD;
        }
        
         Toggle ulcer_selected = ulcers.getSelectedToggle();
        boolean ulcer = false;
        if (ulcer_selected == ulcers_yes){
            ulcer = true;
        } else if (ulcer_selected  == ulcers_no){
            ulcer = false;
        }
        
        

        patient.setAge(age);
        patient.setGender(gender);
        patient.setTobacco(smokes);
        patient.setGenetic(genetics);
        patient.setUlcers(ulcer);


    }


}
