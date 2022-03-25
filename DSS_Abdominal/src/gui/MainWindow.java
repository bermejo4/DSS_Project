package gui;

import dss_abdominal.Disease;
import dss_abdominal.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    @FXML
    private BorderPane main_window;

    @FXML
    protected Button button_prev;

    @FXML
    protected Button button_next;


    protected static Patient patient;

    private int page_num = 0;
    private final int MAX_PAGE = 4;
    
    public static float ibsPorcentage = -1;
    public static float chronPorcentage = -1;
    public static float ulcerativeColitisPorcentage=-1;
    public static float diverticulosisPorcentage = -1;
    public static float herniaPorcentage=-1;
    public static float appendicitisPorcentage=-1;
    public static float enterocolitisPorcentage=-1;
    public static float celiacPorcentage=-1;
    public static float colorectalCancerPorcentage=-1;
    
    Patient ibs = new Patient("Irritable Bowel Syndrom",Patient.Gender.FEMALE,Patient.AgeRange.YOUNG,1f,1f,1f,1f,true,false,false,true,1f,0f,0f,0f,true,1f,false,0f,0f,false,0f,0f,0f,0f,0f);    
    Patient chron = new Patient("Chron",Patient.Gender.FEMALE,Patient.AgeRange.YOUNGADULT,1f,2f,1f,1f,true,true,true,true,0f,1f,2f,0f,true,0f,false,1f,0f,false,1f,0f,0f,0f,0f);        
    Patient ulcerative_colitis = new Patient("Ulcerative Colitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,2f,1f,0f,0f,true,true,false,true,2f,1f,2f,0f,true,0f,false,0f,0f,false,0f,0f,1f,1f,0f);
    Patient diverticulosis = new Patient("Diverticulosis",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,2f,0f,2f,0f,false,false,true,true,2f,0f,0f,0f,false,2f,false,1f,0f,false,0f,1f,1f,0f,0f);
    Patient hernia = new Patient("Inguinal or Abdominal Hernia",Patient.Gender.MALE,Patient.AgeRange.CHILD,2f,0f,2f,2f,false,false,false,false,2f,0f,0f,0f,true,0f,true,2f,0f,false,0f,0f,0f,0f,0f);
    Patient appendicitis = new Patient("Appendicitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,2f,2f,2f,2f,false,false,true,true,0f,0f,0f,2f,false,0f,false,2f,0f,false,0f,0f,0f,0f,0f);
    Patient enterocolitis = new Patient("Infectious Enterocolitis",null,Patient.AgeRange.CHILD,2f,0f,1f,1f,false,false,false,true,2f,1f,0f,0f,false,0f,false,1f,2f,true,0f,0f,0f,0f,0f);
    Patient celiac_Disease = new Patient("Celiac Disease",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,1f,2f,1f,1f,true,true,false,true,0f,1f,0f,0f,true,0f,false,0f,0f,false,0f,0f,0f,0f,0f);
    Patient colorectal_cancer = new Patient("Colorectal Cancer",Patient.Gender.MALE,Patient.AgeRange.ADULT,2f,1f,2f,2f,true,true,true,false,2f,2f,2f,0f,true,0f,false,0f,0f,false,0f,0f,0f,0f,0f);
         
    

    private QuestionPanel current_panel;

    @Override
    public void initialize (URL url, ResourceBundle rb){

        patient = new Patient();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Questions" + page_num + ".fxml"));

        Parent root = null;
        try {
            root = loader.load();
            current_panel = loader.getController();
            current_panel.initComponents(this, patient);
            main_window.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        button_next.setDisable(true);
        button_prev.setDisable(true);

    }
        
    
    @FXML
    public void button_pressed(ActionEvent event) throws Exception {

        if ( event.getSource() == button_next ) {
            page_num++;
            // Will not be enabled until the questions of the new current panel are all selected
            button_prev.setDisable(false);
            button_next.setDisable(true);
        } else {
            page_num--;
            // If we are going back that means this panel already has all the information
            button_next.setDisable(false);
            if( page_num == 0 ){
                button_prev.setDisable(true);
            }
        }
        if(page_num>0){
            if(page_num<4){
                changeQuestionPanel();
            }else{
                calculatePorcentageFromSymptoms();
            }
        }
        
    }

    public void changeQuestionPanel() throws IOException {
        System.out.println(patient);
        current_panel.getQuestionValues();
        System.out.println(patient);

        if ( page_num <= MAX_PAGE) {
            FXMLLoader loader;
            Parent root;
            System.out.println("Loading Questions" + page_num + ".fxml");
            loader = new FXMLLoader(getClass().getResource("Questions" + page_num + ".fxml"));

            root = loader.load();
            current_panel = loader.getController();
            current_panel.initComponents(this, patient);
            main_window.setCenter(root);

        }
    }
    
    public void calculatePorcentageFromSymptoms(){
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
        enterocolitisPorcentage=patient.ComparationArrayListSymptoms(enterocolitis.getDiseaseArrayList());
        celiacPorcentage=patient.ComparationArrayListSymptoms(celiac_Disease.getDiseaseArrayList());
        colorectalCancerPorcentage=patient.ComparationArrayListSymptoms(colorectal_cancer.getDiseaseArrayList());
        
    }
   
}
