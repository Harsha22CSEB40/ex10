import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author 22cseb40
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          final JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        final JTextField firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        final JTextField lastNameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        final JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        final JPasswordField passwordField = new JPasswordField(20);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        final JPasswordField confirmPasswordField = new JPasswordField(20);

        final JCheckBox acceptTermsCheckBox = new JCheckBox("I accept the terms and conditions");

        JButton registerButton = new JButton("Register");
        JButton signInButton = new JButton("Already have an account? Sign in");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();
                boolean acceptTerms = acceptTermsCheckBox.isSelected();

                if (acceptTerms) {
                    if (isPasswordMatch(password, confirmPassword)) {
                        // Registration logic here, e.g., save the data to a database.
                        JOptionPane.showMessageDialog(frame, "Registration Successful!\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email, "Registration Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Passwords do not match. Please try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please accept the terms and conditions to register.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code to handle the "Already have an account? Sign in" action.
                JOptionPane.showMessageDialog(frame, "Redirect to Sign-In Page.", "Sign In", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(acceptTermsCheckBox);
        panel.add(new JLabel("")); // Empty label for spacing
        panel.add(registerButton);
        panel.add(signInButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static boolean isPasswordMatch(char[] password, char[] confirmPassword) {
        return new String(password).equals(new String(confirmPassword));
    }
}
