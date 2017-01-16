package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.model.Champion;
import sample.model.Winrate;
import sample.view.MainController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane mainLayout;

    @FXML
    private ObservableList<Champion> champions;

    private Map<String, Winrate> winrates;



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("LoLProfiler");

        champions = FXCollections.observableArrayList();
        champions.add(new Champion("Katarina",new Winrate(10,5),120,5.4,7.2,3.9,183));
        champions.add(new Champion("Xerath",new Winrate(10,15),120,4.3,3.5,8.9,243));
        champions.add(new Champion("Rengar",new Winrate(12,7),120,12.4,9.2,4.7,89));
        champions.add(new Champion("Orianna",new Winrate(5,5),120,4.2,6.1,13.2,190));
        champions.add(new Champion("Caitlyn",new Winrate(17,31),120,9.4,3.2,3.1,115));

        winrates = new HashMap<>();
        winrates.put("top", new Winrate(23,17));
        winrates.put("jungle", new Winrate(13,6));
        winrates.put("mid", new Winrate(14,19));
        winrates.put("bot", new Winrate(0,0));
        winrates.put("sup", new Winrate(3,8));

        initLayout();


    }

    public void initLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/main.fxml"));
            mainLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            MainController mainController = loader.getController();
            mainController.setMain(this);



            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Champion> getChampions() {
        return champions;
    }

    public Map<String, Winrate> getWinrates() {
        return winrates;
    }
}
