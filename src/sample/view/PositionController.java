package sample.view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import sample.Main;
import sample.model.Winrate;

import java.util.Map;


public class PositionController {

    @FXML
    private ImageView map;

    @FXML
    private PieChart top;

    @FXML
    private PieChart jungle;

    @FXML
    private PieChart mid;

    @FXML
    private PieChart bot;

    @FXML
    private PieChart sup;
    
    @FXML
    private BarChart<String,Integer> distribution;


    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
        Map<String, Winrate> winrates = main.getWinrates();
        top.setData(winrates.get("top").toPieChartData());
        jungle.setData(winrates.get("jungle").toPieChartData());
        mid.setData(winrates.get("mid").toPieChartData());
        bot.setData(winrates.get("bot").toPieChartData());
        sup.setData(winrates.get("sup").toPieChartData());

        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Top", winrates.get("top").getAllGames()));
        series.getData().add(new XYChart.Data<>("Jungle", winrates.get("jungle").getAllGames()));
        series.getData().add(new XYChart.Data<>("Mid", winrates.get("mid").getAllGames()));
        series.getData().add(new XYChart.Data<>("Bot", winrates.get("bot").getAllGames()));
        series.getData().add(new XYChart.Data<>("Sup", winrates.get("sup").getAllGames()));
        distribution.getData().add(series);

    }

    @FXML
    public void initialize() {

    }

}
