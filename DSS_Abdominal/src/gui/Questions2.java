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
public class Questions2 {
    
    @FXML
    private  RadioButton constipation_yes;
    
     @FXML
    private  RadioButton constipation_no;
    
    
     @FXML
    private  RadioButton increasedpee_yes;
     
      @FXML
    private  RadioButton increasedpee_no;
    
     
      @FXML
    private  RadioButton exhaustion_yes;
      
       @FXML
    private  RadioButton exhaustion_no;
    
      
       @FXML
    private  RadioButton weightloss_yes;
       
        @FXML
    private  RadioButton weightloss_no;
    
         
         private ToggleGroup answers;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            answers = new ToggleGroup();
            this.constipation_yes.setToggleGroup(answers);
            this.constipation_no.setToggleGroup(answers);
            this.increasedpee_yes.setToggleGroup(answers);
            this.increasedpee_no.setToggleGroup(answers);
            this.exhaustion_yes.setToggleGroup(answers);
            this.exhaustion_no.setToggleGroup(answers);
            this.weightloss_yes.setToggleGroup(answers);
            this.weightloss_no.setToggleGroup(answers);
            
        }

        public void goBack(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Questions1.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
   
    public void nextQuestions(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Questions3.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
        

}
        