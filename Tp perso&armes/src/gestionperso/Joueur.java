package gestionperso;

import java.util.Random;

public class Joueur {
	Random rf = new Random();
	private int maxf=10;
	private int minf=5;
	
	private boolean mort=false;
	private String nomj;
	private int hp = 10;
	private int xp = 1;
	private int force= rf.nextInt(maxf-minf+1) + minf;
	private Arme arme;
	
	public Joueur(String nomj, Arme arme) {
		this.nomj = nomj;
		this.arme = arme;
	}
	
	
	public boolean isMort() {
		return mort;
	}


	public void setArme(Arme arme) {
		this.arme = arme;
	}


	@Override
	public String toString() {
		if (arme == null) {
			return "Joueur \nNom_joueur= " + nomj + ", Santé= " + hp + ", Expérience= " + xp +", Force= " + force + ", Arme= désarmé";
		}
		return "Joueur \nNom_joueur= " + nomj + ", Santé= " + hp + ", Expérience= " + xp +", Force= " + force + ", Arme= " + arme;
	}
	
	// non fonctionnel
	public void switchw() {
		Arme swarme=this.arme.testarme();
		this.arme= swarme;
		System.out.println(this.arme);
		}
	
	public void attaquer(Joueur ennemi) {
		Random ratt = new Random();
		int maxatt=10;
		int minatt=1;
		int enn_ra= ratt.nextInt(maxatt-minatt) + minatt;
		int pj_ra= ratt.nextInt(maxatt-minatt) + minatt;
		int wound=1;
		int att_pj=this.arme.getPow()*this.hp*this.xp*this.force*pj_ra;
		int att_enn=ennemi.arme.getPow()*ennemi.hp*ennemi.xp*ennemi.force*enn_ra;
		Joueur win=this;
		Joueur los=ennemi;
		if(att_pj>att_enn) {win=this; los=ennemi;}
		else if (att_pj<att_enn){los=this; win=ennemi;}
		
		if(this.mort==false && ennemi.mort==false) {
			if (pj_ra-enn_ra>5) {System.err.println(this.nomj+" fait une attaque dévastatrice a "+ennemi.nomj); wound=3;}
			else if (pj_ra-enn_ra>1) {System.err.println(this.nomj+" fait une attaque faible a "+ennemi.nomj);wound=2;}
			else if (enn_ra-pj_ra>5) {System.err.println(ennemi.nomj+" fait une attaque dévastatrice a "+this.nomj);wound=3;}
			else if (enn_ra-pj_ra>1) {System.err.println(ennemi.nomj+" fait une attaque faible a "+this.nomj);wound=2;}
			else {System.err.println(ennemi.nomj+" et "+this.nomj+" s'attaquent sans relache");wound=1;}
			
			ennemi.xp+=1; 
			this.xp+=1;
			System.err.println(this.nomj+" et "+ennemi.nomj+ " ont gagné 1 xp");
		
			if(att_pj==att_enn){
				if(ennemi.hp-wound>0) {ennemi.hp-=wound; System.err.println(ennemi.nomj+" a perdu "+wound+" HP"); }
				else {ennemi.hp=0;ennemi.mort=true;System.err.println(ennemi.nomj+" est mort");}
				if(this.hp-wound>0) {this.hp-=wound; System.err.println(this.nomj+" a perdu "+wound+" HP");}
				else {this.hp=0;this.mort=true; System.err.println(this.nomj+" est mort");}
				System.err.println("Match nul \n----------");
			}
			else {
				System.err.println(win.nomj+" a battu "+los.nomj);
				if(los.hp-wound>0) {los.hp-=wound; System.err.println(los.nomj+" a perdu "+wound+" HP");}
				else {los.hp=0;los.mort=true; System.err.println(los.nomj+" est mort "+win.nomj+" a gagné");}
				if(win.force<win.maxf) {win.force+=1; System.err.println(win.nomj+" a gagné 1 de force");}
				System.err.println("----------");
			}
		}
		else {System.err.println("Attaque impossible l'un des deux joueur est mort");}
	}
}
