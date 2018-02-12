package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class HistoryController {

    @FXML
    private ComboBox<?> filter;

    @FXML
    private ImageView recherch;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> titreCol;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    private TableColumn<?, ?> importanceCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> localisationCol;

    @FXML
    private TableColumn<?, ?> nomCol;

    @FXML
    private TableColumn<?, ?> prenomCol;

    @FXML
    private TableColumn<?, ?> posteCol;

    @FXML
    private Button retour;

}

