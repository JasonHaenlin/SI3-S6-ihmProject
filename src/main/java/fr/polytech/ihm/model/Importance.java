package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Freyja
 **/
public enum Importance {

    //@formatter:off
    FAIBLE("Faible"),
    MODEREE("Moderée"),
    GRAVE("Grave"),
    CRITIQUE("Critique");
    //@formatter:on

    private final StringProperty importance;

    Importance(String importance) {
        this.importance = new SimpleStringProperty(importance);
    }

    @Override
    public String toString() {
        return importance.getValue();
    }

}
