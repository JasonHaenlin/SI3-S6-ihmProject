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

public class FormulaireController {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private ComboBox<?> posteAnneeDropdown;

    @FXML
    private ComboBox<?> typeDropdown;

    @FXML
    private TextField titreField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ComboBox<?> importanceDropdown;

    @FXML
    private TextField batimentField;

    @FXML
    private TextField salleField;

    @FXML
    private TextField detailsField;

    @FXML
    private Button retourButton;

    @FXML
    private Button validButton;

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
                    submitForm();
                    Stage stage = (Stage) validButton.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    System.out.println("CHAMP EN ROUGE");
                }
            }
        });

        retourButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/freyja-homePage.fxml";
                FXMLLoader loader = new FXMLLoader();
                log.debug("Return to Home Page");
                try {
                    Stage stage = (Stage) retourButton.getScene().getWindow();
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

    public void submitForm() {
        StringProperty nom = new SimpleStringProperty(nomField.getText());
        StringProperty prenom = new SimpleStringProperty(prenomField.getText());
        StringProperty details = new SimpleStringProperty(detailsField.getText());
        StringProperty titre = new SimpleStringProperty(titreField.getText());
        StringProperty description = new SimpleStringProperty(descriptionField.getText());
        StringProperty salle = new SimpleStringProperty(salleField.getText());
        StringProperty batiment = new SimpleStringProperty(batimentField.getText());
        StringProperty posteAnnee = new SimpleStringProperty(posteAnneeDropdown.getValue().toString());
        StringProperty importance = new SimpleStringProperty(importanceDropdown.getValue().toString());
        StringProperty type = new SimpleStringProperty(typeDropdown.getValue().toString());
        LocalDate date = dateField.getValue();
        StringProperty dateString = new SimpleStringProperty(date.toString());

        Incident incident = new Incident(nom, prenom, posteAnnee, type, titre, dateString, description, importance,
                batiment, salle, details);
        IncidentManager.addIncident(incident);
        IncidentManager.saveIncidentList();

    }

}
