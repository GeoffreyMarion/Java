package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modele.Etudiant;

public class CRUDetudiant implements Idao<Etudiant>{
	private String Email="";
	Connection connection = new Database().getConnection();
	
	@Override
	public boolean create(Etudiant etu) {
		String tprenom=etu.getPrenom();
		String tname=etu.getNom();
		String temail=etu.getEmail();

		try {
			if (findByEmail(temail)==null) {
			PreparedStatement statement = connection.prepareStatement("Insert INTO etudiant(Prenom,Nom,Email) VALUES (?,?,?)");
			statement.setString(1,tprenom);
			statement.setString(2,tname);
			statement.setString(3,temail);
			statement.executeUpdate();
			System.err.println("Données de "+tprenom+" "+tname+" "+temail+" crées\n----------------");
			return true;
			}
			else {System.out.println("Mail entré: "+Email+" déjà utilisé\n----------------");
			}
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<Etudiant> read() {
		ResultSet afficher;
		ArrayList<Etudiant> ListEtudiants= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM etudiant");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Etudiant etudiant=new Etudiant(afficher.getString("Prenom"),afficher.getString("Nom"),afficher.getString("Email"));
				ListEtudiants.add(etudiant);
				System.err.println("Prenom: "+etudiant.getPrenom()+"\nNom: "+etudiant.getNom()+"\nEmail: "+etudiant.getEmail()+"\n----------------");
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListEtudiants;
	}
	
	@Override
	public Etudiant update(Etudiant etu) {
		Scanner scan = new Scanner(System.in);
		
		if(findByEmail(etu.getEmail())!=null) {
		System.out.println("Nouveau Prénom:");
		String tprenom=scan.nextLine();
		System.out.println("Nouveau Nom:");
		String tname=scan.nextLine();
		System.out.println("Nouvel Email:");
		String temail=scan.nextLine();
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE etudiant SET Prenom=?,Nom=?,Email=? WHERE Email LIKE ?");
				statement.setString(1,tprenom);
				statement.setString(2,tname);
				statement.setString(3,temail);
				statement.setString(4,etu.getEmail());
				statement.executeUpdate();
				System.out.println("Update de "+etu.getEmail());
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return etu;
		}
		else {System.out.println("Update non fait mail non présent dans la base");}
		return null;
	}
	@Override
	public boolean delete(Etudiant etu) {
		findByEmail(etu.getEmail());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM etudiant WHERE Email LIKE ?");
			statement.setString(1,etu.getEmail());
			statement.executeUpdate();
			System.out.println("Delete de "+etu.getEmail()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Etudiant findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM etudiant WHERE Id LIKE ?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String Prenom = afficher.getString("Prenom");
				String Nom = afficher.getString("Nom");
				String mail = afficher.getString("Email");
				System.err.println("----------------\nPrenom: "+Prenom+"\nNom: "+Nom+"\nEmail: "+mail+"\n----------------");
				Etudiant etudiant= new Etudiant(Prenom,Nom,mail);
				return etudiant;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(Email+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	@Override
	public ArrayList<Etudiant> findByNom(String nom) {
		ResultSet afficher=null;
		ArrayList<Etudiant> Etudiants= new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM etudiant WHERE Nom LIKE ?");
			statement.setString(1,nom);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Etudiant etudiant=new Etudiant(afficher.getString("Prenom"),afficher.getString("Nom"),afficher.getString("Email"));
				Etudiants.add(etudiant);
				System.err.println("Prenom: "+etudiant.getPrenom()+"\nNom: "+etudiant.getNom()+"\nEmail: "+etudiant.getEmail()+"\n----------------");
			}
			return Etudiants;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(Email+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	@Override
	public Etudiant findByEmail(String email) {
		ResultSet afficher=null;
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM etudiant WHERE Email LIKE ?");
			statement.setString(1,email);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String Prenom = afficher.getString("Prenom");
				String Nom = afficher.getString("Nom");
				String mail = afficher.getString("Email");
				System.err.println("----------------\nPrenom: "+Prenom+"\nNom: "+Nom+"\nEmail: "+mail+"\n----------------");
				Etudiant etudiant= new Etudiant(Prenom,Nom,mail);
				return etudiant;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(Email+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}