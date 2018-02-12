package fr.polytech.ihm.controller;
/**
 * Sample Skeleton for 'freyja-homePage.fxml' Controller Class
 */

import fr.polytech.ihm.model.IncidentManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePage {

    @FXML // fx:id="declarationButton"
    private Button declarationButton; // Value injected by FXMLLoader

    @FXML // fx:id="declarationLabel"
    private Label declarationLabel; // Value injected by FXMLLoader

    @FXML // fx:id="visuButton"
    private Button visuButton; // Value injected by FXMLLoader

    @FXML // fx:id="visuLabel"
    private Label visuLabel; // Value injected by FXMLLoader

    @FXML
    public void initialize() {
    	try{
		    IncidentManager.loadIncidentList();
	    }catch (Exception e){
		    System.err.println("Pas de fichier de sauvegarde valide trouvé");
	    }

        declarationButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

                String fxmlFile = "/fxml/formulaireIncident.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) declarationButton.getScene().getWindow();
                    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

                    Scene scene = new Scene(rootNode);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


	    visuButton.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {

	            String fxmlFile = "/fxml/history.fxml";
                FXMLLoader loader = new FXMLLoader();
                try {
                    Stage stage = (Stage) visuButton.getScene().getWindow();
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
