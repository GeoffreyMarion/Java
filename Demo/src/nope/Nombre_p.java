package nope;

public class Nombre_p {
	public static void main(String[] args) {
	int nombre = 5;
	for (int i=2; i< nombre;i++) {
		if(nombre % i == 0) {
			System.out.println("Pas premier");
			break;
		}
		else {
			System.out.println("Premier");
			break;
		}
	}

	}

}
