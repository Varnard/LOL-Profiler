package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import sample.Main;

import java.io.IOException;

/**
 * Created by Varn on 2017-01-16.
 */
public class MainController {

    @FXML
    private Tab champions;

    @FXML
    private Tab positions;

    @FXML
    private Tab details;

    private ChampController champController;

    private PositionController positionController;

    private DetailsController detailsController;




    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;

        FXMLLoader loader = new FXMLLoader();
        champController.setMain(main);
        positionController.setMain(main);
        detailsController.setMain(main);
    }

    @FXML
    public void initialize() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/champions.fxml"));
            BorderPane champions = (BorderPane) loader.load();
            this.champions.setContent(champions);
            champController = loader.getController();

            loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/positions.fxml"));
            BorderPane positions = (BorderPane) loader.load();
            this.positions.setContent(positions);
            positionController = loader.getController();

            loader = new FXMLLoader();
            loader.setLocation(Main.class
                    .getResource("view/details.fxml"));
            BorderPane details = (BorderPane) loader.load();
            this.details.setContent(details);
            detailsController = loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
