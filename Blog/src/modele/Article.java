package modele;

import java.util.Date;

public class Article {
	private int id;
	private String titre;
	private String resume;
	private String contenu;
	private Date date;
	private String auteur;
	private int auteur_id;
	
	public int getAuteur_id() {
		return auteur_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public Article(int id, String titre, String resume, String contenu, Date date, String auteur, int auteur_id) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
		this.auteur_id = auteur_id;
	}
	public Article(int id, String titre, String resume, Date date, String auteur, int auteur_id) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.date = date;
		this.auteur = auteur;
		this.auteur_id = auteur_id;
	}
	public Article(String titre, String resume, String contenu, String auteur, int auteur_id) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.auteur = auteur;
		this.auteur_id = auteur_id;
	}
	public Article(String titre, String resume, String contenu, Date date, String auteur) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}
	public Article(String titre, String resume, String contenu, Date date, String auteur,int auteur_id) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
		this.auteur_id = auteur_id;
	}
	public Article() {
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", resume=" + resume + ", contenu=" + contenu + ", date="
				+ date + ", auteur=" + auteur + ", auteur_id=" + auteur_id + "]";
	}
	
	
}