package Exo2;

public class enseignant {
	private Specialite specialite;
	private String nom;
	
	public enseignant(Specialite specialite,String nom) {
		this.specialite = specialite;
		this.nom = nom;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	@Override
	public String toString() {
		return " "+nom;
	}
}
