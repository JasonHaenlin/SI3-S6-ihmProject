package fr.polytech.ihm.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.polytech.ihm.model.Incident;
import fr.polytech.ihm.model.IncidentManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class ValidationWindow {

    private static final Logger log = LoggerFactory.getLogger(ValidationWindow.class);

    @FXML
    private Label askValidadLabel;

    @FXML
    private Label recapLabel;

    @FXML
    private Label title;

    @FXML
    private Label name;

    @FXML
    private Label famillyName;

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
    private Button validButton;

    @FXML
    private Label validLabel;

    @FXML
    public void initialize() {

        Incident incidents;

        incidents = IncidentManager.getIncidentList().get(IncidentManager.getIncidentList().size() - 1);

        geo.setText(incidents.getLocation());
        title.setText(incidents.getTitre());
        mishapType.setText(incidents.getType());
        seriousness.setText(incidents.getImportance());
        date.setText(incidents.getDate());
        famillyName.setText(incidents.getNom());
        name.setText(incidents.getPrenom());
        occupation.setText(incidents.getPosteAnnee());
        descriptionText.setText(incidents.getDescription());

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
