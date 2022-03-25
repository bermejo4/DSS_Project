/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.ConditionalFeature.FXML;

import dss_abdominal.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


public class Questions1 implements Initializable, QuestionPanel {

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

    @Override
    public void initComponents(MainWindow main, Patient patient) {
        this.main = main;
        this.patient = patient;

        if (patient.isBulks() != null) {
            if (patient.isBulks()) {
                lump_toggle.selectToggle(lump_yes);
            } else {
                lump_toggle.selectToggle(lump_no);
            }
        }
        if (patient.getDistention() != null) {
            int dist = patient.getDistention().intValue();
            if (dist == 0) {
                swelling_toggle.selectToggle(abdominalSwelling_none);
            } else if (dist == 1) {
                swelling_toggle.selectToggle(abdominalSwelling_low);
            } else if (dist == 2) {
                swelling_toggle.selectToggle(abdominalSwelling_high);
            }
        }

        if (patient.isDiarrhea() != null) {
            if (patient.isDiarrhea()) {
                diarrhea_toggle.selectToggle(diarrhea_yes);
            } else {
                diarrhea_toggle.selectToggle(diarrhea_no);
            }
        }

        if (patient.getNausea() != null) {
            int nau = patient.getNausea().intValue();
            if (nau == 0) {
                nausea_toggle.selectToggle(nausea_none);
            } else if (nau == 1) {
                nausea_toggle.selectToggle(nausea_sporadic);
            } else if (nau == 2) {
                nausea_toggle.selectToggle(nausea_frequent);
            }
        }
        if (patient.isAnxiety() != null) {
            if (patient.isAnxiety()) {
                anxiety_toggle.selectToggle(anxiety_depress_yes);
            } else {
                anxiety_toggle.selectToggle(anxiety_depress_no);
            }
        }


        try {
            checkRadialButtons(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error checking if radials already have buttons.");
        }

    }

    @Override
    public void getQuestionValues() {
        Toggle lump_selected = lump_toggle.getSelectedToggle();
        Toggle anxiety_selected = anxiety_toggle.getSelectedToggle();
        Toggle diarrhea_selected = diarrhea_toggle.getSelectedToggle();
        Toggle nausea_selected = nausea_toggle.getSelectedToggle();
        Toggle swelling_selected = swelling_toggle.getSelectedToggle();

        if ( lump_selected != null ) patient.setBulks(lump_selected == lump_yes);
        if ( anxiety_selected != null ) patient.setAnxiety(anxiety_selected == anxiety_depress_yes);
        if ( diarrhea_selected != null ) patient.setDiarrhea(diarrhea_selected == diarrhea_yes);

        if (nausea_selected == nausea_none) {
            patient.setNausea(0);
        } else if (nausea_selected == nausea_sporadic) {
            patient.setNausea(1);
        } else if (nausea_selected == nausea_frequent) {
            patient.setNausea(2);
        }

        if (swelling_selected == abdominalSwelling_none) {
            patient.setDistention(0);
        } else if (swelling_selected == abdominalSwelling_low) {
            patient.setDistention(1);
        } else if (swelling_selected == abdominalSwelling_high) {
            patient.setDistention(2);
        }

        System.out.println("Patient new values: " +
                "\n\t lump: " + patient.isBulks() +
                "\n\t Anxiety: " + patient.isAnxiety() +
                "\n\t Diarrhea: " + patient.isDiarrhea() +
                "\n\t Nausea: " + patient.getNausea() +
                "\n\t Distention: " + patient.getDistention());

    }

    @FXML
    public void checkRadialButtons(ActionEvent evnt) {
        Toggle lump_selected = lump_toggle.getSelectedToggle();
        Toggle diarrhea_selected = diarrhea_toggle.getSelectedToggle();
        Toggle nausea_selected = nausea_toggle.getSelectedToggle();
        Toggle anxiety_selected = anxiety_toggle.getSelectedToggle();
        Toggle swelling_selected = swelling_toggle.getSelectedToggle();

        if (lump_selected == null || diarrhea_selected == null || nausea_selected == null || anxiety_selected == null || swelling_selected == null) {
            main.button_next.setDisable(true);
        } else {
            main.button_next.setDisable(false);
        }

    }


}
