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
public class Questions4 {
    
    @FXML
    private  RadioButton chills_none;
    
     @FXML
    private  RadioButton chills_sporadic;
    
          @FXML
    private  RadioButton chills_frequent;
    
     @FXML
    private  RadioButton increasedpoo_none;
     
      @FXML
    private  RadioButton increasedpoo_mild;
    
           @FXML
    private  RadioButton increasedpoo_disabling;
    
     
      @FXML
    private  RadioButton fatigue_none;
      
       @FXML
    private  RadioButton fatigue_sporadic;
    
            @FXML
    private  RadioButton fatigue_frequent;
   
        @FXML
    private  RadioButton vomiting_none;
      
           @FXML
    private  RadioButton vomiting_sporadic;
      
        
       @FXML
    private  RadioButton vomiting_frequent;
       
      

         
         private ToggleGroup answers;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            answers = new ToggleGroup();
            this.chills_none.setToggleGroup(answers);
            this.chills_sporadic.setToggleGroup(answers);
            this.chills_frequent.setToggleGroup(answers);
            this.increasedpoo_none.setToggleGroup(answers);
            this.increasedpoo_mild.setToggleGroup(answers);
             this.increasedpoo_disabling.setToggleGroup(answers);
            this.fatigue_none.setToggleGroup(answers);
            this.fatigue_sporadic.setToggleGroup(answers);
            this.fatigue_frequent.setToggleGroup(answers);
            this.vomiting_none.setToggleGroup(answers);
            this.vomiting_sporadic.setToggleGroup(answers);
            this.vomiting_frequent.setToggleGroup(answers);
            
        }

    public void gobackquestions3( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions3.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
    
   
   public void gotoResults( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Results.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
        

}
        