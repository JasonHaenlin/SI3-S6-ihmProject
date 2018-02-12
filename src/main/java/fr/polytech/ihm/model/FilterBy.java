package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public enum FilterBy {

    TITRE("Titre"),
    TYPE("Type"),
    IMPORTANCE("Importance"),
    DATE("Date"),
    LOCALISATION("Localisation"),
    NOM("Nom"),
    PRENOM("Prénom"),
    POSTE("Poste");

    private final StringProperty posteannee;

    FilterBy(String posteannee) {
        this.posteannee = new SimpleStringProperty(posteannee);
    }

    @Override
    public String toString() {
        return posteannee.getValue();
    }

}
