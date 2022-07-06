package modele;

public class Vehicule {
	private int id_v;
	private String marque;
	private String modele;
	private String couleur;
	private String immatriculation;
	
	
	public Vehicule(int id_v, String marque, String modele, String couleur, String immatriculation) {
		this.id_v = id_v;
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.immatriculation = immatriculation;
	}
	
	public Vehicule(String marque, String modele, String couleur, String immatriculation) {
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
		this.immatriculation = immatriculation;
	}

	public int getId_v() {
		return id_v;
	}
	public void setId_v(int id) {
		this.id_v = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	
}