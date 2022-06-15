package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Windowform extends JFrame {

	private JPanel contentPane;
	private static JTextField Fnom;
	private static JTextField Fprenom;
	private static JTextField Fpassword;
	private static JTextField Ftel;
	private JTextField Femail;
	private JPasswordField passwordField;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\75013-46-15\\Desktop\\Java\\Swing\\src\\images\\Icon.png"));
		setTitle("Titre");
		setFont(new Font("Agency FB", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 11, 464, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Formulaire d'inscription");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(39, 11, 181, 33);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 76, 464, 374);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 0, 217, 187);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 197, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblPrenom.setBounds(10, 45, 197, 25);
		panel_2.add(lblPrenom);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 115, 197, 25);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tel:");
		lblNewLabel_1_1_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 150, 197, 25);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblPassword.setBounds(10, 80, 197, 25);
		panel_2.add(lblPassword);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(233, 0, 231, 187);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		Fnom = new JTextField();
		Fnom.setBounds(15, 10, 200, 25);
		panel_2_1.add(Fnom);
		Fnom.setColumns(10);
		
		Fprenom = new JTextField();
		Fprenom.setColumns(10);
		Fprenom.setBounds(15, 45, 200, 25);
		panel_2_1.add(Fprenom);
		
		Fpassword = new JPasswordField();
		Fpassword.setBounds(15, 80, 200, 25);
		panel_2_1.add(Fpassword);
		
		Femail = new JTextField();
		Femail.setColumns(10);
		Femail.setBounds(15, 115, 200, 25);
		panel_2_1.add(Femail);
		
		Ftel = new JTextField();
		Ftel.setBounds(15, 150, 200, 25);
		panel_2_1.add(Ftel);
		Ftel.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 201, 464, 173);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JTextArea txt = new JTextArea();
		txt.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txt.setBackground(Color.DARK_GRAY);
		txt.setDisabledTextColor(Color.WHITE);
		txt.setForeground(Color.WHITE);
		txt.setText("Vos infos ici!!!");
		txt.setBounds(10, 11, 425, 151);
		panel_3.add(txt);
		
		JButton valider = new JButton("Valider");
		valider.setFont(new Font("Agency FB", Font.PLAIN, 15));
		valider.setBounds(365, 11, 89, 23);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setText(infos()+"\nPassword"+((JPasswordField) Fpassword).getPassword().toString());;
			}
		});
		panel.add(valider);
	}	
	public String infos() {
		String nom=Fnom.getText();
		String prenom=Fprenom.getText();
		String mail=Femail.getText();
		String tel=Ftel.getText();
		String result="Informations: \nNom: "+ nom +"\nPrenom: "+ prenom +"\nEmail: "+ mail +"\nTel: "+ tel;
		return result;
		}
}
