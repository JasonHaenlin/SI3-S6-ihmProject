package fr.polytech.ihm.model;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup {

    public static void display(final BooleanProperty result) {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Suppression ?");
        Label label1 = new Label("Voulez-vous supprimer cet incident ?");

        Button ok = new Button("Confirmer");
        Button cancel = new Button("Annuler");


        cancel.setOnAction(e -> {
            popupwindow.close();
            result.set(false);
        });

        ok.setOnAction(e -> {
            popupwindow.close();
            result.set(true);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, ok, cancel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #9cc4e4;");
        Scene scene1 = new Scene(layout, 250, 200);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }
}