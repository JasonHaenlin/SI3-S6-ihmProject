package fr.polytech.ihm.controller;

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

public class FormulaireController
{
    private static final Logger log = LoggerFactory.getLogger(FormulaireController.class);

    @FXML private TextField nomField;
    @FXML private TextField prenomField;
    @FXML private TextField detailsField;
    @FXML private TextField titreField;
    @FXML private TextArea descriptionField;
	@FXML private ComboBox posteAnneeDropdown;
	@FXML private DatePicker dateField;
	@FXML private ComboBox importanceDropdown;
	@FXML private TextField salleField;
	@FXML private TextField batimentField;
	@FXML private Button validButton;
	@FXML private Button retourButton;

	@FXML
	public void initialize(){

		validButton.setOnMouseClicked(event ->{
			if ( event.getButton()== MouseButton.PRIMARY) {

				String fxmlFile = "/fxml/freyja-homePage.fxml";
				FXMLLoader loader = new FXMLLoader();
				try {
					Stage stage=(Stage) validButton.getScene().getWindow();
					Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

					Scene scene = new Scene(rootNode);
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		retourButton.setOnMouseClicked(event ->{
			if ( event.getButton()== MouseButton.PRIMARY) {

				String fxmlFile = "/fxml/freyja-homePage.fxml";
				FXMLLoader loader = new FXMLLoader();
				try {
					Stage stage=(Stage) retourButton.getScene().getWindow();
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

       StringBuilder builder = new StringBuilder();
    }

    public void changeView(){
    }

}
