package modele;

public class User {
	private int id;
	private String nom;
	private String prenom;
	private String pwd;
	private String email;
	private String tel;
	
	public User(int id, String nom, String prenom, String pwd, String email, String tel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
	}
	public User(String nom, String prenom, String pwd, String email, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	
}
