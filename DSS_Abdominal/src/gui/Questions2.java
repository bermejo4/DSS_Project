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
import javafx.stage.Stage;

/**
 * @author marin
 */
public class Questions2 implements Initializable, QuestionPanel {

    @FXML
    private RadioButton constipation_yes;

    @FXML
    private RadioButton constipation_no;


    @FXML
    private RadioButton increasedpee_none;

    @FXML
    private RadioButton increasedpee_sporadic;

    @FXML
    private RadioButton increasedpee_frequent;


    @FXML
    private RadioButton exhaustion_none;

    @FXML
    private RadioButton exhaustion_mild;

    @FXML
    private RadioButton exhaustion_disabling;

    @FXML
    private RadioButton abdominal_none;

    @FXML
    private RadioButton abdominal_mild;

    @FXML
    private RadioButton abdominal_severe;

    @FXML
    private RadioButton weightloss_no;

    @FXML
    private RadioButton weightloss_zerotofive;


    @FXML
    private RadioButton weightloss_morefive;


    private ToggleGroup constipation_toggle;
    private ToggleGroup pee_toggle;
    private ToggleGroup exhaustion_toggle;
    private ToggleGroup weightloss_toggle;
    private ToggleGroup abdominal_toggle;

    private MainWindow main;
    private Patient patient;


    public void initialize(URL url, ResourceBundle rb) {

        constipation_toggle = new ToggleGroup();
        pee_toggle = new ToggleGroup();
        exhaustion_toggle = new ToggleGroup();
        weightloss_toggle = new ToggleGroup();
        abdominal_toggle = new ToggleGroup();

        this.constipation_yes.setToggleGroup(constipation_toggle);
        this.constipation_no.setToggleGroup(constipation_toggle);

        this.increasedpee_none.setToggleGroup(pee_toggle);
        this.increasedpee_sporadic.setToggleGroup(pee_toggle);
        this.increasedpee_frequent.setToggleGroup(pee_toggle);

        this.exhaustion_none.setToggleGroup(exhaustion_toggle);
        this.exhaustion_mild.setToggleGroup(exhaustion_toggle);
        this.exhaustion_disabling.setToggleGroup(exhaustion_toggle);

        this.weightloss_no.setToggleGroup(weightloss_toggle);
        this.weightloss_zerotofive.setToggleGroup(weightloss_toggle);
        this.weightloss_morefive.setToggleGroup(weightloss_toggle);

        this.abdominal_none.setToggleGroup(abdominal_toggle);
        this.abdominal_mild.setToggleGroup(abdominal_toggle);
        this.abdominal_severe.setToggleGroup(abdominal_toggle);

    }


    @Override
    public void initComponents(MainWindow mainWindow, Patient patient) {
        this.main = mainWindow;
        this.patient = patient;
        if (patient.isConstipation() != null) {
            if (patient.isConstipation()) {
                constipation_toggle.selectToggle(constipation_yes);
            } else {
                constipation_toggle.selectToggle(constipation_no);
            }
        }
        if (patient.getPee() != null) {
            int pee = patient.getPee().intValue();
            if (pee == 0) {
                pee_toggle.selectToggle(increasedpee_none);
            } else if (pee == 1) {
                pee_toggle.selectToggle(increasedpee_sporadic);
            } else if (pee == 2) {
                pee_toggle.selectToggle(increasedpee_frequent);
            }
        }
        if (patient.getExhaustion() != null) {
            int exhaustion = patient.getExhaustion().intValue();
            if (exhaustion == 0) {
                exhaustion_toggle.selectToggle(exhaustion_none);
            } else if (exhaustion == 1) {
                exhaustion_toggle.selectToggle(exhaustion_mild);
            } else if (exhaustion == 2) {
                exhaustion_toggle.selectToggle(exhaustion_disabling);
            }
        }
        if (patient.getWeightLoss() != null) {
            int weightloss = patient.getWeightLoss().intValue();
            if (weightloss == 0) {
                weightloss_toggle.selectToggle(weightloss_no);
            } else if (weightloss == 1) {
                weightloss_toggle.selectToggle(weightloss_zerotofive);
            } else if (weightloss == 2) {
                weightloss_toggle.selectToggle(weightloss_morefive);
            }
        }
        System.out.println("is abdpain different from null? " + (patient.getAbdpain() != null));
        if (patient.getAbdpain() != null) {
            int abd = patient.getAbdpain().intValue();
            System.out.println("abdpain value: " + patient.getAbdpain() );
            System.out.println("abdpain value int: " + patient.getAbdpain().intValue() );

            if (abd == 0) {
                abdominal_toggle.selectToggle(abdominal_none);
            } else if (abd == 1) {
                abdominal_toggle.selectToggle(abdominal_mild);
            } else if (abd == 2) {
                abdominal_toggle.selectToggle(abdominal_severe);
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

        if ( constipation_toggle.getSelectedToggle() != null ) patient.setConstipation(constipation_toggle.getSelectedToggle() == constipation_yes);


        if (pee_toggle.getSelectedToggle() == increasedpee_none) {
            patient.setPee(0);
        } else if (pee_toggle.getSelectedToggle() == increasedpee_sporadic) {
            patient.setPee(1);
        } else if (pee_toggle.getSelectedToggle() == increasedpee_frequent) {
            patient.setPee(2);
        }

        if (exhaustion_toggle.getSelectedToggle() == exhaustion_none) {
            patient.setExhaustion(0);
        } else if (exhaustion_toggle.getSelectedToggle() == exhaustion_mild) {
            patient.setExhaustion(1);
        } else if (exhaustion_toggle.getSelectedToggle() == exhaustion_disabling) {
            patient.setExhaustion(2);
        }

        if (weightloss_toggle.getSelectedToggle() == weightloss_no) {
            patient.setWeightLoss(0);
        } else if (weightloss_toggle.getSelectedToggle() == weightloss_zerotofive) {
            patient.setWeightLoss(1);
        } else if (weightloss_toggle.getSelectedToggle() == weightloss_morefive) {
            patient.setWeightLoss(2);
        }

        if (abdominal_toggle.getSelectedToggle() == abdominal_none) {
            patient.setAbdpain(0);
        } else if (abdominal_toggle.getSelectedToggle() == abdominal_mild) {
            patient.setAbdpain(1);
        } else if (abdominal_toggle.getSelectedToggle() == abdominal_severe) {
            patient.setAbdpain(2);
        }

        System.out.println("Patient new values: " +
                "\n\t Constipation: " + patient.isConstipation() +
                "\n\t Pee: " + patient.getPee() +
                "\n\t Exhaustion: " + patient.getExhaustion() +
                "\n\t Weightloss: " + patient.getWeightLoss() +
                "\n\t AbdPain: " + patient.getAbdpain());

    }

    @FXML
    public void checkRadialButtons(ActionEvent event) throws Exception {

        Toggle constipation_selected = constipation_toggle.getSelectedToggle();
        Toggle pee_selected = pee_toggle.getSelectedToggle();
        Toggle exhaustion_selected = exhaustion_toggle.getSelectedToggle();
        Toggle weightloss_selected = weightloss_toggle.getSelectedToggle();
        Toggle abdominal_selected = abdominal_toggle.getSelectedToggle();

        if (constipation_selected == null || pee_selected == null || exhaustion_selected == null || weightloss_selected == null || abdominal_selected == null) {
            main.button_next.setDisable(true);
        } else {
            main.button_next.setDisable(false);
        }

    }
}
        