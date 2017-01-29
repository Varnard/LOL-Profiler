package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.model.Champion;
import sample.model.Winrate;
import sample.view.MainController;

import java.io.IOException;
import java.util.Map;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane mainLayout;

    private Storage storage;



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("LoLProfiler");

        storage= new Storage();

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
        return storage.getChampions();
    }

    public Map<String, Winrate> getWinrates() {
        return storage.getWinrates();
    }
}
