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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import controller.ArticleDao;
import controller.CommentaireDao;
import modele.Article;
import modele.Commentaire;
import modele.User;

public class G_articles {
	private User user = Mainframe.user;
	private JPanel content;
	private JTable tarticle;
	static Article article=null;
	static String contenu=null;
	static int article_id=0;
	
	public JPanel Articles() {
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
				ArticleDao artDao = new ArticleDao();
				if (tarticle.getSelectedRow() != -1) {
					int id = tarticle.getSelectedRow();
					article_id = (int) tarticle.getModel().getValueAt(id, 0);
					article = artDao.findById(article_id);
					Mainframe.layer.removeAll();
					G_commentaires art = new G_commentaires();
					Mainframe.layer.add(art.Commentaires());
				} else {
					JOptionPane.showMessageDialog(commentaires, "Pas d'article selectionné");
				}
			}
		});
		contenuhaut.add(commentaires);
		
		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.GRAY);
		contenucentre.setBounds(0, 40, 465, 290);
		content.add(contenucentre);
		contenucentre.setLayout(null);

		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 0, 465, 290);
		//scrollg.setHorizontalScrollBar(null);
		contenucentre.add(scrollg);
		
		ArticleDao articleDao = new ArticleDao();
		articleDao.read();

		String[] columnNames = { "id", "titre", "resume", "date", "auteur","auteur_id"};

		tarticle = new JTable(null, columnNames);
		tarticle.setBounds(0, 0, 465, 290);
		scrollg.add(tarticle);
		scrollg.setViewportView(tarticle);
		tarticle.setModel(liste());
		
		TableColumnModel mtarticle = tarticle.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(20);
		mtarticle.getColumn(1).setPreferredWidth(100);
		mtarticle.getColumn(2).setPreferredWidth(120);
		mtarticle.getColumn(3).setPreferredWidth(60);
		mtarticle.getColumn(4).setPreferredWidth(100);
		mtarticle.getColumn(5).setPreferredWidth(20);

		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 330, 465, 65);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JTextField Ftitre = new JTextField("titre");
		Ftitre.setBounds(40, 5, 85, 20);
		contenubas.add(Ftitre);
		
		JTextField Fresume = new JTextField("resume");
		Fresume.setBounds(125, 5, 95, 20);
		contenubas.add(Fresume);
		
		JTextField Fcontenu = new JTextField("contenu");
		Fcontenu.setBounds(220, 5, 245, 20);
		contenubas.add(Fcontenu);
		
		JButton creer = new JButton("Créer");
		creer.setFont(new Font("Agency FB", Font.PLAIN, 15));
		creer.setBounds(50, 30, 90, 25);
		creer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty(Ftitre) || !isEmpty(Fcontenu)) {
					article = new Article(Ftitre.getText(),Fresume.getText(), Fcontenu.getText(),user.getPrenom() +" "+ user.getNom(),user.getId());
					ArticleDao artDao = new ArticleDao();
					if (artDao.create(article)) {
						JOptionPane.showMessageDialog(creer, "Article créé");
						Mainframe.layer.removeAll();
						G_articles art = new G_articles();
						Mainframe.layer.add(art.Articles());
					}

					else {
						JOptionPane.showMessageDialog(creer, "Article invalide");
					}
				}
				else {
					JOptionPane.showMessageDialog(creer, "Champs vide");
				}
			}
		});
		contenubas.add(creer);
		
		
		tarticle.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (tarticle.getSelectedRow() != -1) {
					int id = tarticle.getSelectedRow();
					article_id = (int) tarticle.getModel().getValueAt(id, 0);
					ArticleDao artDao = new ArticleDao();
					article = artDao.findById(article_id);
					article.setId(article_id);
					article = artDao.findById(article_id);
					Ftitre.setText(article.getTitre());
					Fresume.setText(article.getResume());
					Fcontenu.setText(article.getContenu());
				}
			}
		});
		
		JButton modifier = new JButton("Modifier");
		modifier.setFont(new Font("Agency FB", Font.PLAIN, 15));
		modifier.setBounds(150, 30, 90, 25);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleDao artDao = new ArticleDao();
				if (tarticle.getSelectedRow() != -1) {
					int id = tarticle.getSelectedRow();
					article_id = (int) tarticle.getModel().getValueAt(id, 0);
					article = artDao.findById(article_id);
					if (!isEmpty(Ftitre) && !isEmpty(Fresume) && !isEmpty(Fcontenu)) {
						// article.setTitre(Ftitre.getText());
						// article.setResume(Fresume.getText());
						// article.setContenu(artText.getText());
						if (artDao.update(article, Ftitre.getText(), Fresume.getText(), Fcontenu.getText(),article_id) != null) {
							JOptionPane.showMessageDialog(modifier, "Article modifié");
							Mainframe.layer.removeAll();
							G_articles art = new G_articles();
							Mainframe.layer.add(art.Articles());
						}

						else {
							JOptionPane.showMessageDialog(modifier, "Article invalide");
						}
					}
					else {
						JOptionPane.showMessageDialog(modifier, "Champs vide");
					}
				}
			}
		});
		contenubas.add(modifier);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setFont(new Font("Agency FB", Font.PLAIN, 15));
		supprimer.setBounds(250, 30, 90, 25);
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArticleDao artDao = new ArticleDao();
				CommentaireDao commDao = new CommentaireDao();
				if (tarticle.getSelectedRow() != -1) {
					int id = tarticle.getSelectedRow();
					article_id = (int) tarticle.getModel().getValueAt(id, 0);
					article = artDao.findById(article_id);
					artDao.delete(article);
					ArrayList<Commentaire> listCommentaire = commDao.ComsByArt_Id(article_id);
					for (Commentaire commentaire : listCommentaire) {
						commDao.delete(commentaire);
					}
					JOptionPane.showMessageDialog(supprimer, "Article supprimé");
					Mainframe.layer.removeAll();
					G_articles art = new G_articles();
					Mainframe.layer.add(art.Articles());
				} else {
					JOptionPane.showMessageDialog(supprimer, "Pas d'article selectionné");
				}
			}
		});
		contenubas.add(supprimer);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Agency FB", Font.PLAIN, 15));
		retour.setBounds(350, 30, 90, 25);
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.layer.removeAll();
				G_articles art = new G_articles();
				Mainframe.layer.add(art.Articles());
			}
		});
		contenubas.add(retour);
		
		return content;
	}

	public DefaultTableModel liste() {

		String[] col = { "ID", "Titre", "Résumé", "Date", "Auteur","Auteur_id"};
		DefaultTableModel tab = new DefaultTableModel(null, col){
			   @Override
	            public boolean isCellEditable(int row, int column) {
	                   return false;
	                }
		};

		ArticleDao cliDao = new ArticleDao();

		ArrayList<Article> listArticle = new ArrayList<>();
		listArticle.addAll(cliDao.read());

		for (Article article : listArticle) {

			tab.addRow(new Object[] { article.getId(), article.getTitre(), article.getResume(), article.getDate(),
					article.getAuteur(),article.getAuteur_id() });
		}
		return tab;
	}
	public boolean isEmpty(JTextField field) {
		if(field.getText().length()==0) {
		return true;	
		}
		else {return false;}
	}
}
