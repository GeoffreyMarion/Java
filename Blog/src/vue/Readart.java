package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import controller.ArticleDao;
import controller.UserDao;

public class Readart {
	JPanel content;
	public JPanel read() {
		content = new JPanel();
		content.setBounds(0, 0, 465, 390);
		content.setLayout(null);
		
		JPanel contenuhaut = new JPanel();
		contenuhaut.setBackground(Color.GRAY);
		contenuhaut.setBounds(0, 0, 465, 200);
		content.add(contenuhaut);
		contenuhaut.setLayout(null);

		JScrollPane scrollg = new JScrollPane();
		scrollg.setBounds(0, 0, 465, 200);
		contenuhaut.add(scrollg);
		
		ArticleDao articleDao = new ArticleDao();
		articleDao.read();

		String[] columnNames = { "id", "titre", "resume", "date", "auteur" };

		JTable tarticle = new JTable(null, columnNames);
		tarticle.setBounds(0, 0, 450, 200);
		scrollg.add(tarticle);

		scrollg.setViewportView(tarticle);
		
		tarticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = tarticle.getSelectedRow();
				
				int article_id = (int) tarticle.getModel().getValueAt(id, 0);
				System.out.println(article_id);
			}
			
			
		});
		tarticle.setModel(liste());
		TableColumnModel mtarticle = tarticle.getColumnModel();
		mtarticle.getColumn(0).setPreferredWidth(25);
		mtarticle.getColumn(1).setPreferredWidth(120);
		mtarticle.getColumn(2).setPreferredWidth(135);
		mtarticle.getColumn(3).setPreferredWidth(75);
		mtarticle.getColumn(4).setPreferredWidth(75);

		JPanel contenubas = new JPanel();
		contenubas.setBackground(Color.DARK_GRAY);
		contenubas.setBounds(0, 210, 465, 180);
		content.add(contenubas);
		contenubas.setLayout(null);

		JScrollPane scrollb = new JScrollPane();
		scrollb.setBounds(0, 210, 465, 180);
		contenubas.add(scrollb);
		
		JButton list = new JButton("list");
		list.setFont(new Font("Agency FB", Font.PLAIN, 15));
		list.setBounds(125, 130, 90, 25);
		list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao us = new UserDao();
				if (tarticle.getSelectionModel().isSelectionEmpty()) {
						JOptionPane.showMessageDialog(list, "Connection ok");
						Mainframe.layer.removeAll();
						ListArticles art = new ListArticles();
						Mainframe.layer.add(art.larticles());
						Mainframe.Titrepage.setText("Bienvenu "+Mainframe.Fprenom.getText()+"");
				}
				else { JOptionPane.showMessageDialog(list, "Mail ou mot de pass erroné");} 
			}
		});
		contenubas.add(list);
		return content;
	}
	
}
