package Exo2;

public class Specialite {
	private String nom;
	
	public Specialite(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return nom;
	}
	
	
}