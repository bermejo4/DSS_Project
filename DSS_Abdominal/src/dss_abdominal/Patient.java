/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_abdominal;

import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class Patient {

    private float p_IBS;
    private float p_chrons;
    private float p_ulcerative;
    private float p_diverticulosis;
    private float p_hernia;
    private float p_appendicitis;
    private float p_enterocolitis;
    private float p_coeliac;
    private float p_rectal_cancer;
    private String diseaseName;

    public enum Gender {
        MALE, FEMALE
    };
    //CHILD(5-10), YOUNG(12-14), YOUNGADULT(15-35) AND ADULT(+40) 

    public enum AgeRange {
        CHILD, YOUNG, YOUNGADULT, ADULT
    };
    private Gender gender;
    private AgeRange age;
    private boolean abdpain;
    private boolean distention;
    private boolean nausea;
    private boolean vomiting;
    private boolean anxiety;
    private boolean genetic;
    private boolean tobacco;
    private boolean diarrhea;
    private boolean rectalHemo;
    private boolean exhaustion;
    private boolean weightLoss;
    private boolean cramps;
    private boolean constipation;
    private boolean pee;
    private boolean bulks;
    private boolean fever;
    private boolean perianalDiscom;
    private boolean ulcers;
    private boolean melenas;
    private boolean chills;
    private boolean fatigue;
    private boolean poo;
    private boolean dermatitis;

    public Patient() {
        p_IBS = 0;
        p_chrons = 0;
        p_ulcerative = 0;
        p_diverticulosis = 0;
        p_hernia = 0;
        p_appendicitis = 0;
        p_enterocolitis = 0;
        p_coeliac = 0;
        p_rectal_cancer = 0;
    }

    public Patient(String name) {
        super();
        this.diseaseName = name;

    }

    public Patient(String name, Gender gen, AgeRange age) {
        this.diseaseName = name;
        this.gender = gen;
        this.age = age;
    }

    public Patient(String name, AgeRange age) {
        this.diseaseName = name;
        this.age = age;
    }

    public Patient(String diseaseName, Gender gender, AgeRange age, boolean abdpain, boolean distention, boolean nausea, boolean vomiting, boolean anxiety, boolean genetic, boolean tobacco, boolean diarrhea, boolean rectalHemo, boolean exhaustion, boolean weightLoss, boolean cramps, boolean constipation, boolean pee, boolean bulks, boolean fever, boolean perianalDiscom, boolean ulcers, boolean melenas, boolean chills, boolean fatigue, boolean poo, boolean dermatitis) {
        this.diseaseName = diseaseName;
        this.gender = gender;
        this.age = age;
        this.abdpain = abdpain;
        this.distention = distention;
        this.nausea = nausea;
        this.vomiting = vomiting;
        this.anxiety = anxiety;
        this.genetic = genetic;
        this.tobacco = tobacco;
        this.diarrhea = diarrhea;
        this.rectalHemo = rectalHemo;
        this.exhaustion = exhaustion;
        this.weightLoss = weightLoss;
        this.cramps = cramps;
        this.constipation = constipation;
        this.pee = pee;
        this.bulks = bulks;
        this.fever = fever;
        this.perianalDiscom = perianalDiscom;
        this.ulcers = ulcers;
        this.melenas = melenas;
        this.chills = chills;
        this.fatigue = fatigue;
        this.poo = poo;
        this.dermatitis = dermatitis;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AgeRange getAge() {
        return age;
    }

    public void setAge(AgeRange age) {
        this.age = age;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public boolean isAbdpain() {
        return abdpain;
    }

    public void setAbdpain(boolean abdpain) {
        this.abdpain = abdpain;
    }

    public boolean isDistention() {
        return distention;
    }

    public void setDistention(boolean distention) {
        this.distention = distention;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isVomiting() {
        return vomiting;
    }

    public void setVomiting(boolean vomiting) {
        this.vomiting = vomiting;
    }

    public boolean isAnxiety() {
        return anxiety;
    }

    public void setAnxiety(boolean anxiety) {
        this.anxiety = anxiety;
    }

    public boolean isGenetic() {
        return genetic;
    }

    public void setGenetic(boolean genetic) {
        this.genetic = genetic;
    }

    public boolean isTobacco() {
        return tobacco;
    }

    public void setTobacco(boolean tobacco) {
        this.tobacco = tobacco;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isRectalHemo() {
        return rectalHemo;
    }

    public void setRectalHemo(boolean rectalHemo) {
        this.rectalHemo = rectalHemo;
    }

    public boolean isExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(boolean exhaustion) {
        this.exhaustion = exhaustion;
    }

    public boolean isWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(boolean weightLoss) {
        this.weightLoss = weightLoss;
    }

    public boolean isCramps() {
        return cramps;
    }

    public void setCramps(boolean cramps) {
        this.cramps = cramps;
    }

    public boolean isConstipation() {
        return constipation;
    }

    public void setConstipation(boolean constipation) {
        this.constipation = constipation;
    }

    public boolean isPee() {
        return pee;
    }

    public void setPee(boolean pee) {
        this.pee = pee;
    }

    public boolean isBulks() {
        return bulks;
    }

    public void setBulks(boolean bulks) {
        this.bulks = bulks;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isPerianalDiscom() {
        return perianalDiscom;
    }

    public void setPerianalDiscom(boolean perianalDiscom) {
        this.perianalDiscom = perianalDiscom;
    }

    public boolean isUlcers() {
        return ulcers;
    }

    public void setUlcers(boolean ulcers) {
        this.ulcers = ulcers;
    }

    public boolean isMelenas() {
        return melenas;
    }

    public void setMelenas(boolean melenas) {
        this.melenas = melenas;
    }

    public boolean isChills() {
        return chills;
    }

    public void setChills(boolean chills) {
        this.chills = chills;
    }

    public boolean isFatigue() {
        return fatigue;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isPoo() {
        return poo;
    }

    public void setPoo(boolean poo) {
        this.poo = poo;
    }

    public boolean isDermatitis() {
        return dermatitis;
    }

    public void setDermatitis(boolean dermatitis) {
        this.dermatitis = dermatitis;
    }

    public float getP_IBS() {
        return p_IBS;
    }

    public void setP_IBS(float p_IBS) {
        this.p_IBS = p_IBS;
    }

    public float getP_chrons() {
        return p_chrons;
    }

    public void setP_chrons(float p_chrons) {
        this.p_chrons = p_chrons;
    }

    public float getP_ulcerative() {
        return p_ulcerative;
    }

    public void setP_ulcerative(float p_ulcerative) {
        this.p_ulcerative = p_ulcerative;
    }

    public float getP_diverticulosis() {
        return p_diverticulosis;
    }

    public void setP_diverticulosis(float p_diverticulosis) {
        this.p_diverticulosis = p_diverticulosis;
    }

    public float getP_hernia() {
        return p_hernia;
    }

    public void setP_hernia(float p_hernia) {
        this.p_hernia = p_hernia;
    }

    public float getP_appendicitis() {
        return p_appendicitis;
    }

    public void setP_appendicitis(float p_appendicitis) {
        this.p_appendicitis = p_appendicitis;
    }

    public float getP_enterocolitis() {
        return p_enterocolitis;
    }

    public void setP_enterocolitis(float p_enterocolitis) {
        this.p_enterocolitis = p_enterocolitis;
    }

    public float getP_coeliac() {
        return p_coeliac;
    }

    public void setP_coeliac(float p_coeliac) {
        this.p_coeliac = p_coeliac;
    }

    public float getP_rectal_cancer() {
        return p_rectal_cancer;
    }

    public void setP_rectal_cancer(float p_rectal_cancer) {
        this.p_rectal_cancer = p_rectal_cancer;
    }

    @Override
    public String toString() {
        return "Prediction:"
                + "\n\tChance of IBS=" + p_IBS
                + "\n\tChance of Chron's disease=" + p_chrons
                + "\n\tChance of ulcerative Colitis=" + p_ulcerative
                + "\n\tChance of diverticulosis=" + p_diverticulosis
                + "\n\tChance of Hernia=" + p_hernia
                + "\n\tChance of appendicitis=" + p_appendicitis
                + "\n\tChance of infectious enterocolitis=" + p_enterocolitis
                + "\n\tChance of coeliac disease=" + p_coeliac
                + "\n\tChance of colorectal cancer=" + p_rectal_cancer;

    }

    public ArrayList<Boolean> patientSynmptomsToArrayList() {
        ArrayList<Boolean> diseaseArrayList = new ArrayList<Boolean>();

        diseaseArrayList.add(this.abdpain);
        diseaseArrayList.add(this.distention);
        diseaseArrayList.add(this.nausea);
        diseaseArrayList.add(this.vomiting);
        diseaseArrayList.add(this.anxiety);
        diseaseArrayList.add(this.genetic);
        diseaseArrayList.add(this.tobacco);
        diseaseArrayList.add(this.diarrhea);
        diseaseArrayList.add(this.rectalHemo);
        diseaseArrayList.add(this.exhaustion);
        diseaseArrayList.add(this.weightLoss);
        diseaseArrayList.add(this.cramps);
        diseaseArrayList.add(this.constipation);
        diseaseArrayList.add(this.pee);
        diseaseArrayList.add(this.bulks);
        diseaseArrayList.add(this.fever);
        diseaseArrayList.add(this.perianalDiscom);
        diseaseArrayList.add(this.ulcers);
        diseaseArrayList.add(this.melenas);
        diseaseArrayList.add(this.chills);
        diseaseArrayList.add(this.fatigue);
        diseaseArrayList.add(this.poo);
        diseaseArrayList.add(this.dermatitis);

        return diseaseArrayList;

    }

    public int ComparationArrayListSymptoms(ArrayList<Boolean> disease1) {
        int result = 0;
        ArrayList<Boolean> disease = new ArrayList<Boolean>();
        disease.addAll(this.patientSynmptomsToArrayList());
        
        for (int i = 0; i < (disease1.size() - 1); i++) {
            //System.out.println("-----------");
            //System.out.println(disease1.get(i));
            //System.out.println(disease.get(i));
            //System.out.println("-----------");
            
            
            if (disease1.get(i).equals(disease.get(i))) {
                result++;
            }
        }
        return result;

    }

}
