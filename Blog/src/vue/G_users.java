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
import controller.UserDao;
import modele.Article;
import modele.Commentaire;
import modele.User;

public class G_users {
	private JPanel content;
	static User user=null;
	static String contenu=null;
	static int user_id=0;
	
	public JPanel Users() {
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
		
		/*JButton commentaires = new JButton("Comms");
		commentaires.setFont(new Font("Agency FB", Font.PLAIN, 15));
		commentaires.setBounds(290, 5, 90, 25);
		commentaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Mainframe.layer.removeAll();
						G_commentaires art = new G_commentaires();
						Mainframe.layer.add(art.Commentaires());
			}
		});
		contenuhaut.add(commentaires);*/
		
		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.GRAY);
		contenucentre.setBounds(0, 40, 465, 290);
		content.add(contenucentre);
		contenucentre.setLayout(null);

		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 0, 465, 290);
		//scrollg.setHorizontalScrollBar(null);
		contenucentre.add(scrollg);
		
		UserDao useDao = new UserDao();
		useDao.read();

		String[] columnNames = { "id", "nom", "prenom","email","tel","admin"};

		JTable tuser = new JTable(null, columnNames);
		tuser.setBounds(0, 0, 465, 290);
		scrollg.add(tuser);
		scrollg.setViewportView(tuser);
		tuser.setModel(liste());
		
		TableColumnModel mtarticle = tuser.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(30);
		mtarticle.getColumn(1).setPreferredWidth(80);
		mtarticle.getColumn(2).setPreferredWidth(80);
		mtarticle.getColumn(3).setPreferredWidth(120);
		mtarticle.getColumn(4).setPreferredWidth(80);
		mtarticle.getColumn(5).setPreferredWidth(30);

		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 330, 465, 65);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		/*JTextField Fid = new JTextField();
		Fid.setBounds(0, 5, 40, 15);
		contenubas.add(Fid);*/
		
		JTextField Fnom = new JTextField("nom");
		Fnom.setBounds(40, 5, 85, 20);
		contenubas.add(Fnom);
		
		JTextField Fprenom = new JTextField("prenom");
		Fprenom.setBounds(125, 5, 85, 20);
		contenubas.add(Fprenom);
		
		JTextField Femail = new JTextField("email");
		Femail.setBounds(210, 5, 130, 20);
		contenubas.add(Femail);
		
		JTextField Ftel = new JTextField("tel");
		Ftel.setBounds(340, 5, 85, 20);
		contenubas.add(Ftel);
		
		JTextField Fadmin = new JTextField("admin");
		Fadmin.setBounds(425, 5, 40, 20);
		contenubas.add(Fadmin);
		
		JButton creer = new JButton("Créer");
		creer.setFont(new Font("Agency FB", Font.PLAIN, 15));
		creer.setBounds(50, 30, 90, 25);
		creer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isEmpty(Fnom) || !isEmpty(Fprenom) || !isEmpty(Femail) || !isEmpty(Ftel) || !isEmpty(Fadmin)) {
					user = new User(Fnom.getText(), Fprenom.getText(),"", Femail.getText(),
							Ftel.getText(), false);
					UserDao useDao = new UserDao();
					if (useDao.create(user)) {
						JOptionPane.showMessageDialog(creer, "User créé");
						Mainframe.layer.removeAll();
						G_users p_admin = new G_users();
						Mainframe.layer.add(p_admin.Users());
					}

					else {
						JOptionPane.showMessageDialog(creer, "User invalide");
					}
				}
			}
		});
		contenubas.add(creer);
		
		tuser.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	if (tuser.getSelectedRow() != -1) {
					int id = tuser.getSelectedRow();
					user_id = (int) tuser.getModel().getValueAt(id, 0);
					user = useDao.findById(user_id);
					user.setId(user_id);
	        	Fnom.setText(user.getNom());
				Fprenom.setText(user.getPrenom());
				Femail.setText(user.getEmail());
				Ftel.setText(user.getTel());
				Fadmin.setText(""+user.isAdmin());
	        	}
	        }
	    });
		
		JButton modifier = new JButton("Modifier");
		modifier.setFont(new Font("Agency FB", Font.PLAIN, 15));
		modifier.setBounds(150, 30, 90, 25);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao useDao = new UserDao();
				if (tuser.getSelectedRow() != -1) {
					int id = tuser.getSelectedRow();
					user_id = (int) tuser.getModel().getValueAt(id, 0);
					user = useDao.findById(user_id);
					user.setId(user_id);
					boolean admin=false;
					if(Fadmin.getText().equalsIgnoreCase("true")){admin=true;}
					else{admin=false;}
					if (!isEmpty(Fnom) && !isEmpty(Fprenom) && !isEmpty(Femail) && !isEmpty(Ftel) && !isEmpty(Fadmin)) {
						if (useDao.update(user, Fnom.getText(), Fprenom.getText(), Femail.getText(),user.getPwd(), Ftel.getText(),user_id, admin) != null) {
							JOptionPane.showMessageDialog(modifier, "User modifié");
							Mainframe.layer.removeAll();
							G_users p_admin = new G_users();
							Mainframe.layer.add(p_admin.Users());
						}
						else {
							JOptionPane.showMessageDialog(modifier, "User invalide");
						}
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
				UserDao useDao = new UserDao();
				ArticleDao artDao = new ArticleDao();
				CommentaireDao commDao = new CommentaireDao();
				if (tuser.getSelectedRow() != -1) {
					int id = tuser.getSelectedRow();
					user_id = (int) tuser.getModel().getValueAt(id, 0);
					user = useDao.findById(user_id);
					useDao.delete(user);
					System.out.println(user.getId());
					System.out.println(user_id);
					ArrayList<Article> listArticle = artDao.findByAuteur_id(user_id);
					for (Article article_ : listArticle) {
						article_.setAuteur("Inconnu");
						artDao.updateAuteur(article_,"Inconnu");
						ArrayList<Commentaire> listComms = commDao.ComsByArt_Id(article_.getId());
						for (Commentaire commentaire_ : listComms) {
							commentaire_.setAuteur("Inconnu");
							commDao.updateAuteur(commentaire_,"Inconnu");
						}
					}
					JOptionPane.showMessageDialog(supprimer, "User supprimé");
					Mainframe.layer.removeAll();
					G_users p_admin = new G_users();
					Mainframe.layer.add(p_admin.Users());
				} else {
					JOptionPane.showMessageDialog(supprimer, "Pas de user selectionné");
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
			}
		});
		contenubas.add(retour);
		
		return content;
	}

	public DefaultTableModel liste() {

		String[] col = {"Id", "Nom", "Prenom","Email","Tel","Admin"};
		DefaultTableModel tab = new DefaultTableModel(null, col);

		UserDao useDao = new UserDao();

		ArrayList<User> listUser = new ArrayList<>();
		listUser.addAll(useDao.read());

		for (User user : listUser) {

			tab.addRow(new Object[] { user.getId(), user.getNom(), user.getPrenom(), user.getEmail(),
					user.getTel(),user.isAdmin() });
		}
		return tab;
	}
	
	public boolean isEmpty(JTextField field) {
		if(field.getText()==null) {
		return true;	
		}
		else {return false;}
	}
}
