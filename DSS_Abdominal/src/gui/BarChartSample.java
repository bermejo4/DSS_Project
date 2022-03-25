/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dss_abdominal.Patient;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

import gui.MainWindow;

public class BarChartSample extends Application implements Initializable {

    private Results results;


    @Override
    public void start(Stage stage) {
        stage.setTitle("Graphic Results View");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Disease Approximation Percentage");
        xAxis.setLabel("Disease");
        yAxis.setLabel("Percentage");

        System.out.println(results.ibsPorcentage);

        Series series1 = new Series();
        series1.setName("IBS");
        series1.getData().add(new Data("", results.ibsPorcentage));

        Series series2 = new Series();
        series2.setName("Chrons");
        series2.getData().add(new Data("", results.chronPorcentage));

        Series series3 = new Series();
        series3.setName("Ulcera");
        series3.getData().add(new Data("", results.ulcerativeColitisPorcentage));

        Series series4 = new Series();
        series4.setName("Diverticulosis");
        series4.getData().add(new Data("", results.diverticulosisPorcentage));

        Series series5 = new Series();
        series5.setName("Hernia");
        series5.getData().add(new Data("", results.herniaPorcentage));

        Series series6 = new Series();
        series6.setName("Appendicitis");
        series6.getData().add(new Data("", results.appendicitisPorcentage));


        Series series7 = new Series();
        series7.setName("Enterocolitis");
        series7.getData().add(new Data("", results.enterocolitisPorcentage));

        Series series8 = new Series();
        series8.setName("Celiac");
        series8.getData().add(new Data("", results.celiacPorcentage));

        Series series9 = new Series();
        series9.setName("Rectal cancer");
        series9.getData().add(new Data("", results.colorectalCancerPorcentage));


        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1, series2, series3, series4, series5, series6, series7, series8, series9);

        Collections.sort(series1.getData(), new Comparator<Data>() {

            @Override
            public int compare(Data o1, Data o2) {
                Number xValue1 = (Number) o1.getXValue();
                Number xValue2 = (Number) o2.getXValue();
                return new Float(xValue1.toString()).compareTo(new Float(xValue2.toString()));
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //calculatePorcentageFromSymptoms();


    }


    public void initComponents(Results result) {
        this.results = result;

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

