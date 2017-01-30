package sample.view.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import sample.model.Dataset;
import sample.view.ChartController;

/**
 * Created by Varn on 2017-01-30.
 */
public class DamageDealtController implements ChartController {

    @FXML
    AreaChart chart;


    @Override
    public void setData(Dataset playerData, Dataset averageData) {

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("player");
        series1.getData().add(new XYChart.Data("0",0));
        series1.getData().add(new XYChart.Data("2",playerData.getDamageDealt()*0.07));
        series1.getData().add(new XYChart.Data("4",playerData.getDamageDealt()*0.14));
        series1.getData().add(new XYChart.Data("6",playerData.getDamageDealt()*0.20));
        series1.getData().add(new XYChart.Data("8",playerData.getDamageDealt()*0.26));
        series1.getData().add(new XYChart.Data("10",playerData.getDamageDealt()*0.34));
        series1.getData().add(new XYChart.Data("12",playerData.getDamageDealt()*0.43));
        series1.getData().add(new XYChart.Data("14",playerData.getDamageDealt()*0.53));
        series1.getData().add(new XYChart.Data("16",playerData.getDamageDealt()*0.65));
        series1.getData().add(new XYChart.Data("18",playerData.getDamageDealt()*0.82));
        series1.getData().add(new XYChart.Data("20",playerData.getDamageDealt()));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("average");
        series2.getData().add(new XYChart.Data("0",0));
        series2.getData().add(new XYChart.Data("2",averageData.getDamageDealt()*0.02));
        series2.getData().add(new XYChart.Data("4",averageData.getDamageDealt()*0.05));
        series2.getData().add(new XYChart.Data("6",averageData.getDamageDealt()*0.10));
        series2.getData().add(new XYChart.Data("8",averageData.getDamageDealt()*0.18));
        series2.getData().add(new XYChart.Data("10",averageData.getDamageDealt()*0.26));
        series2.getData().add(new XYChart.Data("12",averageData.getDamageDealt()*0.36));
        series2.getData().add(new XYChart.Data("14",averageData.getDamageDealt()*0.48));
        series2.getData().add(new XYChart.Data("16",averageData.getDamageDealt()*0.63));
        series2.getData().add(new XYChart.Data("18",averageData.getDamageDealt()*0.80));
        series2.getData().add(new XYChart.Data("20",averageData.getDamageDealt()));

        chart.getData().addAll(series1,series2);
        chart.setTitle("Damage Dealt");

    }
}


