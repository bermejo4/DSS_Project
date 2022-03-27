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
    
    private String selectedDiseaseName;
    
    public static void execute(KieServices ks, KieContainer kc, Patient pat){
        KieSession ksession = kc.newKieSession("DiseaseRulesKS");
        ksession.insert(pat);
        ksession.fireAllRules();
        ksession.dispose();
       
    }
    
    
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

        

    public static void main(String[] args) {
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        console_reader = new BufferedReader(new InputStreamReader(System.in));
        
        
        Patient patient = new Patient();
        
        
        String answer="";
        boolean answer_not_acceptable;
        Set<String> acceptable_answers_set = new HashSet<String>();

        do {
            answer = ask("Patient's gender? female(f) or male(m)");
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
                    patient.setGender(Patient.Gender.FEMALE);

                } else if (answer.equalsIgnoreCase("male") || answer.equalsIgnoreCase("m")) {
                    patient.setGender(Patient.Gender.MALE);
                }
            }
        } while ( answer_not_acceptable );

        acceptable_answers_set.clear();

        do {
            answer = ask("How old is the patient? Select: \n\t1. Age between 0 to 10 \n\t2. Age between 11 to 14"
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
                        System.out.println("Patient's age range: CHILD");
                        patient.setAge(Patient.AgeRange.CHILD);
                        break;

                    case 2:
                        System.out.println("Patient's age range: YOUNG");
                        patient.setAge(Patient.AgeRange.YOUNG);
                        break;

                    case 3:
                        System.out.println("Patient's age range: YOUNG-ADULT");
                        patient.setAge(Patient.AgeRange.YOUNGADULT);
                        break;

                    case 4:
                        System.out.println("Patient's age range: ADULT");
                        patient.setAge(Patient.AgeRange.ADULT);
                        break;
                }
            }

        } while ( answer_not_acceptable );

        acceptable_answers_set.clear();
        
        do {
            answer = askSymptom("Is the patient a smoker?(y/n)");
            
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
                    patient.setTobacco(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setTobacco(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

      acceptable_answers_set.clear();

        do {
            answer = askSymptom("Has the patient suffer diarrhea? (y/n)");

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
                    patient.setDiarrhea(true);


                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setDiarrhea(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = askSymptom("Has the patient suffer constipation? (y/n)");

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
                    patient.setConstipation(true);

                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setConstipation(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

        acceptable_answers_set.clear();
        
        do {
            answer = askSymptom("Has the patient any ulcers?(y/n)");
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
                    patient.setUlcers(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setUlcers(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();

        do {
            answer = askSymptom("Has the patient any lumps or bulks?(y/n)");
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
                    patient.setBulks(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setBulks(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();

        do {
            answer = ask("Has the patient experienced chills frequently? \n\t1. None. \n\t2. Sporadic.\n\t3. Frequent.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setChills(0F);
                        break;

                    case 2:
                        patient.setChills(1F);
                        break;

                    case 3:
                        patient.setChills(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );

        acceptable_answers_set.clear();

        do {
            answer = askSymptom("Does any member of the patient's close family suffer or have suffered from any digestive disorder?(y/n)");
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
                    patient.setGenetic(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setGenetic(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

      acceptable_answers_set.clear();

        do {
            answer = ask("Has the patient suffered nauseas recently? \n\t1. None. \n\t2. Sporadic.\n\t3. Frequent.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setNausea(0F);
                        break;

                    case 2:
                        patient.setNausea(1F);
                        break;

                    case 3:
                        patient.setNausea(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient suffered from abdominal swelling? \n\t1. None. \n\t2. Low.\n\t3. High");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setDistention(0F);
                        break;

                    case 2:
                        patient.setDistention(1F);
                        break;

                    case 3:
                        patient.setDistention(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient experienced an increase in pee frequency? \n\t1. None. \n\t2. Sporadic.\n\t3. Frequent.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setPee(0F);
                        break;

                    case 2:
                        patient.setPee(1F);
                        break;

                    case 3:
                        patient.setPee(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient experienced abnormal fatigue? \n\t1. None. \n\t2. Sporadic.\n\t3. Frequent.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setFatigue(0f);
                        break;

                    case 2:
                        patient.setFatigue(1F);
                        break;

                    case 3:
                        patient.setFatigue(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
             
        do {
            answer = ask("Has the patient experienced vomiting? \n\t1. None. \n\t2. Sporadic.\n\t3. Frequent.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setVomiting(0F);
                        break;

                    case 2:
                        patient.setVomiting(1F);
                        break;

                    case 3:
                        patient.setVomiting(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient feel exhausted? \n\t1. None. \n\t2. Mild.\n\t3. Disabling.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setExhaustion(0F);
                        break;

                    case 2:
                        patient.setExhaustion(1F);
                        break;

                    case 3:
                        patient.setExhaustion(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient suffered from a constant urge to defecate \n\t1. None. \n\t2. Mild.\n\t3. Disabling.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setPoo(0F);
                        break;

                    case 2:
                        patient.setPoo(1F);
                        break;

                    case 3:
                        patient.setPoo(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient experienced abdominal pain? \n\t1. None. \n\t2. Mild.\n\t3. Severe.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setAbdpain(0F);
                        break;

                    case 2:
                        patient.setAbdpain(1F);
                        break;

                    case 3:
                        patient.setAbdpain(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient experienced fever lately? \n\t1. None. \n\t2. 37.5º - 39º.\n\t3. > 39º.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setFever(0F);
                        break;

                    case 2:
                        patient.setFever(1F);
                        break;

                    case 3:
                        patient.setFever(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        
        do {
            answer = ask("Has the patient experienced a weight loss in the last 6 months? \n\t1. None. \n\t2. 0-5%.\n\t3. >5%.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setWeightLoss(0F);
                        break;

                    case 2:
                        patient.setWeightLoss(1F);
                        break;

                    case 3:
                        patient.setWeightLoss(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
        do {
            answer = ask("Has the patient experienced discomfort around the anus? \n\t1. None. \n\t2. Focalized.\n\t3. Extended.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setPerianalDiscom(0F);
                        break;

                    case 2:
                        patient.setPerianalDiscom(1F);
                        break;

                    case 3:
                        patient.setPerianalDiscom(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
        
        acceptable_answers_set.clear();
        
         do {
            answer = ask("Has the patient experienced dermatitis? \n\t1. None. \n\t2. Focalized.\n\t3. Extended.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setDermatitis(0F);
                        break;

                    case 2:
                        patient.setDermatitis(1F);
                        break;

                    case 3:
                        patient.setDermatitis(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
         
         acceptable_answers_set.clear();
         
         do {
            answer = ask("Has the patient experienced abdominal cramps? \n\t1. None. \n\t2. Mild.\n\t3. Disabling.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setCramps(0F);
                        break;

                    case 2:
                        patient.setCramps(1F);
                        break;

                    case 3:
                        patient.setCramps(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
         
         acceptable_answers_set.clear();
         
         do {
            answer = ask("Has the patient experienced blood in their feces? \n\t1. None. \n\t2. Few.\n\t3. Substantially.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setMelenas(0F);
                        break;

                    case 2:
                        patient.setMelenas(1F);
                        break;

                    case 3:
                        patient.setMelenas(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
         
         acceptable_answers_set.clear();
         
         do {
            answer = ask("Has the patient bled from the anus? \n\t1. None. \n\t2. A bit.\n\t3. A lot.");

            acceptable_answers_set.add("1");
            acceptable_answers_set.add("2");
            acceptable_answers_set.add("3");

            answer_not_acceptable = !acceptable_answers_set.contains(answer);

            if (answer_not_acceptable) {
                System.out.println("Please enter a number between 1 and 3");
            } else {
                int option = Integer.parseInt(answer);

                switch (option) {
                    case 1:
                        patient.setRectalHemo(0F);
                        break;

                    case 2:
                        patient.setRectalHemo(1F);
                        break;

                    case 3:
                        patient.setRectalHemo(2F);
                        break;
                }
            }
        } while ( answer_not_acceptable );
         
         acceptable_answers_set.clear();
        
        do {
            answer = askSymptom("Has the patient suffered anxiety or depression? (y/n)");
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
                    patient.setAnxiety(true);
                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                    patient.setAnxiety(false);
                } else {
                    System.out.println("Please enter Yes(y) or No(n)");
                }
            }
        } while ( answer_not_acceptable );

        execute(ks,kc,patient);
        
        //String name=selectBestDisease(patient);
        //patient.setDiseaseName(name);
        //System.out.println("/nThe best approximation of your disease is: " + patient.getDiseaseName());
        //System.out.println("/nIf you want more information go to https://medlineplus.gov ");
        
        
      
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
    
    public void calculatePercentageFromSymptoms(Patient patient) {
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
    public String selectBestDisease(Patient patient) {
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
        float position = 0;
        for (int i = 0; i < allPercentages.size(); i++) {
            if (allPercentages.get(i) > max) {
                max = allPercentages.get(i);
                position = i;
            }
        }
        switch ((int) position) {
            case 0:
                selectedDiseaseName = "Irritable Bowel Syndrom";
                break;
            case 1:
                selectedDiseaseName = "Chron's disease";
                break;
            case 2:
                selectedDiseaseName = "Ulcerative Colitis";
                break;
            case 3:
                selectedDiseaseName = "Diverticulosis";
                break;
            case 4:
                selectedDiseaseName = "Inguinal or Abdominal Hernia";
                break;
            case 5:
                selectedDiseaseName = "Appendicitis";
                break;
            case 6:
                selectedDiseaseName = "Infectious Enterocolitis";
                break;
            case 7:
                selectedDiseaseName = "Celiac Disease";
                break;
            case 8:
                selectedDiseaseName = "Colorectal Cancer";
                break;
            default:
                break;
        }

        patient.setDiseaseName(selectedDiseaseName);
        System.out.println(patient.getDiseaseName());
        return selectedDiseaseName;


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
     
    
