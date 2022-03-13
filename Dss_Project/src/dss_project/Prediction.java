package dss_project;



public class Prediction extends Disease {
    private float p_IBS;
    private float p_chrons;
    private float p_ulcerative;
    private float p_diverticulosis;
    private float p_hernia;
    private float p_appendicitis;
    private float p_enterocolitis;
    private float p_coeliac;
    private float p_rectal_cancer;

    public Prediction(){
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
        return "Prediction:" +
                "\n\tChance of IBS=" + p_IBS +
                "\n\tChance of Chron's disease=" + p_chrons +
                "\n\tChance of ulcerative Colitis=" + p_ulcerative +
                "\n\tChance of diverticulosis=" + p_diverticulosis +
                "\n\tChance of Hernia=" + p_hernia +
                "\n\tChance of appendicitis=" + p_appendicitis +
                "\n\tChance of infectious enterocolitis=" + p_enterocolitis +
                "\n\tChance of coeliac disease=" + p_coeliac +
                "\n\tChance of colorectal cancer=" + p_rectal_cancer;
    }
}
