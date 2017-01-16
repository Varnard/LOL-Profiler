package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sample.Main;
import sample.model.Champion;
import sample.model.Winrate;


public class ChampController {

    @FXML
    private TableView<Champion> table;

    @FXML
    private TableColumn<Champion, String> nameColumn;

    @FXML
    private TableColumn<Champion, Number> scoreColumn;

    @FXML
    private TableColumn<Champion, Winrate> winrateColumn;

    @FXML
    private TableColumn<Champion, Number> killsColumn;

    @FXML
    private TableColumn<Champion, Number> deathsColumn;

    @FXML
    private TableColumn<Champion, Number> assistsColumn;

    @FXML
    private TableColumn<Champion, Number> csColumn;

    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
        table.setItems(main.getChampions());
    }

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        scoreColumn.setCellValueFactory(cellData -> cellData.getValue().scoreProperty());
        winrateColumn.setCellValueFactory(cellData -> cellData.getValue().winrateProperty());
        killsColumn.setCellValueFactory(cellData -> cellData.getValue().killsProperty());
        deathsColumn.setCellValueFactory(cellData -> cellData.getValue().deathsProperty());
        assistsColumn.setCellValueFactory(cellData -> cellData.getValue().assistsProperty());
        csColumn.setCellValueFactory(cellData -> cellData.getValue().csProperty());

        // ** The TableCell class has the method setTextFill(Paint p) that you
        // ** need to override the text color
        //   To obtain the TableCell we need to replace the Default CellFactory
        //   with one that returns a new TableCell instance,
        //   and @Override the updateItem(String item, boolean empty) method.
        //
        killsColumn.setCellFactory(colorFunc(7));
        assistsColumn.setCellFactory(colorFunc(10));
        csColumn.setCellFactory(colorFunc(120));
        deathsColumn.setCellFactory(new Callback<TableColumn<Champion, Number>, TableCell<Champion, Number>>() {
            public TableCell<Champion, Number> call(TableColumn param) {
                return new TableCell<Champion, Number>() {

                    @Override
                    public void updateItem(Number item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if ((double) item > 5)
                                setStyle("-fx-background-color: derive(rgba(255,0,0,0.2),90%)");
                            if ((double) item < 5)
                                setStyle("-fx-background-color: derive(rgba(0,255,0,0.3),90%)");

                            this.setText(item.toString());
                        }

                    }
                };
            }
        });
        winrateColumn.setCellFactory(new Callback<TableColumn<Champion, Winrate>, TableCell<Champion, Winrate>>() {
            public TableCell<Champion, Winrate> call(TableColumn param) {
                return new TableCell<Champion, Winrate>() {

                    @Override
                    public void updateItem(Winrate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.getWinrate() < 0.50)
                                setStyle("-fx-background-color: derive(rgba(255,0,0,0.2),90%)");
                            // Get fancy and change color based on data
                            if (item.getWinrate() > 0.50)
                                setStyle("-fx-background-color: derive(rgba(0,255,0,0.3),90%)");
                            this.setText(item.toString());
                        }

                    }
                };
            }
        });
    }

    private Callback<TableColumn<Champion, Number>, TableCell<Champion, Number>> colorFunc(double value){
        return new Callback<TableColumn<Champion, Number>, TableCell<Champion, Number>>() {
            public TableCell<Champion, Number> call(TableColumn param) {
                return new TableCell<Champion, Number>() {

                    @Override
                    public void updateItem(Number item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item instanceof Double) {
                                if ((double) item < value)
                                    setStyle("-fx-background-color: derive(rgba(255,0,0,0.2),90%)");
                                if ((double) item > value)
                                    setStyle("-fx-background-color: derive(rgba(0,255,0,0.3),90%)");
                            } else if (item instanceof Integer) {
                                if ((int) item < value)
                                    setStyle("-fx-background-color: derive(rgba(255,0,0,0.2),90%)");
                                if ((int) item > value)
                                    setStyle("-fx-background-color: derive(rgba(0,255,0,0.3),90%)");
                            }
                            this.setText(item.toString());
                        }

                    }
                };
            }
        };
    }
}
