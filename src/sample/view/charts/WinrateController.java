package sample.view.charts;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import sample.model.Dataset;
import sample.model.Winrate;
import sample.view.ChartController;

/**
 * Created by Varn on 2017-01-30.
 */
public class WinrateController implements ChartController {

    @FXML
    Label wins;

    @FXML
    Label loses;

    @FXML
    Label winrate;

    @FXML
    PieChart chart;


    @Override
    public void setData(Dataset playerData, Dataset averageData) {
        Winrate wr = playerData.getWinrate();
        chart.setLegendVisible(false);
        chart.setTitle("Winrate");
        chart.setData(wr.toPieChartData());
        wins.setText(String.valueOf(wr.getWins()));
        loses.setText(String.valueOf(wr.getLoses()));
        winrate.setText(String.format("%.2f",wr.getWinrate()*100)+"%");


    }
}
