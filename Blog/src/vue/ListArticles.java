package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import controller.ArticleDao;
import modele.Article;

public class ListArticles extends JPanel{
	private JPanel content;
	static Article article=null;
	static String contenu=null;
	static int article_id=0;
	
	public JPanel larticles() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		System.out.println(Mainframe.user);
		
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

		String[] columnNames = { "id", "titre", "resume", "date", "auteur","auteur_id"};

		JTable tarticle = new JTable(null, columnNames);
		tarticle.setBounds(0, 0, 465, 340);
		scrollg.add(tarticle);
		scrollg.setViewportView(tarticle);
		tarticle.setModel(liste());
		
		TableColumnModel mtarticle = tarticle.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(0);
		mtarticle.getColumn(0).setMaxWidth(0); 
		mtarticle.getColumn(0).setMinWidth(0);
		mtarticle.getColumn(0).setWidth(0);
		mtarticle.getColumn(0).setMaxWidth(0); 
		mtarticle.getColumn(1).setPreferredWidth(120);
		mtarticle.getColumn(2).setPreferredWidth(140);
		mtarticle.getColumn(3).setPreferredWidth(60);
		mtarticle.getColumn(4).setPreferredWidth(100);
		mtarticle.getColumn(5).setPreferredWidth(0);
		mtarticle.getColumn(5).setMinWidth(0);
		mtarticle.getColumn(5).setWidth(0);
		mtarticle.getColumn(5).setMaxWidth(0);

		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 350, 465, 40);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JButton lire = new JButton("Lire");
		lire.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lire.setBounds(40, 5, 90, 25);
		lire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleDao art = new ArticleDao();
				//if (tarticle.getSelectionModel().isSelectionEmpty()==false) {
				if (tarticle.getSelectedRow()!=-1) {
						int id = tarticle.getSelectedRow();
						article_id = (int) tarticle.getModel().getValueAt(id, 0);
						article=art.findById(article_id);
						contenu=article.getContenu();
						Mainframe.layer.removeAll();
						Readart arti = new Readart();
						Mainframe.layer.add(arti.read_art());
						Mainframe.Titrepage.setText("Lecture d'article: "+art.findById(article_id).getTitre());
				}
				else { JOptionPane.showMessageDialog(lire, "pas d'article selectionné");} 
			}
		});
		contenubas.add(lire);
		
		JButton ecrire = new JButton("Ecrire");
		ecrire.setFont(new Font("Agency FB", Font.PLAIN, 15));
		ecrire.setBounds(140, 5, 90, 25);
		ecrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.layer.removeAll();
				Writeart art = new Writeart();
				Mainframe.layer.add(art.write());
				Mainframe.Titrepage.setText("Nouvel article de " + Mainframe.user.getPrenom()+ "");

			}
		});
		contenubas.add(ecrire);
		
		JButton editer = new JButton("Editer");
		editer.setFont(new Font("Agency FB", Font.PLAIN, 15));
		editer.setBounds(240, 5, 90, 25);
		editer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tarticle.getSelectedRow() != -1) {
					int id = tarticle.getSelectedRow();
					article_id = (int) tarticle.getModel().getValueAt(id, 0);
					ArticleDao artD = new ArticleDao();
					article = artD.findById(article_id);
					if (article.getAuteur_id() == Mainframe.user.getId()) {
						Mainframe.layer.removeAll();
						Updateart up = new Updateart();
						Mainframe.layer.add(up.updateart());
					} else {
						JOptionPane.showMessageDialog(lire, "Vous n'étes pas l'Auteur");
					}
				} else {
					JOptionPane.showMessageDialog(lire, "Pas d'article selectionné");
				}
			}
		});
		contenubas.add(editer);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setFont(new Font("Agency FB", Font.PLAIN, 15));
		supprimer.setBounds(340, 5, 90, 25);
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tarticle.getSelectedRow() != -1) {
					int id = tarticle.getSelectedRow();
					article_id = (int) tarticle.getModel().getValueAt(id, 0);
					ArticleDao artD = new ArticleDao();
					article = artD.findById(article_id);
					if (article.getAuteur_id() == Mainframe.user.getId()) {
						artD.delete(article);
						JOptionPane.showMessageDialog(lire, "Article supprimé");
						Mainframe.layer.removeAll();
						ListArticles art = new ListArticles();
						Mainframe.layer.add(art.larticles());
					} else {
						JOptionPane.showMessageDialog(lire, "Vous n'étes pas l'Auteur");
					}
				} else {
					JOptionPane.showMessageDialog(lire, "Pas d'article selectionné");
				}
			}
		});
		contenubas.add(supprimer);
		
		return content;
	}

	public DefaultTableModel liste() {

		String[] col = { "ID", "Titre", "Résumé", "Date création", "Auteur","Auteur_id"};
		DefaultTableModel tab = new DefaultTableModel(null, col);

		ArticleDao cliDao = new ArticleDao();

		ArrayList<Article> listArticle = new ArrayList<>();
		listArticle.addAll(cliDao.read());

		for (Article article : listArticle) {

			tab.addRow(new Object[] { article.getId(), article.getTitre(), article.getResume(), article.getDate(),
					article.getAuteur(),article.getAuteur_id() });
		}
		return tab;
	}
}
