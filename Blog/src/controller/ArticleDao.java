package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Database;
import DAO.iDAO;
import modele.Article;

public class ArticleDao implements iDAO<Article>{

	Connection connection = Database.getConnection();
	
	@Override
	public boolean create(Article objet) {
		try {
			PreparedStatement statement = connection.prepareStatement("Insert INTO Articles(titre,resume,contenu,date,auteur) VALUES (?,?,?,?,?)");
			statement.setString(1,objet.getTitre());
			statement.setString(2,objet.getResume());
			statement.setString(3,objet.getContenu());
			statement.setString(4,objet.getDate());
			statement.setString(5,objet.getAuteur());
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
	public ArrayList<Article> read() {
		ResultSet afficher;
		ArrayList<Article> ListArticles= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Articles");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Article art=new Article(afficher.getInt("id"),afficher.getString("titre"),afficher.getString("resume"),afficher.getString("contenu"),afficher.getString("date"),afficher.getString("auteur"));
				ListArticles.add(art);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListArticles;
	}

	@Override
	public Article update(Article object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Article object) {
		// TODO Auto-generated method stub
		findById(object.getId());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Articles WHERE id=?");
			statement.setInt(1,object.getId());
			statement.executeUpdate();
			System.out.println("Delete de "+object.getId()+" fait\n----------------");
			return true;
		} catch (SQLException e) {
			System.out.println("Delete non fait");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Article findById(int id) {
		ResultSet afficher=null;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Articles WHERE id=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				int ide = afficher.getInt("id");
				String titre = afficher.getString("titre");
				String resume = afficher.getString("resume");
				String contenu = afficher.getString("contenu");
				String date = afficher.getString("date");
				String auteur = afficher.getString("auteur");
				Article art= new Article (ide,titre,resume,contenu,date,auteur);
				return art;
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	@Override
	public ArrayList<Article> findByNom(String nom) {
		ResultSet afficher=null;
		ArrayList<Article> Articles= new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Articles WHERE auteur LIKE ?");
			statement.setString(1,nom);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Article art=new Article(afficher.getString("nom"),afficher.getString("prenom"),afficher.getString("pwd"),afficher.getString("email"),afficher.getString("tel"));
				Articles.add(art);
			}
			return Articles;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(nom+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}

	

}