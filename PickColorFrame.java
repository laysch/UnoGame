/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uno;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author laila
 */
public class PickColorFrame extends javax.swing.JFrame {

    private UnoCard.Color wildColor = null;
    Boolean allow = false;
    CardSelectionWindow popUp;
    
    public PickColorFrame() {
        initComponents();
    }
    
    public PickColorFrame(CardSelectionWindow pop){
        initComponents();
        popUp = pop;
    }
    
    /**
     *
     * @param card
     * @return
     */
    public UnoCard.Color choseColor(UnoCard card){
        if(card.getColor() == UnoCard.Color.Wild){
            this.setVisible(true);
            this.setResizable(false);
            this.setBounds(100,150,600,700);
            
        } return card.getColor();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        redButton = new javax.swing.JToggleButton();
        blueButton = new javax.swing.JToggleButton();
        greenButton = new javax.swing.JToggleButton();
        yellowButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tamil MN", 0, 24)); // NOI18N
        jLabel1.setText("pick the color of your wild card");

        redButton.setBackground(new java.awt.Color(204, 51, 0));
        redButton.setFont(new java.awt.Font("Tamil MN", 0, 14)); // NOI18N
        redButton.setText("Red");
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        blueButton.setBackground(new java.awt.Color(0, 51, 255));
        blueButton.setFont(new java.awt.Font("Tamil MN", 0, 14)); // NOI18N
        blueButton.setText("Blue");
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        greenButton.setBackground(new java.awt.Color(51, 204, 0));
        greenButton.setFont(new java.awt.Font("Tamil MN", 0, 14)); // NOI18N
        greenButton.setText("Green");
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        yellowButton.setBackground(new java.awt.Color(255, 255, 0));
        yellowButton.setFont(new java.awt.Font("Tamil MN", 0, 14)); // NOI18N
        yellowButton.setText("Yellow");
        yellowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(redButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(greenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yellowButton, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(198, 198, 198))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(redButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(greenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(yellowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        wildColor = UnoCard.Color.Red;
        JLabel message = new JLabel("The Wild Card Color is Red!");
        message.setFont(new Font("Poppins",Font.BOLD,48));
        JOptionPane.showMessageDialog(null,message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Red;
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(("/Users/laila/Desktop/images/small/" + popUp.game.getTopCardImage())));
       popUp.game.setCardColor(UnoCard.Color.Red);
       popUp.dispose();
    }                                         

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        wildColor = UnoCard.Color.Blue;
        JLabel message = new JLabel("The Wild Card Color is Blue!");
        message.setFont(new Font("Poppins",Font.BOLD,48));
        JOptionPane.showMessageDialog(null,message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Blue;
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(("/Users/laila/Desktop/images/small/" + popUp.game.getTopCardImage())));
       popUp.game.setCardColor(UnoCard.Color.Blue);
       popUp.dispose();
    }                                          

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
         wildColor = UnoCard.Color.Green;
        JLabel message = new JLabel("The Wild Card Color is Green!");
        message.setFont(new Font("Poppins",Font.BOLD,48));
        JOptionPane.showMessageDialog(null,message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Green;
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(("/Users/laila/Desktop/images/small/" + popUp.game.getTopCardImage())));
       popUp.game.setCardColor(UnoCard.Color.Green);
       popUp.dispose();
    }                                           

    private void yellowButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
         wildColor = UnoCard.Color.Yellow;
        JLabel message = new JLabel("The Wild Card Color is Yellow!");
        message.setFont(new Font("Poppins",Font.BOLD,48));
        JOptionPane.showMessageDialog(null,message);
        allow = true;
        this.dispose();
        popUp.declaredColor = UnoCard.Color.Yellow;
        popUp.gameStage.setPidName(popUp.game.getCurrentPlayer());
        popUp.gameStage.setButtonIcons();
        popUp.topCardButton.setIcon(new javax.swing.ImageIcon(("/Users/laila/Desktop/images/small/" + popUp.game.getTopCardImage())));
       popUp.game.setCardColor(UnoCard.Color.Yellow);
       popUp.dispose();
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PickColorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PickColorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton blueButton;
    private javax.swing.JToggleButton greenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton redButton;
    private javax.swing.JToggleButton yellowButton;
    // End of variables declaration                   
}
