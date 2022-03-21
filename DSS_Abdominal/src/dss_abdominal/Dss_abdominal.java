/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_abdominal;

/**
 *
 * @author gabri
 */
import java.io.*;
import java.util.*;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.util.ArrayList;



public class Dss_abdominal {

    private static BufferedReader console_reader;
    private static boolean DEBUGGING = true;
    
    public static void execute(KieServices ks, KieContainer kc, Patient pat){
        KieSession ksession = kc.newKieSession("DiseaseRulesKS");
        ksession.insert(pat);
        ksession.fireAllRules();
        ksession.dispose();
       
    }
    

    public static void main(String[] args) {
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        console_reader = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        
        Patient prediction = new Patient();
        
        Patient patient = new Patient("",Patient.AgeRange.ADULT);
        
        Patient ibs = new Patient("Irritable Bowel Syndrom",Patient.Gender.FEMALE,Patient.AgeRange.YOUNG,true,true,true,true,true,false,false,true,true,false,false,true,true,true,false,false,false,false,false,false,false,false,false);
        
        Patient chron = new Patient("Chron",Patient.Gender.FEMALE,Patient.AgeRange.YOUNGADULT,true,true,true,true,true,true,true,true,false,true,true,false,true,false,false,true,false,false,true,false,false,false,false);
        
        Patient ulcerative_colitis = new Patient("Ulcerative Colitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,true,true,false,false,true,true,false,true,true,true,true,false,true,false,false,false,false,false,false,false,true,true,false);
        
        Patient diverticulosis = new Patient("Diverticulosis",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,true,false,true,false,false,false,true,true,true,false,false,false,false,true,false,true,false,false,false,true,true,false,false);
        
        Patient hernia = new Patient("Inguinal or Abdominal Hernia",Patient.Gender.MALE,Patient.AgeRange.CHILD,true,false,true,true,false,false,false,false,true,false,false,false,true,false,true,true,false,false,false,false,false,false,false);
        
        Patient appendicitis = new Patient("Appendicitis",Patient.Gender.MALE,Patient.AgeRange.YOUNGADULT,true,true,true,true,false,false,true,true,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false);
        
        Patient enterocolitis = new Patient("Infectious Enterocolitis",null,Patient.AgeRange.CHILD,true,false,true,true,false,false,false,true,true,true,false,false,false,false,false,true,true,true,false,false,false,false,false);
        
        Patient celiac_Disease = new Patient("Celiac Disease",Patient.Gender.FEMALE,Patient.AgeRange.ADULT,true,false,true,true,true,true,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,true);
        
        Patient colorectal_cancer = new Patient("Colorectal Cancer",Patient.Gender.MALE,Patient.AgeRange.ADULT,true,true,true,true,true,true,true,true,true,true,true,false,true,false,false,false,false,false,false,false,false,false,false);
        
        //Código molón para probar mis funciones, salu2 Bermejo:
        
        System.out.println(hernia.patientSynmptomsToArrayList());
        System.out.println(hernia.ComparationArrayListSymptoms(appendicitis.patientSynmptomsToArrayList()));
        
        // Fin del código molón :(
        
        
        String answer="";
        boolean answer_not_acceptable;
        Set<String> acceptable_answers_set = new HashSet<String>();

        do {
            answer = ask("What is your gender? female(f) or male(m)");
            acceptable_answers_set.add("f");
            acceptable_answers_set.add("female");
            acceptable_answers_set.add("m");
            acceptable_answers_set.add("male");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter Female(f) or Male(m)");

            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("female") || answer.equalsIgnoreCase("f")) {
                    prediction.setGender(Patient.Gender.FEMALE);
                    patient.setGender(Patient.Gender.FEMALE);

                } else if (answer.equalsIgnoreCase("male") || answer.equalsIgnoreCase("m")) {
                    prediction.setGender(Patient.Gender.MALE);
                    patient.setGender(Patient.Gender.MALE);
                }
            }
        } while ( answer_not_acceptable );

