package fr.polytech.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Freyja
 **/
public enum PosteAnnee {

    //@formatter:off
    TECHNICIEN_DE_SURFACE("Technicien de surface"),
    PROFESSEUR("Professeur"),
    STAGIAIRE("Stagiaire"),
    DOCTORANT("Doctorant"),
    PERSONNEL_ADMINISTRATIF("Personnel administratif"),
    TROISIEME_ANNEE("3\u00E8me Ann\u00E9e"),
    QUATRIEME_ANNEE("4\u00E8me Ann\u00E9e"),
    CINQUIEME_ANNEE("5\u00E8me Ann\u00E9e"),
    VISITEUR("Visiteur"),
    AUTRE("Autre");
    //@formatter:on

    private final StringProperty posteannee;

    PosteAnnee(String posteannee) {
        this.posteannee = new SimpleStringProperty(posteannee);
    }

    @Override
    public String toString() {
        return posteannee.getValue();
    }

    public static PosteAnnee getByName(String name){
        for(PosteAnnee value : values()){
            if(value.posteannee.getValue().equals(name))
                return value;
        }
        return null;
    }

}
