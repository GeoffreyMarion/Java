package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controller.ArticleDao;
import controller.UserDao;
import modele.Article;

public class ListArticles extends JPanel{
	JPanel content;
	int article_id=0;
	
	public JPanel larticles() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		
		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.GRAY);
		contenucentre.setBounds(0, 0, 465, 340);
		content.add(contenucentre);
		contenucentre.setLayout(null);

		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 0, 465, 340);
		contenucentre.add(scrollg);
		
		ArticleDao articleDao = new ArticleDao();
		articleDao.read();

		String[] columnNames = { "id", "titre", "resume", "date", "auteur" };

		JTable tarticle = new JTable(null, columnNames);
		tarticle.setBounds(0, 0, 465, 340);
		scrollg.add(tarticle);

		scrollg.setViewportView(tarticle);
		
		tarticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = tarticle.getSelectedRow();
				
				article_id = (int) tarticle.getModel().getValueAt(id, 0);
			}
			
			
		});
		tarticle.setModel(liste());
		TableColumnModel mtarticle = tarticle.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(25);
		mtarticle.getColumn(1).setPreferredWidth(120);
		mtarticle.getColumn(2).setPreferredWidth(135);
		mtarticle.getColumn(3).setPreferredWidth(75);
		mtarticle.getColumn(4).setPreferredWidth(75);

		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 350, 465, 40);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JButton lire = new JButton("Lire");
		lire.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lire.setBounds(90, 5, 90, 25);
		lire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao us = new UserDao();
				if (tarticle.getSelectionModel().isSelectionEmpty()) {
						Mainframe.layer.removeAll();
						Readart art = new Readart();
						Mainframe.layer.add(art.read());
						Mainframe.Titrepage.setText("Lecture d'article par "+Mainframe.Fprenom.getText()+"");
				}
				else { JOptionPane.showMessageDialog(lire, "Mail ou mot de pass erroné");} 
			}
		});
		contenubas.add(lire);
		
		JButton ecrire = new JButton("Ecrire");
		ecrire.setFont(new Font("Agency FB", Font.PLAIN, 15));
		ecrire.setBounds(180, 5, 90, 25);
		ecrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.layer.removeAll();
				Writeart art = new Writeart();
				Mainframe.layer.add(art.write());
				Mainframe.Titrepage.setText("Nouvel article de " + Mainframe.Fprenom.getText() + "");

			}
		});
		contenubas.add(lire);
		
		return content;
	}

	public DefaultTableModel liste() {

		String[] col = { "ID", "Titre", "Résumé", "Date création", "Auteur", "Show" };
		DefaultTableModel tab = new DefaultTableModel(null, col);

		ArticleDao cliDao = new ArticleDao();

		ArrayList<Article> listArticle = new ArrayList<>();
		listArticle.addAll(cliDao.read());

		for (Article article : listArticle) {

			tab.addRow(new Object[] { article.getId(), article.getTitre(), article.getResume(), article.getDate(),
					article.getAuteur() });
		}
		return tab;
	}
}
