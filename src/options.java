/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author islam
 */
import javax.swing.*;
import java.awt.event.*;

public class options extends JFrame {
 private  User user;
   public options(User user) {
       this.user=  user ;
        initComponents();
    }
    public options() {
         
        initComponents();
//        System.out.println(getUser().getId()) ;
    }


    private void initComponents() {

        withdrawalBtn = new javax.swing.JButton();
        depositBtn = new javax.swing.JButton();
        balanceBtn = new javax.swing.JButton();
        label1 = new java.awt.Label();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Options ");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(357, 100, 0, 0));
//        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);

        withdrawalBtn.setBackground(new java.awt.Color(255, 102, 0));
        withdrawalBtn.setText("Withdrawal");
        withdrawalBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        withdrawalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawalBtnActionPerformed(evt);
            }
        });

        depositBtn.setBackground(new java.awt.Color(255, 102, 0));
        depositBtn.setText("Deposit");
        depositBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        depositBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositBtnActionPerformed(evt);
            }
        });

        balanceBtn.setBackground(new java.awt.Color(255, 102, 0));
        balanceBtn.setText("Balance Inquiry");
        balanceBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        balanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceBtnActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 102, 0));
        label1.setText("Welcome " + this.user.getName() +" to FCI Bank");
        Back.setBackground(new java.awt.Color(255, 102, 0));
        Back.setText("Close");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(withdrawalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(balanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(depositBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(withdrawalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(162, 162, 162)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(balanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(227, Short.MAX_VALUE))
        );

        pack();
    }                  

    private void withdrawalBtnActionPerformed(java.awt.event.ActionEvent evt) {
  
        new Withdrawal(this.user).setVisible(true);
             this.dispose();
    }

    private void balanceBtnActionPerformed(java.awt.event.ActionEvent evt) {
     
          new balanceframe(this.user).setVisible(true);
          this.dispose();
    }

    private void depositBtnActionPerformed(java.awt.event.ActionEvent evt) {
      new Depostit(this.user).setVisible(true);
                this.dispose();
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Back;
    private javax.swing.JButton balanceBtn;
    private javax.swing.JButton depositBtn;
    private java.awt.Label label1;
    private javax.swing.JButton withdrawalBtn;
    // End of variables declaration            

   

}
