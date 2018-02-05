package fr.polytech.ihm;

public class Formulaire {

	private String nom;
	private String prenom;
	private String posteAnnee;
	private String type;
	private String titre;
	private String date;
	private String description;
	private String importance;
	private String batiment;
	private String salle;
	private String details;

	public Formulaire(String nom, String prenom, String posteAnnee, String type, String titre, String date, String description, String importance, String batiment, String salle, String details) {
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

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getPosteAnnee() {
		return posteAnnee;
	}

	public String getType() {
		return type;
	}

	public String getTitre() {
		return titre;
	}

	public String getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public String getImportance() {
		return importance;
	}

	public String getBatiment() {
		return batiment;
	}

	public String getSalle() {
		return salle;
	}

	public String getDetails() {
		return details;
	}
}
