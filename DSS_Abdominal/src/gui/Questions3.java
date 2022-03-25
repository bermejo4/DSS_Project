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
import javafx.fxml.Initializable;
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
public class Questions3 implements Initializable, QuestionPanel {
    
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
        
        if (patient.getFever()!=null) {
            int fev = patient.getFever().intValue();
            if ( fev == 0 ) {
                fever.selectToggle(fever_low);
            } else if ( fev == 1 ) {
                fever.selectToggle(fever_medium);
            } else if ( fev == 2 ){
                fever.selectToggle(fever_high);
            }
        }
        if (patient.getPerianalDiscom()!=null) {
            int dis = patient.getPerianalDiscom().intValue();
            if ( dis == 0 ) {
                discomfort.selectToggle(discomfort_none);
            } else if ( dis == 1 ) {
                discomfort.selectToggle(discomfort_focalized);
            } else if ( dis == 2 ){
                discomfort.selectToggle(discomfort_extended);
            }
        }
        
        if (patient.getCramps()!=null) {
            int cr = patient.getCramps().intValue();
            if ( cr == 0 ) {
                cramps.selectToggle(cramps_none);
            } else if ( cr == 1 ) {
                cramps.selectToggle(cramps_mild);
            } else if ( cr == 2 ){
                cramps.selectToggle(cramps_disabling);
            }
        }
        
        
        if (patient.isMelenas()!=null) {
            int mel = patient.isMelenas().intValue();
            if ( mel == 0 ) {
                melenas.selectToggle(melenas_none);
            } else if ( mel == 1 ) {
                melenas.selectToggle(melenas_few);
            } else if ( mel == 2 ){
                melenas.selectToggle(melenas_substantially);
            }
        }
        
        if (patient.isDermatitis()!=null) {
            int derm = patient.isDermatitis().intValue();
            if ( derm == 0 ) {
                dermatitis.selectToggle(dermatitis_none);
            } else if ( derm == 1 ) {
                dermatitis.selectToggle(dermatitis_focalized);
            } else if ( derm == 2 ){
                dermatitis.selectToggle(dermatitis_extended);
            }
        }

    }


        public void getQuestionValues() {
            Toggle fever_selected = fever.getSelectedToggle();
            Toggle discomfort_selected = discomfort.getSelectedToggle();
            Toggle cramps_selected = cramps.getSelectedToggle();
            Toggle melenas_selected = melenas.getSelectedToggle();
            Toggle dermatitis_selected = dermatitis.getSelectedToggle();

            if ( fever_selected == fever_low ){
                patient.setFever(0);
            } else if ( fever_selected == fever_medium ) {
                patient.setFever(1);
            } else if ( fever_selected == fever_high ) {
                patient.setFever(2);
            }
            
               if ( discomfort_selected == discomfort_none ){
                patient.setPerianalDiscom(0);
            } else if ( discomfort_selected == discomfort_focalized ) {
                patient.setPerianalDiscom(1);
            } else if ( discomfort_selected == discomfort_extended ) {
                patient.setPerianalDiscom(2);
            }

            if ( cramps_selected == cramps_none ){
                patient.setCramps(0);
            } else if ( cramps_selected == cramps_mild ) {
                patient.setCramps(1);
            } else if ( cramps_selected == cramps_disabling ) {
                patient.setCramps(2);
            }
            
                 if ( melenas_selected == melenas_none ){
                patient.setMelenas(0F);
            } else if ( melenas_selected == melenas_few ) {
                patient.setMelenas(1F);
            } else if ( melenas_selected == melenas_substantially ) {
                patient.setMelenas(2F);
            }
                 
                if ( dermatitis_selected == dermatitis_none ){
                patient.setDermatitis(0F);
            } else if ( dermatitis_selected == dermatitis_focalized ) {
                patient.setDermatitis(1F);
            } else if ( dermatitis_selected == dermatitis_extended ) {
                patient.setDermatitis(2F);
            }

        }
        public void gobackques2(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions2.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

    }


    public void nextQuestions(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Questions4.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
    
        
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
