package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.CommentaireDao;
import modele.Commentaire;

public class Readart {
	private 
	JPanel content;
	//private JLayeredPane contenucomm;
	//private JScrollPane comms;
	
	public JPanel read_art() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		
		JPanel contenuhaut = new JPanel();
		contenuhaut.setBackground(Color.GRAY);
		contenuhaut.setBounds(0, 0, 465, 250);
		content.add(contenuhaut);
		contenuhaut.setLayout(null);

		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 5, 295, 240);
		contenuhaut.add(scrollg);
		
		JTextArea artText = new JTextArea();
		artText.setBounds(0, 5, 295, 240);
		artText.setEditable(false);
		artText.setLineWrap(true);
		artText.setText(ListArticles.contenu);
		scrollg.add(artText);
		
		scrollg.setViewportView(artText);
		
		/*contenucomm = new JLayeredPane();
		contenucomm.setBounds(305, 0, 160, 250);
		
		comms = new JScrollPane();
		comms.setBackground(Color.DARK_GRAY);
		comms.setBounds(0, 0, 160, 250);
		contenucomm.add(comms);*/
		
		JScrollPane comms = new JScrollPane();
		comms.setBackground(Color.LIGHT_GRAY);
		comms.setBounds(295, 5, 170, 240);
		contenuhaut.add(comms);
		
		JTextArea tcoms = new JTextArea();
		tcoms.setBounds(295, 5, 170, 240);
		tcoms.setLineWrap(true);
		tcoms.setFont(new Font("Agency FB", Font.PLAIN, 15));
		tcoms.setText(affiche_comm());
		tcoms.setEditable(false);
		comms.add(tcoms);
		
		comms.setViewportView(tcoms);
		
		JPanel contenucentre = new JPanel();
		contenucentre.setBackground(Color.LIGHT_GRAY);
		contenucentre.setBounds(0, 260, 465, 90);
		content.add(contenucentre);
		contenucentre.setLayout(null);
		
		JLabel commentaire= new JLabel("Votre commentaire");
		commentaire.setFont(new Font("Agency FB", Font.PLAIN, 20));
		commentaire.setBounds(5, 5, 150, 25);
		contenucentre.add(commentaire);
		
		JTextField Fcomm = new JTextField();
		Fcomm.setBounds(5, 30, 455, 25);
		contenucentre.add(Fcomm);
		
		JButton poster = new JButton("Poster");
		poster.setFont(new Font("Agency FB", Font.PLAIN, 15));
		poster.setBounds(370, 60, 90, 25);
		poster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commentaire comm = new Commentaire(ListArticles.article.getId(),
						Mainframe.user.getPrenom() + "" + Mainframe.user.getNom(), Fcomm.getText());
				CommentaireDao cDao = new CommentaireDao();
				if (!isEmpty(Fcomm)) {
					if (cDao.create(comm)) {
						comm.setDate(cDao.findDatebyContenu(comm.getContenu()));
						comm.setId(cDao.findIdbyContenu(comm.getContenu()));
						JOptionPane.showMessageDialog(poster, "Commentaire publi�");
						Mainframe.layer.removeAll();
						Readart rart = new Readart();
						// comms.removeAll();
						// coms.add(rart.affiche_comm());
						Mainframe.layer.add(rart.read_art());
						Mainframe.Titrepage.setText("Lecture d'article: "+ListArticles.article.getTitre());
					} else {
						JOptionPane.showMessageDialog(poster, "Commentaire invalide");
					}
				}
			}
		});
		contenucentre.add(poster);
		
		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 355, 465, 35);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Agency FB", Font.PLAIN, 15));
		retour.setBounds(370, 5, 90, 25);
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
	/*public JScrollPane affiche_comm() {
		CommentaireDao commDao = new CommentaireDao();
		ArrayList<Commentaire> listCommentaire = new ArrayList<>();
		listCommentaire.addAll(commDao.read());
		
		for (Commentaire comm : listCommentaire) {
			
			JPanel postcomm = new JPanel();
			postcomm.setBackground(Color.GRAY);
			comms.add(postcomm);
			postcomm.setLayout(null);
			
			JLabel auteur = new JLabel(comm.getAuteur());
			auteur.setFont(new Font("Agency FB", Font.PLAIN, 20));
			auteur.setBounds(5, 5, 70, 25);
			postcomm.add(auteur);
			
			JLabel date = new JLabel(comm.getDate());
			date.setFont(new Font("Agency FB", Font.PLAIN, 20));
			date.setBounds(120, 5, 40, 25);
			postcomm.add(date);
			
			JLabel contenu= new JLabel(comm.getDate());
			contenu.setFont(new Font("Agency FB", Font.PLAIN, 20));
			contenu.setBounds(5, 30, 160, 25);
			postcomm.add(contenu);
			System.out.println("hop");
			
			
			comms.setViewportView(postcomm);
		}
		return comms;
	}*/
	public String affiche_comm() {
		CommentaireDao commDao = new CommentaireDao();
		ArrayList<Commentaire> listCommentaire = new ArrayList<>();
		listCommentaire.addAll(commDao.ComsByArt_Id(ListArticles.article_id));
		String contenu="";
		
		for (Commentaire comm : listCommentaire) {
			contenu+="   "+comm.getAuteur()+"     "+comm.getDate()+"\n   "+comm.getContenu()+"\n______________________________\n";
		}
		return contenu;
	}
	public boolean isEmpty(JTextField field) {
		if(field.getText()==null) {
		return true;	
		}
		else {return false;}
	}
	
}
