package Heritage;

public class User extends Personne {
	private String login;
	private String pwd;
	private String service;
	
	private Role role;
	
	public User(String nom, String prenom, String email, int tel, double salaire,
			String login, String pwd, String service) {
		
		super(nom, prenom, email,tel,salaire);
		
		this.login = login;
		this.pwd = pwd;
		this.service = service;
	}
	
	
	public double calculerSalaire() {
		
		if (this.role.getCode().equalsIgnoreCase("MN")) {
			
			this.salaire += this.salaire * 0.1; 
			
			return this.salaire;
		}else if (this.role.getCode().equalsIgnoreCase("DG")) {
			this.salaire += this.salaire * 0.4; 
			
			return this.salaire;
		}
		else {
			
			return super.CalculSalaire();
		}
		
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return super.toString()+ " role=" + role.getLibelle() ;
	}


	
	
	
}