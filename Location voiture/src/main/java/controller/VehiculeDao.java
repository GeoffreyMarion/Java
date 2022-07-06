package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.Database;
import dao.iDAO;
import modele.Vehicule;

public class VehiculeDao implements iDAO<Vehicule> {
	Connection connection = Database.getConnection();
	
	public boolean create(Vehicule objet) {
		try {
		PreparedStatement statement = connection.prepareStatement("Insert INTO Vehicule (marque,modele,couleur,immatriculation) VALUES (?,?,?,?)");
		statement.setString(1,objet.getMarque());
		statement.setString(2,objet.getModele());
		statement.setString(3,objet.getCouleur());
		statement.setString(4,objet.getImmatriculation());
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
	public ArrayList<Vehicule> read() {
		ResultSet afficher;
		ArrayList<Vehicule> ListVehis= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Vehicule");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Vehicule vehi = new Vehicule(afficher.getInt("id_v"), afficher.getString("marque"),
						afficher.getString("modele"), afficher.getString("couleur"),
						afficher.getString("immatriculation"));
				ListVehis.add(vehi);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListVehis;
	}
	
	public Vehicule update(Vehicule vehi,String marque,String modele,String couleur,String immatriculation,int id) {
		Vehicule veh=null;
		if(findById(vehi.getId_v())!=null) {
			vehi=findById(vehi.getId_v());
			try {	
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE Vehicule SET marque=?,modele=?,couleur=?,immatriculation=? WHERE id_v=?");
				statement.setString(1, marque);
				statement.setString(2, modele);
				statement.setString(3, couleur);
				statement.setString(4, immatriculation);
				statement.setInt(5, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return veh;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}

	@Override
	public boolean delete(Vehicule object) {
		findById(object.getId_v());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Association WHERE id_v=?");
			statement.setInt(1,object.getId_v());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getId_v()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Vehicule WHERE id_v=?");
			statement.setInt(1,object.getId_v());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getId_v()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Vehicule findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Vehicule WHERE id_v=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				int Id_v = afficher.getInt("id_v");
				String marque = afficher.getString("marque");
				String modele = afficher.getString("modele");
				String couleur = afficher.getString("couleur");
				String immatriculation = afficher.getString("immatriculation");
				Vehicule vehi= new Vehicule (Id_v,marque,modele,couleur,immatriculation);
				return vehi;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	public ArrayList<Vehicule> findByModele(String modele) {
		ResultSet afficher=null;
		ArrayList<Vehicule> Vehis= new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Vehicule WHERE modele LIKE ?");
			statement.setString(1,modele);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Vehicule vehi = new Vehicule(afficher.getInt("id_v"), afficher.getString("marque"),
						afficher.getString("modele"), afficher.getString("couleur"),
						afficher.getString("immatriculation"));
				Vehis.add(vehi);
			}
			return Vehis;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(modele+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}