package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.UserDao;
import modele.User;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	static JPanel content;
	static JLabel Titrepage;
	static JLayeredPane layer;
	static User user;
	static JPasswordField Fpassword;
	static JTextField Fprenom;
	static JTextField Femail;
	static JPasswordField Fcpassword;
	static JTextField Fcmail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\75013-46-15\\Desktop\\Java\\Swing\\src\\images\\Icon.png"));
		setTitle("Blog");
		setFont(new Font("Agency FB", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Fondtitre = new JPanel();
		Fondtitre.setBackground(Color.DARK_GRAY);
		Fondtitre.setBounds(10, 10, 465, 40);
		contentPane.add(Fondtitre);
		Fondtitre.setLayout(null);
		
		Titrepage = new JLabel("Formulaire d'inscription");
		Titrepage.setFont(new Font("Agency FB", Font.PLAIN, 25));
		Titrepage.setForeground(Color.WHITE);
		Titrepage.setBounds(5, 5, 455, 30);
		Fondtitre.add(Titrepage);
		
		layer = new JLayeredPane();
		layer.setBounds(10, 60, 465, 390);
		contentPane.add(layer);
		layer.setLayout(null);
		
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		layer.add(content);
		content.setLayout(null);
		
		//inscription
		
		JPanel contenugauche = new JPanel();
		contenugauche.setBackground(Color.GRAY);
		contenugauche.setBounds(0, 0, 225, 225);
		content.add(contenugauche);
		contenugauche.setLayout(null);
		
		JLabel lnom = new JLabel("Nom:");
		lnom.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lnom.setBounds(10, 10, 197, 25);
		contenugauche.add(lnom);
		
		JLabel lprenom = new JLabel("Prenom:");
		lprenom.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lprenom.setBounds(10, 45, 197, 25);
		contenugauche.add(lprenom);
		
		JLabel lemail = new JLabel("Email");
		lemail.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lemail.setBounds(10, 115, 197, 25);
		contenugauche.add(lemail);
		
		JLabel ltel = new JLabel("Tel:");
		ltel.setFont(new Font("Agency FB", Font.PLAIN, 20));
		ltel.setBounds(10, 150, 197, 25);
		contenugauche.add(ltel);
		
		JLabel lPassword = new JLabel("Password:");
		lPassword.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lPassword.setBounds(10, 80, 197, 25);
		contenugauche.add(lPassword);
		
		JPanel contenudroite = new JPanel();
		contenudroite.setBackground(Color.LIGHT_GRAY);
		contenudroite.setBounds(235, 0, 230, 225);
		content.add(contenudroite);
		contenudroite.setLayout(null);
		
		JTextField Fnom = new JTextField();
		Fnom.setBounds(15, 10, 200, 25);
		contenudroite.add(Fnom);
		Fnom.setColumns(10);
		
		Fprenom = new JTextField();
		Fprenom.setColumns(10);
		Fprenom.setBounds(15, 45, 200, 25);
		contenudroite.add(Fprenom);
		
		Fpassword = new JPasswordField();
		Fpassword.setBounds(15, 80, 200, 25);
		contenudroite.add(Fpassword);
		
		Femail = new JTextField();
		Femail.setColumns(10);
		Femail.setBounds(15, 115, 200, 25);
		contenudroite.add(Femail);
		
		JTextField Ftel = new JTextField();
		Ftel.setBounds(15, 150, 200, 25);
		contenudroite.add(Ftel);
		Ftel.setColumns(10);
		
		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.LIGHT_GRAY);
		contenubas.setBounds(0, 235, 465, 155);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JLabel l_email = new JLabel("Votre Email");
		l_email.setFont(new Font("Agency FB", Font.PLAIN, 20));
		l_email.setBounds(10, 10, 100, 25);
		contenubas.add(l_email);
		
		JLabel l_Password = new JLabel("Votre Email");
		l_Password.setFont(new Font("Agency FB", Font.PLAIN, 20));
		l_Password.setBounds(10, 45, 100, 25);
		contenubas.add(l_Password);
		
		Fcmail = new JTextField();
		Fcmail.setColumns(10);
		Fcmail.setBounds(115, 10, 200, 25);
		contenubas.add(Fcmail);
		
		Fcpassword = new JPasswordField();
		Fcpassword.setBounds(115, 45, 200, 25);
		contenubas.add(Fcpassword);
		
		JButton inscription = new JButton("Inscription");
		inscription.setFont(new Font("Agency FB", Font.PLAIN, 15));
		inscription.setBounds(125, 185, 90, 25);
		inscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = new User(Fnom.getText(),Fprenom.getText(),String.valueOf(Fpassword.getPassword()),Femail.getText(),Ftel.getText());
				UserDao us = new UserDao();
				if (us.findByEmail(Femail.getText()) == null) {
					if (us.create(user)) {
						JOptionPane.showMessageDialog(inscription, "Inscription ok");
						user.setId(us.idbymail(user.getEmail()));
					} else {
						JOptionPane.showMessageDialog(inscription, "Inscription echec");
					}
				}
				else { JOptionPane.showMessageDialog(inscription, "email déjà  utilisé");} 
			}
		});
		contenudroite.add(inscription);
		
		JButton connection = new JButton("Connection");
		connection.setFont(new Font("Agency FB", Font.PLAIN, 15));
		connection.setBounds(360, 45, 90, 25);
		connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao us = new UserDao();
				if (us.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword())) != null) {
						user=us.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword()));
						user.setId(us.idbymail(user.getEmail()));
						JOptionPane.showMessageDialog(connection, "Connection ok");
						Mainframe.layer.removeAll();
						ListArticles art = new ListArticles();
						Mainframe.layer.add(art.larticles());
						Mainframe.Titrepage.setText("Liste des articles");
				}
				else { JOptionPane.showMessageDialog(connection, "Mail ou mot de pass erroné");} 
			}
		});
		contenubas.add(connection);
	}
}
