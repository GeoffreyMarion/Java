package FOAD;

import java.util.ArrayList;
import java.util.Scanner;

public class Testlivre {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("how many books do you want ??");
		int nb= sc.nextInt();
		double totprix=0;
		ArrayList<Livre> Livres = new ArrayList<>();
		for(int i=0;i<=nb;i++) {
			System.out.println("Give: Title ");
			String Titre= sc.nextLine();
			System.out.println("Give: Author ");
			String Auteur= sc.nextLine();
			System.out.println("Give: Price ");
			double Prix= sc.nextDouble();
			Livre Livre= new Livre(Titre,Auteur,Prix);
			Livres.add(Titre,Auteur,Prix);
			totprix+=Prix;
		}
		System.out.println(Livres);
		System.out.println(totprix);
	}

}
