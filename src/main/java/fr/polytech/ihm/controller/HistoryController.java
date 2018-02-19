package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HistoryController {

    @FXML
    private ImageView recherch;

    @FXML
    private TableView<Incident> table;

    @FXML
    private TableColumn<Incident, String> titreCol;

    @FXML
    private TableColumn<Incident, String> typeCol;

    @FXML
    private TableColumn<Incident, String> importanceCol;

    @FXML
    private TableColumn<Incident, String> dateCol;

    @FXML
    private TableColumn<Incident, String> localisationCol;

    @FXML
    private TableColumn<Incident, String> nomCol;

    @FXML
    private TableColumn<Incident, String> prenomCol;

    @FXML
    private TableColumn<Incident, String> posteCol;

    @FXML
    private Button retour;

    private static final Logger log = LoggerFactory.getLogger(HistoryController.class);

    @FXML
    public void initialize() {

        ObservableList<Incident> incidents = FXCollections.observableArrayList();
        incidents.addAll(IncidentManager.getIncidentList());

        titreCol.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        typeCol.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        importanceCol.setCellValueFactory(cellData -> cellData.getValue().importanceProperty());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        localisationCol.setCellValueFactory(
                cellData -> (cellData.getValue().batimentProperty().concat(cellData.getValue().salleProperty())));
        nomCol.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomCol.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        posteCol.setCellValueFactory(cellData -> cellData.getValue().posteAnneeProperty());
        table.setItems(incidents);

        retour.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/freyja-homePage.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) retour.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        table.setRowFactory(tv -> {
            TableRow<Incident> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    String fxmlFile = "/fxml/recapForm.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    try {
                        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
                        Stage stage = (Stage) retour.getScene().getWindow();
                        Scene scene = new Scene(rootNode);
                        stage.setScene(scene);
                        RecapWindow controller = loader.<RecapWindow>getController();
                        try {
                            log.info(row.getItem().getNom());
                        } catch (Exception e) {
                            log.error("class null (before new form)");
                        }
                        controller.initData(row);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });
    }
}
