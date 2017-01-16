package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * Created by Varn on 2017-01-15.
 */
public class Winrate {

    private IntegerProperty wins;
    private IntegerProperty loses;

    public Winrate() {
    }

    public Winrate(int wins, int loses) {
        this.wins = new SimpleIntegerProperty(wins);
        this.loses = new SimpleIntegerProperty(loses);
    }

    public int getWins() {
        return wins.get();
    }

    public IntegerProperty winsProperty() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins.set(wins);
    }

    public int getLoses() {
        return loses.get();
    }

    public IntegerProperty losesProperty() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses.set(loses);
    }

    public double getWinrate() {
        double winrate;
        if (loses.get() + wins.get() == 0) winrate = 0;
        else {
            winrate = (double) wins.get() / (wins.get() + loses.get());
        }
        return winrate;
    }

    public int getAllGames() {
        return wins.get()+loses.get();
    }

    @Override
    public String toString() {
        return String.valueOf((int) (getWinrate() * 100) + "%");
    }

    public ObservableList<PieChart.Data> toPieChartData() {
        int winCount = wins.get();
        int lossCount = loses.get();
        if (winCount==0 && lossCount==0) lossCount=1;
        return FXCollections.observableArrayList(
                new PieChart.Data("Wins", winCount),
                new PieChart.Data("Loses", lossCount));
    }
}
