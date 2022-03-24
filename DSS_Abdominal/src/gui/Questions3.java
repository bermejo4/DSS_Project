/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dss_abdominal.Patient;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author marin
 */
public class Questions3 {
    
      @FXML
    private RadioButton fever_low;

    @FXML
    private  RadioButton fever_medium;

    @FXML
    private  RadioButton fever_high;

    @FXML
    private  RadioButton discomfort_none;

    @FXML
    private  RadioButton discomfort_focalized;

    @FXML
    private  RadioButton discomfort_extended;

    @FXML
    private  RadioButton cramps_none;

    @FXML
    private  RadioButton cramps_mild;
    
     @FXML
    private  RadioButton cramps_disabling;
     
      @FXML
    private  RadioButton melenas_none;
      
       @FXML
    private  RadioButton melenas_few;
       
        @FXML
    private  RadioButton melenas_substantially;
        
        @FXML
    private  RadioButton dermatitis_none;
        
        @FXML
    private  RadioButton dermatitis_extended;
        
        @FXML
    private  RadioButton dermatitis_focalized;


    private ToggleGroup fever;
    private ToggleGroup discomfort;
    private ToggleGroup cramps;
    private ToggleGroup melenas;
    private ToggleGroup dermatitis;

    private MainWindow main;
    private Patient patient;


    public void initialize (URL url, ResourceBundle rb){

        fever = new ToggleGroup();
        discomfort = new ToggleGroup();
        cramps = new ToggleGroup();
        melenas = new ToggleGroup();
        dermatitis  = new ToggleGroup();


        this.fever_low.setToggleGroup(fever);
        this.fever_medium.setToggleGroup(fever);
        this.fever_high.setToggleGroup(fever);
        this.discomfort_none.setToggleGroup(discomfort);
        this.discomfort_focalized.setToggleGroup(discomfort);
        this.discomfort_extended.setToggleGroup(discomfort);
        this.cramps_none.setToggleGroup(cramps);
        this.cramps_mild.setToggleGroup(cramps);
        this.cramps_disabling.setToggleGroup(cramps);
        this.melenas_none.setToggleGroup(melenas);
        this.melenas_few.setToggleGroup(melenas);
        this.melenas_substantially.setToggleGroup(melenas);
        this.dermatitis_none.setToggleGroup(dermatitis);
        this.dermatitis_focalized.setToggleGroup(dermatitis);
        this.dermatitis_extended.setToggleGroup(dermatitis);
    }


    public void initComponents(MainWindow main, Patient patient) {
        this.main = main;
        this.patient = patient;

        if ( (int) (patient.getFever())==0 ) {
            fever.selectToggle(fever_low);
        } else if ((int) (patient.getFever())==1){
            fever.selectToggle(fever_medium);
        }
        else if ((int) (patient.getFever())==2){
            fever.selectToggle(fever_high);
        }

        if ( (int) (patient.getPerianalDiscom()) == 0 ){
            discomfort.selectToggle(discomfort_none);
        } else if ( (int) (patient.getPerianalDiscom()) == 1 ){
            discomfort.selectToggle(discomfort_focalized);
        } else if ( (int) (patient.getPerianalDiscom()) == 2 ){
            discomfort.selectToggle(discomfort_extended);
        }

        if ( (int) (patient.getCramps()) == 0 ){
            cramps.selectToggle(cramps_none);
        } else if ( (int) (patient.getCramps()) == 1 ){
            cramps.selectToggle(cramps_mild);
        } else if ( (int) (patient.getCramps()) == 2 ){
            cramps.selectToggle(cramps_disabling);
        }
        
        /*

        if ( (int) patient.ge()== 0) {
            melenas.selectToggle(melenas_none);
        } else if ( (int) patient.getNausea() == 1) {
            nausea_toggle.selectToggle(nausea_sporadic);
        } else if ( (int) patient.getNausea() == 2) {
            nausea_toggle.selectToggle(nausea_frequent);
        }

        if ( (int) (patient.()) == 0 ){
            discomfort.selectToggle(discomfort_none);
        } else if ( (int) (patient.getPerianalDiscom()) == 1 ){
            discomfort.selectToggle(discomfort_focalized);
        } else if ( (int) (patient.getPerianalDiscom()) == 2 ){
            discomfort.selectToggle(discomfort_extended);
        }
        if ( patient.isAnxiety() ) {
            anxiety_toggle.selectToggle(anxiety_depress_yes);
        } else {
            anxiety_toggle.selectToggle(anxiety_depress_no);
        }
*/
    }
/*
    @Override
    public void getQuestionValues() {
        Toggle fever_selected = fever.getSelectedToggle();
        Toggle discomfort_selected = discomfort.getSelectedToggle();
        Toggle cramps_selected = cramps.getSelectedToggle();
        Toggle melenas_selected = melenas.getSelectedToggle();
        Toggle dermatitis_selected = dermatitis.getSelectedToggle();

        patient.setFever(fever_selected == fever_medium);
        patient.setAnxiety( anxiety_selected == anxiety_depress_yes);
        patient.setDiarrhea( diarrhea_selected == diarrhea_yes );

        if ( nausea_selected == nausea_none ){
            patient.setNausea(0);
        } else if ( nausea_selected == nausea_sporadic ) {
            patient.setNausea(1);
        } else if ( nausea_selected == nausea_frequent ) {
            patient.setNausea(2);
        }

        if ( swelling_selected == abdominalSwelling_none ){
            patient.setDistention(0);
        } else if ( nausea_selected == abdominalSwelling_low ) {
            patient.setDistention(1);
        } else if ( nausea_selected == abdominalSwelling_high ) {
            patient.setDistention(2);
        }

    }
*/
    @FXML
    public void checkRadialButtons(javafx.event.ActionEvent evnt){
        Toggle fever_selected = fever.getSelectedToggle();
        Toggle discomfort_selected = discomfort.getSelectedToggle();
        Toggle cramps_selected = cramps.getSelectedToggle();
        Toggle melenas_selected = melenas.getSelectedToggle();
        Toggle dermatitis_selected = dermatitis.getSelectedToggle();

        if ( fever_selected == null || discomfort_selected == null || cramps_selected == null || melenas_selected == null || dermatitis_selected ==null ) {
            main.button_next.setDisable(true);
        } else {
            main.button_next.setDisable(false);
        }

    }


}
