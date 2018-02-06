package fr.polytech.ihm.controller;

import fr.polytech.ihm.MainApp;
import fr.polytech.ihm.model.Importance;
import fr.polytech.ihm.model.PosteAnnee;
import fr.polytech.ihm.model.Type;
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
    private TextField detailsField;
    @FXML
    private TextField titreField;
    @FXML
    private TextField salleField;
    @FXML
    private TextField batimentField;


    @FXML
    private TextArea descriptionField;

    @FXML
    private DatePicker dateField;

    @FXML
    private Button validButton;
    @FXML
    private Button retourButton;

    @FXML
    private ComboBox posteAnneeDropdown;
    @FXML
    private ComboBox typeDropdown;
    @FXML
    private ComboBox importanceDropdown;


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
                    //System.out.println(dateField.getChronology());
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
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String details = detailsField.getText();
        String titre = titreField.getText();
        String description = descriptionField.getText();
        String salle = salleField.getText();
        String batiment = batimentField.getText();
        String posteAnnee = posteAnneeDropdown.getValue().toString();
        String importance = importanceDropdown.getValue().toString();
        String type = typeDropdown.getValue().toString();
        LocalDate date = dateField.getValue();


        StringBuilder builder = new StringBuilder();
    }

    public void changeView() {
    }

}
