package fr.polytech.ihm.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import fr.polytech.ihm.model.Popup;
import javafx.fxml.FXML;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class RecapWindow {

    private static final Logger log = LoggerFactory.getLogger(RecapWindow.class);
    @FXML
    private Label recapTitleLabel;

    @FXML
    private Label recapLabel;

    @FXML
    private Label title;

    @FXML
    private Label famillyName;

    @FXML
    private Label name;

    @FXML
    private Label mishapType;

    @FXML
    private Label date;

    @FXML
    private Label occupation;

    @FXML
    private Label seriousness;

    @FXML
    private Label geo;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea descriptionText;

    @FXML
    private Button returnButton;

    @FXML
    private Label returnLabel;

    @FXML
    private Button deleteButton;

    @FXML
    private Label deleteLabel;

    Incident incidents;

    BooleanProperty validation = new SimpleBooleanProperty();

    @FXML
    public void initialize() {
    }

    public void initData(TableRow<Incident> row) {
        incidents = row.getItem();

        geo.setText(incidents.getLocation());
        title.setText(incidents.getTitre());
        mishapType.setText(incidents.getType());
        seriousness.setText(incidents.getImportance());
        date.setText(incidents.getDate());
        famillyName.setText(incidents.getNom());
        name.setText(incidents.getPrenom());
        occupation.setText(incidents.getPosteAnnee());
        descriptionText.setText(incidents.getDescription());
        descriptionText.setText(incidents.getDescription());
        event();
    }

    @FXML
    public void event() {

        validation.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                validation.set(newValue);
            }
        });

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
                if (removeAsk()) {
                    String fxmlFile = "/fxml/history.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    try {

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
            }
        });
    }

    private boolean removeAsk() {
        Popup.display(validation);
        if (validation.get()) {
            IncidentManager.deleteIncident(incidents);
            log.debug("NE REGARDE PAS ICI ");
            log.debug(IncidentManager.getIncidentList().toString());
            try {
                IncidentManager.saveIncidentList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return validation.get();
    }
}
