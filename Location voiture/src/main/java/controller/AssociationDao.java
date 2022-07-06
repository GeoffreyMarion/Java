package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.Database;
import dao.iDAO;
import modele.Association;
import modele.Conducteur;
import modele.Vehicule;

public class AssociationDao implements iDAO<Association> {
	Connection connection = Database.getConnection();
	
	public boolean create(Association objet) {
		try {
		PreparedStatement statement = connection.prepareStatement("Insert INTO Association(id_c,id_v) VALUES (?,?)");
		statement.setInt(1,objet.getConducteur().getId_c());
		statement.setInt(2,objet.getVehicule().getId_v());
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
	public ArrayList<Association> read() {
		ResultSet afficher;
		ArrayList<Association> ListAssos= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Association");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				int Id_a = afficher.getInt("id_a");
				int id_c = afficher.getInt("id_c");
				int id_v = afficher.getInt("id_v");
				ConducteurDao conDao= new ConducteurDao();
				Conducteur cond= conDao.findById(id_c);
				VehiculeDao vehiDao= new VehiculeDao();
				Vehicule vehi= vehiDao.findById(id_v);
				Association asso= new Association (Id_a,cond,vehi);
				ListAssos.add(asso);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListAssos;
	}
	
	public Association update(Association asso,Conducteur conducteur,Vehicule vehicule,int id) {
		Association ass=null;
		int id_c=conducteur.getId_c();
		int id_v=vehicule.getId_v();
		if(findById(asso.getId_a())!=null) {
			ass=findById(asso.getId_a());
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE Association SET id_c=?,id_v=? WHERE id_a=?");
				statement.setInt(1,id_c);
				statement.setInt(2,id_v);
				statement.setInt(3,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return asso;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}

	@Override
	public boolean delete(Association object) {
		findById(object.getId_a());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Association WHERE id_a=?");
			statement.setInt(1,object.getId_a());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getId_a()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Association findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Association WHERE id_a=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			if (afficher.next()) {
				int Id_a = afficher.getInt("id_a");
				int id_c = afficher.getInt("id_c");
				int id_v = afficher.getInt("id_v");
				ConducteurDao conDao= new ConducteurDao();
				Conducteur cond= conDao.findById(id_c);
				VehiculeDao vehiDao= new VehiculeDao();
				Vehicule vehi= vehiDao.findById(id_v);
				Association asso= new Association (Id_a,cond,vehi);
				return asso;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	public Association findById_c(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Association WHERE id_c=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			if (afficher.next()) {
				int Id_a = afficher.getInt("id_a");
				int id_c = afficher.getInt("id_c");
				int id_v = afficher.getInt("id_v");
				ConducteurDao conDao= new ConducteurDao();
				Conducteur cond= conDao.findById(id_c);
				VehiculeDao vehiDao= new VehiculeDao();
				Vehicule vehi= vehiDao.findById(id_v);
				Association asso= new Association (Id_a,cond,vehi);
				return asso;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	public Association findById_v(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Association WHERE id_v=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			if (afficher.next()) {
				int Id_a = afficher.getInt("id_a");
				int id_c = afficher.getInt("id_c");
				int id_v = afficher.getInt("id_v");
				ConducteurDao conDao= new ConducteurDao();
				Conducteur cond= conDao.findById(id_c);
				VehiculeDao vehiDao= new VehiculeDao();
				Vehicule vehi= vehiDao.findById(id_v);
				Association asso= new Association (Id_a,cond,vehi);
				return asso;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	public Association findById_cv(int id,int id_) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Association WHERE id_c=? AND id_v=?");
			statement.setInt(1,id);
			statement.setInt(2,id_);
			afficher=statement.executeQuery();
			if (afficher.next()) {
				int Id_a = afficher.getInt("id_a");
				int id_c = afficher.getInt("id_c");
				int id_v = afficher.getInt("id_v");
				ConducteurDao conDao= new ConducteurDao();
				Conducteur cond= conDao.findById(id_c);
				VehiculeDao vehiDao= new VehiculeDao();
				Vehicule vehi= vehiDao.findById(id_v);
				Association asso= new Association (Id_a,cond,vehi);
				return asso;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
}