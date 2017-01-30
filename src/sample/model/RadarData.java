package sample.model;

/**
 * Created by Varn on 2017-01-30.
 */
public class RadarData {

    private double kills;
    private double deaths;
    private double assists;
    private int damageDealt;
    private int damageTaken;
    private int goldEarned;

    public RadarData() {
    }

    public RadarData(double kills, double deaths, double assists, int damageDealt, int damageTaken, int goldEarned) {
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.damageDealt = damageDealt;
        this.damageTaken = damageTaken;
        this.goldEarned = goldEarned;
    }

    public double getKills() {
        return kills;
    }

    public void setKills(double kills) {
        this.kills = kills;
    }

    public double getDeaths() {
        return deaths;
    }

    public void setDeaths(double deaths) {
        this.deaths = deaths;
    }

    public double getAssists() {
        return assists;
    }

    public void setAssists(double assists) {
        this.assists = assists;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }
}
