package sample.view.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import sample.model.Dataset;
import sample.view.ChartController;

/**
 * Created by Varn on 2017-01-30.
 */
public class GoldEarnedController implements ChartController {

    @FXML
    AreaChart chart;


    @Override
    public void setData(Dataset playerData, Dataset averageData) {

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("player");
        series1.getData().add(new XYChart.Data("0",0));
        series1.getData().add(new XYChart.Data("2",playerData.getGoldEarned()*0.02));
        series1.getData().add(new XYChart.Data("4",playerData.getGoldEarned()*0.05));
        series1.getData().add(new XYChart.Data("6",playerData.getGoldEarned()*0.10));
        series1.getData().add(new XYChart.Data("8",playerData.getGoldEarned()*0.18));
        series1.getData().add(new XYChart.Data("10",playerData.getGoldEarned()*0.26));
        series1.getData().add(new XYChart.Data("12",playerData.getGoldEarned()*0.36));
        series1.getData().add(new XYChart.Data("14",playerData.getGoldEarned()*0.48));
        series1.getData().add(new XYChart.Data("16",playerData.getGoldEarned()*0.63));
        series1.getData().add(new XYChart.Data("18",playerData.getGoldEarned()*0.80));
        series1.getData().add(new XYChart.Data("20",playerData.getGoldEarned()));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("average");
        series2.getData().add(new XYChart.Data("0",0));
        series2.getData().add(new XYChart.Data("2",averageData.getGoldEarned()*0.07));
        series2.getData().add(new XYChart.Data("4",averageData.getGoldEarned()*0.14));
        series2.getData().add(new XYChart.Data("6",averageData.getGoldEarned()*0.20));
        series2.getData().add(new XYChart.Data("8",averageData.getGoldEarned()*0.26));
        series2.getData().add(new XYChart.Data("10",averageData.getGoldEarned()*0.34));
        series2.getData().add(new XYChart.Data("12",averageData.getGoldEarned()*0.43));
        series2.getData().add(new XYChart.Data("14",averageData.getGoldEarned()*0.53));
        series2.getData().add(new XYChart.Data("16",averageData.getGoldEarned()*0.65));
        series2.getData().add(new XYChart.Data("18",averageData.getGoldEarned()*0.82));
        series2.getData().add(new XYChart.Data("20",averageData.getGoldEarned()));

        chart.getData().addAll(series1,series2);
        chart.setTitle("Gold Earned");

    }
}
