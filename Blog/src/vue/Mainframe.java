package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import controller.UserDao;
import modele.User;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	static JPanel content;
	static JLabel Titrepage;
	static JLayeredPane layer;
	static JPasswordField Fpassword;
	static JTextField Fprenom;
	static JTextField Femail;
	
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
		Titrepage.setBounds(10, 5, 290, 30);
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
		contenugauche.setBounds(0, 0, 225, 200);
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
		contenudroite.setBounds(235, 0, 230, 200);
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
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 210, 465, 180);
		content.add(contenubas);
		contenubas.setLayout(null);
		
		JTextArea txt = new JTextArea();
		txt.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txt.setBackground(Color.DARK_GRAY);
		txt.setDisabledTextColor(Color.WHITE);
		txt.setForeground(Color.WHITE);
		txt.setText("Vos infos ici!!!");
		txt.setBounds(10, 11, 444, 151);
		contenubas.add(txt);
		
		JButton valider = new JButton("Valider");
		valider.setFont(new Font("Agency FB", Font.PLAIN, 15));
		valider.setBounds(125, 164, 90, 25);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setText("\nPassword" + (Fpassword).getPassword().toString());
				 
				User user = new User(Fnom.getText(),Fprenom.getText(),String.valueOf(Fpassword.getPassword()),Femail.getText(),Ftel.getText());
				UserDao us = new UserDao();
				if (us.findByEmail(Femail.getText()) == null) {
					if (us.create(user)) {
						JOptionPane.showMessageDialog(valider, "creation ok");
						layer.removeAll();
						Connection con = new Connection();
						layer.add(con.connection());
						Titrepage.setText("Page de connection");
					} else {
						JOptionPane.showMessageDialog(valider, "creation echec");
					}
				}
				else { JOptionPane.showMessageDialog(valider, "email déjà utilisé");} 
			}
		});
		contenugauche.add(valider);
	}
	/*	
	public String infos() {
		String nom=Fnom.getText();
		String prenom=Fprenom.getText();
		String mail=Femail.getText();
		String tel=Ftel.getText();
		String result="Informations: \nNom: "+ nom +"\nPrenom: "+ prenom +"\nEmail: "+ mail +"\nTel: "+ tel;
		return result;
		}*/
}
