/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_project;
import java.io.*;
import java.util.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;






public class Dss_Project {

    private static BufferedReader console_reader;
    private static boolean DEBUGGING = true;

    public static void main(String[] args) {
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        KieSession ksession = kc.newKieSession("DiseasesRulesKS");
        
        console_reader= new BufferedReader(new InputStreamReader(System.in));
     
       Prediction prediction = new Prediction();
        
        Disease ibs = new Disease("Irritable Bowel Syndrom",Disease.Gender.FEMALE,Disease.AgeRange.YOUNG,true,true,true,true,true,false,false,true,true,false,false,true,true,true,false,false,false,false,false,false,false,false,false);
        
        Disease chron = new Disease("Chron",Disease.Gender.FEMALE,Disease.AgeRange.YOUNGADULT,true,true,true,true,true,true,true,true,false,true,true,false,true,false,false,true,false,false,true,false,false,false,false);
        
        Disease ylcerative_colitis = new Disease("Ulcerative Colitis",Disease.Gender.MALE,Disease.AgeRange.YOUNGADULT,true,true,false,false,true,true,false,true,true,true,true,false,true,false,false,false,false,false,false,false,true,true,false);
        
        Disease diverticulosis = new Disease("Diverticulosis",Disease.Gender.FEMALE,Disease.AgeRange.ADULT,true,false,true,false,false,false,true,true,true,false,false,false,false,true,false,true,false,false,false,true,true,false,false);
        
        Disease hernia = new Disease("Inguinal or Abdominal Hernia",Disease.Gender.MALE,Disease.AgeRange.CHILD,true,false,true,true,false,false,false,false,true,false,false,false,true,false,true,true,false,false,false,false,false,false,false);
        
        Disease appendicitis = new Disease("Appendicitis",Disease.Gender.MALE,Disease.AgeRange.YOUNGADULT,true,true,true,true,false,false,true,true,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false);
        
        Disease enterocolitis = new Disease("Infectious Enterocolitis",null,Disease.AgeRange.CHILD,true,false,true,true,false,false,false,true,true,true,false,false,false,false,false,true,true,true,false,false,false,false,false);
        
        Disease celiac_Disease = new Disease("Celiac Disease",Disease.Gender.FEMALE,Disease.AgeRange.ADULT,true,false,true,true,true,true,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,true);
        
        Disease colorectal_cancer = new Disease("Colorectal Cancer",Disease.Gender.MALE,Disease.AgeRange.ADULT,true,true,true,true,true,true,true,true,true,true,true,false,true,false,false,false,false,false,false,false,false,false,false);
        
        String answer = askSymptom("Do you suffer diarrhea?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools? Class prediction already instanciated in object prediction
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        answer = askSymptom("Have you seen blood in your feces?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        answer = askSymptom("Do you have ulcers?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        answer = askSymptom("Do you have any lumps or bulks in your torso?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        answer = askSymptom("Do you have random chills?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        answer = askSymptom("Have you been suffering dermatitis?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        // TODO: Change the question here, I have no idea how to ask this.
        answer = askSymptom("Genetic factor");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }

        // TODO: I can't read the last one.
        answer = askSymptom("Have you seen blood in your feces?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                // TODO: drools?
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){

            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
        }



    }

    private static String askSymptom( String message ){
        System.out.println(message);
        try {
            return console_reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static void DEBUG( String message ){
        if ( DEBUGGING ) System.out.println("[ DEBUG ] :: " + message);
    }


    
}