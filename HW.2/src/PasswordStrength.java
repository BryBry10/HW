import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Bryan Martinez
 * @version 1.0
 * In the Password Strength App, users will be prompted to check their password strength. Password blocks
 * (adjacent characters that are exactly the same) are counted and the output gives the user a 
 * recommended change. 
 */

public class PasswordStrength {

    private JFrame frame;
    private JTextField txtInput;
    private JTextArea txtArea;
    private PasswordStrengthChecker checker;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PasswordStrength window = new PasswordStrength();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * This creates the public application PasswordStrength()
     */
    public PasswordStrength() {
        checker = new PasswordStrengthChecker();
        initialize();
    }

    /**
     * All the frame contents. Labels, text areas, text lines, etc.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter Password (8-12 characters):");
        lblNewLabel.setBounds(10, 11, 234, 14);
        frame.getContentPane().add(lblNewLabel);

        txtInput = new JTextField();
        txtInput.setBounds(254, 6, 170, 25);
        frame.getContentPane().add(txtInput);
        txtInput.setColumns(10);

        JButton btnCheck = new JButton("Generate");
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPasswordStrength();
            }
        });
        btnCheck.setBounds(131, 42, 89, 23);
        frame.getContentPane().add(btnCheck);

        txtArea = new JTextArea();
        txtArea.setBounds(20, 76, 404, 174);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBounds(20, 76, 404, 174);
        frame.getContentPane().add(scrollPane);
    }

    /**
     * This is the method called to check the password strength.
     * Password string is developed from textField entry using the getText()
     * Result string is developed from the checkPasswordStrength(password) return
     */
    private void checkPasswordStrength() {
        String password = txtInput.getText().trim();
        String result = checker.checkPasswordStrength(password);
        txtArea.setText(result);
    }

    /**
     * Checking Password Strength method
     * @author Bryan Martinez
     *
     */
    private static class PasswordStrengthChecker {

        /**
         * Number of blocks is what determines the password's strength
         * @param password
         * @return A message about the password strength.
         */
        public String checkPasswordStrength(String password) {
            if (password.length() < 8 || password.length() > 12) {
                return "Error: Password is not 8-12 characters long.";
            }
            if (password.contains(" ")) {
                return "Error: Password can't have any spaces.";
            }

            int largestBlock = findLargestBlock(password);
            if (largestBlock > 2) {
                int tryReducing = largestBlock - 2;
                return "The largest block in the password is " + largestBlock
                        + ". This password can be made stronger by reducing this block by " + tryReducing + ".";
            } else {
                return "The largest block in the password is " + largestBlock + ". This is a decent password.";
            }
        }

        /**
         * Finds the largest block in password.
         * @param password The password to analyze.
         * @return The length of the largest block.
         */
        private int findLargestBlock(String password) {
            int maxBlock = 1, currentBlock = 1;
            for (int i = 1; i < password.length(); i++) {
                if (password.charAt(i) == password.charAt(i - 1)) {
                    currentBlock++;
                } else {
                    maxBlock = Math.max(maxBlock, currentBlock);
                    currentBlock = 1;
                }
            }
            return Math.max(maxBlock, currentBlock);
        }
    }
}
