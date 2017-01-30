package sample;

import javafx.scene.Node;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import sample.model.RadarData;

import java.awt.*;

/**
 * Created by Varn on 2017-01-30.
 */
public class Radar {

    ChartViewer viewer;

    private static CategoryDataset createDataset(RadarData playerData, RadarData avgData)
    {
        String player = "Player";
        String avg = "Average";
        String kills = "Kills";
        String deaths = "Deaths";
        String assists = "Assists";
        String damageDealt = "Damage dealt";
        String damageTaken = "Damage taken";
        String gold = "Gold earned";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1,avg,kills);
        dataset.addValue(1,avg,deaths);
        dataset.addValue(1,avg,assists);
        dataset.addValue(1,avg,damageDealt);
        dataset.addValue(1,avg,damageTaken);
        dataset.addValue(1,avg,gold);

        dataset.addValue(playerData.getKills()/avgData.getKills(),player,kills);
        dataset.addValue(playerData.getDeaths()/avgData.getDeaths(),player,deaths);
        dataset.addValue(playerData.getAssists()/avgData.getAssists(),player,assists);
        dataset.addValue((double)playerData.getDamageDealt()/avgData.getDamageDealt(),player,damageDealt);
        dataset.addValue((double)playerData.getGoldEarned()/avgData.getGoldEarned(),player,gold);

        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        SpiderWebPlot spiderwebplot = new SpiderWebPlot(categorydataset);
        JFreeChart jfreechart = new JFreeChart("Overall", TextTitle.DEFAULT_FONT, spiderwebplot, false);
        LegendTitle legendtitle = new LegendTitle(spiderwebplot);
        legendtitle.setPosition(RectangleEdge.BOTTOM);
        jfreechart.addSubtitle(legendtitle);
        spiderwebplot.setSeriesPaint(0,new Color(100,100,100,160));
        spiderwebplot.setSeriesPaint(1,new Color(0,20,240,160));
        return jfreechart;
    }


    public Radar(RadarData player, RadarData average) {
        CategoryDataset dataset = createDataset(player, average);
        JFreeChart chart = createChart(dataset);
        viewer = new ChartViewer(chart);

    }

    public Node getRadarChart(){
        return viewer;
    }

}
