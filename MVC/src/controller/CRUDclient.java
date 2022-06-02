package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import modele.Client;

public class CRUDclient {
	private String Email="";
	Connection connection = new Database().getConnection();
	
	public Client create() {
		Scanner scpre = new Scanner(System.in);
		Scanner scnom = new Scanner(System.in);
		Scanner scmail = new Scanner(System.in);
		System.out.println("Saisir Prénom:");
		String tprenom=scpre.nextLine();
		System.out.println("Saisir Nom:");
		String tname=scnom.nextLine();
		System.out.println("Email:");
		String temail=scmail.nextLine();
		
		Client client = new Client();
		client.setPrenom(tprenom);
		client.setNom(tname);
		client.setEmail(temail);

		try {
			readmailarg(temail);
			if (Email == "") {
			Statement statement = connection.createStatement();
			statement.executeUpdate("Insert INTO Client(Prenom,Nom,Email) VALUES ('"+tprenom+"','"+tname+"','"+temail+"')");
			System.err.println("Données de "+tprenom+" "+tname+" crées\n----------------");}
			else {System.out.println("Mail entré: "+Email+" déjà utilisé\n----------------");}
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return client;
	}

	public String readmail() {
		ResultSet afficher;
		Scanner scmail = new Scanner(System.in);
		System.out.println("Email du client:");
		String temail=scmail.nextLine();
		String mail="";
		
		try {
			Statement statement = connection.createStatement();
			afficher=statement.executeQuery("SELECT* FROM Client WHERE Email LIKE '"+temail+"'");
			while (afficher.next()) {
				String Prenom = afficher.getString("Prenom");
				String Nom = afficher.getString("Nom");
				mail = afficher.getString("Email");
				System.err.println("----------------\nPrenom: "+Prenom+"\nNom: "+Nom+"\nEmail: "+mail+"\n----------------");
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		Email=mail;
		if(Email==""){System.err.println(temail+"ne se trouve pas dans la base de données\n----------------");}
		return Email;
	}
	
	public String readmailarg(String email) {
		ResultSet afficher;
		String mail="";
		try {
			Statement statement = connection.createStatement();
			afficher=statement.executeQuery("SELECT* FROM Client WHERE Email LIKE '"+email+"'");
			while (afficher.next()) {
				String Prenom = afficher.getString("Prenom");
				String Nom = afficher.getString("Nom");
				mail = afficher.getString("Email");
				System.err.println("----------------\nPrenom: "+Prenom+"\nNom: "+Nom+"\nEmail: "+mail+"\n----------------");
			}
		} catch (SQLException e) {
			System.out.println("Données arg non lues");
			e.printStackTrace();
		}
		return Email=mail;
	}
	
	public void readlist() {
		ResultSet afficher;
	
		try {
			Statement statement = connection.createStatement();
			afficher=statement.executeQuery("SELECT* FROM Client");
			while (afficher.next()) {
				String Prenom = afficher.getString("Prenom");
				String Nom = afficher.getString("Nom");
				String mail = afficher.getString("Email");
				System.err.println("Prenom: "+Prenom+"\nNom: "+Nom+"\nEmail: "+mail+"\n----------------");
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
	}
	
	public void update() {
		Scanner scpre = new Scanner(System.in);
		Scanner scnom = new Scanner(System.in);
		Scanner scmail = new Scanner(System.in);
		
		readmail();
		
		System.out.println("Nouveau Prénom:");
		String tprenom=scpre.nextLine();
		System.out.println("Nouveau Nom:");
		String tname=scnom.nextLine();
		System.out.println("Nouvel Email:");
		String temail=scmail.nextLine();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE Client SET Prenom='"+tprenom+"',Nom='"+tname+"',Email='"+temail+ "'WHERE Email LIKE '"+Email+"'");
		} catch (SQLException e) {
			System.out.println("Update non fait");
			e.printStackTrace();
		}
		readmailarg(temail);
	}
	
	public void delete() {
		readmail();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM Client WHERE Email='"+Email+"'");
			System.out.println("Delete de "+Email+" fait\n----------------");
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
	}
}