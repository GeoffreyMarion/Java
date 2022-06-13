package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 169, 99, 281);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(375, 169, 99, 281);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(119, 11, 246, 206);
		contentPane.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.DARK_GRAY);
		panel_2_1.setBounds(119, 303, 246, 147);
		contentPane.add(panel_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 11, 99, 147);
		contentPane.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.DARK_GRAY);
		panel_3_1.setBounds(375, 11, 99, 147);
		contentPane.add(panel_3_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.DARK_GRAY);
		panel_2_2.setBounds(119, 228, 246, 64);
		contentPane.add(panel_2_2);
		panel_2_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		panel_2_2.add(menuBar);
		
		JMenuItem attaquer = new JMenuItem("Attaquer");
		attaquer.setMinimumSize(new Dimension(100, 0));
		attaquer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		menuBar.add(attaquer);
		JMenuItem changer = new JMenuItem("Changer d'arme");
		changer.setMinimumSize(new Dimension(100, 0));
		menuBar.add(changer);
	}
}
