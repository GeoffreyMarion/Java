package modele;

public class Article {
	private int id;
	private String titre;
	private String resume;
	private String contenu;
	private String date;
	private String auteur;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Article(String titre, String resume, String contenu, String date, String auteur) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}
	public Article(int id, String titre, String resume, String contenu, String date, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}
	public Article() {
	}
	
	
}
