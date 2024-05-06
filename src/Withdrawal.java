

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Withdrawal extends JFrame {
    private JLabel amountLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton Backbtn; // New button for closing the window
    private User user ;

    public Withdrawal() {
        setTitle("Withdrawal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addComponents();
        setSize(800, 400); // Set the size to 800x400 pixels
        setLocationRelativeTo(null);
        setVisible(true);
    }
     public Withdrawal(User user) {
          setTitle("Withdrawal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addComponents();
        setSize(800, 400); // Set the size to 800x400 pixels
        setLocationRelativeTo(null);
        setVisible(true);
         
      this.user = user; 
//  JOptionPane.showMessageDialog(this, this.user.getName());
    }


    private void initComponents() {
        amountLabel = new JLabel("Enter Amount to Withdraw:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set font, size, and style
        withdrawButton.setBackground(new Color(0, 153, 204)); // Set background color
        withdrawButton.setForeground(Color.WHITE); // Set text color
        withdrawButton.setFocusPainted(false); // Remove focus border
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performWithdrawal();
            }
        });
        
        Backbtn = new JButton("Back"); // Create a new button named "Close"
        Backbtn.setFont(new Font("Arial", Font.BOLD, 18)); // Set font, size, and style
        Backbtn.setBackground(Color.ORANGE); // Set background color
        Backbtn.setForeground(Color.WHITE); // Set text color
        Backbtn.setFocusPainted(false); // Remove focus border
        Backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
               new options().setVisible(true);
            }
        });
    }

    private void addComponents() {
        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Add spacing between components
        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(withdrawButton);
        buttonPanel.add(Backbtn); // Add the Close button

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void performWithdrawal() {
        String amountText = amountField.getText();
        try {
            double amount = Double.parseDouble(amountText);
            this.user.withdrawal(amount);
            JOptionPane.showMessageDialog(this, "Withdrawal of $" + amount + " successful.");
            amountField.setText("");
            new options(this.user).setVisible(true);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Withdrawal().setVisible(true);
            }
        });
    }
}
