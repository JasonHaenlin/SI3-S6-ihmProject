package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.Incident;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecapWindow {

    private static final Logger log = LoggerFactory.getLogger(RecapWindow.class);

    @FXML
    private Label recapTitleLabel;

    @FXML
    private Label recapLabel;

    @FXML
    private TableView<Incident> recapArray;

    @FXML
    private TableColumn<Incident, String> title;

    @FXML
    private TableColumn<Incident, String> mishapType;

    @FXML
    private TableColumn<Incident, String> seriousness;

    @FXML
    private TableColumn<Incident, String> date;

    @FXML
    private TableColumn<Incident, String> location;

    @FXML
    private TableColumn<Incident, String> famillyName;

    @FXML
    private TableColumn<Incident, String> name;

    @FXML
    private TableColumn<Incident, String> occupation;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea descriptionText;

    @FXML
    private Button returnButton;

    @FXML
    private Label returnLabel;

    private Incident incidentObject;

    @FXML
    public void initialize() {
        /*ObservableList<Incident> incidents = FXCollections.observableArrayList();
        incidents.add(incidentObject);
        try {
            location.setCellValueFactory(
                    cellData -> (cellData.getValue().batimentProperty().concat(cellData.getValue().salleProperty())));
        } catch (Exception e) {
        }
        title.setCellValueFactory(cellData -> cellData.getValue().titreProperty());
        mishapType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        seriousness.setCellValueFactory(cellData -> cellData.getValue().importanceProperty());
        date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        famillyName.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        name.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        occupation.setCellValueFactory(cellData -> cellData.getValue().posteAnneeProperty());
        recapArray.setItems(incidents);
        descriptionText.setText(incidents.get(0).getDescription());*/
        try {
            log.info(incidentObject.getNom());
        } catch (Exception e) {
            log.error("class null");
        }
    }

    public void initData(TableRow<Incident> row) {
        incidentObject = row.getItem();
    }

}
