package Heritage;

public class MainPersonne {

	public static void main(String[] args) {
		
		Role MN = new Role("MN","MANAGER");
		Role CP = new Role("CP","Chef de projet");
		Role DP = new Role("DP","Directeur de projet");
		Role DRH = new Role("DRH","Directeur des ressources humaines");
		Role DG = new Role("DG","Directeur général");
		
		User cda1 = new User("CAM", "MOUs","test",66565656, 2000, "login","pwd","service");
		User cda2 = new User("AFPA", "ZAK","test",66565656, 2000, "login","pwd","service");
		User cda3 = new User("DUPONT", "JEAN","test",3698545, 1750, "login","pwd","service");
		User cda4 = new User("MACRON", "MANU","test",456789, 99750, "login","pwd","service");
		User cda5 = new User("HOLLANDE", "Francois","test",123456, 2000, "login","pwd","service");
		
		cda1.setRole(MN);
		cda2.setRole(CP);
		cda3.setRole(DP);
		cda4.setRole(DRH);
		cda5.setRole(DG);
	
		cda1.calculerSalaire();
		cda2.calculerSalaire();
		cda5.calculerSalaire();
		
		System.out.println(cda1);
		System.out.println(" --- "+cda2);
		System.out.println("** "+cda5);
	
	}
}
