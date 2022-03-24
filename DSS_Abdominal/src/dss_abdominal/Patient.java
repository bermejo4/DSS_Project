/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_abdominal;

import java.util.ArrayList;
import java.lang.Math;


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
    private Float abdpain;
    private Float distention;
    private Float nausea;
    private Float vomiting;
    private Boolean anxiety;
    private Boolean genetic;
    private Boolean tobacco;
    private Boolean diarrhea;
    private Float rectalHemo;
    private Float exhaustion;
    private Float weightLoss;
    private Float cramps;
    private boolean constipation;
    private Float pee;
    private boolean bulks;
    private Float fever;
    private Float perianalDiscom;
    private Boolean ulcers;
    private Float melenas;
    private Float chills;
    private Float fatigue;
    private Float poo;
    private Float dermatitis;

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

    public Patient(String diseaseName, Gender gender, AgeRange age, Float abdpain, Float distention, Float nausea, Float vomiting, Boolean anxiety, Boolean genetic, Boolean tobacco, Boolean diarrhea, Float rectalHemo, Float exhaustion, Float weightLoss, Float cramps, Boolean constipation, Float pee, Boolean bulks, Float fever, Float perianalDiscom, Boolean ulcers, Float melenas, Float chills, Float fatigue, Float poo, Float dermatitis) {
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

    public Float getAbdpain() {
        return abdpain;
    }

    public Float getDistention() {
        return distention;
    }

    public Float getVomiting() {
        return vomiting;
    }

    public Float getRectalHemo() {
        return rectalHemo;
    }

    public Float getExhaustion() {
        return exhaustion;
    }

    public Float getWeightLoss() {
        return weightLoss;
    }

    public Float getCramps() {
        return cramps;
    }

    public Float getPee() {
        return pee;
    }

    public Float getFever() {
        return fever;
    }

    public Float getPerianalDiscom() {
        return perianalDiscom;
    }

    public Float getFatigue() {
        return fatigue;
    }

    public Float getNausea() {
        return nausea;
    }

    public void setNausea(float nausea) {
        this.nausea = nausea;
    }

    public Boolean isAnxiety() {
        return anxiety;
    }

    public void setAnxiety(Boolean anxiety) {
        this.anxiety = anxiety;
    }

    public Boolean isGenetic() {
        return genetic;
    }

    public void setGenetic(Boolean genetic) {
        this.genetic = genetic;
    }

    public Boolean isTobacco() {
        return tobacco;
    }

    public void setTobacco(Boolean tobacco) {
        this.tobacco = tobacco;
    }

    public Boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(Boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public Boolean isConstipation() {
        return constipation;
    }

    public void setConstipation(Boolean constipation) {
        this.constipation = constipation;
    }

    public Boolean isBulks() {
        return bulks;
    }

    public void setBulks(Boolean bulks) {
        this.bulks = bulks;
    }

    public void setAbdpain(float abdpain) {
        this.abdpain = abdpain;
    }

    public void setDistention(float distention) {
        this.distention = distention;
    }

    public void setVomiting(float vomiting) {
        this.vomiting = vomiting;
    }

    public void setRectalHemo(float rectalHemo) {
        this.rectalHemo = rectalHemo;
    }

    public void setExhaustion(float exhaustion) {
        this.exhaustion = exhaustion;
    }

    public void setWeightLoss(float weightLoss) {
        this.weightLoss = weightLoss;
    }

    public void setCramps(float cramps) {
        this.cramps = cramps;
    }

    public void setPee(float pee) {
        this.pee = pee;
    }

    public void setFever(float fever) {
        this.fever = fever;
    }

    public void setPerianalDiscom(float perianalDiscom) {
        this.perianalDiscom = perianalDiscom;
    }

    public void setFatigue(float fatigue) {
        this.fatigue = fatigue;
    }

    public Boolean isUlcers() {
        return ulcers;
    }

    public void setUlcers(Boolean ulcers) {
        this.ulcers = ulcers;
    }

    public Float isMelenas() {
        return melenas;
    }

    public void setMelenas(Float melenas) {
        this.melenas = melenas;
    }

    public Float isChills() {
        return chills;
    }

    public void setChills(Float chills) {
        this.chills = chills;
    }

    public Float isPoo() {
        return poo;
    }

    public void setPoo(Float poo) {
        this.poo = poo;
    }

    public Float isDermatitis() {
        return dermatitis;
    }

    public void setDermatitis(Float dermatitis) {
        this.dermatitis = dermatitis;
    }

    public Float getP_IBS() {
        return p_IBS;
    }

    public void setP_IBS(Float p_IBS) {
        this.p_IBS = p_IBS;
    }

    public Float getP_chrons() {
        return p_chrons;
    }

    public void setP_chrons(Float p_chrons) {
        this.p_chrons = p_chrons;
    }

    public Float getP_ulcerative() {
        return p_ulcerative;
    }

    public void setP_ulcerative(Float p_ulcerative) {
        this.p_ulcerative = p_ulcerative;
    }

    public Float getP_diverticulosis() {
        return p_diverticulosis;
    }

    public void setP_diverticulosis(Float p_diverticulosis) {
        this.p_diverticulosis = p_diverticulosis;
    }

    public Float getP_hernia() {
        return p_hernia;
    }

    public void setP_hernia(Float p_hernia) {
        this.p_hernia = p_hernia;
    }

    public Float getP_appendicitis() {
        return p_appendicitis;
    }

    public void setP_appendicitis(Float p_appendicitis) {
        this.p_appendicitis = p_appendicitis;
    }

    public Float getP_enterocolitis() {
        return p_enterocolitis;
    }

    public void setP_enterocolitis(Float p_enterocolitis) {
        this.p_enterocolitis = p_enterocolitis;
    }

    public Float getP_coeliac() {
        return p_coeliac;
    }

    public void setP_coeliac(Float p_coeliac) {
        this.p_coeliac = p_coeliac;
    }

    public Float getP_rectal_cancer() {
        return p_rectal_cancer;
    }

    public void setP_rectal_cancer(Float p_rectal_cancer) {
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

    public ArrayList<Object> patientSynmptomsToArrayList() {
        ArrayList<Object> diseaseArrayList = new ArrayList<Object>();

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

    public float ComparationArrayListSymptoms(ArrayList<Object> disease1) {
        float result = 0;
        ArrayList<Object> disease = new ArrayList<Object>();
        disease.addAll(this.patientSynmptomsToArrayList());
        
        for (int i = 0; i < (disease1.size() - 1); i++) {
        //System.out.println("");    
        //System.out.println("-----------");
        //System.out.println("-----------");
            if(disease1.get(i).toString().equals(disease.get(i).toString())){
                result=result+0;
                //System.out.println("Sumo 0");
            }
            else{
                if(disease1.get(i).toString().equals("true")){
                    if(disease.get(i).toString().equals("false")){
                        result=result+2;
                        //System.out.println("Sumo 2");
                    }
                }else if(disease1.get(i).toString().equals("false")){
                    if(disease.get(i).toString().equals("true")){
                        result=result+2;
                        //System.out.println("Sumo 2");
                    }
                }else{
                    result=result+Math.abs(Float.parseFloat(disease.get(i).toString())-Float.parseFloat(disease1.get(i).toString()));
                    //System.out.println("Sumo: "+Math.abs(Float.parseFloat(disease.get(i).toString())-Float.parseFloat(disease1.get(i).toString())));
                }
            }
            //System.out.println("-----------");
            //System.out.println(disease1.get(i));
            //System.out.println(disease.get(i));
            //System.out.println("-----------");
            
        }
        System.out.println("result:"+result);
        
        float porcentage=((float)(69-(float)result)/69)*100;//69 is because 23 symptons * 3 range of ponderation
        return porcentage;

    }

}
