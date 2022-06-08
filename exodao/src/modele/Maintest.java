package modele;

import java.util.Scanner;

import controller.CRUDetudiant;

public class Maintest {

	public static void main(String[] args) {
		CRUDetudiant crudC = new CRUDetudiant();
		Scanner scchoix = new Scanner(System.in);
		boolean quitter = false;
		int choix = 0;
		Etudiant etudiant = new Etudiant("Moussaka","Kama","moussaka@kama");
		Etudiant etudiant2 = new Etudiant("moussik","moussak","moussik@moussak");
		Etudiant etudiant3 = new Etudiant("Bob","Robert","Bob@Robert");
		Etudiant etudiant4 = new Etudiant("Moussaka","PtiMouss","moussaka@ptiMouss");
		do {
			System.out.println(
				"\t-----Gestion des utilisateurs-----\n"
				+"\t1-Ajouter une utilisateur\n"
				+ "\t2-Afficher la liste des utilisateurs\n"
				+ "\t3-Modifier un utilisateur\n"
				+ "\t4-Supprimer un utilisateur\n"
				+ "\t5-Rechercher un utilisateur (via mail)\n"
				+ "\t6-Rechercher un utilisateur (via id)\n"
				+ "\t7-Rechercher un utilisateur (via nom)\n"
				+ "\t8-Quitter\n");
			System.err.println("\tEntrez votre numéro de requête ?");
			choix = scchoix.nextInt();
			switch (choix) {
			case 1:
				crudC.create(etudiant);
				break;
			case 2:
				crudC.read();
				break;
			case 3:
				crudC.update(etudiant2);
				break;
			case 4:
				crudC.delete(etudiant3);
				break;
			case 5:
				crudC.findByEmail("moussaka@kama");
				break;
			case 6:
				crudC.findById(1);
				break;
			case 7:
				crudC.findByNom("Kama");
				break;
			case 8:
				quitter = true;
				System.err.println("Exit\nBonne journée!!!");
				break;
			}
		} while (quitter == false);
	}

}
