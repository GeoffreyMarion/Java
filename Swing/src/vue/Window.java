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

public class Window extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\75013-46-15\\Desktop\\Java\\Swing\\src\\images\\Icon.png"));
		setTitle("Titre");
		setFont(new Font("Agency FB", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 169, 99, 281);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(375, 169, 99, 281);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(119, 11, 246, 206);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 11, 99, 147);
		contentPane.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.DARK_GRAY);
		panel_3_1.setBounds(375, 11, 99, 147);
		contentPane.add(panel_3_1);*/
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBounds(119, 303, 246, 144);
		contentPane.add(layeredPane);
		
		JPanel accueilc = new JPanel();
		accueilc.setBounds(0, 0, 247, 147);
		accueilc.setBackground(Color.red);
		layeredPane.setLayer(accueilc, 1);
		layeredPane.add(accueilc);
		
		JPanel contactc = new JPanel();
		contactc.setBackground(Color.pink);
		contactc.setBounds(0, 0, 247, 147);
		layeredPane.setLayer(contactc, 2);
		
		JPanel aproposc = new JPanel();
		aproposc.setBackground(Color.blue);
		aproposc.setBounds(0, 0, 247, 147);
		layeredPane.setLayer(aproposc, 3);
		
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.DARK_GRAY);
		menu.setBounds(119, 228, 246, 64);
		contentPane.add(menu);
		menu.setLayout(new GridLayout(1, 0, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 12));
		menuBar.setBackground(Color.DARK_GRAY);
		menu.add(menuBar);
		
		JMenuItem accueil = new JMenuItem("Accueil");
		accueil.setMargin(new Insets(2, 2, 2, 0));
		accueil.setFont(new Font("Papyrus", Font.PLAIN, 12));
		accueil.setBackground(Color.orange);
		accueil.setMinimumSize(new Dimension(90, 0));
		accueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changecontenu(layeredPane,accueilc);
			}
		});
		menuBar.add(accueil);
		
		JMenuItem contact = new JMenuItem("Contact");
		contact.setMinimumSize(new Dimension(100, 0));
		contact.setBackground(Color.orange);
		contact.setMargin(new Insets(2, 0, 2, 0));
		contact.setFont(new Font("Papyrus", Font.PLAIN, 12));
		contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changecontenu(layeredPane,contactc);
			}
		});
		menuBar.add(contact);
		
		JMenuItem apropos = new JMenuItem("A propos");
		apropos.setMinimumSize(new Dimension(100, 0));
		apropos.setBackground(Color.orange);
		apropos.setMargin(new Insets(2, 0, 2, 0));
		apropos.setFont(new Font("Papyrus", Font.PLAIN, 12));
		apropos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changecontenu(layeredPane,aproposc);
			}
		});
		menuBar.add(apropos);
	}
	public void changecontenu(JLayeredPane panel,JPanel contenu) {
		panel.removeAll();
		panel.add(contenu);
		panel.repaint();
		panel.revalidate();
	}
}
