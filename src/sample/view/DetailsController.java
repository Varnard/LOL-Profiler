package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import org.jfree.chart.fx.ChartViewer;
import sample.Main;
import sample.Radar;
import sample.model.Dataset;
import sample.model.Winrate;

import java.io.IOException;


public class DetailsController {

    @FXML
    Label champion;

    @FXML
    TextField championSearch;
    
    @FXML
    Label position;

    @FXML
    TextField positionSearch;

    @FXML
    SplitPane lowerPane;
    
    @FXML
    Label avgWinrate;

    @FXML
    Label avgKills;

    @FXML
    Label avgDeaths;

    @FXML
    Label avgAssists;

    @FXML
    Label avgDamageDealt;

    @FXML
    Label avgDamageTaken;

    @FXML
    Label avgGoldEarned;

    @FXML
    Label avgCreepScore;

    @FXML
    Label playerWinrate;

    @FXML
    Label playerKills;

    @FXML
    Label playerDeaths;

    @FXML
    Label playerAssists;

    @FXML
    Label playerDamageDealt;

    @FXML
    Label playerDamageTaken;

    @FXML
    Label playerGoldEarned;

    @FXML
    Label playerCreepScore;

    @FXML
    GridPane grid;

    @FXML
    private AreaChart<Number,Number> areaChart;

    private ChartViewer chartviewer;

    Dataset playerData;
    Dataset averageData;


    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;

        championSearch.setText("Camille");
        positionSearch.setText("Jungle");

        playerData = new Dataset(new Winrate(82,43),10,3,7,15100,20300,11627,88);
        averageData= new Dataset(new Winrate(1329,1547),7.25,7.48,8.48,16330,34560,11800,55);

        avgWinrate.setText(String.format("%.2f",averageData.getWinrate().getWinrate()*100)+"%");
        avgKills.setText(String.valueOf(averageData.getKills()));
        avgDeaths.setText(String.valueOf(averageData.getDeaths()));
        avgAssists.setText(String.valueOf(averageData.getAssists()));
        avgDamageDealt.setText(String.valueOf(averageData.getDamageDealt()));
        avgDamageTaken.setText(String.valueOf(averageData.getDamageTaken()));
        avgGoldEarned.setText(String.valueOf(averageData.getGoldEarned()));
        avgCreepScore.setText(String.valueOf(averageData.getCreepScore()));

        playerWinrate.setText(String.format("%.2f",playerData.getWinrate().getWinrate()*100)+"%");
        playerKills.setText(String.valueOf(playerData.getKills()));
        playerDeaths.setText(String.valueOf(playerData.getDeaths()));
        playerAssists.setText(String.valueOf(playerData.getAssists()));
        playerDamageDealt.setText(String.valueOf(playerData.getDamageDealt()));
        playerDamageTaken.setText(String.valueOf(playerData.getDamageTaken()));
        playerGoldEarned.setText(String.valueOf(playerData.getGoldEarned()));
        playerCreepScore.setText(String.valueOf(playerData.getCreepScore()));
        
        grid.add(new Radar(playerData.getRadarData(),averageData.getRadarData()).getRadarChart(),1,0);

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
        champion.setText("Champion");
        position.setText("Position");
    }

    @FXML
    public void showWinrate(){
        changeLayout("winrate");
    }

    @FXML
    public void showKills(){
        changeLayout("kills");
    }

    @FXML
    public void showDeaths(){
        changeLayout("deaths");
    }
    @FXML
    public void showAssists(){
        changeLayout("assists");
    }


    private void changeLayout(String layout) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getClassLoader()
                    .getResource(layout + ".fxml"));

            AnchorPane operation = (AnchorPane) loader.load();

            lowerPane.getItems().remove(1);
            lowerPane.getItems().add(operation);

            // Give the controller access to the main app.
            ChartController controller = loader.getController();
            controller.setData(playerData,averageData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
