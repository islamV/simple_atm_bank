import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame {
    public WelcomePage() {
        setTitle("Welcome to FCI Bank");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Creating components
        JLabel titleLabel = new JLabel("FCI Bank", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        
        JLabel descriptionLabel = new JLabel("Your Trusted Financial Partner", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        ImageIcon bankImage = new ImageIcon("bank_image.png"); // Replace "bank_image.png" with the actual file path of your image
        JLabel imageLabel = new JLabel(bankImage);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 20));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                           dispose(); // Close the window
                Login  ll = new Login() ;
                ll.setVisible(true);
            }
        });
        
        JButton signupButton = new JButton("Signup");
        signupButton.setFont(new Font("Arial", Font.PLAIN, 20));
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                             dispose(); // Close the window
                SignUp  sp = new SignUp() ;
                sp.setVisible(true);
            }
        });
        
        // Adding components to content pane
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(descriptionLabel, BorderLayout.CENTER);
        container.add(imageLabel, BorderLayout.WEST);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        container.add(buttonPanel, BorderLayout.SOUTH);
        
        // Centering the window on the screen
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WelcomePage().setVisible(true);
            }
        });
    }
}
