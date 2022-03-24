/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dss_abdominal.Patient;
import static gui.MainWindow.patient;
import javafx.scene.chart.*;
/**
 *
 * @author marin
 */
public class BarChart {
        
    float ibsPorcentage = -1;
    float chronPorcentage = -1;
    float ulcerativeColitisPorcentage=-1;
    float diverticulosisPorcentage = -1;
    float herniaPorcentage=-1;
    float appendicitisPorcentage=-1;
    float enterocolitisPorcentage=-1;
    float celiacPorcentage=-1;
    float colorectalCancerPorcentage=-1;
    
    Patient ibs = new Patient("Irritable Bowel Syndrom",Patient.Gender.FEMALE,Patient.AgeRange.YOUNG,1f,1f,1f,1f,true,false,false,true,1f,0f,0f,0f,true,1f,false,0f,0f,false,0f,0f,0f,0f,0f);    
    Patient chron = new Patient("Chron",Patient.Gender.FEMALE,Patient.AgeRange.YOUNGADULT,1f,2f,1f,1f,true,true,true,true,0f,1f,2f,0f,true,0f,false,1f,0f,false,1f,0f,0f,0f,0f);        
    Patient ulcerative_colitis = new Patient("Ulcerative Colitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,2f,1f,0f,0f,true,true,false,true,2f,1f,2f,0f,true,0f,false,0f,0f,false,0f,0f,1f,1f,0f);
    Patient diverticulosis = new Patient("Diverticulosis",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,2f,0f,2f,0f,false,false,true,true,2f,0f,0f,0f,false,2f,false,1f,0f,false,0f,1f,1f,0f,0f);
    Patient hernia = new Patient("Inguinal or Abdominal Hernia",Patient.Gender.MALE,Patient.AgeRange.CHILD,2f,0f,2f,2f,false,false,false,false,2f,0f,0f,0f,true,0f,true,2f,0f,false,0f,0f,0f,0f,0f);
    Patient appendicitis = new Patient("Appendicitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,2f,2f,2f,2f,false,false,true,true,0f,0f,0f,2f,false,0f,false,2f,0f,false,0f,0f,0f,0f,0f);
    Patient enterocolitis = new Patient("Infectious Enterocolitis",null,Patient.AgeRange.CHILD,2f,0f,1f,1f,false,false,false,true,2f,1f,0f,0f,false,0f,false,1f,2f,true,0f,0f,0f,0f,0f);
    Patient celiac_Disease = new Patient("Celiac Disease",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,1f,2f,1f,1f,true,true,false,true,0f,1f,0f,0f,true,0f,false,0f,0f,false,0f,0f,0f,0f,0f);
    Patient colorectal_cancer = new Patient("Colorectal Cancer",Patient.Gender.MALE,Patient.AgeRange.ADULT,2f,1f,2f,2f,true,true,true,false,2f,2f,2f,0f,true,0f,false,0f,0f,false,0f,0f,0f,0f,0f);
         
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

    public static void main(String[] args) {
    
        //calculatePorcentageFromSymptoms();
         
    
    
    
    }
    
    
    
    
}
