import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class balanceframe extends JFrame {
    private JLabel salaryLabel;
    private JButton okButton;

    public balanceframe(User u) {
        setTitle("Salary Information");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int rectWidth = 400; // Rectangle width
                int rectHeight = 200; // Rectangle height
                int rectX = (getWidth() - rectWidth) / 2; // X-coordinate of top-left corner of rectangle
                int rectY = (getHeight() - rectHeight) / 2; // Y-coordinate of top-left corner of rectangle

                g.drawRect(rectX, rectY, rectWidth, rectHeight);

                Font font = new Font("Arial", Font.BOLD, 20); // Define font
                g.setFont(font);
                g.drawString("Salary: ", rectX + 120, rectY + 100); // Draw "Salary:" text inside the rectangle
                g.drawString(String.valueOf(u.balance()), rectX + 185, rectY + 100); // Draw salary inside the rectangle
            }
        };

        okButton = new JButton(" Back");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new options(u).setVisible(true);
            }
        });

        panel.setLayout(new BorderLayout());
        panel.add(okButton, BorderLayout.SOUTH); // Add button to the bottom
        add(panel);

        // Centering the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        setVisible(true);
    }

    public balanceframe() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new balanceframe();
            }
        });
    }
}
