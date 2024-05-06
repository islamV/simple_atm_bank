
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField cardField;
    private JPasswordField passwordField;
    private JButton loginButton, closeButton;

    public Login() {
        super("Login");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Username Label
        usernameLabel = new JLabel("Card  number: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(usernameLabel, constraints);

        // Username Field
        cardField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(cardField, constraints);

        // Password Label
        passwordLabel = new JLabel("Password: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(passwordLabel, constraints);

        // Password Field
        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(passwordField, constraints);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(loginButton, constraints);

        // Close Button
        closeButton = new JButton("Back");
        closeButton.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(closeButton, constraints);

        // Set frame size
        setSize(800, 600);

        // Center the frame on screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            User user = new User();
            try {
                User userData = user.findUserData(cardField.getText());

              if (  userData !=  null && passwordField.getText().equals(userData.getPassword())) {
              
                options o=  new options(userData) ;
               
         o.setVisible(true);
                   this.dispose();
                } else {
                 JOptionPane.showMessageDialog(this, "card number or password  not currect");
                }

            } catch (Exception ee) {
                System.out.println("Exception: " + ee.getMessage());
            }
        } else if (e.getSource() == closeButton) {
            this.dispose();
            WelcomePage wp = new WelcomePage();
            wp.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
