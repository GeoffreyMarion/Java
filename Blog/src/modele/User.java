package modele;

public class User {
	private int id;
	private String nom;
	private String prenom;
	private String pwd;
	private String email;
	private String tel;
	private boolean admin=false;
	
	public User(int id, String nom, String prenom, String pwd, String email, String tel,boolean admin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
		this.admin = admin;
	}
	public User(String nom, String prenom, String pwd, String email, String tel,boolean admin) {
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
		this.admin = admin;
	}
	public User(int id, String nom, String prenom, String pwd, String email, String tel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
		this.admin = false;
	}
	public User(String nom, String prenom, String pwd, String email, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pwd=" + pwd + ", email=" + email + ", tel="
				+ tel + ", admin=" + admin +"]";
	}
	
}