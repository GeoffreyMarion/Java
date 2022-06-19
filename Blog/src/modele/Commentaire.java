package modele;

public class Commentaire {
	private int id;
	private int article;
	private String auteur;
	private String date;
	private String contenu;
	
	public int getArticle() {
		return article;
	}
	public void setArticle(int article) {
		this.article = article;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getId() {
		return id;
	}
	public Commentaire(int id, int article, String auteur, String date, String contenu) {
		this.id = id;
		this.article = article;
		this.auteur = auteur;
		this.date = date;
		this.contenu = contenu;
	}
	
	public Commentaire(int article, String auteur, String date, String contenu) {
		this.article = article;
		this.auteur = auteur;
		this.date = date;
		this.contenu = contenu;
	}
	
	public Commentaire(String auteur, String date, String contenu) {
		this.auteur = auteur;
		this.date = date;
		this.contenu = contenu;
	}
	
	public Commentaire() {
	}
}
