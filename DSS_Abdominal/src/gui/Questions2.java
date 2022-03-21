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
public class Questions2 {
    
    @FXML
    private  RadioButton constipation_yes;
    
     @FXML
    private  RadioButton constipation_no;
    
    
     @FXML
    private  RadioButton increasedpee_none;
     
      @FXML
    private  RadioButton increasedpee_sporadic;
    
           @FXML
    private  RadioButton increasedpee_frequent;
    
     
      @FXML
    private  RadioButton exhaustion_none;
      
       @FXML
    private  RadioButton exhaustion_mild;
    
            @FXML
    private  RadioButton exhaustion_disabling;
   
        @FXML
    private  RadioButton weightloss_no;
      
       @FXML
    private  RadioButton weightloss_zerotofive;
       
      
       @FXML
    private  RadioButton weightloss_morefive;
       
         
         private ToggleGroup answers;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            answers = new ToggleGroup();
            this.constipation_yes.setToggleGroup(answers);
            this.constipation_no.setToggleGroup(answers);
            this.increasedpee_none.setToggleGroup(answers);
            this.increasedpee_sporadic.setToggleGroup(answers);
            this.increasedpee_frequent.setToggleGroup(answers);
            this.exhaustion_none.setToggleGroup(answers);
            this.exhaustion_mild.setToggleGroup(answers);
            this.exhaustion_disabling.setToggleGroup(answers);
            this.weightloss_no.setToggleGroup(answers);
            this.weightloss_zerotofive.setToggleGroup(answers);
            this.weightloss_morefive.setToggleGroup(answers);
            
        }

    public void gobackques1( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Questions1.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
    
  }
    
   
    public void nextQuestions(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Questions3.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
        

}
        