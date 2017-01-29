package sample.view;

import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import sample.Main;


public class DetailsController {

    @FXML
    Label asdf;

    @FXML
    private AreaChart<Number,Number> areaChart;

    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;

        areaChart.setTitle("Player-Average Gold Diffrence");

        areaChart.setLegendVisible(false);

        XYChart.Series seriesPlus= new XYChart.Series();
        seriesPlus.getData().add(new XYChart.Data("0", 100));
        seriesPlus.getData().add(new XYChart.Data("2", 0));
        seriesPlus.getData().add(new XYChart.Data("4", 0));
        seriesPlus.getData().add(new XYChart.Data("6", 0));
        seriesPlus.getData().add(new XYChart.Data("8", 100));
        seriesPlus.getData().add(new XYChart.Data("10", 500));
        seriesPlus.getData().add(new XYChart.Data("12", 700));
        seriesPlus.getData().add(new XYChart.Data("14", 1200));
        seriesPlus.getData().add(new XYChart.Data("16", 1000));
        seriesPlus.getData().add(new XYChart.Data("18", 1100));
        seriesPlus.getData().add(new XYChart.Data("20", 1500));
        seriesPlus.getData().add(new XYChart.Data("22", 1700));
        seriesPlus.getData().add(new XYChart.Data("24", 1800));
        seriesPlus.getData().add(new XYChart.Data("26", 2400));
        seriesPlus.getData().add(new XYChart.Data("28", 2600));

        XYChart.Series seriesMinus= new XYChart.Series();
        seriesMinus.getData().add(new XYChart.Data("0", 0));
        seriesMinus.getData().add(new XYChart.Data("2", -200));
        seriesMinus.getData().add(new XYChart.Data("4", -200));
        seriesMinus.getData().add(new XYChart.Data("6", -500));
        seriesMinus.getData().add(new XYChart.Data("8", 0));
        seriesMinus.getData().add(new XYChart.Data("10", -0));
        seriesMinus.getData().add(new XYChart.Data("12", -0));
        seriesMinus.getData().add(new XYChart.Data("14", -0));
        seriesMinus.getData().add(new XYChart.Data("16", -0));
        seriesMinus.getData().add(new XYChart.Data("18", -0));
        seriesMinus.getData().add(new XYChart.Data("20", -0));
        seriesMinus.getData().add(new XYChart.Data("22", -0));
        seriesMinus.getData().add(new XYChart.Data("24", -0));
        seriesMinus.getData().add(new XYChart.Data("26", -0));
        seriesMinus.getData().add(new XYChart.Data("28", -0));

        areaChart.getData().addAll(seriesPlus, seriesMinus);

    }

    @FXML
    public void initialize() {

    }

}
