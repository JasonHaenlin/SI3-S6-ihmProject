package fr.polytech.ihm.effect;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
    private TranslateTransition tt;

    public Shaker() {
        tt = new TranslateTransition(Duration.millis(25));
        tt.setFromX(0f);
        tt.setToX(5f);
        tt.setFromY(0f);
        tt.setToY(5f);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);
    }

    public void shake(Node node) {
        tt.setNode(node);
        tt.playFromStart();
    }
}