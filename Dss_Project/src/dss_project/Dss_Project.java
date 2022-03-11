/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_project;
import java.io.*;
import java.util.*;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
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
       Disease disease = new Disease("",Disease.AgeRange.ADULT);
        
        Disease ibs = new Disease("Irritable Bowel Syndrom",Disease.Gender.FEMALE,Disease.AgeRange.YOUNG,true,true,true,true,true,false,false,true,true,false,false,true,true,true,false,false,false,false,false,false,false,false,false);
        
        Disease chron = new Disease("Chron",Disease.Gender.FEMALE,Disease.AgeRange.YOUNGADULT,true,true,true,true,true,true,true,true,false,true,true,false,true,false,false,true,false,false,true,false,false,false,false);
        
        Disease ylcerative_colitis = new Disease("Ulcerative Colitis",Disease.Gender.MALE,Disease.AgeRange.YOUNGADULT,true,true,false,false,true,true,false,true,true,true,true,false,true,false,false,false,false,false,false,false,true,true,false);
        
        Disease diverticulosis = new Disease("Diverticulosis",Disease.Gender.FEMALE,Disease.AgeRange.ADULT,true,false,true,false,false,false,true,true,true,false,false,false,false,true,false,true,false,false,false,true,true,false,false);
        
        Disease hernia = new Disease("Inguinal or Abdominal Hernia",Disease.Gender.MALE,Disease.AgeRange.CHILD,true,false,true,true,false,false,false,false,true,false,false,false,true,false,true,true,false,false,false,false,false,false,false);
        
        Disease appendicitis = new Disease("Appendicitis",Disease.Gender.MALE,Disease.AgeRange.YOUNGADULT,true,true,true,true,false,false,true,true,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false);
        
        Disease enterocolitis = new Disease("Infectious Enterocolitis",null,Disease.AgeRange.CHILD,true,false,true,true,false,false,false,true,true,true,false,false,false,false,false,true,true,true,false,false,false,false,false);
        
        Disease celiac_Disease = new Disease("Celiac Disease",Disease.Gender.FEMALE,Disease.AgeRange.ADULT,true,false,true,true,true,true,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,true);
        
        Disease colorectal_cancer = new Disease("Colorectal Cancer",Disease.Gender.MALE,Disease.AgeRange.ADULT,true,true,true,true,true,true,true,true,true,true,true,false,true,false,false,false,false,false,false,false,false,false,false);
        
        
        
        String answer = ask("What is your gender?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("female") || answer.equalsIgnoreCase("f") ){
                prediction.setGender(Disease.Gender.FEMALE);
                disease.setGender(Disease.Gender.FEMALE);
                
            } else if ( answer.equalsIgnoreCase("male") || answer.equalsIgnoreCase("m") ){
                prediction.setGender(Disease.Gender.MALE);
                disease.setGender(Disease.Gender.MALE);
            } else {
                System.out.println("Please enter Female(f) or Male(m)");
            }
            //KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }
         //answer = ask("How old are you?");
         //Baby (0-2 años), child (2-12 años),young(12-16) adolescent (16-25), young adult (25-40), adult (40-60), elder (+60)
        /*if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setDiarrhea(true);
                disease.setDiarrhea(true);
                
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setDiarrhea(false);
                disease.setDiarrhea(false);
            } else {
                System.out.println("Please enter a number.");
            }
            //KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        //}
        
        answer = askSymptom("Do you suffer diarrhea?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setDiarrhea(true);
                disease.setDiarrhea(true);
                
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setDiarrhea(false);
                disease.setDiarrhea(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            //KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

        answer = askSymptom("Have you seen blood in your feces?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
               prediction.setRectalHemo(true);
                disease.setRectalHemo(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setRectalHemo(false);
                disease.setRectalHemo(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

        answer = askSymptom("Do you have ulcers?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setUlcers(true);
                disease.setUlcers(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setUlcers(false);
                disease.setUlcers(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

        answer = askSymptom("Do you have any lumps or bulks in your torso?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setBulks(true);
                disease.setBulks(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setBulks(false);
                disease.setBulks(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

        answer = askSymptom("Do you have random chills?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setChills(true);
                disease.setChills(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setChills(false);
                disease.setChills(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

        answer = askSymptom("Have you been suffering dermatitis?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setDermatitis(true);
                disease.setDermatitis(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setDermatitis(false);
                disease.setDermatitis(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

        
        answer = askSymptom("Does any member of your family suffers or have suffered any digestive disorder?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setGenetic(true);
                disease.setGenetic(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setGenetic(false);
                disease.setGenetic(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }

       
        answer = askSymptom("Have you seen blood in your feces?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setMelenas(true);
                disease.setMelenas(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setMelenas(false);
                disease.setMelenas(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }
    
    
        answer = askSymptom("Have you suffered nauseas recently?");
        if ( !answer.equals("")) {
            DEBUG("Answer = " + answer);
            if ( answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y") ){
                prediction.setNausea(true);
                disease.setNausea(true);
            } else if ( answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n") ){
                prediction.setNausea(false);
                disease.setNausea(false);
            } else {
                System.out.println("Please enter Yes(y) or No(n)");
            }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
        }
        
        ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();
    
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
    private static String ask( String message ){
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