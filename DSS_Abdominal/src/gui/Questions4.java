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


public class Questions4 implements Initializable, QuestionPanel {
     
      @FXML
    private RadioButton chill_none;

    @FXML
    private  RadioButton chill_sporadic;

    @FXML
    private  RadioButton chill_frequent;

    @FXML
    private  RadioButton poo_none;

    @FXML
    private  RadioButton poo_mild;

    @FXML
    private  RadioButton poo_disabling;

    @FXML
    private  RadioButton fatigue_none;

    @FXML
    private  RadioButton fatigue_sporadic;
    
     @FXML
    private  RadioButton fatigue_frequent;
     
      @FXML
    private  RadioButton vomiting_none;
      
       @FXML
    private  RadioButton vomiting_sporadic;
       
        @FXML
    private  RadioButton vomiting_frequent;
        



    private ToggleGroup chills;
    private ToggleGroup poo;
    private ToggleGroup fatigue;
    private ToggleGroup vomiting;


    private MainWindow main;
    private Patient patient;


    public void initialize (URL url, ResourceBundle rb){

        chills = new ToggleGroup();
        poo = new ToggleGroup();
        fatigue = new ToggleGroup();
        vomiting = new ToggleGroup();


        this.chill_none.setToggleGroup(chills);
        this.chill_sporadic.setToggleGroup(chills);
        this.chill_frequent.setToggleGroup(chills);
        this.poo_none.setToggleGroup(poo);
        this.poo_mild.setToggleGroup(poo);
        this.poo_disabling.setToggleGroup(poo);
        this.fatigue_none.setToggleGroup(fatigue);
        this.fatigue_sporadic.setToggleGroup(fatigue);
        this.fatigue_frequent.setToggleGroup(fatigue);
        this.vomiting_none.setToggleGroup(vomiting);
        this.vomiting_sporadic.setToggleGroup(vomiting);
        this.vomiting_frequent.setToggleGroup(vomiting);

    }


    public void initComponents(MainWindow main, Patient patient) {
        this.main = main;
        this.patient = patient;
        
        if (patient.isChills()!=null) {
            int ch = patient.isChills().intValue();
            if ( ch == 0 ) {
                chills.selectToggle(chill_none);
            } else if ( ch == 1 ) {
                chills.selectToggle(chill_sporadic);
            } else if ( ch == 2 ){
                chills.selectToggle(chill_frequent);
            }
        }
        if (patient.isPoo()!=null) {
            int po = patient.isPoo().intValue();
            if ( po == 0 ) {
                poo.selectToggle(poo_none);
            } else if ( po == 1 ) {
                poo.selectToggle(poo_mild);
            } else if ( po == 2 ){
                poo.selectToggle(poo_disabling);
            }
        }
        if (patient.getFatigue()!=null) {
            int fat = patient.getFatigue().intValue();
            if ( fat == 0 ) {
                fatigue.selectToggle(fatigue_none);
            } else if ( fat == 1 ) {
                fatigue.selectToggle(fatigue_sporadic);
            } else if ( fat == 2 ){
                fatigue.selectToggle(fatigue_frequent);
            }
        }
        
        if(patient.getVomiting()!=null) {
            int vom = patient.getVomiting().intValue();
            if ( vom == 0 ) {
                vomiting.selectToggle(vomiting_none);
            } else if ( vom == 1 ) {
                vomiting.selectToggle(vomiting_sporadic);
            } else if ( vom == 2 ){
                vomiting.selectToggle(vomiting_frequent);
            }
        }
    }


    public void getQuestionValues() {
        Toggle chills_selected = chills.getSelectedToggle();
        Toggle poo_selected = poo.getSelectedToggle();
        Toggle fatigue_selected = fatigue.getSelectedToggle();
        Toggle vomiting_selected = vomiting.getSelectedToggle();
        

        if ( chills_selected == chill_none ){
            patient.setChills(0F);
        } else if ( chills_selected == chill_sporadic ) {
            patient.setChills(1F);
        } else if ( chills_selected == chill_frequent ) {
            patient.setChills(2F);
        }
        
        if ( poo_selected == poo_none ){
            patient.setPoo(0F);
        } else if ( poo_selected == poo_mild ) {
            patient.setPoo(1F);
        } else if ( poo_selected == poo_disabling ) {
            patient.setPoo(2F);
        }

        if ( fatigue_selected == fatigue_none ){
            patient.setFatigue(0);
        } else if ( fatigue_selected == fatigue_sporadic ) {
            patient.setFatigue(1);
        } else if ( fatigue_selected == fatigue_frequent ) {
            patient.setFatigue(2);
        }
        
         if ( vomiting_selected == vomiting_none ){
            patient.setVomiting(0);
        } else if ( vomiting_selected == vomiting_sporadic ) {
            patient.setVomiting(1);
        } else if ( vomiting_selected == vomiting_frequent ) {
            patient.setVomiting(2);
        }

    }


    public void gobackques1(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions3.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

    }    
    
    public void nextQuestions(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Results.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void checkRadialButtons(javafx.event.ActionEvent evnt){
        Toggle chills_selected = chills.getSelectedToggle();
        Toggle poo_selected = poo.getSelectedToggle();
        Toggle fatigue_selected = fatigue.getSelectedToggle();
        Toggle vomiting_selected = vomiting.getSelectedToggle();

        if ( chills_selected == null || poo_selected == null || fatigue_selected == null || vomiting_selected == null ) {
            main.button_next.setDisable(true);
        } else {
            main.button_next.setDisable(false);
        }

    }


}