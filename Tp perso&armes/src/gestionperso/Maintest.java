package gestionperso;

public class Maintest {

	public static void main(String[] args) {
		
		Arme arme1= new Arme();
		Arme arme2= new Arme();
		Arme arme3= new Arme();
		Arme arme4= new Arme();
		Joueur j1= new Joueur("Zelda",arme1);
		Joueur j2= new Joueur("Ganondorf",arme2);
		
		System.out.println(j1+"\n"+j2+"\n----------");
		
		while(j1.isMort()==false && j2.isMort()==false) {
		j1.attaquer(j2);
		System.out.println(j1+"\n"+j2+"\n----------");
		if(j1.isMort()==false && j2.isMort()==false) {
		j2.attaquer(j1);
		System.out.println(j2+"\n"+j1+"\n----------");}
		}
	}

}
