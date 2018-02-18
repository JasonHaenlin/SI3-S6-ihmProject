package fr.polytech.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting Freyja application");
        String fxmlFile = "/fxml/freyja-homePage.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing Home Page scene");
        Scene scene = new Scene(rootNode, 735, 465);

        stage.setTitle("Freyja - Gestion d'incidents pour Polytech");
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/logo.png"));

        stage.show();
    }
}
