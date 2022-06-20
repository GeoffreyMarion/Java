package controller;

import java.sql.Connection;
import java.sql.Date;
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
			PreparedStatement statement = connection.prepareStatement("Insert INTO Article(titre,resume,contenu,date,auteur,auteur_id) VALUES (?,?,?,now(),?,?)");
			statement.setString(1,objet.getTitre());
			statement.setString(2,objet.getResume());
			statement.setString(3,objet.getContenu());
			statement.setString(4,objet.getAuteur());
			statement.setInt(5,objet.getAuteur_id());
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
		ArrayList<Article> ListArticle= new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article");
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Article art=new Article(afficher.getInt("id"),afficher.getString("titre"),afficher.getString("resume"),afficher.getString("contenu"),
						afficher.getDate("date"),afficher.getString("auteur"),afficher.getInt("auteur_id"));
				ListArticle.add(art);
			}
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		return ListArticle;
	}
	
	public Article update(Article article,String titre,String resume,String contenu,int id) {
		Article art=null;
		if(findById(article.getId())!=null) {
			art=findById(article.getId());
			try {	
				PreparedStatement statement = connection.prepareStatement("UPDATE Article SET titre=?,resume=?,contenu=?,date=now() WHERE id=?");
				statement.setString(1,titre);
				statement.setString(2,resume);
				statement.setString(3,contenu);
				statement.setInt(4,id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update non fait");
				e.printStackTrace();
			}
			return art;
		}
		else {System.out.println("Update non fait mail non présent dans la base");}
		return null;
	}

	@Override
	public boolean delete(Article object) {
		findById(object.getId());
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Article WHERE id=?");
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
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE id=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				int ide = afficher.getInt("id");
				String titre = afficher.getString("titre");
				String resume = afficher.getString("resume");
				String contenu = afficher.getString("contenu");
				Date date = afficher.getDate("date");
				String auteur = afficher.getString("auteur");
				int auteur_id = afficher.getInt("auteur_id");
				Article art= new Article (ide,titre,resume,contenu,date,auteur,auteur_id);
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
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE auteur LIKE ?");
			statement.setString(1,nom);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Article art=new Article(afficher.getInt("id"),afficher.getString("titre"),afficher.getString("resume"),afficher.getString("contenu"),
						afficher.getDate("date"),afficher.getString("auteur"),afficher.getInt("auteur_id"));
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
	
	public ArrayList<Article> findByAuteur_id(int id) {
		ResultSet afficher=null;
		ArrayList<Article> Articles= new ArrayList<>();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE auteur_id=?");
			statement.setInt(1,id);
			afficher=statement.executeQuery();
			while (afficher.next()) {
				Article art=new Article(afficher.getInt("id"),afficher.getString("titre"),afficher.getString("resume"),afficher.getString("contenu"),
						afficher.getDate("date"),afficher.getString("auteur"),afficher.getInt("auteur_id"));
				Articles.add(art);
			}
			return Articles;
		} catch (SQLException e) {
			System.out.println("Données non lues");
			e.printStackTrace();
		}
		if(afficher==null){System.err.println(id+" ne se trouve pas dans la base de données\n----------------");
		}
		return null;
	}
	public Date findDatebyTitre(String titre) {
		ResultSet afficher=null;	
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE titre LIKE ?");
			statement.setString(1,titre);
			afficher=statement.executeQuery();
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
	public int findIdbyTitre(String titre) {
		ResultSet afficher=null;	
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT* FROM Article WHERE titre LIKE ?");
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