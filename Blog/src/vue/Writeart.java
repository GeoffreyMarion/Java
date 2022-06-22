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

public class Writeart {
	static Article article;
	private JPanel content;
	public JPanel write() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		
		JPanel contenuhaut = new JPanel();
		contenuhaut.setBackground(Color.GRAY);
		contenuhaut.setBounds(0, 0, 465, 70);
		content.add(contenuhaut);
		contenuhaut.setLayout(null);
		
		JLabel lTitreart = new JLabel("Titre de l'article");
		lTitreart.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lTitreart.setForeground(Color.WHITE);
		lTitreart.setBounds(10, 5, 150, 25);
		contenuhaut.add(lTitreart);
		
		JTextField Ftitre = new JTextField();
		Ftitre.setBounds(160, 5, 300, 25);
		contenuhaut.add(Ftitre);
		Ftitre.setColumns(10);
		
		JLabel lResume = new JLabel("Résumé de l'article");
		lResume.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lResume.setForeground(Color.WHITE);
		lResume.setBounds(10, 40, 150, 25);
		contenuhaut.add(lResume);
		
		JTextField Fresume = new JTextField();
		Fresume.setBounds(160, 40, 300, 25);
		contenuhaut.add(Fresume);
		Fresume.setColumns(10);

		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.LIGHT_GRAY);
		contenucentre.setBounds(0, 80, 465, 265);
		content.add(contenucentre);
		contenucentre.setLayout(null);

		JScrollPane scrollb = new JScrollPane();
		scrollb.setBounds(5, 5, 455, 255);
		contenucentre.add(scrollb);
		
		JTextArea artText = new JTextArea();
		artText.setBounds(5, 5, 465, 255);
		artText.setLineWrap(true);
		scrollb.add(artText);
		
		scrollb.setViewportView(artText);
		
		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 355, 465, 110);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JButton publier = new JButton("Publier");
		publier.setFont(new Font("Agency FB", Font.PLAIN, 15));
		publier.setBounds(370, 5, 90, 25);
		publier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty(Ftitre) || !isEmpty(Fresume) || !isEmptyt(artText)) {
					article = new Article(Ftitre.getText(), Fresume.getText(), artText.getText(),
							Mainframe.user.getPrenom() +" "+ Mainframe.user.getNom(), Mainframe.user.getId());
					ArticleDao ar = new ArticleDao();
					if (ar.create(article)) {
						article.setDate(ar.findDatebyTitre(article.getTitre()));
						article.setId(ar.findIdbyTitre(article.getTitre()));
						JOptionPane.showMessageDialog(publier, "Article créé");
						Mainframe.layer.removeAll();
						ListArticles lart = new ListArticles();
						Mainframe.layer.add(lart.larticles());
						Mainframe.Titrepage.setText("Bienvenue " + Mainframe.user.getPrenom() + "");
					}

					else {
						JOptionPane.showMessageDialog(publier, "Article invalide");
					}
				}
			}
		});
		contenubas.add(publier);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Agency FB", Font.PLAIN, 15));
		retour.setBounds(275, 5, 90, 25);
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Mainframe.layer.removeAll();
						ListArticles art = new ListArticles();
						Mainframe.layer.add(art.larticles());
						Mainframe.Titrepage.setText("Liste des articles");
			}
		});
		contenubas.add(retour);
		
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
