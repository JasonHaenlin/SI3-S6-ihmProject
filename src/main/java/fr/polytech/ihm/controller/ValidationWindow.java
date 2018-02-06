package fr.polytech.ihm.controller;

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
    private TableView<?> recapArray;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private TableColumn<?, ?> mishapType;

    @FXML
    private TableColumn<?, ?> seriousness;

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> location;

    @FXML
    private TableColumn<?, ?> famillyName;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> occupation;

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
        log.debug("Validation page");
        validButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

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

                String fxmlFile = "/fxml/formulaireIncident.fxml";
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
