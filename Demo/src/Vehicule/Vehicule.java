package Vehicule;

public class Vehicule{
	protected int Roues;
	protected String Carburant;
	protected int Vitesse_max;
	protected int contenanceReservoir;
	protected int contenuRersevoir;

	protected int Nbr_roues() {
		return 0;
	}
	protected String T_carb() {
		return "Diesel";
	}
	protected int V_max() {
		return 500;
	}
	protected void fairePlein(Pompe pompe) {
		int reste=pompe.getContenu();
		int remplir=0;
		if(this.Carburant==pompe.getTypeCarburant()) {
		remplir=this.contenanceReservoir-this.contenuRersevoir;
		System.out.println("Bon carburant à la pompe");
			if(pompe.getContenu()==0) {
				System.out.println("Pompe vide");
				return;
			}
			else if(pompe.getContenu()>=remplir) {
				this.contenuRersevoir=this.contenanceReservoir;
				reste=pompe.getContenu()-remplir;
				pompe.setContenu(reste);
				System.out.println("Vous avez rempli " + remplir +"L ,vous avez mainteant "+this.contenuRersevoir+"L de carburant et il reste "+ pompe.getContenu()+ "L dans la pompe \n");
				return;
			}
			else {
				this.contenuRersevoir=this.contenuRersevoir+pompe.getContenu();
				System.out.println("Contenu Pompe insuffisant, vous n'avez rempli que "+ pompe.getContenu() +"L ,vous avez maintenant "+this.contenuRersevoir+"L et la pompe est vide\n");
				pompe.setContenu(0);
				return;
			}
		}
		else {
			System.out.println("Mauvais carburant à la pompe \n");
		}
		return;
	}
	
	public Vehicule(int roues, String carburant, int vitesse_max,int contenancereservoir,int contenurersevoir) {
		super();
		Roues = roues;
		Carburant = carburant;
		Vitesse_max = vitesse_max;
		contenanceReservoir = contenancereservoir;
		contenuRersevoir = contenurersevoir;
	}
	
}

