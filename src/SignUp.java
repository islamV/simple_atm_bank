import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUp extends JFrame implements ActionListener {

    private JLabel nameLabel, cardLabel, passwordLabel;
    private JTextField nameField,  cardField;
    private JPasswordField passwordField;
    private JButton signUpButton, closeButton;
       


    public SignUp() {
        super("Sign Up");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

      // Name Label and Field
nameLabel = new JLabel("Name: ");
constraints.gridx = 0;
constraints.gridy = 0;
add(nameLabel, constraints);

nameField = new JTextField(20);
constraints.gridx = 1;
constraints.gridy = 0;
add(nameField, constraints);

// Phone Number Label and Field
cardLabel = new JLabel("Card Number: ");
constraints.gridy++; // Move to the next row
constraints.gridx = 0; // Reset to the first column
add(cardLabel, constraints);

cardField = new JTextField(20);
constraints.gridx = 1;
constraints.gridy = constraints.gridy; // Stay on the same row
add(cardField, constraints);

// Password Label and Field
passwordLabel = new JLabel("Password: ");
constraints.gridy++; // Move to the next row
constraints.gridx = 0; // Reset to the first column
add(passwordLabel, constraints);

passwordField = new JPasswordField(20);
constraints.gridx = 1;
constraints.gridy = constraints.gridy; // Stay on the same row
add(passwordField, constraints);

// To convert JTextField content to String
String name = nameField.getText();
String phone = cardField.getText();

// To convert JPasswordField content to String
//char[] passwordChars = passwordField.getPassword();
//String password = new String(passwordChars);

        // Add some space between password and buttons
        constraints.gridy++; // Move to next row
        add(new JLabel(""), constraints); // Empty label for spacing

        // Sign Up Button
        signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = constraints.gridy; // Stay on same row
        add(signUpButton, constraints);

        // Close Button
        closeButton = new JButton("Back");
        closeButton.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = constraints.gridy; // Stay on same row
        add(closeButton, constraints);

        // Set frame size
        setSize(800, 600);

        // Center the frame on screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            try{
                 User user = new User(nameField.getText() ,cardField.getText() , passwordField.getText()) ;
                user.create();  
              new balance(user.findUserData(cardField.getText()).getId() , 0.0).create();
                JOptionPane.showMessageDialog(this, "User created successfully");
              this.dispose();
              WelcomePage wp  = new WelcomePage() ;
              wp.setVisible(true);
                    
                  
            } catch (Exception ee) {
            System.out.println("Exception: " + ee.getMessage()); 
            }
      
//            JOptionPane.showMessageDialog(this, "Sign Up Button Clicked!");
        } else if (e.getSource() == closeButton) {
             this.dispose();
              WelcomePage wp  = new WelcomePage() ;
              wp.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
