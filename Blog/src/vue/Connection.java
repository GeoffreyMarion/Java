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

public class Connection extends JPanel{
	private JPanel content;
	
	public JPanel connection() {
	content = new JPanel();
	content.setBounds(0, 0, 465, 390);
	content.setLayout(null);
		
	JPanel contenugauche = new JPanel();
	contenugauche.setBackground(Color.GRAY);
	contenugauche.setBounds(0, 0, 225, 200);
	content.add(contenugauche);
	contenugauche.setLayout(null);
	
	JLabel lemail_conn = new JLabel("Email");
	lemail_conn.setFont(new Font("Agency FB", Font.PLAIN, 20));
	lemail_conn.setBounds(10, 10, 197, 25);
	contenugauche.add(lemail_conn);
	
	JLabel lPassword_conn = new JLabel("Password:");
	lPassword_conn.setFont(new Font("Agency FB", Font.PLAIN, 20));
	lPassword_conn.setBounds(10, 45, 197, 25);
	contenugauche.add(lPassword_conn);

	JPanel contenudroite = new JPanel();
	contenudroite.setBackground(Color.LIGHT_GRAY);
	contenudroite.setBounds(235, 0, 230, 200);
	content.add(contenudroite);
	contenudroite.setLayout(null);
	
	JTextField Fcmail = new JTextField();
	Fcmail.setBounds(15, 10, 200, 25);
	contenudroite.add(Fcmail);
	Fcmail.setColumns(10);
	
	JPasswordField Fcpassword = new JPasswordField();
	Fcpassword.setBounds(15, 45, 200, 25);
	contenudroite.add(Fcpassword);
	
	JPanel contenubas = new JPanel();
	contenubas.setBackground(Color.DARK_GRAY);
	contenubas.setBounds(0, 213, 465, 175);
	content.add(contenubas);
	contenubas.setLayout(null);
	
	JTextArea ctxt = new JTextArea();
	ctxt.setFont(new Font("Agency FB", Font.PLAIN, 20));
	ctxt.setBackground(Color.DARK_GRAY);
	ctxt.setDisabledTextColor(Color.WHITE);
	ctxt.setForeground(Color.WHITE);
	ctxt.setText("Vos infos ici!!!");
	ctxt.setBounds(10, 11, 444, 151);
	contenubas.add(ctxt);
	
	JButton connection = new JButton("Connection");
	connection.setFont(new Font("Agency FB", Font.PLAIN, 15));
	connection.setBounds(125, 130, 90, 25);
	connection.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ctxt.setText("Email: " +Fcmail.getText()+ "\nPassword: " + (Fcpassword).getPassword().toString());
			UserDao us = new UserDao();
			if (us.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword())) != null) {
					Mainframe.user=us.testlog(Fcmail.getText(),String.valueOf(Fcpassword.getPassword()));
					JOptionPane.showMessageDialog(connection, "Connection ok");
					Mainframe.layer.removeAll();
					ListArticles art = new ListArticles();
					Mainframe.layer.add(art.larticles());
					Mainframe.Titrepage.setText("Liste des articles");
			}
			else { JOptionPane.showMessageDialog(connection, "Mail ou mot de pass erroné");} 
		}
	});
	contenudroite.add(connection);
	return content;
	}
}
