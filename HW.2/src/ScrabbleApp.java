import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;



public class ScrabbleApp {

	private JFrame frame;
	private JTextField txtEnterWord;
	private JButton txtButton;
	private JTextArea txtOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleApp window = new ScrabbleApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScrabbleApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScrabbleApp = new JLabel("Scrabble App");
		lblScrabbleApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblScrabbleApp.setBounds(0, 11, 434, 14);
		frame.getContentPane().add(lblScrabbleApp);
		
		txtEnterWord = new JTextField();
		txtEnterWord.setBounds(43, 91, 264, 20);
		frame.getContentPane().add(txtEnterWord);
		txtEnterWord.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Word:");
		lblNewLabel_1.setBounds(43, 66, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnButton = new JButton("Scrabble");
		btnButton.setBounds(43, 138, 89, 23);
		frame.getContentPane().add(btnButton);
		
		JTextArea textOutput = new JTextArea();
		textOutput.setBounds(43, 172, 341, 62);
		frame.getContentPane().add(textOutput);
		
		btnButton.addActionListener(new ActionListener() {
			
			
		});
	}
	
	
}
