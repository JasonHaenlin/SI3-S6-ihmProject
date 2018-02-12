package fr.polytech.ihm.model;

import com.sun.istack.internal.Nullable;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Incident implements Serializable{

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
    public Incident(StringProperty nom, StringProperty prenom, StringProperty posteAnnee, StringProperty type, StringProperty titre, @Nullable StringProperty date, StringProperty description, @Nullable StringProperty importance, @Nullable StringProperty batiment, @Nullable StringProperty salle, @Nullable StringProperty details) {
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

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        nom.set(s.readUTF());
        prenom.set(s.readUTF());
        posteAnnee.set(s.readUTF());
        type.set(s.readUTF());
        titre.set(s.readUTF());
        date.set(s.readUTF());
        description.set(s.readUTF());
        importance.set(s.readUTF());
        batiment.set(s.readUTF());
        salle.set(s.readUTF());
        details.set(s.readUTF());
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
}
