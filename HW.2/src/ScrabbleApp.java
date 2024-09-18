import javax.swing.*;
import java.awt.EventQueue;
import java.util.*;
 
/**

* @author Bryan Martinez
* @version 1.0
* In the Scrabble App, a user will be able to input any word as long as it is seven 
* letters. Once the user clicks the scrabble button, all the permutations for that 
* word will be demonstrated.
*/

public class ScrabbleApp {

	private JFrame frame;
	private JTextField txtInput;
	private JTextArea textOutput;
	private JButton btnScrabble;
 
	/**
	 * Launch the application.
	 * @param args Unused.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			try {
				ScrabbleApp window = new ScrabbleApp();
				window.frame.setVisible(true);
			} catch (Exception e) {

				e.printStackTrace();
			}
		});
	}
 
	/**
	 * Constructor and GUI initialized.
	 * @wbp.parser.entryPoint
	 */

	public ScrabbleApp() {

		initialize();

	}
 
	/**
	 * Initialize the frame and all of the components. (Labels, buttons, texts, etc)
	 */

	private void initialize() {

		frame = new JFrame("Scrabble Tile Permutations");
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblEnter = new JLabel("Enter 7 Scrabble tiles:");
		lblEnter.setBounds(10, 44, 150, 25);
		frame.getContentPane().add(lblEnter);
		txtInput = new JTextField();
		txtInput.setBounds(162, 44, 200, 25);
		frame.getContentPane().add(txtInput);
		txtInput.setColumns(10);
		JButton btnScrabble = new JButton("Scrabble");
		btnScrabble.setBounds(133, 105, 100, 25);
		btnScrabble.addActionListener(e -> generatePermutations());
		frame.getContentPane().add(btnScrabble);
		textOutput = new JTextArea();
		textOutput.setBounds(10, 141, 364, 97);
		frame.getContentPane().add(textOutput);

	}
 
	/**

	 *Method used to create all of the permutations

	 */

	private void generatePermutations() {

		String input = txtInput.getText().trim();

		textOutput.setText("");
 
		if (input.length() != 7) {
			textOutput.setText("Error: Has to be exactly 7 leters.");
			
			return;

		}

		if (!input.matches("[a-zA-Z]+")) {
			textOutput.setText("Error: Only alphabet letters eligible.");

			return;
		}
 
		List<String> permutations = new ArrayList<>();
		permute(input.toCharArray(), 0, permutations);
		textOutput.append("Permutations:\n");

		for (String perm : permutations) {
			textOutput.append(perm + "\n");

		}

	}
 
	/**
	 * Recursively generate all permutations of a given character array.

	 * @param arr     The character array to permute.
	 * @param index   Index for recurssion.
	 * @param results The list to hold all of the permutations.
	 */

	private void permute(char[] arr, int index, List<String> results) {

		if (index == arr.length - 1) {
			results.add(new String(arr));

			return;
		}

		for (int i = index; i < arr.length; i++) {
			swap(arr, i, index);
			permute(arr, index + 1, results);
			swap(arr, i, index);

		}

	}
 
	/**

	 * Swaps two elements in a character array.
	 * @param arr The character array.
	 * @param i   The first index.
	 * @param j   The second index.

	 */

	private void swap(char[] arr, int i, int j) {

		char temp = arr[i];

		arr[i] = arr[j];

		arr[j] = temp;

	}

}

 