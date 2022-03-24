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
public class Questions4 {
     
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

        if ( (int) (patient.isChills())==0 ) {
            chills.selectToggle(chill_none);
        } else if ((int) (patient.isChills())==1){
            chills.selectToggle(chill_sporadic);
        }
        else if ((int) (patient.isChills())==2){
            chills.selectToggle(chill_frequent);
        } 

        if ( (int) (patient.isPoo()) == 0 ){
            poo.selectToggle(poo_none);
        } else if ( (int) (patient.isPoo()) == 1 ){
            poo.selectToggle(poo_mild);
        } else if ( (int) (patient.isPoo()) == 2 ){
            poo.selectToggle(poo_disabling);
        }

        if ( (int) (patient.getFatigue()) == 0 ){
            fatigue.selectToggle(fatigue_none);
        } else if ( (int) (patient.getCramps()) == 1 ){
            fatigue.selectToggle(fatigue_sporadic);
        } else if ( (int) (patient.getCramps()) == 2 ){
            fatigue.selectToggle(fatigue_frequent);
        }

        if ( (int) patient.getVomiting()== 0) {
            vomiting.selectToggle(vomiting_none);
        } else if ( (int) patient.getNausea() == 1) {
            vomiting.selectToggle(vomiting_sporadic);
        } else if ( (int) patient.getNausea() == 2) {
            vomiting.selectToggle(vomiting_frequent);
        }

    }


    public void getQuestionValues() {
        Toggle chills_selected = chills.getSelectedToggle();
        Toggle poo_selected = poo.getSelectedToggle();
        Toggle fatigue_selected = fatigue.getSelectedToggle();
        Toggle vomiting_selected = vomiting.getSelectedToggle();
        

        if ( chills_selected == chill_none ){
            patient.setChills(0);
        } else if ( chills_selected == chill_sporadic ) {
            patient.setChills(1);
        } else if ( chills_selected == chill_frequent ) {
            patient.setChills(2);
        }
        
        if ( poo_selected == poo_none ){
            patient.setPoo(0);
        } else if ( poo_selected == poo_mild ) {
            patient.setPoo(1);
        } else if ( poo_selected == poo_disabling ) {
            patient.setPoo(2);
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