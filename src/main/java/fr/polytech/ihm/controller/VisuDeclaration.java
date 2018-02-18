package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VisuDeclaration {

    @FXML
    private Label askValidadLabel;

    @FXML
    private Button loupeButton;

    @FXML
    private TextField loupeFiel;

    @FXML
    private ComboBox<?> loupeCombo;

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
    private Button returnButton;

    @FXML
    private Label returnLabel;

}
