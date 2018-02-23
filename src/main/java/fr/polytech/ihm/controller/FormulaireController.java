package fr.polytech.ihm.controller;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import java.time.LocalDate;
import java.util.Calendar;

public class FormulaireController {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    private static final String WARNING_COLOR = "-fx-background-color: rgb(237, 109, 109);";
    private static final String NO_WARNING_COLOR = "-fx-background-color: rgb(255, 255, 255);";

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private ComboBox<PosteAnnee> posteAnneeDropdown;

    @FXML
    private ComboBox<Type> typeDropdown;

    @FXML
    private TextField titreField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private ComboBox<Importance> importanceDropdown;

    @FXML
    private TextField batimentField;

    @FXML
    private TextField salleField;

    @FXML
    private TextField detailsField;

    @FXML
    private Button returnButton;

    @FXML
    private Button validButton;

    @FXML
    private Label champs;

    @FXML
    public void initialize() {
        posteAnneeDropdown.getItems().setAll(PosteAnnee.values());
        typeDropdown.getItems().setAll(Type.values());
        importanceDropdown.getItems().setAll(Importance.values());

        validButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/askValidation.fxml";
                FXMLLoader loader = new FXMLLoader();
                log.debug("Validate input");
                try {
                    if (submitFormOk()) {
                        Stage stage = (Stage) validButton.getScene().getWindow();
                        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                        Scene scene = new Scene(rootNode);
                        stage.setScene(scene);
                        stage.show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        returnButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/freyja-homePage.fxml";
                FXMLLoader loader = new FXMLLoader();
                log.debug("Return to Home Page");
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

    private boolean submitFormOk() {

        boolean reboot = false;

        LocalDate date = dateField.getValue();
        Calendar cal = Calendar.getInstance();

        StringProperty nom = null;//required field
        StringProperty prenom = null;//required field
        StringProperty titre = null;//required field
        StringProperty description = null;//required field
        StringProperty posteAnnee = null; //required field
        StringProperty type = null; //required field
        StringProperty salle = null;
        StringProperty batiment = null;
        StringProperty details = null;
        StringProperty importance = null;
        StringProperty dateString = null;
        //--------//
        nom = new SimpleStringProperty(nomField.getText());
        if (nom.getValue().isEmpty()) {
            nomField.setStyle(WARNING_COLOR);
            reboot = true;
        } else
            nomField.setStyle(NO_WARNING_COLOR);
        //--------//
        prenom = new SimpleStringProperty(prenomField.getText());
        if (prenom.getValue().isEmpty()) {
            prenomField.setStyle(WARNING_COLOR);
            reboot = true;
        } else
            prenomField.setStyle(NO_WARNING_COLOR);
        //--------//
        titre = new SimpleStringProperty(titreField.getText());
        if (titre.getValue().isEmpty()) {
            titreField.setStyle(WARNING_COLOR);
            reboot = true;
        } else
            titreField.setStyle(NO_WARNING_COLOR);
        //--------//
        description = new SimpleStringProperty(descriptionField.getText());
        if (description.getValue().isEmpty()) {
            descriptionField.setStyle(WARNING_COLOR);
            reboot = true;
        } else
            descriptionField.setStyle(NO_WARNING_COLOR);
        //--------//
        try {
            posteAnnee = new SimpleStringProperty(posteAnneeDropdown.getValue().toString());
            posteAnneeDropdown.setStyle(NO_WARNING_COLOR);
        } catch (Exception e) {
            posteAnneeDropdown.setStyle(WARNING_COLOR);
            reboot = true;
        }
        //--------//
        try {
            type = new SimpleStringProperty(typeDropdown.getValue().toString());
            typeDropdown.setStyle(NO_WARNING_COLOR);
        } catch (Exception e) {
            typeDropdown.setStyle(WARNING_COLOR);
            reboot = true;
        }
        //--------//
        try {
            dateString = new SimpleStringProperty(date.toString());
        } catch (NullPointerException e) {
            dateString = new SimpleStringProperty(cal.getTime().toString());
        }
        try {
            importance = new SimpleStringProperty(importanceDropdown.getValue().toString());
        } catch (NullPointerException e) {
            importance = new SimpleStringProperty(Importance.MODEREE.toString());
        }

        salle = new SimpleStringProperty(salleField.getText());
        batiment = new SimpleStringProperty(batimentField.getText());
        details = new SimpleStringProperty(detailsField.getText());

        //--------//
        if (!reboot) {
            Incident incident = new Incident(nom, prenom, posteAnnee, type, titre, dateString, description, importance,
                    batiment, salle, details);
            IncidentManager.addIncident(incident);
        } else {
            log.error("required field needed");
            log.debug("CHAMP EN ROUGE");
            champs.setVisible(true);
        }
        return !reboot;
    }

}
