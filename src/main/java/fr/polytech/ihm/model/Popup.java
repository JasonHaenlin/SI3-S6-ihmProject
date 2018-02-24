package fr.polytech.ihm.model;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.beans.property.BooleanProperty;

public class Popup {

    public static void display(final BooleanProperty result) {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Suppression ?");
        Label label1 = new Label("Voulez-vous supprimer cette Incident ?");

        Button cancel = new Button("Annul\u00E9");
        Button ok = new Button("Confirm\u00E9");

        cancel.setOnAction(e -> {
            popupwindow.close();
            result.set(false);
        });

        ok.setOnAction(e -> {
            popupwindow.close();
            result.set(true);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, cancel, ok);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #9cc4e4;");
        Scene scene1 = new Scene(layout, 250, 200);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();

    }
}