        acceptable_answers_set.clear();

        do {
            answer = ask("How old are you? Select: \n\t1. Age between 0 to 10 \n\t2. Age between 11 to 14"
                    + "\n\t3. Age between 15 to 35 \n\t4. Age above 40");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");
            acceptable_answers_set.add("4");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 4");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        System.out.println("Your age belongs to the age-group CHILD");
                        prediction.setAge(Patient.AgeRange.CHILD);
                        patient.setAge(Patient.AgeRange.CHILD);
                        break;

                    case 2:
                        System.out.println("Your age belongs to the age-group YOUNG");
                        prediction.setAge(Patient.AgeRange.YOUNG);
                        patient.setAge(Patient.AgeRange.YOUNG);
                        break;

                    case 3:
                        System.out.println("Your age belongs to the age-group YOUNG-ADULT");
                        prediction.setAge(Patient.AgeRange.YOUNGADULT);
                        patient.setAge(Patient.AgeRange.YOUNGADULT);
                        break;

                    case 4:
                        System.out.println("Your age belongs to the age-group ADULT");
                        prediction.setAge(Patient.AgeRange.ADULT);
                        patient.setAge(Patient.AgeRange.ADULT);
                        break;
                }
            }

        } while ( answer_not_acceptable );

        acceptable_answers_set.clear();

        do {
            answer = askSymptom("Do you suffer diarrhea?(y/n)");

            acceptable_answers_set.add("y");
            acceptable_answers_set.add("yes");
            acceptable_answers_set.add("n");
            acceptable_answers_set.add("no");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setDiarrhea(true);
                    patient.setDiarrhea(true);


                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setDiarrhea(false);
                    patient.setDiarrhea(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Have you seen blood in your feces?(y/n)");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setRectalHemo(true);
                    patient.setRectalHemo(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setRectalHemo(false);
                    patient.setRectalHemo(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }

            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Do you have ulcers?(y/n)");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setUlcers(true);
                    patient.setUlcers(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setUlcers(false);
                    patient.setUlcers(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Do you have any lumps or bulks in your torso?(y/n)");
            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setBulks(true);
                    patient.setBulks(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setBulks(false);
                    patient.setBulks(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Do you have random chills?(y/n)");
            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setChills(true);
                    patient.setChills(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setChills(false);
                    patient.setChills(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Have you been suffering dermatitis?(y/n)");
            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setDermatitis(true);
                    patient.setDermatitis(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setDermatitis(false);
                    patient.setDermatitis(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Does any member of your family suffers or have suffered any digestive disorder?(y/n)");
            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setGenetic(true);
                    patient.setGenetic(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setGenetic(false);
                    patient.setGenetic(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Have you seen blood in your feces?(y/n)");
            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setMelenas(true);
                    patient.setMelenas(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setMelenas(false);
                    patient.setMelenas(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
            }
        } while ( answer_not_acceptable );

        do {
            answer = askSymptom("Have you suffered nauseas recently?(y/n)");
            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if ( answer_not_acceptable ) {
                System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                DEBUG("Answer = " + answer);
                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                    prediction.setNausea(true);
                    patient.setNausea(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    prediction.setNausea(false);
                    patient.setNausea(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            /*ksession.insert(disease);
            ksession.fireAllRules();
            ksession.dispose();*/
            }
        } while ( answer_not_acceptable );

        execute(ks,kc,patient);
        
        // Result code:
        System.out.println(patient.ComparationArrayListSymptoms(ibs.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(chron.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(ulcerative_colitis.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(diverticulosis.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(hernia.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(appendicitis.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(enterocolitis.patientSynmptomsToArrayList()));
        System.out.println(patient.ComparationArrayListSymptoms(celiac_Disease.patientSynmptomsToArrayList()));
         System.out.println(patient.ComparationArrayListSymptoms(colorectal_cancer.patientSynmptomsToArrayList()));



        
      
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
     
    
