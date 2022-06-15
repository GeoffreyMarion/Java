package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.UserDao;
import modele.User;

public class Register extends JPanel{
	static JTextField Fprenom;
	public JPanel register() {
		JPanel contenugauche_ins = new JPanel();
		contenugauche_ins.setBackground(Color.GRAY);
		contenugauche_ins.setBounds(0, 0, 225, 200);
		add(contenugauche_ins);
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
		add(contenudroite_ins);
		contenudroite_ins.setLayout(null);
		
		JTextField Fnom = new JTextField();
		Fnom.setBounds(15, 10, 200, 25);
		contenudroite_ins.add(Fnom);
		Fnom.setColumns(10);
		
		Fprenom = new JTextField();
		Fprenom.setColumns(10);
		Fprenom.setBounds(15, 45, 200, 25);
		contenudroite_ins.add(Fprenom);
		
		JPasswordField Fpassword = new JPasswordField();
		Fpassword.setBounds(15, 80, 200, 25);
		contenudroite_ins.add(Fpassword);
		
		JTextField Femail = new JTextField();
		Femail.setColumns(10);
		Femail.setBounds(15, 115, 200, 25);
		contenudroite_ins.add(Femail);
		
		JTextField Ftel = new JTextField();
		Ftel.setBounds(15, 150, 200, 25);
		contenudroite_ins.add(Ftel);
		Ftel.setColumns(10);
		
		JPanel contenubas_ins = new JPanel();
		contenubas_ins.setBackground(Color.DARK_GRAY);
		contenubas_ins.setBounds(0, 210, 465, 180);
		add(contenubas_ins);
		contenubas_ins.setLayout(null);
		
		JTextArea txt = new JTextArea();
		txt.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txt.setBackground(Color.DARK_GRAY);
		txt.setDisabledTextColor(Color.WHITE);
		txt.setForeground(Color.WHITE);
		txt.setText("Vos infos ici!!!");
		txt.setBounds(10, 11, 444, 151);
		contenubas_ins.add(txt);
		
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
						Connection con = new Connection();
						con.connection();
						Mainframe.Titrepage.setText("Page de connection");
					} else {
						JOptionPane.showMessageDialog(valider, "creation echec");
					}
				}
				else { JOptionPane.showMessageDialog(valider, "email déjà utilisé");} 
			}
		});
		contenugauche_ins.add(valider);
		
		return Mainframe.content;
	}
}
