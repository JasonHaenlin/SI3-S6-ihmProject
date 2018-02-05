package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Freyja
 **/
public enum PosteAnnee {

    TECHNICIEN_DE_SURFACE("Technicien de surface"),
    PROFESSEUR("Professeur"),
    STAGIAIRE("Stagiaire"),
    DOCTORANT("Doctorant"),
    PERSONNEL_ADMINISTRATIF("Personnel administratif"),
    TROISIEME_ANNEE("3ème Année"),
    QUATRIEME_ANNEE("4ème Année"),
    CINQUIEME_ANNEE("5ème Année"),
    VISITEUR("Visiteur"),
    AUTRE("Autre");

    private final StringProperty posteannee;

    PosteAnnee(String posteannee) {
        this.posteannee = new SimpleStringProperty(posteannee);
    }

    @Override
    public String toString() {
        return posteannee.getValue();
    }

}
