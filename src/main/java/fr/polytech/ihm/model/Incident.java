package fr.polytech.ihm.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Incident implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(Incident.class);

    private transient StringProperty nom;
    private transient StringProperty prenom;
    private transient StringProperty type;
    private transient StringProperty titre;
    private transient StringProperty posteAnnee;
    private transient StringProperty date;
    private transient StringProperty description;
    private transient StringProperty importance;
    private transient StringProperty batiment;
    private transient StringProperty salle;
    private transient StringProperty details;

    /**
     * Default constructor for an Incident
     *
     * @param nom         the name of the person declaring the incident
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
    public Incident(StringProperty nom, StringProperty prenom, StringProperty posteAnnee, StringProperty type,
            StringProperty titre, StringProperty date, StringProperty description, StringProperty importance,
            StringProperty batiment, StringProperty salle, StringProperty details) {
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

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(nom.getValueSafe());
        s.writeUTF(prenom.getValueSafe());
        s.writeUTF(posteAnnee.getValueSafe());
        s.writeUTF(type.getValueSafe());
        s.writeUTF(titre.getValueSafe());
        s.writeUTF(date.getValueSafe());
        s.writeUTF(description.getValueSafe());
        s.writeUTF(importance.getValueSafe());
        s.writeUTF(batiment.getValueSafe());
        s.writeUTF(salle.getValueSafe());
        s.writeUTF(details.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException {
        nom = new SimpleStringProperty(s.readUTF());
        prenom = new SimpleStringProperty(s.readUTF());
        posteAnnee = new SimpleStringProperty(s.readUTF());
        type = new SimpleStringProperty(s.readUTF());
        titre = new SimpleStringProperty(s.readUTF());
        date = new SimpleStringProperty(s.readUTF());
        description = new SimpleStringProperty(s.readUTF());
        importance = new SimpleStringProperty(s.readUTF());
        batiment = new SimpleStringProperty(s.readUTF());
        salle = new SimpleStringProperty(s.readUTF());
        details = new SimpleStringProperty(s.readUTF());
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getTitre() {
        return titre.get();
    }

    public StringProperty titreProperty() {
        return titre;
    }

    public String getPosteAnnee() {
        return posteAnnee.get();
    }

    public StringProperty posteAnneeProperty() {
        return posteAnnee;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getImportance() {
        return importance.get();
    }

    public StringProperty importanceProperty() {
        return importance;
    }

    public String getBatiment() {
        return batiment.get();
    }

    public StringProperty batimentProperty() {
        return batiment;
    }

    public String getSalle() {
        return salle.get();
    }

    public StringProperty salleProperty() {
        return salle;
    }

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }

    public StringProperty locationProperty() {
        StringProperty sp = new SimpleStringProperty(batiment.get() + "\n" + salle.get() + "\n" + details.get());
        return sp;
    }

    public String getLocation() {
        return "B\u00E2timent: " + batiment.get() + "\nSalle: " + salle.get() + "\nDétails: " + details.get();
    }
}
