package sample.model;

import javafx.beans.property.*;

/**
 * Created by Varn on 2017-01-15.
 */
public class Champion {

    private StringProperty name;
    private ObjectProperty<Winrate> winrate;
    private IntegerProperty score;
    private DoubleProperty kills;
    private DoubleProperty deaths;
    private DoubleProperty assists;
    private IntegerProperty cs;

    public Champion() {
    }

    public Champion(StringProperty name, ObjectProperty<Winrate> winrate, IntegerProperty score, DoubleProperty kills, DoubleProperty deaths, DoubleProperty assists, IntegerProperty cs) {
        this.name = name;
        this.winrate = winrate;
        this.score = score;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.cs = cs;
    }

    public Champion(String name, Winrate winrate, int score, double kills, double deaths, double assists, int cs) {
        this.name = new SimpleStringProperty(name);
        this.winrate = new SimpleObjectProperty<>();
        this.winrate.set(winrate);
        this.score = new SimpleIntegerProperty(score);
        this.kills = new SimpleDoubleProperty(kills);
        this.deaths = new SimpleDoubleProperty(deaths);
        this.assists = new SimpleDoubleProperty(assists);
        this.cs = new SimpleIntegerProperty(cs);
    }



    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Winrate getWinrate() {
        return winrate.get();
    }

    public ObjectProperty<Winrate> winrateProperty() {
        return winrate;
    }

    public void setWinrate(Winrate winrate) {
        this.winrate.set(winrate);
    }

    public int getScore() {
        return score.get();
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public double getKills() {
        return kills.get();
    }

    public DoubleProperty killsProperty() {
        return kills;
    }

    public void setKills(double kills) {
        this.kills.set(kills);
    }

    public double getDeaths() {
        return deaths.get();
    }

    public DoubleProperty deathsProperty() {
        return deaths;
    }

    public void setDeaths(double deaths) {
        this.deaths.set(deaths);
    }

    public double getAssists() {
        return assists.get();
    }

    public DoubleProperty assistsProperty() {
        return assists;
    }

    public void setAssists(double assists) {
        this.assists.set(assists);
    }

    public int getCs() {
        return cs.get();
    }

    public IntegerProperty csProperty() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs.set(cs);
    }
}
