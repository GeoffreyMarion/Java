package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.Database;
import dao.iDAO;
import modele.Conducteur;

public class ConducteurDao implements iDAO<Conducteur> {
	Connection connection = Database.getConnection();
	
	public boolean create(Conducteur objet) {
		try {
		PreparedStatement statement = connection.prepareStatement("Insert INTO Conducteur(nom,prenom) VALUES (?,?)");
		statement.setString(1,objet.getNom());
		statement.setString(2,objet.getPrenom());
		statement.executeUpdate();
		return true;
		}
		catch (SQLException e){
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Conducteur> read() {
		ResultSet afficher;
		ArrayList<Conducteur> ListCondus= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Conducteur");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Conducteur condu=new Conducteur(afficher.getInt("id_c"),afficher.getString("nom"),afficher.getString("prenom"));
				ListCondus.add(condu);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCondus;
	}
	
	public Conducteur update(Conducteur condu,String nom,String prenom,int id) {
		Conducteur con=null;
		if(findById(condu.getId_c())!=null) {
			con=findById(condu.getId_c());
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE Conducteur SET nom=?,prenom=? WHERE id_c=?");
				statement.setString(1,nom);
				statement.setString(2,prenom);
				statement.setInt(3,id);
				System.out.println(statement);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return con;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}

	@Override
	public boolean delete(Conducteur object) {
		findById(object.getId_c());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Association WHERE id_c=?");
			statement.setInt(1,object.getId_c());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getId_c()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Conducteur WHERE id_c=?");
			statement.setInt(1,object.getId_c());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getId_c()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Conducteur findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Conducteur WHERE id_c=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				int Id_c = afficher.getInt("id_c");
				String Nom = afficher.getString("nom");
				String Prenom = afficher.getString("prenom");
				Conducteur cond= new Conducteur (Id_c,Nom,Prenom);
				return cond;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	public ArrayList<Conducteur> findByNom(String nom) {
		ResultSet afficher=null;
		ArrayList<Conducteur> Conds= new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Conducteur WHERE nom LIKE ?");
			statement.setString(1,nom);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Conducteur cond=new Conducteur(afficher.getInt("id_c"),afficher.getString("nom"),afficher.getString("prenom"));
				Conds.add(cond);
			}
			return Conds;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(nom+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}