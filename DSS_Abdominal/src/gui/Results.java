/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dss_abdominal.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Results implements Initializable {

    @FXML
    protected Button button_view;
    @FXML
    private BorderPane results_window;
    @FXML
    private TextField disease_solution;
    @FXML
    private TextField disease_treatment; 
    @FXML
    private Hyperlink medline;

    private Patient patient;

    public static float ibsPorcentage = -1;
    public static float chronPorcentage = -1;
    public static float ulcerativeColitisPorcentage = -1;
    public static float diverticulosisPorcentage = -1;
    public static float herniaPorcentage = -1;
    public static float appendicitisPorcentage = -1;
    public static float enterocolitisPorcentage = -1;
    public static float celiacPorcentage = -1;
    public static float colorectalCancerPorcentage = -1;

    Patient ibs = new Patient("Irritable Bowel Syndrom", Patient.Gender.FEMALE, Patient.AgeRange.YOUNG, 1f, 1f, 1f, 1f, true, false, false, true, 1f, 0f, 0f, 0f, true, 1f, false, 0f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient chron = new Patient("Chron", Patient.Gender.FEMALE, Patient.AgeRange.YOUNGADULT, 1f, 2f, 1f, 1f, true, true, true, true, 0f, 1f, 2f, 0f, true, 0f, false, 1f, 0f, false, 1f, 0f, 0f, 0f, 0f);
    Patient ulcerative_colitis = new Patient("Ulcerative Colitis", Patient.Gender.MALE, Patient.AgeRange.YOUNGADULT, 2f, 1f, 0f, 0f, true, true, false, true, 2f, 1f, 2f, 0f, true, 0f, false, 0f, 0f, false, 0f, 0f, 1f, 1f, 0f);
    Patient diverticulosis = new Patient("Diverticulosis", Patient.Gender.FEMALE, Patient.AgeRange.ADULT, 2f, 0f, 2f, 0f, false, false, true, true, 2f, 0f, 0f, 0f, false, 2f, false, 1f, 0f, false, 0f, 1f, 1f, 0f, 0f);
    Patient hernia = new Patient("Inguinal or Abdominal Hernia", Patient.Gender.MALE, Patient.AgeRange.CHILD, 2f, 0f, 2f, 2f, false, false, false, false, 2f, 0f, 0f, 0f, true, 0f, true, 2f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient appendicitis = new Patient("Appendicitis", Patient.Gender.MALE, Patient.AgeRange.YOUNGADULT, 2f, 2f, 2f, 2f, false, false, true, true, 0f, 0f, 0f, 2f, false, 0f, false, 2f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient enterocolitis = new Patient("Infectious Enterocolitis", null, Patient.AgeRange.CHILD, 2f, 0f, 1f, 1f, false, false, false, true, 2f, 1f, 0f, 0f, false, 0f, false, 1f, 2f, true, 0f, 0f, 0f, 0f, 0f);
    Patient celiac_Disease = new Patient("Celiac Disease", Patient.Gender.FEMALE, Patient.AgeRange.ADULT, 1f, 2f, 1f, 1f, true, true, false, true, 0f, 1f, 0f, 0f, true, 0f, false, 0f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient colorectal_cancer = new Patient("Colorectal Cancer", Patient.Gender.MALE, Patient.AgeRange.ADULT, 2f, 1f, 2f, 2f, true, true, true, false, 2f, 2f, 2f, 0f, true, 0f, false, 0f, 0f, false, 0f, 0f, 0f, 0f, 0f);



    public void button_pressed2(ActionEvent event) throws Exception {
        if ( event.getSource() == button_view ) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("BarChartSample.fxml"));
            Parent root = loader.load();
            BarChartSample chartSample = loader.getController();
            chartSample.initComponents(this);

            Scene scene = new Scene(root);

            //stage.setScene(scene);
            //stage.show();
            System.out.println("Button pressed");
        }
    }
     public void gobackques4(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions4.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

    }
        
     
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    protected void initComponents(Patient patient){
        this.patient = patient;
        this.calculatePercentageFromSymptoms();

    }

    public void calculatePercentageFromSymptoms() {
        ibs.patientSynmptomsToArrayList();
        chron.patientSynmptomsToArrayList();
        ulcerative_colitis.patientSynmptomsToArrayList();
        diverticulosis.patientSynmptomsToArrayList();
        hernia.patientSynmptomsToArrayList();
        appendicitis.patientSynmptomsToArrayList();
        enterocolitis.patientSynmptomsToArrayList();
        celiac_Disease.patientSynmptomsToArrayList();
        colorectal_cancer.patientSynmptomsToArrayList();

        ibsPorcentage = patient.ComparationArrayListSymptoms(ibs.getDiseaseArrayList());
        chronPorcentage = patient.ComparationArrayListSymptoms(chron.getDiseaseArrayList());
        ulcerativeColitisPorcentage = patient.ComparationArrayListSymptoms(ulcerative_colitis.getDiseaseArrayList());
        diverticulosisPorcentage = patient.ComparationArrayListSymptoms(diverticulosis.getDiseaseArrayList());
        herniaPorcentage = patient.ComparationArrayListSymptoms(hernia.getDiseaseArrayList());
        appendicitisPorcentage = patient.ComparationArrayListSymptoms(appendicitis.getDiseaseArrayList());
        enterocolitisPorcentage = patient.ComparationArrayListSymptoms(enterocolitis.getDiseaseArrayList());
        celiacPorcentage = patient.ComparationArrayListSymptoms(celiac_Disease.getDiseaseArrayList());
        colorectalCancerPorcentage = patient.ComparationArrayListSymptoms(colorectal_cancer.getDiseaseArrayList());

    }
    
}
