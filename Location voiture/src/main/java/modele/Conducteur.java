package modele;

public class Conducteur {
	private int id_c;
	private String nom;
	private String prenom;
	
	
	public Conducteur(int id_c, String prenom, String nom) {
		this.id_c = id_c;
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public Conducteur(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
