package FOAD;

public class Livre {
	private String Titre;
	private String Auteur;
	private double Prix;
	
	public Livre(String titre, String auteur, double prix) {
		super();
		Titre = titre;
		Auteur = auteur;
		Prix = prix;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public double getPrix() {
		return Prix;
	}
	public void setPrix(double prix) {
		Prix = prix;
	}
	@Override
	public String toString() {
		return "Livre [Titre=" + Titre + ", Auteur=" + Auteur + ", Prix=" + Prix + "]";
	}

}
