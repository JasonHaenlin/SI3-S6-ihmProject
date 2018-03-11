package fr.polytech.ihm.controller;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.effect.Shaker;
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
import java.time.format.DateTimeFormatter;
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
    private Label posteLabel;

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

    Shaker shNom = new Shaker();
    Shaker shPrenom = new Shaker();
    Shaker shPoste = new Shaker();
    Shaker shDescripction = new Shaker();
    Shaker shTitre = new Shaker();
    Shaker shType = new Shaker();

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

        Incident tmpIncident = IncidentManager.getTmpIncident();
        if (tmpIncident != null) {
            nomField.setText(tmpIncident.nomProperty().getValue());
            prenomField.setText(tmpIncident.prenomProperty().getValue());
            titreField.setText(tmpIncident.titreProperty().getValue());
            descriptionField.setText(tmpIncident.descriptionProperty().getValue());
            salleField.setText(tmpIncident.salleProperty().getValue());
            batimentField.setText(tmpIncident.batimentProperty().getValue());
            detailsField.setText(tmpIncident.detailsProperty().getValue());

            posteAnneeDropdown.setValue(PosteAnnee.getByName(tmpIncident.posteAnneeProperty().getValue()));
            importanceDropdown.setValue(Importance.getByName(tmpIncident.importanceProperty().getValue()));
            typeDropdown.setValue(Type.getByName(tmpIncident.typeProperty().getValue()));

            System.out.println(tmpIncident.dateProperty().getValue());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
            dateField.setValue(LocalDate.parse(tmpIncident.dateProperty().getValue(), formatter));

        }

    }

    /**
     * Method used to check if the form is correct, meaning if all the required fields are valids
     *
     * @return true if the form is valid, false otherwise
     */
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
            shNom.shake(nomField);
            reboot = true;
        } else
            nomField.setStyle(NO_WARNING_COLOR);
        //--------//
        prenom = new SimpleStringProperty(prenomField.getText());
        if (prenom.getValue().isEmpty()) {
            prenomField.setStyle(WARNING_COLOR);
            shPrenom.shake(prenomField);
            reboot = true;
        } else
            prenomField.setStyle(NO_WARNING_COLOR);
        //--------//
        titre = new SimpleStringProperty(titreField.getText());
        if (titre.getValue().isEmpty()) {
            titreField.setStyle(WARNING_COLOR);
            shTitre.shake(titreField);
            reboot = true;
        } else
            titreField.setStyle(NO_WARNING_COLOR);
        //--------//
        description = new SimpleStringProperty(descriptionField.getText());
        if (description.getValue().isEmpty()) {
            descriptionField.setStyle(WARNING_COLOR);
            shDescripction.shake(descriptionField);
            reboot = true;
        } else
            descriptionField.setStyle(NO_WARNING_COLOR);
        //--------//
        try {
            posteAnnee = new SimpleStringProperty(posteAnneeDropdown.getValue().toString());
            posteAnneeDropdown.setStyle(NO_WARNING_COLOR);
        } catch (Exception e) {
            posteAnneeDropdown.setStyle(WARNING_COLOR);
            shPoste.shake(posteAnneeDropdown);
            reboot = true;
        }
        //--------//
        try {
            type = new SimpleStringProperty(typeDropdown.getValue().toString());
            typeDropdown.setStyle(NO_WARNING_COLOR);
        } catch (Exception e) {
            typeDropdown.setStyle(WARNING_COLOR);
            shType.shake(typeDropdown);
            reboot = true;
        }
        //--------//
        int jour;
        int mois;
        int annee;
        try {
            jour = date.getDayOfMonth();
            mois = date.getMonthValue();
            annee = date.getYear();
        } catch (NullPointerException e) {
            jour = cal.get(Calendar.DAY_OF_MONTH);
            mois = cal.get(Calendar.MONTH) + 1;
            annee = cal.get(Calendar.YEAR);
        }
        dateString = new SimpleStringProperty(jour + "-" + (mois < 9 ? "0" + mois : mois) + "-" + (annee < 9 ? "0" + annee : annee));
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
            champs.setVisible(true);
        }
        return !reboot;
    }
}
