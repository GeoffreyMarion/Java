package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import controller.ArticleDao;
import controller.UserDao;
import modele.Article;
import modele.User;

public class Writeart {
	JPanel content;
	public JPanel write() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		
		JPanel contenuhaut = new JPanel();
		contenuhaut.setBackground(Color.GRAY);
		contenuhaut.setBounds(0, 0, 465, 40);
		content.add(contenuhaut);
		contenuhaut.setLayout(null);
		
		JLabel lTitreart = new JLabel("Titre de l'article");
		lTitreart.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lTitreart.setForeground(Color.WHITE);
		lTitreart.setBounds(10, 5, 290, 25);
		contenuhaut.add(lTitreart);
		
		JTextField Ftitre = new JTextField();
		Ftitre.setBounds(15, 10, 200, 25);
		contenuhaut.add(Ftitre);
		Ftitre.setColumns(10);

		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.DARK_GRAY);
		contenucentre.setBounds(0, 45, 465, 180);
		content.add(contenucentre);
		contenucentre.setLayout(null);

		JScrollPane scrollb = new JScrollPane();
		scrollb.setBounds(0, 230, 465, 160);
		contenucentre.add(scrollb);
		
		JTextArea artText = new JTextArea();
		artText.setBounds(0, 230, 465, 160);
		scrollb.add(artText);
		
		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 210, 465, 180);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JButton publier = new JButton("Publier");
		publier.setFont(new Font("Agency FB", Font.PLAIN, 15));
		publier.setBounds(125, 130, 90, 25);
		publier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Article art = new Article(Ftitre.getText(),"fff",artText.getText(),"fff",Mainframe.Fprenom.getText());
				ArticleDao ar = new ArticleDao();
				if (ar.create(art)) {
						JOptionPane.showMessageDialog(publier, "Connection ok");
						Mainframe.layer.removeAll();
						ListArticles lart = new ListArticles();
						Mainframe.layer.add(lart.larticles());
						Mainframe.Titrepage.setText("Bienvenu "+Mainframe.Fprenom.getText()+"");
				}
				else { JOptionPane.showMessageDialog(publier, "Mail ou mot de pass erroné");} 
			}
		});
		contenubas.add(publier);
		return content;
	}
	
}
