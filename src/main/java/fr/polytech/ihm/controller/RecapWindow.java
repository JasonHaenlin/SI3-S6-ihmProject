package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RecapWindow {

    private static final Logger log = LoggerFactory.getLogger(RecapWindow.class);

    @FXML
    private Label recapTitleLabel;

    @FXML
    private Label recapLabel;

    @FXML
    private TableView<Incident> recapArray;

    @FXML
    private TableColumn<Incident, String> title;

    @FXML
    private TableColumn<Incident, String> mishapType;

    @FXML
    private TableColumn<Incident, String> seriousness;

    @FXML
    private TableColumn<Incident, String> date;

    @FXML
    private TableColumn<Incident, String> location;

    @FXML
    private TableColumn<Incident, String> famillyName;

    @FXML
    private TableColumn<Incident, String> name;

    @FXML
    private TableColumn<Incident, String> occupation;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea descriptionText;

    @FXML
    private Button returnButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label returnLabel;

    private Incident incidentObject;

    private IncidentManager incidentManager;

    @FXML
    public void initialize() {
    }

    public void initData(TableRow<Incident> row) {
        incidentObject = row.getItem();
        ObservableList<Incident> incidents = FXCollections.observableArrayList();
        incidents.add(incidentObject);
        try {
            location.setCellValueFactory(
                    cellData -> (cellData.getValue().batimentProperty().concat(cellData.getValue().salleProperty())));
        } catch (Exception e) {
        }
        title.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        mishapType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        seriousness.setCellValueFactory(cellData -> cellData.getValue().importanceProperty());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        famillyName.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        occupation.setCellValueFactory(cellData -> cellData.getValue().posteAnneeProperty());
        recapArray.setItems(incidents);
        descriptionText.setText(incidents.get(0).getDescription());
        event();
    }

    @FXML
    public void event() {
        returnButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/history.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) returnButton.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        deleteButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/history.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {

                    IncidentManager.deleteIncident(incidentObject);
                    log.debug("REGARDE ICI ");
                    log.debug(IncidentManager.getIncidentList().toString());
                    IncidentManager.saveIncidentList();
                    try {
                        IncidentManager.loadIncidentList();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Stage stage = (Stage) returnButton.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
