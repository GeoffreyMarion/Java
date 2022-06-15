package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Database;
import DAO.iDAO;
import modele.User;

public class UserDao implements iDAO<User> {
	Connection connection = Database.getConnection();
	
	public boolean create(User objet) {
		try {
		PreparedStatement statement = connection.prepareStatement("Insert INTO User(nom,prenom,pwd,email,tel) VALUES (?,?,Password(?),?,?)");
		statement.setString(1,objet.getNom());
		statement.setString(2,objet.getPrenom());
		statement.setString(3,objet.getPwd());
		statement.setString(4,objet.getEmail());
		statement.setString(5,objet.getTel());
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
	public ArrayList<User> read() {
		ResultSet afficher;
		ArrayList<User> ListUsers= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM User");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				User user=new User(afficher.getString("nom"),afficher.getString("prenom"),afficher.getString("pwd"),afficher.getString("email"),afficher.getString("tel"));
				ListUsers.add(user);
				System.err.println("Prenom: "+user.getPrenom()+"\nNom: "+user.getNom()+"\nEmail: "+user.getEmail()+"\n----------------");
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListUsers;
	}

	/*@Override
	public User update(String femail,String nom,String prenom,String pass,String email,String tel) {
		User user=null;
		if(findByEmail(femail)!=null) {
			user=findByEmail(femail);
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE User SET nom=?,prenom=?,pwd=?,email=?,tel=? WHERE femail=?");
				statement.setString(1,nom);
				statement.setString(2,prenom);
				statement.setString(3,pass);
				statement.setString(4,email);
				statement.setString(5,tel);
				statement.setString(6,femail);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return user;
		}
		else {System.out.println("Update non fait mail non présent dans la base");}
		return null;
	}*/

	@Override
	public boolean delete(User object) {
		findByEmail(object.getEmail());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM User WHERE email LIKE ?");
			statement.setString(1,object.getEmail());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getEmail()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM User WHERE id=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String Nom = afficher.getString("nom");
				String Prenom = afficher.getString("prenom");
				String Pass = afficher.getString("pwd");
				String Email = afficher.getString("email");
				String Tel = afficher.getString("tel");
				User user= new User (Nom,Prenom,Pass,Email,Tel);
				return user;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	public User findByEmail(String email) {
		ResultSet afficher=null;
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE email LIKE ?");
			statement.setString(1,email);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				String nom = afficher.getString("nom");
				String prenom = afficher.getString("prenom");
				String pwd = afficher.getString("pwd");
				String mail = afficher.getString("Email");
				String tel = afficher.getString("tel");
				User user= new User(nom,prenom,pwd,mail,tel);
				return user;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(email+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	@Override
	public ArrayList<User> findByNom(String nom) {
		ResultSet afficher=null;
		ArrayList<User> Users= new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM User WHERE nom LIKE ?");
			statement.setString(1,nom);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				User user=new User(afficher.getString("nom"),afficher.getString("prenom"),afficher.getString("pwd"),afficher.getString("email"),afficher.getString("tel"));
				Users.add(user);
			}
			return Users;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(nom+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	public boolean testlog(String email,String pass) {
	ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE email LIKE ? AND pwd LIKE PASSWORD(?)");
			statement.setString(1,email);
			statement.setString(2,pass);
			afficher=statement.executeQuery();
			if(afficher.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User update(User object) {
		// TODO Auto-generated method stub
		return null;
	}
}
