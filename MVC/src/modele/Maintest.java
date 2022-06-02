package modele;

import java.util.Scanner;

import controller.CRUDclient;

public class Maintest {

	public static void main(String[] args) {
		CRUDclient crudC = new CRUDclient();
		Scanner scchoix = new Scanner(System.in);
		boolean quitter = false;
		int choix = 0;
		do {
			System.out.println(
				"\t-----Gestion des utilisateurs-----\n"
				+"\t1-Ajouter une utilisateur\n"
				+ "\t2-Afficher la liste des utilisateurs\n"
				+ "\t3-Modifier un utilisateur\n"
				+ "\t4-Supprimer un utilisateur\n"
				+ "\t5-Rechercher un utilisateur (via mail)\n"
				+ "\t6-Quitter\n");
			System.err.println("\tEntrez votre numéro de requête ?");
			choix = scchoix.nextInt();
			switch (choix) {
			case 1:
				crudC.create();
				break;
			case 2:
				crudC.readlist();
				break;
			case 3:
				crudC.update();
				break;
			case 4:
				crudC.delete();
				break;
			case 5:
				crudC.readmail();
				break;
			case 6:
				quitter = true;
				System.err.println("Exit\nBonne journée!!!");
				break;
			}
		} while (quitter == false);
	}

}
