package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class HistoryController {

    @FXML
    private ImageView recherch;

    @FXML
    private Button researchButton;

    @FXML
    private TextField researchField;

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
        localisationCol.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        nomCol.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomCol.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        posteCol.setCellValueFactory(cellData -> cellData.getValue().posteAnneeProperty());
        table.setItems(incidents);

        wrapLines(localisationCol);
        wrapLines(titreCol);

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
        researchButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                research();
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

    private void wrapLines(TableColumn<Incident, String> col) {
        col.setCellFactory(tc -> {
            TableCell<Incident, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(col.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });
    }

    private void research() {
        StringProperty researched = new SimpleStringProperty(researchField.getText());
        if (!researched.getValue().isEmpty()) {
            String stringResearched = researched.getValue().toLowerCase();
            List<Incident> incidentList = IncidentManager.getIncidentList();
            ObservableList<Incident> incidentObservableList = FXCollections.observableArrayList();
            for (Incident i : incidentList) {
                if (i.getDescription().toLowerCase().contains(stringResearched)
                        || i.getNom().toLowerCase().contains(stringResearched)
                        || i.getLocation().toLowerCase().contains(stringResearched)
                        || i.getPosteAnnee().toLowerCase().contains(stringResearched)
                        || i.getPrenom().toLowerCase().contains(stringResearched)
                        || i.getTitre().toLowerCase().contains(stringResearched)
                        || i.getImportance().toLowerCase().contains(stringResearched)
                        || i.getType().toLowerCase().contains(stringResearched)) {
                    incidentObservableList.add(i);
                }
            }
            table.setItems(incidentObservableList);
            table.refresh();
        }

    }
}
