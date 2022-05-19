package Exo1;

public class Livre {
	private int Id;
	private String Titre;
	private String Auteur;
	private int Prix;
	
	public int getId() {
		return Id;
	}
	public String getTitre() {
		return Titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public int getPrix() {
		return Prix;
	}
	public Livre(String titre, String auteur, int prix) {
		Titre = titre;
		Auteur = auteur;
		Prix = prix;
	}
	@Override
	public String toString() {
		return "Livre [Titre=" + Titre + ", Auteur=" + Auteur + ", Prix=" + Prix + "]";
	}
}