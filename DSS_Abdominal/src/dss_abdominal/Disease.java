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
public class Disease {
    
    private String diseaseName;
    public enum Gender {MALE, FEMALE};
  //CHILD(5-10), YOUNG(12-14), YOUNGADULT(15-35) AND ADULT(+40) 
    public enum AgeRange {CHILD,YOUNG,YOUNGADULT,ADULT}; 
    private Gender gender;
    private AgeRange age;
    private static float weight_abdpain;
    private static float weight_distention;
    private static float weight_nausea;
    private static float weight_vomiting;
    private static float weight_anxiety;
    private static float weight_genetic;
    private static float weight_tobacco;
    private static float weight_diarrhea;
    private static float weight_rectalHemo;
    private static float weight_exhaustion;
    private static float weight_weightLoss;
    private static float weight_cramps;
    private static float weight_constipation;
    private static float weight_pee;
    private static float weight_bulks;
    private static float weight_fever;
    private static float weight_perianalDiscom;
    private static float weight_ulcers;
    private static float weight_melenas;
    private static float weight_chills;
    private static float weight_fatigue;
    private static float weight_poo;
    private static float weight_dermatitis;

    public String getDiseaseName() {
        return diseaseName;
    }

    public Gender getGender() {
        return gender;
    }

    public AgeRange getAge() {
        return age;
    }

    public static float getWeight_abdpain() {
        return weight_abdpain;
    }

    public static float getWeight_distention() {
        return weight_distention;
    }

    public static float getWeight_nausea() {
        return weight_nausea;
    }

    public static float getWeight_vomiting() {
        return weight_vomiting;
    }

    public static float getWeight_anxiety() {
        return weight_anxiety;
    }

    public static float getWeight_genetic() {
        return weight_genetic;
    }

    public static float getWeight_tobacco() {
        return weight_tobacco;
    }

    public static float getWeight_diarrhea() {
        return weight_diarrhea;
    }

    public static float getWeight_rectalHemo() {
        return weight_rectalHemo;
    }

    public static float getWeight_exhaustion() {
        return weight_exhaustion;
    }

    public static float getWeight_weightLoss() {
        return weight_weightLoss;
    }

    public static float getWeight_cramps() {
        return weight_cramps;
    }

    public static float getWeight_constipation() {
        return weight_constipation;
    }

    public static float getWeight_pee() {
        return weight_pee;
    }

    public static float getWeight_bulks() {
        return weight_bulks;
    }

    public static float getWeight_fever() {
        return weight_fever;
    }

    public static float getWeight_perianalDiscom() {
        return weight_perianalDiscom;
    }

    public static float getWeight_ulcers() {
        return weight_ulcers;
    }

    public static float getWeight_melenas() {
        return weight_melenas;
    }

    public static float getWeight_chills() {
        return weight_chills;
    }

    public static float getWeight_fatigue() {
        return weight_fatigue;
    }

    public static float getWeight_poo() {
        return weight_poo;
    }

    public static float getWeight_dermatitis() {
        return weight_dermatitis;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(AgeRange age) {
        this.age = age;
    }

    public static void setWeight_abdpain(float weight_abdpain) {
        Disease.weight_abdpain = weight_abdpain;
    }

    public static void setWeight_distention(float weight_distention) {
        Disease.weight_distention = weight_distention;
    }

    public static void setWeight_nausea(float weight_nausea) {
        Disease.weight_nausea = weight_nausea;
    }

    public static void setWeight_vomiting(float weight_vomiting) {
        Disease.weight_vomiting = weight_vomiting;
    }

    public static void setWeight_anxiety(float weight_anxiety) {
        Disease.weight_anxiety = weight_anxiety;
    }

    public static void setWeight_genetic(float weight_genetic) {
        Disease.weight_genetic = weight_genetic;
    }

    public static void setWeight_tobacco(float weight_tobacco) {
        Disease.weight_tobacco = weight_tobacco;
    }

    public static void setWeight_diarrhea(float weight_diarrhea) {
        Disease.weight_diarrhea = weight_diarrhea;
    }

    public static void setWeight_rectalHemo(float weight_rectalHemo) {
        Disease.weight_rectalHemo = weight_rectalHemo;
    }

    public static void setWeight_exhaustion(float weight_exhaustion) {
        Disease.weight_exhaustion = weight_exhaustion;
    }

    public static void setWeight_weightLoss(float weight_weightLoss) {
        Disease.weight_weightLoss = weight_weightLoss;
    }

    public static void setWeight_cramps(float weight_cramps) {
        Disease.weight_cramps = weight_cramps;
    }

    public static void setWeight_constipation(float weight_constipation) {
        Disease.weight_constipation = weight_constipation;
    }

    public static void setWeight_pee(float weight_pee) {
        Disease.weight_pee = weight_pee;
    }

    public static void setWeight_bulks(float weight_bulks) {
        Disease.weight_bulks = weight_bulks;
    }

    public static void setWeight_fever(float weight_fever) {
        Disease.weight_fever = weight_fever;
    }

    public static void setWeight_perianalDiscom(float weight_perianalDiscom) {
        Disease.weight_perianalDiscom = weight_perianalDiscom;
    }

    public static void setWeight_ulcers(float weight_ulcers) {
        Disease.weight_ulcers = weight_ulcers;
    }

    public static void setWeight_melenas(float weight_melenas) {
        Disease.weight_melenas = weight_melenas;
    }

    public static void setWeight_chills(float weight_chills) {
        Disease.weight_chills = weight_chills;
    }

    public static void setWeight_fatigue(float weight_fatigue) {
        Disease.weight_fatigue = weight_fatigue;
    }

    public static void setWeight_poo(float weight_poo) {
        Disease.weight_poo = weight_poo;
    }

    public static void setWeight_dermatitis(float weight_dermatitis) {
        Disease.weight_dermatitis = weight_dermatitis;
    }

    @Override
    public String toString() {
        return "Disease{" + "diseaseName=" + diseaseName + ", gender=" + gender + ", age=" + age + '}';
    }

    
    
    
    
}


