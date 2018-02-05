package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Freyja
 **/
public enum Type {

    //@formatter:off
    ELEC("Problème électrique"),
    MAT("Problème matériel"),
    OBJP("Objet perdu"),
    OBJT("Objet trouvé"),
    INFO("Problème informatique"),
    WC("Problème toilettes"),
    SALE("Saleté dans les batiments"),
    CAR("Problème parking"),
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