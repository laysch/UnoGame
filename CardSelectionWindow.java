/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uno;

import java.util.ArrayList;
import javax.swing.JButton;
import java.util.logging.Level;
import java.util.logging.Logger;        
        

/**
 *
 * @author laila
 */
public class CardSelectionWindow extends javax.swing.JFrame {

    String cardImage = "";
    Game game;
    ArrayList<UnoCard>playerHand;
    int choice; 
    ArrayList<JButton>cardButtons;
    GameStage gameStage;
    JButton topCardButton;
    UnoCard.Color declaredColor;
    
    public CardSelectionWindow(){}
    
    public CardSelectionWindow(String cardName, Game game, int index, ArrayList<JButton> cardButtons, GameStage gamestage, JButton topCardButton) {
        initComponents();
        cardImage = cardName;
        this.game = game;
        playerHand = game.getPlayerHand(game.getCurrentPlayer());
        this.cardButtons = cardButtons;
        cardLabel.setIcon(new javax.swing.ImageIcon(("/com/mycompany/uno/imagesA/small/" + cardImage + ".png")));
        this.gameStage = gamestage;
        this.topCardButton = topCardButton;
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
        useCardButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cardLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        useCardButton.setFont(new java.awt.Font("Tamil MN", 0, 24)); // NOI18N
        useCardButton.setText("use card");
        useCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useCardButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tamil MN", 0, 24)); // NOI18N
        cancelButton.setText("cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(useCardButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(cardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(cardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(useCardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void useCardButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        PickColorFrame pickColor = new PickColorFrame(this);
        declaredColor = pickColor.choseColor(playerHand.get(choice));
        if (declaredColor != null){
            try {
                game.submitPlayerCard(game.getCurrentPlayer(), playerHand.get(choice),declaredColor);
  
            }
            catch (InvalidColorSubmissionException | InvalidValueSubmissionException | InvalidPlayerTurnException ex){
                Logger.getLogger(CardSelectionWindow.class.getName()).log(Level.SEVERE,null,ex);
            }
               this.revalidate();
            if(declaredColor != UnoCard.Color.Wild){
                gameStage.setPidName(game.getCurrentPlayer());
                gameStage.setButtonIcons();
                topCardButton.setIcon(new javax.swing.ImageIcon(("/Users/laila/Desktop/images/small/" + game.getTopCardImage())));
                this.dispose();
            }
        }
    }                                             

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
       this.dispose();
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
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardSelectionWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cardLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton useCardButton;
    // End of variables declaration                   
}

