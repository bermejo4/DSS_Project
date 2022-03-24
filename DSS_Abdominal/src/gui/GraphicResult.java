/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.stage.Stage;
import gui.MainWindow;

/**
 *
 * @author marin
 */
public class GraphicResult implements Initializable {

    private BarChart barChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Diseases");
        series1.getData().add(new XYChart(x:"Chron's disease",y: MainWindow.));
        
        CategoryAxis xAxis=new CategoryAxis(); //We use this class of category because each disease is a category
        //xAxis.setLabel("Diseases");
    
        NumberAxis yAxis = new NumberAxis();
        //yAxis.setLabel("Approximation percentage");
        //BarChart 11 = new BarChart(xAxis,yAxis);

        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
