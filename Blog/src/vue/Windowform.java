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

public class Windowform extends JFrame {

	private JPanel contentPane;
	private JTextField Fnom;
	private JTextField Fprenom;
	private JPasswordField Fpassword;
	private JTextField Femail;
	private JTextField Ftel;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windowform frame = new Windowform();
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
	public Windowform() {
		//page inscription
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\75013-46-15\\Desktop\\Java\\Swing\\src\\images\\Icon.png"));
		setTitle("Titre");
		setFont(new Font("Agency FB", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane content = new JLayeredPane();
		content.setBounds(10, 61, 465, 390);
		contentPane.add(content);
		
		JPanel Fondtitre = new JPanel();
		Fondtitre.setBackground(Color.DARK_GRAY);
		Fondtitre.setBounds(10, 10, 465, 40);
		contentPane.add(Fondtitre);
		Fondtitre.setLayout(null);
		
		JLabel Titrepage = new JLabel("Formulaire d'inscription");
		Titrepage.setFont(new Font("Agency FB", Font.PLAIN, 25));
		Titrepage.setForeground(Color.WHITE);
		Titrepage.setBounds(10, 5, 290, 30);
		Fondtitre.add(Titrepage);
		
		JPanel contenugauche_ins = new JPanel();
		contenugauche_ins.setBackground(Color.GRAY);
		contenugauche_ins.setBounds(0, 0, 225, 200);
		content.add(contenugauche_ins);
		contenugauche_ins.setLayout(null);
		
		JLabel lnom = new JLabel("Nom:");
		lnom.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lnom.setBounds(10, 10, 197, 25);
		contenugauche_ins.add(lnom);
		
		JLabel lprenom = new JLabel("Prenom:");
		lprenom.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lprenom.setBounds(10, 45, 197, 25);
		contenugauche_ins.add(lprenom);
		
		JLabel lemail = new JLabel("Email");
		lemail.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lemail.setBounds(10, 115, 197, 25);
		contenugauche_ins.add(lemail);
		
		JLabel ltel = new JLabel("Tel:");
		ltel.setFont(new Font("Agency FB", Font.PLAIN, 20));
		ltel.setBounds(10, 150, 197, 25);
		contenugauche_ins.add(ltel);
		
		JLabel lPassword = new JLabel("Password:");
		lPassword.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lPassword.setBounds(10, 80, 197, 25);
		contenugauche_ins.add(lPassword);
		
		JPanel contenudroite_ins = new JPanel();
		contenudroite_ins.setBackground(Color.LIGHT_GRAY);
		contenudroite_ins.setBounds(235, 0, 230, 200);
		content.add(contenudroite_ins);
		contenudroite_ins.setLayout(null);
		
		Fnom = new JTextField();
		Fnom.setBounds(15, 10, 200, 25);
		contenudroite_ins.add(Fnom);
		Fnom.setColumns(10);
		
		Fprenom = new JTextField();
		Fprenom.setColumns(10);
		Fprenom.setBounds(15, 45, 200, 25);
		contenudroite_ins.add(Fprenom);
		
		Fpassword = new JPasswordField();
		Fpassword.setBounds(15, 80, 200, 25);
		contenudroite_ins.add(Fpassword);
		
		Femail = new JTextField();
		Femail.setColumns(10);
		Femail.setBounds(15, 115, 200, 25);
		contenudroite_ins.add(Femail);
		
		Ftel = new JTextField();
		Ftel.setBounds(15, 150, 200, 25);
		contenudroite_ins.add(Ftel);
		Ftel.setColumns(10);
		
		JPanel contenubas_ins = new JPanel();
		contenubas_ins.setBackground(Color.DARK_GRAY);
		contenubas_ins.setBounds(0, 210, 465, 180);
		content.add(contenubas_ins);
		contenubas_ins.setLayout(null);
		
		JTextArea txt = new JTextArea();
		txt.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txt.setBackground(Color.DARK_GRAY);
		txt.setDisabledTextColor(Color.WHITE);
		txt.setForeground(Color.WHITE);
		txt.setText("Vos infos ici!!!");
		txt.setBounds(10, 11, 444, 151);
		contenubas_ins.add(txt);
		
		// page connection 
		JPanel contenugauche_conn = new JPanel();
		contenugauche_conn.setBackground(Color.GRAY);
		contenugauche_conn.setBounds(0, 0, 225, 200);
		contenugauche_conn.setLayout(null);
		
		JLabel lemail_conn = new JLabel("Email");
		lemail_conn.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lemail_conn.setBounds(10, 10, 197, 25);
		contenugauche_conn.add(lemail_conn);
		
		JLabel lPassword_conn = new JLabel("Password:");
		lPassword_conn.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lPassword_conn.setBounds(10, 45, 197, 25);
		contenugauche_conn.add(lPassword_conn);

		JPanel contenudroite_conn = new JPanel();
		contenudroite_conn.setBackground(Color.LIGHT_GRAY);
		contenudroite_conn.setBounds(235, 0, 230, 200);
		contenudroite_conn.setLayout(null);
		
		JTextField Fcmail = new JTextField();
		Fcmail.setBounds(15, 10, 200, 25);
		contenudroite_conn.add(Fcmail);
		Fcmail.setColumns(10);
		
		JPasswordField Fcpassword = new JPasswordField();
		Fcpassword.setBounds(15, 45, 200, 25);
		contenudroite_conn.add(Fcpassword);
		
		JPanel contenubas_conn = new JPanel();
		contenubas_conn.setBackground(Color.DARK_GRAY);
		contenubas_conn.setBounds(0, 210, 465, 180);
		contenubas_conn.setLayout(null);
		
		JTextArea ctxt = new JTextArea();
		ctxt.setFont(new Font("Agency FB", Font.PLAIN, 20));
		ctxt.setBackground(Color.DARK_GRAY);
		ctxt.setDisabledTextColor(Color.WHITE);
		ctxt.setForeground(Color.WHITE);
		ctxt.setText("Vos infos ici!!!");
		ctxt.setBounds(10, 11, 444, 151);
		contenubas_conn.add(ctxt);
		
		// page connecté
		JPanel contenugauche_log = new JPanel();
		contenugauche_log.setBackground(Color.GRAY);
		contenugauche_log.setBounds(0, 0, 465, 200);
		contenugauche_log.setLayout(null);
		
		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 0, 465, 200);
		contenugauche_log.add(scrollg);
		
		String[][] data = {
	            { "1", "Martine à la plage", "La plage c'est bien","02/05/1998","Martine" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les conffessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les conffessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de Rousseau","02/05/1999","Rousseau" },
	            { "2", "Les confessions", "La vie de bob","02/05/1999","Bob" },
	        };
	 
	    
	    String[] columnNames = { "id", "titre", "resume","date","auteur" };
	        
		JTable tarticle = new JTable(data, columnNames);
		tarticle.setBounds(0, 0, 450, 200);
		TableColumnModel mtarticle = tarticle.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(25);
		mtarticle.getColumn(1).setPreferredWidth(120);
		mtarticle.getColumn(2).setPreferredWidth(135);
		mtarticle.getColumn(3).setPreferredWidth(75);
		mtarticle.getColumn(4).setPreferredWidth(75);
		scrollg.add(tarticle);
		
		scrollg.setViewportView(tarticle);
		
		JPanel contenudroite_log = new JPanel();
		contenudroite_log.setBackground(Color.LIGHT_GRAY);
		contenudroite_log.setBounds(0, 0, 0, 0);
		contenudroite_log.setLayout(null);
		
		JPanel contenubas_log = new JPanel();
		contenubas_log.setBackground(Color.DARK_GRAY);
		contenubas_log.setBounds(0, 210, 465, 180);
		contenubas_log.setLayout(null);
		
		JScrollPane scrollb = new JScrollPane();
		scrollb.setBounds(0, 210, 465, 180);
		contenubas_log.add(scrollb);
		
		JButton connection = new JButton("Connection");
		connection.setFont(new Font("Agency FB", Font.PLAIN, 15));
		connection.setBounds(125, 130, 90, 25);
		connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctxt.setText("Email: " +Fcmail.getText()+ "\nPassword: " + (Fcpassword).getPassword().toString());
				UserDao us = new UserDao();
				if (us.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword()))) {
						JOptionPane.showMessageDialog(connection, "Connection ok");
						changeframe(content,contenugauche_log,contenudroite_log,contenubas_conn);
						Titrepage.setText("Bienvenu "+Fprenom.getText()+"");
				}
				else { JOptionPane.showMessageDialog(connection, "Mail ou mot de pass erroné");} 
			}
		});
		contenudroite_conn.add(connection);
		
		JButton valider = new JButton("Valider");
		valider.setFont(new Font("Agency FB", Font.PLAIN, 15));
		valider.setBounds(125, 164, 90, 25);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setText(infos() + "\nPassword" + (Fpassword).getPassword().toString());
				 
				User user = new User(Fnom.getText(),Fprenom.getText(),String.valueOf(Fpassword.getPassword()),Femail.getText(),Ftel.getText());
				UserDao us = new UserDao();
				if (us.findByEmail(Femail.getText()) == null) {
					if (us.create(user)) {
						JOptionPane.showMessageDialog(valider, "creation ok");
						changeframe(content,contenugauche_conn,contenudroite_conn,contenubas_ins);
						Titrepage.setText("Page de connection");
					} else {
						JOptionPane.showMessageDialog(valider, "creation echec");
					}
				}
				else { JOptionPane.showMessageDialog(valider, "email déjà utilisé");} 
			}
		});
		contenugauche_ins.add(valider);
	}	
	public String infos() {
		String nom=Fnom.getText();
		String prenom=Fprenom.getText();
		String mail=Femail.getText();
		String tel=Ftel.getText();
		String result="Informations: \nNom: "+ nom +"\nPrenom: "+ prenom +"\nEmail: "+ mail +"\nTel: "+ tel;
		return result;
		}
	public void changeframe(JLayeredPane panel,JPanel cg,JPanel cd,JPanel cb) {
		panel.removeAll();
		panel.add(cg);
		panel.add(cd);
		panel.add(cb);
		panel.repaint();
		panel.revalidate();
	}
}
