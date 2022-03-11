/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_project;


public class Disease {
    
    private String diseaseName;
    public enum Gender {MALE, FEMALE};
    //Baby (0-2 años), child (2-12 años),young(12-16) adolescent (16-25), young adult (25-40), adult (40-60), elder (+60)
    public enum AgeRange {BABY,CHILD,YOUNG,ADOLESCENT,YOUNGADULT,ADULT,ELDER};
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

    public Disease() {
       super();
    }
    public Disease(String name) {
       super();
        this.diseaseName=name;
        
    }
    public Disease(String name,Gender gen, AgeRange age) {
       this.diseaseName = name;
        this.gender = gen;
        this.age = age;
    }
     public Disease(String name,AgeRange age) {
       this.diseaseName = name;
        this.age = age;
    }

    public Disease(String diseaseName, Gender gender, AgeRange age, boolean abdpain, boolean distention, boolean nausea, boolean vomiting, boolean anxiety, boolean genetic, boolean tobacco, boolean diarrhea, boolean rectalHemo, boolean exhaustion, boolean weightLoss, boolean cramps, boolean constipation, boolean pee, boolean bulks, boolean fever, boolean perianalDiscom, boolean ulcers, boolean melenas, boolean chills, boolean fatigue, boolean poo, boolean dermatitis) {
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

    @Override
    public String toString() {
        return "Disease{" + "diseaseName=" + diseaseName + ", gender=" + gender + ", age=" + age + ", abdpain=" + abdpain + ", distention=" + distention + ", nausea=" + nausea + ", vomiting=" + vomiting + ", anxiety=" + anxiety + ", genetic=" + genetic + ", tobacco=" + tobacco + ", diarrhea=" + diarrhea + ", rectalHemo=" + rectalHemo + ", exhaustion=" + exhaustion + ", weightLoss=" + weightLoss + ", cramps=" + cramps + ", constipation=" + constipation + ", pee=" + pee + ", bulks=" + bulks + ", fever=" + fever + ", perianalDiscom=" + perianalDiscom + ", ulcers=" + ulcers + ", melenas=" + melenas + ", chills=" + chills + ", fatigue=" + fatigue + ", poo=" + poo + ", dermatitis=" + dermatitis + '}';
    }

    
    
    
}
