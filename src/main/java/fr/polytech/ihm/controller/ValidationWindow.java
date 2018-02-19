package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import fr.polytech.ihm.MainApp;
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

public class ValidationWindow {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    @FXML
    private Label askValidadLabel;

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
    private Label returnLabel;

    @FXML
    private Button validButton;

    @FXML
    private Label validLabel;

    @FXML
    public void initialize() {

        ObservableList<Incident> incidents = FXCollections.observableArrayList();

        incidents.add(IncidentManager.getIncidentList().get(IncidentManager.getIncidentList().size() - 1));

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

        log.debug("Validation page");
        validButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                try {
                    IncidentManager.saveIncidentList();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String fxmlFile = "/fxml/freyja-homePage.fxml";
                FXMLLoader loader = new FXMLLoader();
                log.debug("Validate");

                try {
                    Stage stage = (Stage) validButton.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        returnButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                IncidentManager.removeLastIncident();
                String fxmlFile = "/fxml/applicationForm.fxml";
                FXMLLoader loader = new FXMLLoader();
                log.debug("Go back");
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
    }
}
