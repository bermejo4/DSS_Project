/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import dss_abdominal.Patient;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Results extends Application implements Initializable  {


    @FXML
    protected Button button_view;
    @FXML
    private BorderPane results_window;
    @FXML
    private Label disease_solution;
    @FXML
    private TextArea disease_treatment;
    @FXML
    private Hyperlink medline;

    private Patient patient;

    private String selectedDiseaseName = "You do not have a problem";
    private String diseaseNameToMedURL;
    private String diseaseMayoURL;

    public float ibsPorcentage = -1;
    public float chronPorcentage = -1;
    public float ulcerativeColitisPorcentage = -1;
    public float diverticulosisPorcentage = -1;
    public float herniaPorcentage = -1;
    public float appendicitisPorcentage = -1;
    public float enterocolitisPorcentage = -1;
    public float celiacPorcentage = -1;
    public float colorectalCancerPorcentage = -1;

    Patient ibs = new Patient("Irritable Bowel Syndrom", Patient.Gender.FEMALE, Patient.AgeRange.YOUNG, 1f, 1f, 1f, 1f, true, false, false, true, 1f, 0f, 0f, 0f, true, 1f, false, 0f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient chron = new Patient("Chron", Patient.Gender.FEMALE, Patient.AgeRange.YOUNGADULT, 1f, 2f, 1f, 1f, true, true, true, true, 0f, 1f, 2f, 0f, true, 0f, false, 1f, 0f, false, 1f, 0f, 0f, 0f, 0f);
    Patient ulcerative_colitis = new Patient("Ulcerative Colitis", Patient.Gender.MALE, Patient.AgeRange.YOUNGADULT, 2f, 1f, 0f, 0f, true, true, false, true, 2f, 1f, 2f, 0f, true, 0f, false, 0f, 0f, false, 0f, 0f, 1f, 1f, 0f);
    Patient diverticulosis = new Patient("Diverticulosis", Patient.Gender.FEMALE, Patient.AgeRange.ADULT, 2f, 0f, 2f, 0f, false, false, true, true, 2f, 0f, 0f, 0f, false, 2f, false, 1f, 0f, false, 0f, 1f, 1f, 0f, 0f);
    Patient hernia = new Patient("Inguinal or Abdominal Hernia", Patient.Gender.MALE, Patient.AgeRange.CHILD, 2f, 0f, 2f, 2f, false, false, false, false, 2f, 0f, 0f, 0f, true, 0f, true, 2f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient appendicitis = new Patient("Appendicitis", Patient.Gender.MALE, Patient.AgeRange.YOUNGADULT, 2f, 2f, 2f, 2f, false, false, true, true, 0f, 0f, 0f, 2f, false, 0f, false, 2f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient enterocolitis = new Patient("Infectious Enterocolitis", null, Patient.AgeRange.CHILD, 2f, 0f, 1f, 1f, false, false, false, true, 2f, 1f, 0f, 0f, false, 0f, false, 1f, 2f, true, 0f, 0f, 0f, 0f, 0f);
    Patient celiac_Disease = new Patient("Celiac Disease", Patient.Gender.FEMALE, Patient.AgeRange.ADULT, 1f, 2f, 1f, 1f, true, true, false, true, 0f, 1f, 0f, 0f, true, 0f, false, 0f, 0f, false, 0f, 0f, 0f, 0f, 0f);
    Patient colorectal_cancer = new Patient("Colorectal Cancer", Patient.Gender.MALE, Patient.AgeRange.ADULT, 2f, 1f, 2f, 2f, true, true, true, false, 2f, 2f, 2f, 0f, true, 0f, false, 0f, 0f, false, 0f, 0f, 0f, 0f, 0f);


    public void initialize(URL url, ResourceBundle rb) {

    }


    public void button_pressed2(ActionEvent event) throws Exception {

        if (event.getSource() == button_view) {
            button_view.setDisable(true);
        }
        System.out.println("Moving to page: Graphic");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GraphicStadistics.fxml"));
        Parent root = loader.load();
        BarChartSample chartSample = loader.getController();
        chartSample.initComponents(this);

        Stage stage = new Stage();
        stage.setOnCloseRequest(e-> button_view.setDisable(false));
        chartSample.start(stage);


    }

    public void seeDisease(ActionEvent e) {
        System.out.println("Link clicked!");
        getHostServices().showDocument(medline.getText());
    }


    protected void initComponents(Patient patient) {
        this.patient = patient;
        this.calculatePercentageFromSymptoms();
        this.selectBestDisease();
        patient.getDiseaseName();
        disease_solution.setText(patient.getDiseaseName());
        medline.setText("https://medlineplus.gov/" + diseaseNameToMedURL + ".html");

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        try {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setPrintContentOnFailingStatusCode(false);
            HtmlPage page = webClient.getPage(diseaseMayoURL);
            List<HtmlParagraph> paragraphs =  page.getByXPath("//div[@class='content']/div/p");
            disease_treatment.setText(paragraphs.get(0).asNormalizedText());
        } catch (IOException e) {
            disease_treatment.setText("Sorry, we couldn't load the information from the webpage.");
            e.printStackTrace();
        } finally {
            webClient.close();
        }


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

    public String selectBestDisease() {
        ArrayList<Float> allPercentages = new ArrayList();
        allPercentages.add(ibsPorcentage);
        allPercentages.add(chronPorcentage);
        allPercentages.add(ulcerativeColitisPorcentage);
        allPercentages.add(diverticulosisPorcentage);
        allPercentages.add(herniaPorcentage);
        allPercentages.add(appendicitisPorcentage);
        allPercentages.add(enterocolitisPorcentage);
        allPercentages.add(celiacPorcentage);
        allPercentages.add(colorectalCancerPorcentage);

        float max = 0;
        float min = 0;
        float position = 0;
        for (int i = 0; i < allPercentages.size(); i++) {
            if (allPercentages.get(i) > max) {
                max = allPercentages.get(i);
                position = i;
            } else if ( allPercentages.get(i) < min ){
                min = allPercentages.get(i);
            }
        }
        for (int i = 0; i < allPercentages.size(); i++) {
            allPercentages.set(i, allPercentages.get(i)/min);
        }

        switch ((int) position) {
            case 0:
                selectedDiseaseName = "Irritable Bowel Syndrom";
                diseaseNameToMedURL = "irritablebowelsyndrome";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/irritable-bowel-syndrome/symptoms-causes/syc-20360016";
                break;
            case 1:
                selectedDiseaseName = "Chron's disease";
                diseaseNameToMedURL = "crohnsdisease";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/crohns-disease/symptoms-causes/syc-20353304";
                break;
            case 2:
                selectedDiseaseName = "Ulcerative Colitis";
                diseaseNameToMedURL = "ulcerativecolitis";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/ulcerative-colitis/symptoms-causes/syc-20353326";
                break;
            case 3:
                selectedDiseaseName = "Diverticulosis";
                diseaseNameToMedURL = "diverticulosisanddiverticulitis";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/diverticulitis/symptoms-causes/syc-20371758";
                break;
            case 4:
                selectedDiseaseName = "Inguinal or Abdominal Hernia";
                diseaseNameToMedURL = "hernia";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/inguinal-hernia/symptoms-causes/syc-20351547";
                break;
            case 5:
                selectedDiseaseName = "Appendicitis";
                diseaseNameToMedURL = "appendicitis";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/appendicitis/symptoms-causes/syc-20369543";
                break;
            case 6:
                selectedDiseaseName = "Infectious Enterocolitis";
                diseaseNameToMedURL = "ency/article/001148";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/irritable-bowel-syndrome/symptoms-causes/syc-20360016";
                break;
            case 7:
                selectedDiseaseName = "Celiac Disease";
                diseaseNameToMedURL = "celiacdisease";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/celiac-disease/symptoms-causes/syc-20352220";
                break;
            case 8:
                selectedDiseaseName = "Colorectal Cancer";
                diseaseNameToMedURL = "colorectalcancer";
                diseaseMayoURL = "https://www.mayoclinic.org/diseases-conditions/colon-cancer/symptoms-causes/syc-20353669";
                break;
            default:
                break;
        }

        patient.setDiseaseName(selectedDiseaseName);
        System.out.println(patient.getDiseaseName());
        System.out.println(selectedDiseaseName);
        return selectedDiseaseName;


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported ");
    }
}
