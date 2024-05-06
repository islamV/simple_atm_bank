

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Depostit extends JFrame {
    private JLabel amountLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton Backbtn; // New button for closing the window
    private User user ;
    public Depostit() {
        setTitle("Deposit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addComponents();
        setSize(800, 400); // Set the size to 800x400 pixels
        setLocationRelativeTo(null);
        setVisible(true);
    }
     public Depostit(User u) {
        setTitle("Deposit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        addComponents();
        setSize(800, 400); // Set the size to 800x400 pixels
        setLocationRelativeTo(null);
        setVisible(true);
        this.user =  u;
    }
    

    private void initComponents() {
        amountLabel = new JLabel("Enter Amount to Depostit:");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font and size
        withdrawButton = new JButton("Depostit");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set font, size, and style
        withdrawButton.setBackground(new Color(0, 153, 204)); // Set background color
        withdrawButton.setForeground(Color.WHITE); // Set text color
        withdrawButton.setFocusPainted(false); // Remove focus border
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performDeposit();
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

                 new options(user).setVisible(true);
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

    private void performDeposit() {
        String amountText = amountField.getText();
        try {
            double amount = Double.parseDouble(amountText);
                    

            if(amount > this.user.balance()){
                JOptionPane.showMessageDialog(this, "Your balance not allow to deposit this amount");
            }else{
               double a = this.user.balance()- amount;
               this.user.deposit(a);
                           JOptionPane.showMessageDialog(this, "Deposit of $" + amount + " successful.");            
                       new options(this.user).setVisible(true);
                       this.dispose();
            }
            
//        new balance(this.user.getId(), amount).update(this.user.getId());
            amountField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Depostit().setVisible(true);
            }
        });
    }
}
