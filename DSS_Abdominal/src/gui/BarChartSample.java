/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class BarChartSample extends Application {
    
 
    @Override 
    public void start(Stage stage) {
        stage.setTitle("Graphic Results View");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Disease Approximation Percentage");
        xAxis.setLabel("Disease");       
        yAxis.setLabel("Percentage");
 
        
        
        XYChart.Series series1 = new XYChart.Series(); 
        series1.setName("IBS"); 
        series1.getData().add(new XYChart.Data("", 100));
        
        XYChart.Series series2 = new XYChart.Series(); 
        series2.setName("Chrons"); 
        series2.getData().add(new XYChart.Data("", 3));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Ulcera"); 
        series3.getData().add(new XYChart.Data("", 35));
         
        XYChart.Series series4 = new XYChart.Series();
        series4.setName("Diverticulosis"); 
        series4.getData().add(new XYChart.Data("", 78.15));
        
        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Hernia"); 
        series5.getData().add(new XYChart.Data("", 12.12)); 
        
        XYChart.Series series6 = new XYChart.Series();
        series6.setName("Appendicitis"); 
        series6.getData().add(new XYChart.Data("", 41));  
        
        
        XYChart.Series series7 = new XYChart.Series();
        series7.setName("Enterocolitis"); 
        series7.getData().add(new XYChart.Data("", 1)); 
        
        XYChart.Series series8 = new XYChart.Series();
        series8.setName("Celiac");
        series8.getData().add(new XYChart.Data("", 56));  
        
        XYChart.Series series9 = new XYChart.Series();
        series9.setName("Rectal cancer");
        series9.getData().add(new XYChart.Data("", 8));  
         
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1,series2,series3,series4,series5,series6,series7,series8,series9);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //calculatePorcentageFromSymptoms();
         
    
    
    
    }
    
    
    
    
}

