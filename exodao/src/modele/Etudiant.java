package modele;

public class Etudiant {
	private String nom;
	private String prenom;
	private String Email;
	
	public Etudiant() {
	}
	public Etudiant(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		Email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
