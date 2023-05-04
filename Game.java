/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unogame;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author laila
 */
public class Game {
     private int currPlayer;
    private String[] playerID;
    private Deck deck;
    private ArrayList<ArrayList<unoCards>> playersHand;
    private ArrayList<unoCards> pile;
    private unoCards.cardColor validcolor;
    private unoCards.cardValue validvalue;
    boolean direction;
    
    public Game(String[] IDs){
    deck= new Deck();
    deck.shuffledeck();
    pile = new ArrayList<unoCards>();
    playerID= IDs;
    currPlayer= 0;
    direction = false;
    playersHand = new ArrayList<ArrayList<unoCards>>();
    
    for(int i=0; i < IDs.length; i++){
    ArrayList<unoCards> hand = new ArrayList<unoCards>(Arrays.asList(deck.drawCards(7)));
    playersHand.add(hand);
    }
    }
    public void start(Game game){
    unoCards card = deck.drawCard();
    validcolor = card.getcardColor();
    validvalue= card.getcardValue();
    
    if(card.getcardValue()==unoCards.cardValue.wild){
    start(game);}
    
    if(card.getcardValue() == unoCards.cardValue.wildDrawFour || card.getcardValue() == unoCards.cardValue.drawTwo){
    start(game);}
    
    if(card.getcardValue()==unoCards.cardValue.skip){
    JLabel message = new JLabel(playerID[currPlayer]+" was skipped.");
    message.setFont(new Font("Arial",Font.BOLD,48));
    JOptionPane.showMessageDialog(null, message);
    if(direction == false){
    currPlayer = (currPlayer+1)%playerID.length;}
    else if(direction==true){
        currPlayer = (currPlayer-1)%playerID.length;
    if(currPlayer==-1){
       currPlayer=playerID.length-1; 
    }
    }
    
    }
    if(card.getcardValue() == unoCards.cardValue.reverse){
    JLabel message = new JLabel("The game direction has changed.");
    message.setFont(new Font("Arial",Font.BOLD,48));
    JOptionPane.showMessageDialog(null, message);
    direction ^= true;
    currPlayer = playerID.length -1;}
    pile.add(card);
    }
    public unoCards getTopcard(){
    return new unoCards(validcolor,validvalue);}
    
    public ImageIcon getTopcardImage(){
    return new ImageIcon(validcolor+ "_"+validvalue+ ".png");}
    
    public boolean gameover(){
    for(String player: this.playerID){
    if(hasEmptyHand(player)){
    return true;}
    }
    return false;}
  

    public String getcurrentPlayer(){
    return this.playerID[this.currPlayer];}
    public String getpreviuosPlayer(int i){
    int index = this.currPlayer - i;
    if(index==-1){
    index=playerID.length-1;}
    return this.playerID[index];}
    
    public String[] getplayers(){
    return playerID;}
    
    public ArrayList<unoCards> getplayerhand(String id){
    int index = Arrays.asList(playerID).indexOf(id);
    return playersHand.get(index);}
    
    public int getplayerhandsize(String id){
    return getplayerhand(id).size();}
    
    public unoCards getPlayerCard(String id, int choice){
    ArrayList<unoCards> hand = getplayerhand(id);
    return hand.get(choice);
    }
    
    public boolean hasEmptyHand(String id){
    return getplayerhand(id).isEmpty();}
    
