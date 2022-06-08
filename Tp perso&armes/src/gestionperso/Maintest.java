package gestionperso;

public class Maintest {

	public static void main(String[] args) {
		
		Arme arme1= new Arme("Excalibur");
		Arme arme2= new Arme("Soulblade");
		Arme arme3= new Arme("Moonblade");
		Arme arme4= new Arme("Shadowblade");
		Joueur j1= new Joueur("Zelda",arme1);
		Joueur j2= new Joueur("Ganondorf",arme2);
		Joueur j3= new Joueur("Moussaka",arme3);
		
		System.out.println(j3+"\n----------");
		j3.setArme(arme1);
		System.out.println(j3+"\n----------");
		System.out.println(j1+"\n"+j2+"\n----------");
		
		while(j1.isMort()==false && j2.isMort()==false) {
		j1.attaquer(j2);
		System.out.println(j1+"\n"+j2+"\n----------");
		}
	}

}
