/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss_project;

/**
 *
 * @author Jaime Bermejo
 */
public class Dss_Project {

    public static void main(String[] args) {
        
        Disease IBS= new Disease("Irritable Bowel Syndrom",Disease.Gender.FEMALE,Disease.AgeRange.YOUNG,true,true,true,true,true,false,false,true,true,false,false,true,true,true,false,false,false,false,false,false,false,false,false);
        
        Disease Chron = new Disease("Chron",Disease.Gender.FEMALE,Disease.AgeRange.YOUNGADULT,true,true,true,true,true,true,true,true,false,true,true,false,true,false,false,true,false,false,true,false,false,false,false);
        
        Disease Ulcerative_colitis= new Disease("Ulcerative Colitis",Disease.Gender.MALE,Disease.AgeRange.YOUNGADULT,true,true,false,false,true,true,false,true,true,true,true,false,true,false,false,false,false,false,false,false,true,true,false);
        
        Disease Diverticulosis= new Disease("Diverticulosis",Disease.Gender.FEMALE,Disease.AgeRange.ADULT,true,false,true,false,false,false,true,true,true,false,false,false,false,true,false,true,false,false,false,true,true,false,false);
        
        Disease Hernia= new Disease("Inguinal or Abdominal Hernia",Disease.Gender.MALE,Disease.AgeRange.CHILD,true,false,true,true,false,false,false,false,true,false,false,false,true,false,true,true,false,false,false,false,false,false,false);
        
        Disease Appendicitis= new Disease("Appendicitis",Disease.Gender.MALE,Disease.AgeRange.YOUNGADULT,true,true,true,true,false,false,true,true,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false);
        
        Disease Enterocolitis= new Disease("Infectious Enterocolitis",null,Disease.AgeRange.CHILD,true,false,true,true,false,false,false,true,true,true,false,false,false,false,false,true,true,true,false,false,false,false,false);
        
        Disease Celiac_Disease = new Disease("Celiac Disease",Disease.Gender.FEMALE,Disease.AgeRange.ADULT,true,false,true,true,true,true,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,true);
        
        Disease Colorectal_cancer= new Disease("Colorectal Cancer",Disease.Gender.MALE,Disease.AgeRange.ADULT,true,true,true,true,true,true,true,true,true,true,true,false,true,false,false,false,false,false,false,false,false,false,false);
        
        
    
    
    }
    
}