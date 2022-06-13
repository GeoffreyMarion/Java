package gestionperso;

import java.util.Random;
import java.util.Scanner;

public class Joueur {
	Random rf = new Random();
	private int max=10;
	private int min=5;
	
	private boolean mort=false;
	private String nomj;
	private int hp = 10;
	private int xp = 1;
	private int force= rf.nextInt(max-min+1) + min-4;
	private int def= rf.nextInt(max-min+1) + min-4;
	private Arme arme;
	int T_att=0;
	Scanner sc = new Scanner(System.in);
	
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
			return "Joueur \nNom_joueur= " + nomj + " | Santé= " + hp + " | Expérience= " + xp +" | Force= " + force+" | Defense= " + def + " | Arme= désarmé";
		}
		return "Joueur \nNom_joueur= " + nomj + " | Santé= " + hp + " | Expérience= " + xp +" | Force= " + force+" | Defense= " + def + "\n" + arme;
	}
	
	public Arme switchw(Scanner scan) {
			System.out.println("1-épée\n2-couteau\n3-masse\n4-pistolet\n5-désarmé");
			int c= scan.nextInt();
			switch(c) {
				case 1:
					this.arme.setTypea(TypeArme.épée);
					this.arme.stat_arme();
					System.out.println(this.arme);
					break;
				case 2:
					this.arme.setTypea(TypeArme.couteau);
					this.arme.stat_arme();
					System.out.println(this.arme);
					break;
				case 3:
					this.arme.setTypea(TypeArme.masse);
					this.arme.stat_arme();
					System.out.println(this.arme);
					break;
				case 4:
					this.arme.setTypea(TypeArme.pistolet);
					this.arme.stat_arme();
					System.out.println(this.arme);
					break;
				case 5:
					this.arme.setTypea(TypeArme.désarmé);
					this.arme.stat_arme();
					System.out.println(this.arme);
					break;
				}
		return this.arme;
		}
	
	public int Ch_att(Scanner scan) {
		System.out.println("1-Violence\n2-Précision\n3-Dexterité");
		int att= scan.nextInt();
		if (att==1) {T_att=this.arme.getVio();}
		else if (att==2) {T_att=this.arme.getPre();}
		else if (att==3) {T_att=this.arme.getDex();}
		return T_att;
	}
	
	public void attaquer(Joueur ennemi) {
		Random r_att = new Random();
		int maxatt=10;
		int minatt=1;
		int enn_ra= r_att.nextInt(maxatt-minatt) + minatt;
		int pj_ra= r_att.nextInt(maxatt-minatt) + minatt;
		int wound=1;
		System.err.println(this.nomj+"\n1-Changer d'arme\n2-Attaquer");
		int c= sc.nextInt();
		if(c==1) {
			switchw(sc);}
		
		else if(c==2) {
			Ch_att(sc);
			int att_pj=T_att+this.xp+pj_ra+(this.force*this.hp/10);
			int att_enn=ennemi.arme.getVio()+ennemi.xp+enn_ra+(ennemi.def*ennemi.hp/10);
			if(T_att==this.arme.getVio()) {att_enn=ennemi.arme.getVio()+ennemi.xp+enn_ra+(ennemi.def*ennemi.hp/10);}
			else if(T_att==this.arme.getPre()) {att_enn=ennemi.arme.getPre()+ennemi.xp+enn_ra+(ennemi.def*ennemi.hp/10);}
			else if(T_att==this.arme.getDex()) {att_enn=ennemi.arme.getDex()+ennemi.xp+enn_ra+(ennemi.def*ennemi.hp/10);}
			Joueur win=this;
			Joueur los=ennemi;
			if(att_pj>att_enn) {win=this; los=ennemi;}
			else if (att_pj<att_enn){los=this; win=ennemi;}
		
			if(this.mort==false && ennemi.mort==false) {
				if (att_pj-att_enn>7) {System.err.println(this.nomj+" (Att:"+att_pj+") fait une blessure grave avec son "+this.arme.getTypea()+" a "+ennemi.nomj+" (Att:"+att_enn+")"); wound=3;}
				else if (att_pj-att_enn>3) {System.err.println(this.nomj+" (Att:"+att_pj+") fait une une blessure avec son "+this.arme.getTypea()+" a "+ennemi.nomj+" (Att:"+att_enn+")");wound=2;}
				else if (att_enn-att_pj>7) {System.err.println(ennemi.nomj+" (Att:"+att_enn+") fait une blessure grave avec son "+this.arme.getTypea()+" a "+this.nomj+" (Att:"+att_pj+")");wound=3;}
				else if (att_enn-att_pj>3) {System.err.println(ennemi.nomj+" (Att:"+att_enn+") fait une blessure avec son "+this.arme.getTypea()+" a "+this.nomj+" (Att:"+att_pj+")");wound=2;}
				else {System.err.println(ennemi.nomj+" (Att:"+att_enn+") fait une égratignure a "+this.nomj+" (Att:"+att_pj+")");wound=1;}
			
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
					if(win==this) {
						if(this.force<this.max) {this.force+=1; System.err.println(this.nomj+" a gagné 1 de force");}}
					if(win==ennemi) {
						if(ennemi.def<ennemi.max) {ennemi.def+=1; System.err.println(ennemi.nomj+" a gagné 1 de defense");}}
					System.err.println("----------");
					}
			}
			else {System.err.println("Attaque impossible l'un des deux joueur est mort");}
		}
	}
}
