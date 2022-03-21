/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
    private  RadioButton abdominalSwelling_none;
     
      @FXML
    private  RadioButton abdominalSwelling_low;
    
           @FXML
    private  RadioButton abdominalSwelling_high;
     
      @FXML
    private  RadioButton diarrhea_yes;
      
       @FXML
    private  RadioButton diarrhea_no;
    
      
       @FXML
    private  RadioButton nausea_none;
       
        @FXML
    private  RadioButton nausea_sporadic;
    
             @FXML
    private  RadioButton nausea_frequent;
       
        @FXML
    private  RadioButton anxiety_depress_yes;
        
         @FXML
    private  RadioButton anxiety_depress_no;
         
         private ToggleGroup answers;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            answers = new ToggleGroup();
            this.lump_yes.setToggleGroup(answers);
            this.lump_no.setToggleGroup(answers);
            this.abdominalSwelling_none.setToggleGroup(answers);
            this.abdominalSwelling_low.setToggleGroup(answers);
            this.abdominalSwelling_high.setToggleGroup(answers);
            this.diarrhea_yes.setToggleGroup(answers);
            this.diarrhea_no.setToggleGroup(answers);
            this.nausea_none.setToggleGroup(answers);
            this.nausea_sporadic.setToggleGroup(answers);
            this.nausea_frequent.setToggleGroup(answers);
            this.anxiety_depress_yes.setToggleGroup(answers);
            this.anxiety_depress_no.setToggleGroup(answers);    
            
        }
        
        /* no se si hay que agregarlo
        public void radioButtonUpdated(){
            if(this.answers.getSelectedToggle().equals(this.lump_yes)){
                
            }
        }

 */ 
        
   
  public void goback( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("MainWindow.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
  
  public void gotoquestions( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions2.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
    
    
    
    
    
    
}
