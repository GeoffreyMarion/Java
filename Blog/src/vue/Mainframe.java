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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;

public class Mainframe extends JFrame {
	static User user;
	static JPanel content;
	static JLabel Titrepage;
	static JLayeredPane layer;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validmail(String mail) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
		        return matcher.find();
		}
	
		public static final Pattern VALID_PRE_NOM_REGEX = Pattern.compile("^[a-zA-Z ]*$", Pattern.CASE_INSENSITIVE);

		public static boolean validnom(String pre_nom) {
			Matcher matcher = VALID_PRE_NOM_REGEX.matcher(pre_nom);
			return matcher.find();
		}

		public static final Pattern VALID_Num_REGEX = Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);

		public static boolean validtel(String tel) {
			Matcher matcher = VALID_Num_REGEX.matcher(tel);
			return matcher.find();
		}
	
	
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
		
		JPanel contentPane = new JPanel();
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
		Titrepage.setBounds(5, 5, 400, 30);
		Fondtitre.add(Titrepage);
		
		JLabel prenom = new JLabel();
		prenom.setFont(new Font("Agency FB", Font.PLAIN, 15));
		prenom.setForeground(Color.WHITE);
		prenom.setBounds(405, -5, 50, 30);
		Fondtitre.add(prenom);
		
		JLabel nom = new JLabel();
		nom.setFont(new Font("Agency FB", Font.PLAIN, 15));
		nom.setForeground(Color.WHITE);
		nom.setBounds(405, 10, 50, 30);
		Fondtitre.add(nom);
		
		JButton admin = new JButton("Admin");
		admin.setFont(new Font("Agency FB", Font.PLAIN, 15));
		admin.setBounds(370, 10, 90, 25);
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.isAdmin()) {
					Fondtitre.setBackground(Color.RED);
					Mainframe.layer.removeAll();
					Panneau_admin p_admin = new Panneau_admin();
					Mainframe.layer.add(p_admin.admin_p());
					Mainframe.Titrepage.setText("Panneau admin");
				}
				else { JOptionPane.showMessageDialog(admin, "Vous n'êtes pas admin");} 
			}
		});
		Fondtitre.add(admin);
		admin.setVisible(false);
		
		JButton retour = new JButton("Retour");
		retour.setFont(new Font("Agency FB", Font.PLAIN, 15));
		retour.setBounds(270, 10, 90, 25);
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.isAdmin()) {
					Fondtitre.setBackground(Color.DARK_GRAY);
					Mainframe.layer.removeAll();
					ListArticles art = new ListArticles();
					Mainframe.layer.add(art.larticles());
					Mainframe.Titrepage.setText("Liste des articles");
				}
				else { JOptionPane.showMessageDialog(retour, "Vous n'êtes pas admin");} 
			}
		});
		Fondtitre.add(retour);
		retour.setVisible(false);
		
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
		
		JTextField Fprenom = new JTextField();
		Fprenom.setColumns(10);
		Fprenom.setBounds(15, 45, 200, 25);
		contenudroite.add(Fprenom);
		
		JPasswordField Fpassword = new JPasswordField();
		Fpassword.setBounds(15, 80, 200, 25);
		contenudroite.add(Fpassword);
		
		JTextField Femail = new JTextField();
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
		
		JLabel l_Password = new JLabel("Votre Mdp");
		l_Password.setFont(new Font("Agency FB", Font.PLAIN, 20));
		l_Password.setBounds(10, 45, 100, 25);
		contenubas.add(l_Password);
		
		JTextField Fcmail = new JTextField();
		Fcmail.setColumns(10);
		Fcmail.setBounds(115, 10, 200, 25);
		contenubas.add(Fcmail);
		
		JPasswordField Fcpassword = new JPasswordField();
		Fcpassword.setBounds(115, 45, 200, 25);
		contenubas.add(Fcpassword);
		
		JButton inscription = new JButton("Inscription");
		inscription.setFont(new Font("Agency FB", Font.PLAIN, 15));
		inscription.setBounds(125, 185, 90, 25);
		inscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao uDao = new UserDao();
				user = new User(Fnom.getText(), Fprenom.getText(), String.valueOf(Fpassword.getPassword()),
						Femail.getText(), Ftel.getText(), false);
				if (!isEmpty(Fnom) && !isEmpty(Fprenom) && !isEmpty(Fpassword) && !isEmpty(Femail) && !isEmpty(Ftel)) {
					System.out.println();
					if (uDao.findByEmail(Femail.getText()) == null && validmail(Femail.getText()) && validnom(Fnom.getText()) && validnom(Fprenom.getText())  && validtel(Ftel.getText())) {
						if (uDao.create(user)) {
							JOptionPane.showMessageDialog(inscription, "Inscription ok");
							user.setId(uDao.idbymail(user.getEmail()));
							Fcmail.setText(Femail.getText());
						} else {
							JOptionPane.showMessageDialog(inscription, "Inscription echec");
						}
					}
					if(!validnom(Fnom.getText())){JOptionPane.showMessageDialog(inscription, "Nom invalde");}
					if(!validnom(Fprenom.getText())){JOptionPane.showMessageDialog(inscription, "Prenom invalde");}
					if(uDao.findByEmail(Femail.getText()) != null) {JOptionPane.showMessageDialog(inscription, "email déja utilisé");}
					if(!validmail(Femail.getText())){JOptionPane.showMessageDialog(inscription, "email invalde");}
					if(!validtel(Ftel.getText())){JOptionPane.showMessageDialog(inscription, "Téléphone invalde");}
				}
				else {JOptionPane.showMessageDialog(inscription, "Remplissez tous les champs");}
			}
		});
		contenudroite.add(inscription);
		
		JPanel changemdp = new JPanel();
		changemdp.setBounds(5, 75, 455, 75);
		changemdp.setVisible(false);
		contenubas.add(changemdp);
		changemdp.setLayout(null);
		
		JButton connection = new JButton("Connection");
		connection.setFont(new Font("Agency FB", Font.PLAIN, 15));
		connection.setBounds(360, 45, 90, 25);
		connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao uDao = new UserDao();
				if (uDao.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword())) != null) {
						user=uDao.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword()));
						user.setId(uDao.idbymail(user.getEmail()));
						nom.setText(user.getNom());
						prenom.setText(user.getPrenom());
						JOptionPane.showMessageDialog(connection, "Connection ok");
						Mainframe.layer.removeAll();
						ListArticles art = new ListArticles();
						Mainframe.layer.add(art.larticles());
						Mainframe.Titrepage.setText("Liste des articles");
						if (user.isAdmin()) {
							admin.setVisible(true);
							retour.setVisible(true);
						}
				}
				else { JOptionPane.showMessageDialog(connection, "Mail ou mot de pass erroné"); changemdp.setVisible(true);}
			}
		});
		contenubas.add(connection);
		
		JLabel l_vemail = new JLabel("Votre Email");
		l_vemail.setFont(new Font("Agency FB", Font.PLAIN, 20));
		l_vemail.setBounds(5, 10, 100, 25);
		changemdp.add(l_vemail);
		
		JLabel l_nPassword = new JLabel("nouveau Mdp");
		l_nPassword.setFont(new Font("Agency FB", Font.PLAIN, 20));
		l_nPassword.setBounds(5, 45, 100, 25);
		changemdp.add(l_nPassword);
		
		JTextField Fvmail = new JTextField();
		Fvmail.setColumns(10);
		Fvmail.setBounds(110, 10, 200, 25);
		changemdp.add(Fvmail);
		
		JTextField Fnpassword = new JPasswordField();
		Fnpassword.setBounds(110, 45, 200, 25);
		changemdp.add(Fnpassword);
		
		JButton modifier = new JButton("Modifier");
		modifier.setFont(new Font("Agency FB", Font.PLAIN, 15));
		modifier.setBounds(360, 45, 90, 25);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao uDao = new UserDao();
				if (!isEmpty(Fvmail) && !isEmpty(Fnpassword)) {
					if(uDao.findByEmail(Fvmail.getText())!=null) {
						int id=uDao.idbymail(Fvmail.getText());
						user=uDao.findById(id);
						user.setId(id);
						uDao.update(user, user.getNom(), user.getPrenom(),user.getEmail(), Fnpassword.getText(),  user.getTel(), user.getId(), user.isAdmin());
						user.setPwd(Fnpassword.getText());
						JOptionPane.showMessageDialog(connection, "Modification ok");
						changemdp.setVisible(false);
				}
				else { JOptionPane.showMessageDialog(connection, "Mail pas dans la base");}
				}
			}
		});
		changemdp.add(modifier);
	}
	public boolean isEmpty(JTextField field) {
		if(field.getText().length()==0) {
		return true;	
		}
		else {return false;}
	}
}
