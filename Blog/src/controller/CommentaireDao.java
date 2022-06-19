package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.Database;
import DAO.iDAO;

import modele.Commentaire;

public class CommentaireDao implements iDAO<Commentaire> {
	Connection connection = Database.getConnection();

	@Override
	public boolean create(Commentaire objet) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("Insert INTO Commentaire(article,auteur,date,contenu) VALUES (?,?,?,?)");
			statement.setInt(1, objet.getArticle());
			statement.setString(2, objet.getAuteur());
			statement.setString(3, objet.getDate());
			statement.setString(4, objet.getContenu());
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
				Commentaire comm = new Commentaire(afficher.getInt("id"),afficher.getInt("article"),afficher.getString("auteur"), afficher.getString("date"), afficher.getString("contenu"));
				ListCommentaire.add(comm);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListCommentaire;
	}

	@Override
	public Commentaire update(Commentaire object) {
		// TODO Auto-generated method stub
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
				String date = afficher.getString("date");
				String contenu = afficher.getString("contenu");
				Commentaire comm = new Commentaire(ide,article, auteur, date, contenu);
				return comm;
			}
		} catch (SQLException e) {
			System.out.println("Donn�es non lues");
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
						afficher.getString("auteur"), afficher.getString("date"), afficher.getString("contenu"));
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
}
