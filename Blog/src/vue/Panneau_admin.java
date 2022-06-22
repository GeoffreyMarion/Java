package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ArticleDao;
import modele.Article;

public class Panneau_admin{
	static Article article;
	private JPanel content;
	public JPanel admin_p() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		
		JPanel contenuhaut = new JPanel();
		contenuhaut.setBackground(Color.GRAY);
		contenuhaut.setBounds(0, 0, 465, 35);
		content.add(contenuhaut);
		contenuhaut.setLayout(null);
		
		JButton users = new JButton("Utilisateurs");
		users.setFont(new Font("Agency FB", Font.PLAIN, 15));
		users.setBounds(90, 5, 90, 25);
		users.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.layer.removeAll();
				G_users users = new G_users();
				Mainframe.layer.add(users.Users());
			}
		});
		contenuhaut.add(users);
		
		JButton articles = new JButton("Articles");
		articles.setFont(new Font("Agency FB", Font.PLAIN, 15));
		articles.setBounds(190, 5, 90, 25);
		articles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Mainframe.layer.removeAll();
						G_articles art = new G_articles();
						Mainframe.layer.add(art.Articles());
			}
		});
		contenuhaut.add(articles);
		
		JButton commentaires = new JButton("Comms");
		commentaires.setFont(new Font("Agency FB", Font.PLAIN, 15));
		commentaires.setBounds(290, 5, 90, 25);
		commentaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Mainframe.layer.removeAll();
						G_commentaires art = new G_commentaires();
						Mainframe.layer.add(art.Commentaires());
			}
		});
		commentaires.setVisible(false);
		contenuhaut.add(commentaires);

		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.LIGHT_GRAY);
		contenucentre.setBounds(0, 40, 465, 310);
		content.add(contenucentre);
		contenucentre.setLayout(null);
		
		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 355, 465, 110);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		return content;
	}
	public boolean isEmpty(JTextField field) {
		if(field.getText()==null) {
		return true;	
		}
		else {return false;}
	}
	public boolean isEmptyt(JTextArea tarea) {
		if(tarea.getText()==null) {
		return true;	
		}
		else {return false;}
	}
}
