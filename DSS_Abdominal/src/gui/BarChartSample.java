/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dss_abdominal.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import gui.MainWindow;
 
public class BarChartSample extends Application implements Initializable {
    
    private Patient patient;
    private MainWindow main;
    private Results results;
    
    public void initComponents(Results result, Patient patient) {
        this.results = result;
        this.patient = patient;
        
      

    }
 
    @Override 
    public void start(Stage stage) {
        stage.setTitle("Graphic Results View");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Disease Approximation Percentage");
        xAxis.setLabel("Disease");       
        yAxis.setLabel("Percentage");
 
        System.out.println(MainWindow.ibsPorcentage);
        
        XYChart.Series series1 = new XYChart.Series(); 
        series1.setName("IBS"); 
        series1.getData().add(new XYChart.Data("",MainWindow.ibsPorcentage));
        
        XYChart.Series series2 = new XYChart.Series(); 
        series2.setName("Chrons"); 
        series2.getData().add(new XYChart.Data("", MainWindow.chronPorcentage));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Ulcera"); 
        series3.getData().add(new XYChart.Data("", MainWindow.ulcerativeColitisPorcentage));
         
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Diverticulosis"); 
        series4.getData().add(new XYChart.Data("", MainWindow.diverticulosisPorcentage));
        
        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Hernia"); 
        series5.getData().add(new XYChart.Data("", MainWindow.herniaPorcentage)); 
        
        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Appendicitis"); 
        series6.getData().add(new XYChart.Data("", MainWindow.appendicitisPorcentage));  
        
        
        XYChart.Series series7 = new XYChart.Series();
        series7.setName("Enterocolitis"); 
        series7.getData().add(new XYChart.Data("", MainWindow.enterocolitisPorcentage )); 
        
        XYChart.Series series8 = new XYChart.Series();
        series8.setName("Celiac");
        series8.getData().add(new XYChart.Data("", MainWindow.celiacPorcentage));  
        
        XYChart.Series series9 = new XYChart.Series();
        series9.setName("Rectal cancer");
        series9.getData().add(new XYChart.Data("", MainWindow.colorectalCancerPorcentage));  
         
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1,series2,series3,series4,series5,series6,series7,series8,series9);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //calculatePorcentageFromSymptoms();
       
    
    }
    public void initComponents(MainWindow main, Patient patient) {
        this.main=main;
        this.patient=patient;
        main.calculatePorcentageFromSymptoms();
        
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