    public boolean validcardplay(unoCards card){
        return card.getcardColor()==validcolor || card.getcardValue()==validvalue;
    }
    public void checkturn(String id) throws InvalidPlayerTurnException{
    if (this.playerID[this.currPlayer] != id){
       throw new InvalidPlayerTurnException("It is not "+ id+ "'s turn.",id); 
    }
}
    public void submitdraw(String id)throws InvalidPlayerTurnException{
        checkturn(id);
        if(deck.isempty()){
        deck.replacedeck(pile);
        deck.shuffledeck();}
        getplayerhand(id).add(deck.drawCard());
        if(direction == false){
            currPlayer = (currPlayer + 1)% playerID.length;
        }
        else if (direction == true){
        currPlayer = (currPlayer -1)%playerID.length;
        if(currPlayer==-1){
        currPlayer = playerID.length-1;}}
    }
    public void setcardcolor(unoCards.cardColor color){
        validcolor=color;
    }
    public void submitplayercard(String id, unoCards card, unoCards.cardColor declaredcolor)
        throws InvalidPlayerTurnException, InvalidColorSubmissionException, InvalidValueSubmissionException{
        checkturn(id);
        ArrayList<unoCards> handp = getplayerhand(id);
        if(validcardplay(card)){
            if(card.getcardColor()==unoCards.cardColor.wild){
                validcolor=card.getcardColor();
                validvalue=card.getcardValue();
            }
            if(card.getcardColor() != validcolor){
              JLabel message = new JLabel("Invalid move, expected color: "+validcolor+" ,but got "+ card.getcardColor());
              message.setFont(new Font("Arial", Font.BOLD,48));
              JOptionPane.showMessageDialog(null,message);
              throw new InvalidColorSubmissionException("Invalid move, expected color: "+validcolor+" ,but got "+ card.getcardColor(), card.getcardColor(), validcolor);
            }
            else if(card.getcardValue() != validvalue){
               JLabel message2 = new JLabel("Invalid move, expected color: "+validvalue+" ,but got "+ card.getcardValue());
               message2.setFont(new Font("Arial", Font.BOLD,48));
                 JOptionPane.showMessageDialog(null,message2);
               throw new InvalidValueSubmissionException("Invalid move, expected color: "+validvalue+" ,but got "+ card.getcardValue(), card.getcardValue(), validvalue);
            }}
         handp.remove(card);
         if(hasEmptyHand(this.playerID[currPlayer])){
             JLabel message2 = new JLabel(this.playerID[currPlayer]+" won the game!");
              message2.setFont(new Font("Arial", Font.BOLD,48));
              JOptionPane.showMessageDialog(null,message2);
             System.exit(0);
         }
         validcolor=card.getcardColor();
         validvalue=card.getcardValue();
         pile.add(card);
         
         if(direction == false){
             currPlayer=(currPlayer + 1)%playerID.length;}
         else if (direction == true){
              currPlayer=(currPlayer - 1)%playerID.length;
                 if(currPlayer == -1){
                     currPlayer = playerID.length -1;
                 }}
         if(card.getcardColor()==unoCards.cardColor.wild){
             validcolor = declaredcolor;
         }
         if(card.getcardValue()==unoCards.cardValue.drawTwo){
             id=playerID[currPlayer];
             getplayerhand(id).add(deck.drawCard());
             getplayerhand(id).add(deck.drawCard());
             JLabel message = new JLabel(id+" drew 2 cards.");
         }
          if(card.getcardValue()==unoCards.cardValue.wildDrawFour){
             id=playerID[currPlayer];
             getplayerhand(id).add(deck.drawCard());
             getplayerhand(id).add(deck.drawCard());
             getplayerhand(id).add(deck.drawCard());
             getplayerhand(id).add(deck.drawCard());
             JLabel message = new JLabel(id+" drew 4 cards.");
         }
           if(card.getcardValue()==unoCards.cardValue.skip){
                JLabel message = new JLabel(playerID[currPlayer]+" was skipped.");
                 message.setFont(new Font("Arial", Font.BOLD,48));
              JOptionPane.showMessageDialog(null,message);
                if(direction == false){
             currPlayer=(currPlayer + 1)%playerID.length;}
         else if (direction == true){
              currPlayer=(currPlayer - 1)%playerID.length;
                 if(currPlayer == -1){
                     currPlayer = playerID.length -1; 
               }
           }
         }
           if(card.getcardValue()==unoCards.cardValue.reverse){
              JLabel message = new JLabel(id+" changed the game direction.");
                message.setFont(new Font("Arial", Font.BOLD,48));
              JOptionPane.showMessageDialog(null,message);
                direction ^= true;
                if(direction==true){
                    currPlayer = (currPlayer -2)%playerID.length;
                    if(currPlayer==-1){
                        currPlayer = playerID.length -1;
                    }
                         if(currPlayer==-2){
                        currPlayer = playerID.length -2;
                }
           }
    
                else if(direction == false){
                    currPlayer=(currPlayer +2)%playerID.length;
                }
 
        
             }

    } }
class InvalidPlayerTurnException extends Exception{
 String playerId;
 public InvalidPlayerTurnException(String message, String id){
     super(message);
     playerId = id;
 }
 public String getID(){
  return playerId;   
 }
}
class InvalidColorSubmissionException extends Exception{
    private unoCards.cardColor expectedcolor;
    private unoCards.cardColor actualcolor;
    
    public InvalidColorSubmissionException(String message, unoCards.cardColor expectedcolor, unoCards.cardColor actualcolor){
        this.actualcolor=actualcolor;
        this.expectedcolor=expectedcolor;
    }
}
class InvalidValueSubmissionException extends Exception{
    private unoCards.cardValue expectedvalue;
    private unoCards.cardValue actualvalue;
    
    public InvalidValueSubmissionException(String message, unoCards.cardValue expectedvalue, unoCards.cardValue actualvalue){
        this.actualvalue=actualvalue;
        this.expectedvalue=expectedvalue;
   
}
}

