package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DAO.Database;
import DAO.iDAO;
import modele.Article;
import modele.Commentaire;

public class CommentaireDao implements iDAO<Commentaire> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Commentaire objet) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("Insert INTO Commentaire(article,auteur,date,contenu) VALUES (?,?,now(),?)");
			statement.setInt(1, objet.getArticle());
			statement.setString(2, objet.getAuteur());
			statement.setString(3, objet.getContenu());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Données non crées");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Commentaire> read() {
		ResultSet afficher;
		ArrayList<Commentaire> ListCommentaire = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Commentaire");
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Commentaire comm = new Commentaire(afficher.getInt("id"),afficher.getInt("article"),afficher.getString("auteur"), afficher.getDate("date"), afficher.getString("contenu"));
				ListCommentaire.add(comm);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCommentaire;
	}
	
	public Commentaire update(Commentaire commentaire,String contenu,int id) {
		Commentaire comm=null;
		if(findById(commentaire.getId())!=null) {
			comm=findById(commentaire.getId());
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE Commentaire SET contenu=?,date=now() WHERE id=?");
				statement.setString(1,contenu);
				statement.setInt(2,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return comm;
		}
		else {System.out.println("Update non fait id non présent dans la base");}
		return null;
	}
	
	public Commentaire updateAuteur(Commentaire comm,String auteur) {
		Commentaire com=null;
		if(findById(comm.getId())!=null) {
			com=findById(comm.getId());
			int id=com.getId();
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE Commentaire SET auteur=?WHERE id=?");
				statement.setString(1,auteur);
				statement.setInt(2,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return com;
		}
		else {System.out.println("Update non fait mail non présent dans la base");}
		return null;
	}
	
	@Override
	public boolean delete(Commentaire object) {
		findById(object.getId());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Commentaire WHERE id=?");
			statement.setInt(1, object.getId());
			statement.executeUpdate();
			System.out.println("Delete de " + object.getId() + " fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Commentaire findById(int id) {
		ResultSet afficher = null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Commentaire WHERE id=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				int ide = afficher.getInt("id");
				int article = afficher.getInt("article");
				String auteur = afficher.getString("auteur");
				Date date = afficher.getDate("date");
				String contenu = afficher.getString("contenu");
				Commentaire comm = new Commentaire(ide,article, auteur, date, contenu);
				return comm;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(id + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	@Override
	public ArrayList<Commentaire> findByNom(String nom) {
		ResultSet afficher = null;
		ArrayList<Commentaire> Commentaires = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Commentaire WHERE auteur LIKE ?");
			statement.setString(1, nom);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Commentaire comm = new Commentaire(afficher.getInt("id"), afficher.getInt("article"),
						afficher.getString("auteur"), afficher.getDate("date"), afficher.getString("contenu"));
				Commentaires.add(comm);
			}
			return Commentaires;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if (afficher == null) {
			System.err.println(nom + " ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	
	public ArrayList<Commentaire> ComsByArt_Id(int id) {
		ResultSet afficher;
		ArrayList<Commentaire> ListCommentaire = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Commentaire WHERE article=?");
			statement.setInt(1, id);
			afficher = statement.executeQuery();
			while (afficher.next()) {
				Commentaire comm = new Commentaire(afficher.getInt("id"),afficher.getInt("article"),afficher.getString("auteur"), afficher.getDate("date"), afficher.getString("contenu"));
				ListCommentaire.add(comm);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCommentaire;
	}
	public Date findDatebyContenu(String titre) {
		ResultSet afficher=null;	
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE contenu LIKE ?");
			statement.setString(1,titre);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Date date = afficher.getDate("date");
				return date;
				}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return null;
	}
	
	public int findIdbyContenu(String titre) {
		ResultSet afficher=null;	
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE contenu LIKE ?");
			statement.setString(1,titre);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				int id = afficher.getInt("id");
				return id;
				}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return 0;
	}
}
