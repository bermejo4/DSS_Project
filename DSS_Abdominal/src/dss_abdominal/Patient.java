/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_abdominal;

import java.util.ArrayList;
import java.lang.Math;


public class Patient {

    private String diseaseName;

    public enum Gender {
        MALE, FEMALE
    };
    
    /**
     * The age ranges are CHILD(5-10), YOUNG(12-14), YOUNGADULT(15-35) AND ADULT(+40)
     */
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
    private Boolean constipation;
    private Float pee;
    private Boolean bulks;
    private Float fever;
    private Float perianalDiscom;
    private Boolean ulcers;
    private Float melenas;
    private Float chills;
    private Float fatigue;
    private Float poo;
    private Float dermatitis;
    
    ArrayList<Object> diseaseArrayList = new ArrayList<>();

   
    public Patient() {
        super();

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

    
    public void setAbdpain(Float abdpain) {
        this.abdpain = abdpain;
    }

    public void setDistention(Float distention) {
        this.distention = distention;
    }

    public void setNausea(Float nausea) {
        this.nausea = nausea;
    }

    public void setVomiting(Float vomiting) {
        this.vomiting = vomiting;
    }

    public void setRectalHemo(Float rectalHemo) {
        this.rectalHemo = rectalHemo;
    }

    public void setExhaustion(Float exhaustion) {
        this.exhaustion = exhaustion;
    }

    public void setWeightLoss(Float weightLoss) {
        this.weightLoss = weightLoss;
    }

    public void setCramps(Float cramps) {
        this.cramps = cramps;
    }

    public void setPee(Float pee) {
        this.pee = pee;
    }

    public void setFever(Float fever) {
        this.fever = fever;
    }

    public void setPerianalDiscom(Float perianalDiscom) {
        this.perianalDiscom = perianalDiscom;
    }

    public void setFatigue(Float fatigue) {
        this.fatigue = fatigue;
    }

    public Boolean getAnxiety() {
        return anxiety;
    }

    public Boolean getGenetic() {
        return genetic;
    }

    public Boolean getTobacco() {
        return tobacco;
    }

    public Boolean getDiarrhea() {
        return diarrhea;
    }

    public Boolean getConstipation() {
        return constipation;
    }

    public Boolean getBulks() {
        return bulks;
    }

    public Boolean getUlcers() {
        return ulcers;
    }

    public Float getMelenas() {
        return melenas;
    }

    public Float getChills() {
        return chills;
    }

    public Float getPoo() {
        return poo;
    }

    public Float getDermatitis() {
        return dermatitis;
    }

    public ArrayList<Object> getDiseaseArrayList() {
        return diseaseArrayList;
    }
    
    

   
    public ArrayList<Object> patientSynmptomsToArrayList() {

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
            if(disease1.get(i).toString().equals(disease.get(i).toString())){
                result=result+0;
            }
            else{
                if(disease1.get(i).toString().equals("true")){
                    if(disease.get(i).toString().equals("false")){
                        result=result+2;
                    }
                }else if(disease1.get(i).toString().equals("false")){
                    if(disease.get(i).toString().equals("true")){
                        result=result+2;
                    }
                }else{
                    result=result+Math.abs(Float.parseFloat(disease.get(i).toString())-Float.parseFloat(disease1.get(i).toString()));
                }
            }
            
        }
        
        float porcentage=((float)(69-(float)result)/69)*100; //23 symptons * 3 range of ponderation = 69
        return porcentage;

    }

    @Override
    public String toString() {
        return "Patient{" + "diseaseName=" + diseaseName + ", gender=" + gender + ", age=" + age + ", abdpain=" + abdpain + ", distention=" + distention + ", nausea=" + nausea + ", vomiting=" + vomiting + ", anxiety=" + anxiety + ", genetic=" + genetic + ", tobacco=" + tobacco + ", diarrhea=" + diarrhea + ", rectalHemo=" + rectalHemo + ", exhaustion=" + exhaustion + ", weightLoss=" + weightLoss + ", cramps=" + cramps + ", constipation=" + constipation + ", pee=" + pee + ", bulks=" + bulks + ", fever=" + fever + ", perianalDiscom=" + perianalDiscom + ", ulcers=" + ulcers + ", melenas=" + melenas + ", chills=" + chills + ", fatigue=" + fatigue + ", poo=" + poo + ", dermatitis=" + dermatitis + ", diseaseArrayList=" + diseaseArrayList + '}';
    }
    
    

}
