package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MainWindow {

    @FXML
    private  RadioButton smoker_yes;
    
    @FXML
    private  RadioButton smoker_no;
     
    @FXML
    private  RadioButton female;
    
    @FXML
    private  RadioButton male;
     
    @FXML
    private  RadioButton age_one;
    
    @FXML
    private  RadioButton age_two;
     
    @FXML
    private  RadioButton age_three;
    
    @FXML
    private  RadioButton age_four;
    
    @FXML
    private  RadioButton anxiety_depress_no;
         
        private ToggleGroup smoker;
        private ToggleGroup gender;
        private ToggleGroup age;
         
    
        public void initialize (URL url, ResourceBundle rb){
            
            smoker = new ToggleGroup();
            gender = new ToggleGroup();
            age = new ToggleGroup();

            this.smoker_yes.setToggleGroup(smoker);
            this.smoker_no.setToggleGroup(smoker);
            this.male.setToggleGroup(gender);
            this.female.setToggleGroup(gender);
            this.age_one.setToggleGroup(age);
            this.age_two.setToggleGroup(age);
            this.age_three.setToggleGroup(age);
            this.age_four.setToggleGroup(age);
            
        }
        
    
       
    public void gotoquestions(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Questions1.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
     
    
    
    
}
