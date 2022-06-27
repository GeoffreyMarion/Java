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
import controller.CommentaireDao;
import modele.Commentaire;
import modele.User;

public class G_commentaires {
	private User user = Mainframe.user;
	private JPanel content;
	static Commentaire commentaire=null;
	static String contenu=null;
	private int article_id=G_articles.article_id;
	static int commentaire_id=0;
	
	public JPanel Commentaires() {
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
		contenucentre.setBackground(Color.GRAY);
		contenucentre.setBounds(0, 40, 465, 290);
		content.add(contenucentre);
		contenucentre.setLayout(null);

		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 0, 465, 290);
		//scrollg.setHorizontalScrollBar(null);
		contenucentre.add(scrollg);
		
		CommentaireDao commDao = new CommentaireDao();
		commDao.read();

		String[] columnNames = { "id", "article", "auteur", "date", "contenu"};

		JTable tcomms = new JTable(null, columnNames);
		tcomms.setBounds(0, 0, 465, 290);
		scrollg.add(tcomms);
		scrollg.setViewportView(tcomms);
		tcomms.setModel(liste());
		
		TableColumnModel mtarticle = tcomms.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(20);
		mtarticle.getColumn(1).setPreferredWidth(20);
		mtarticle.getColumn(2).setPreferredWidth(120);
		mtarticle.getColumn(3).setPreferredWidth(60);
		mtarticle.getColumn(4).setPreferredWidth(200);

		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 330, 465, 65);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JTextField Fcontenu = new JTextField("contenu");
		Fcontenu.setBounds(40, 5, 85, 20);
		contenubas.add(Fcontenu);
		
		JButton creer = new JButton("Créer");
		creer.setFont(new Font("Agency FB", Font.PLAIN, 15));
		creer.setBounds(50, 30, 90, 25);
		creer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty(Fcontenu)) {
					commentaire = new Commentaire(article_id,user.getPrenom()+" "+user.getNom(),Fcontenu.getText());
					CommentaireDao commDao = new CommentaireDao();
					if (commDao.create(commentaire)) {
						JOptionPane.showMessageDialog(creer, "Commentaire créé");
						Mainframe.layer.removeAll();
						G_commentaires comm = new G_commentaires();
						Mainframe.layer.add(comm.Commentaires());
					}

					else {
						JOptionPane.showMessageDialog(creer, "Commentaire invalide");
					}
				}
				else {
					JOptionPane.showMessageDialog(creer, "Contenu vide");
				}
			}
		});
		contenubas.add(creer);
		
		tcomms.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (tcomms.getSelectedRow() != -1) {
					int id = tcomms.getSelectedRow();
					commentaire_id = (int) tcomms.getModel().getValueAt(id, 0);
					CommentaireDao commDao = new CommentaireDao();
					commentaire = commDao.findById(commentaire_id);
					commentaire.setId(commentaire_id);
					commentaire = commDao.findById(commentaire_id);
					Fcontenu.setText(commentaire.getContenu());
				}
			}
		});
		
		JButton modifier = new JButton("Modifier");
		modifier.setFont(new Font("Agency FB", Font.PLAIN, 15));
		modifier.setBounds(150, 30, 90, 25);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommentaireDao commDao = new CommentaireDao();
				if (tcomms.getSelectedRow() != -1) {
					int id = tcomms.getSelectedRow();
					commentaire_id = (int) tcomms.getModel().getValueAt(id, 0);
					commentaire = commDao.findById(commentaire_id);
					if (!isEmpty(Fcontenu)) {
						if (commDao.update(commentaire, Fcontenu.getText(),commentaire_id) != null) {
							JOptionPane.showMessageDialog(modifier, "Article modifié");
							Mainframe.layer.removeAll();
							G_commentaires comm = new G_commentaires();
							Mainframe.layer.add(comm.Commentaires());
						}

						else {
							JOptionPane.showMessageDialog(modifier, "Article invalide");
						}
					}
					else {
						JOptionPane.showMessageDialog(modifier, "Contenu vide");
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
				CommentaireDao commDao = new CommentaireDao();
				if (tcomms.getSelectedRow() != -1) {
					int id = tcomms.getSelectedRow();
					commentaire_id = (int) tcomms.getModel().getValueAt(id, 0);
					commentaire = commDao.findById(commentaire_id);
					commDao.delete(commentaire);
					JOptionPane.showMessageDialog(supprimer, "Commentaire supprimé");
					Mainframe.layer.removeAll();
					G_commentaires art = new G_commentaires();
					Mainframe.layer.add(art.Commentaires());
				} else {
					JOptionPane.showMessageDialog(supprimer, "Pas de commentaire selectionné");
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
				Panneau_admin p_admin = new Panneau_admin();
				Mainframe.layer.add(p_admin.admin_p());
				Mainframe.Titrepage.setText("Panneau admin");
			}
		});
		contenubas.add(retour);
		
		return content;
	}

	public DefaultTableModel liste() {

		String[] col = {"Id", "Article", "Auteur", "Date", "Contenu"};
		DefaultTableModel tab = new DefaultTableModel(null, col){
			   @Override
	            public boolean isCellEditable(int row, int column) {
	                   return false;
	                }
		};

		CommentaireDao commDao = new CommentaireDao();

		ArrayList<Commentaire> listCommentaire = new ArrayList<>();
		listCommentaire.addAll(commDao.ComsByArt_Id(G_articles.article_id));

		for (Commentaire commentaire : listCommentaire) {

			tab.addRow(new Object[] { commentaire.getId(), commentaire.getArticle(), commentaire.getAuteur(), commentaire.getDate(),
					commentaire.getContenu() });
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