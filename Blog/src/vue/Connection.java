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

public class Connection {
	public void connection() {
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
	contenubas_conn.setBounds(0, 213, 465, 175);
	contenubas_conn.setLayout(null);
	
	JTextArea ctxt = new JTextArea();
	ctxt.setFont(new Font("Agency FB", Font.PLAIN, 20));
	ctxt.setBackground(Color.DARK_GRAY);
	ctxt.setDisabledTextColor(Color.WHITE);
	ctxt.setForeground(Color.WHITE);
	ctxt.setText("Vos infos ici!!!");
	ctxt.setBounds(10, 11, 444, 151);
	contenubas_conn.add(ctxt);
	
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
	}
}
