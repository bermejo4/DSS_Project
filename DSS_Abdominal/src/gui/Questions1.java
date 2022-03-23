/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.ConditionalFeature.FXML;

import dss_abdominal.Patient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * @author marin
 */
public class Questions1 implements Initializable {

    @FXML
    private RadioButton lump_yes;

    @FXML
    private RadioButton lump_no;


    @FXML
    private RadioButton abdominalSwelling_none;

    @FXML
    private RadioButton abdominalSwelling_low;

    @FXML
    private RadioButton abdominalSwelling_high;

    @FXML
    private RadioButton diarrhea_yes;

    @FXML
    private RadioButton diarrhea_no;


    @FXML
    private RadioButton nausea_none;

    @FXML
    private RadioButton nausea_sporadic;

    @FXML
    private RadioButton nausea_frequent;

    @FXML
    private RadioButton anxiety_depress_yes;

    @FXML
    private RadioButton anxiety_depress_no;

    private ToggleGroup lump_toggle;
    private ToggleGroup swelling_toggle;
    private ToggleGroup diarrhea_toggle;
    private ToggleGroup nausea_toggle;
    private ToggleGroup anxiety_toggle;

    private MainWindow main;
    private Patient patient;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lump_toggle = new ToggleGroup();
        swelling_toggle = new ToggleGroup();
        diarrhea_toggle = new ToggleGroup();
        nausea_toggle = new ToggleGroup();
        anxiety_toggle = new ToggleGroup();

        this.lump_yes.setToggleGroup(lump_toggle);
        this.lump_no.setToggleGroup(lump_toggle);
        this.abdominalSwelling_none.setToggleGroup(swelling_toggle);
        this.abdominalSwelling_low.setToggleGroup(swelling_toggle);
        this.abdominalSwelling_high.setToggleGroup(swelling_toggle);
        this.diarrhea_yes.setToggleGroup(diarrhea_toggle);
        this.diarrhea_no.setToggleGroup(diarrhea_toggle);
        this.nausea_none.setToggleGroup(nausea_toggle);
        this.nausea_sporadic.setToggleGroup(nausea_toggle);
        this.nausea_frequent.setToggleGroup(nausea_toggle);
        this.anxiety_depress_yes.setToggleGroup(anxiety_toggle);
        this.anxiety_depress_no.setToggleGroup(anxiety_toggle);

    }


    public void goback(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("MainWindow.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

    }

    public void gotoquestions(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions2.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

    }

    public void initComponents(MainWindow main, Patient patient) {
        this.main = main;
        this.patient = patient;

    }


}
