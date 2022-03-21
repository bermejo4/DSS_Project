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
public class Questions3 {
    
    @FXML
    private  RadioButton fever_none;
    
     @FXML
    private  RadioButton fever_medium;
    
          @FXML
    private  RadioButton fever_high;
    
     @FXML
    private  RadioButton discomfortanus_none;
     
      @FXML
    private  RadioButton discomfortanus_focalized;
    
           @FXML
    private  RadioButton discomfortanus_extended;
    
     
      @FXML
    private  RadioButton cramps_none;
      
       @FXML
    private  RadioButton cramps_mild;
    
            @FXML
    private  RadioButton cramps_disabling;
   
        @FXML
    private  RadioButton melenas_none;
      
           @FXML
    private  RadioButton melenas_some;
      
        
       @FXML
    private  RadioButton melenas_alot;
       
          @FXML
    private  RadioButton dermatitis_none;
       
              @FXML
    private  RadioButton dermatitis_focalized;
       
                  @FXML
    private  RadioButton dermatitis_extended;
       

         
         private ToggleGroup answers;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            answers = new ToggleGroup();
            this.fever_none.setToggleGroup(answers);
            this.fever_medium.setToggleGroup(answers);
            this.fever_high.setToggleGroup(answers);
            this.discomfortanus_none.setToggleGroup(answers);
            this.discomfortanus_focalized.setToggleGroup(answers);
             this.discomfortanus_extended.setToggleGroup(answers);
            this.cramps_none.setToggleGroup(answers);
            this.cramps_mild.setToggleGroup(answers);
            this.cramps_disabling.setToggleGroup(answers);
            this.melenas_none.setToggleGroup(answers);
            this.melenas_some.setToggleGroup(answers);
            this.melenas_alot.setToggleGroup(answers);
            this.dermatitis_none.setToggleGroup(answers);
            this.dermatitis_focalized.setToggleGroup(answers);
            this.dermatitis_extended.setToggleGroup(answers);
            
        }

   public void gotoquestions4( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions4.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
    
   
  public void gobackquestions2( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions2.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
        

}
        