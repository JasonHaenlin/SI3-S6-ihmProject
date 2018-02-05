package fr.polytech.ihm.model;

import javafx.beans.property.StringProperty;

public class Incident {

    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty posteAnnee;
    private StringProperty type;
    private StringProperty titre;
    private StringProperty date;
    private StringProperty description;
    private StringProperty importance;
    private StringProperty batiment;
    private StringProperty salle;
    private StringProperty details;

    /**
     * Default constructor for an Incident
     *
     * @param nom         the name of the person declaring the incient
     * @param prenom      the first name of the person declaring the incident
     * @param posteAnnee  the role or year of the person declaring the incident
     * @param type        the type of the incident
     * @param titre       the title of the incident
     * @param date        the date at which the incident occured or was declarated
     * @param description the precise description of the incident
     * @param importance  the importance of the incident
     * @param batiment    the location of the incident
     * @param salle       the room of Polytech of the incident
     * @param details     some details can be add
     */
    public Incident(StringProperty nom, StringProperty prenom, StringProperty posteAnnee, StringProperty type, StringProperty titre, StringProperty date, StringProperty description, StringProperty importance, StringProperty batiment, StringProperty salle, StringProperty details) {
        this.nom = nom;
        this.prenom = prenom;
        this.posteAnnee = posteAnnee;
        this.type = type;
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.importance = importance;
        this.batiment = batiment;
        this.salle = salle;
        this.details = details;
    }

}
