/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author marin
 */
public class Questions1 {
    
    @FXML
    private  RadioButton lump_yes;
    
     @FXML
    private  RadioButton lump_no;
    
    
     @FXML
    private  RadioButton abdominalSwelling_yes;
     
      @FXML
    private  RadioButton abdominalSwelling_no;
    
     
      @FXML
    private  RadioButton diarrhea_yes;
      
       @FXML
    private  RadioButton diarrhea_no;
    
      
       @FXML
    private  RadioButton nausea_yes;
       
        @FXML
    private  RadioButton nausea_no;
    
       
        @FXML
    private  RadioButton anxiety_depress_yes;
        
         @FXML
    private  RadioButton anxiety_depress_no;
         
         private ToggleGroup answers;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            answers = new ToggleGroup();
            this.lump_yes.setToggleGroup(answers);
            this.lump_no.setToggleGroup(answers);
            this.abdominalSwelling_yes.setToggleGroup(answers);
            this.abdominalSwelling_no.setToggleGroup(answers);
            this.diarrhea_yes.setToggleGroup(answers);
            this.diarrhea_no.setToggleGroup(answers);
            this.nausea_yes.setToggleGroup(answers);
            this.nausea_no.setToggleGroup(answers);
            this.anxiety_depress_yes.setToggleGroup(answers);
            this.anxiety_depress_no.setToggleGroup(answers);    
            
        }
        
        /* no se si hay que agregarlo
        public void radioButtonUpdated(){
            if(this.answers.getSelectedToggle().equals(this.lump_yes)){
                
            }
        }

 */ 
        
    
    
    
    
    
    
}
