package vue;

import java.awt.*;
import javax.swing.*;

public class mainvue {

	public static void main(String[] args) {
		// on cr�e une fen�tre dont le titre est "Titre"
        JFrame frame = new JFrame("Titre");
        // on fixe la taille de la fenetre
        frame.setSize(500,400);
        // la fen�tre doit se fermer quand on clique sur la croix rouge
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon image = new ImageIcon(mainvue.class.getResource("/images/Icon.png"));
        frame.setIconImage(image.getImage());
        // on ajoute le texte "Hello, World!" dans la fen�tre
        JPanel panel = (JPanel)frame.getContentPane();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel ("Hello World!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        JButton button = new JButton("clique");
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBackground(Color.gray);
        button.setFont(new Font("Arial", Font.PLAIN, 10));
        panel.add(button);
        label.setFont(new Font("Agency FB", Font.PLAIN, 50));
        // on passe le background du pane en route
        frame.getContentPane().setBackground(Color.orange);
        JTextArea text = new JTextArea(2,10);
        panel.add(text);
        JLabel label2 = new JLabel ("End of the world");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(label2);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        // on centre la fen�tre
        frame.setLocationRelativeTo(null);
        // on rend la fen�tre visible
        frame.setVisible(true);
	}

}
