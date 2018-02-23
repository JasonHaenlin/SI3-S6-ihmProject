package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Freyja
 **/
public enum Type {

    //@formatter:off
    ELEC("Probl\u00E8me \u00E9lectrique"),
    MAT("Probl\u00E8me mat\u00E9riel"),
    OBJP("Objet perdu"),
    OBJT("Objet trouv\u00E9"),
    INFO("Probl\u00E8me informatique"),
    WC("Probl\u00E8me toilettes"),
    SALE("Salet\u00E9 dans les b\u00E2timents"),
    CAR("Probl\u00E8me parking"),
    SALLE("Conflit salle"),
    AUTRE("Autre");
    //@formatter:on

    private final StringProperty type;

    Type(String type) {
        this.type = new SimpleStringProperty(type);
    }

    @Override
    public String toString() {
        return type.getValue();
    }
}