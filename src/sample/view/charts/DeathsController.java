package sample.view.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import sample.model.Dataset;
import sample.view.ChartController;

/**
 * Created by Varn on 2017-01-30.
 */
public class DeathsController implements ChartController {

    @FXML
    BarChart chart;


    @Override
    public void setData(Dataset playerData, Dataset averageData) {

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("player");
        series1.getData().add(new XYChart.Data("early",playerData.getDeaths()*0.3));
        series1.getData().add(new XYChart.Data("mid",playerData.getDeaths()*0.6));
        series1.getData().add(new XYChart.Data("late",playerData.getDeaths()));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("average");
        series2.getData().add(new XYChart.Data("early",averageData.getDeaths()*0.2));
        series2.getData().add(new XYChart.Data("mid",averageData.getDeaths()*0.7));
        series2.getData().add(new XYChart.Data("late",averageData.getDeaths()));

        chart.getData().addAll(series1,series2);
        chart.setTitle("Kills");

    }
}
