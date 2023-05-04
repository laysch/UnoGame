/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unogame;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author laila
 */
public class Deck {
  //array of cards
    private unoCards[] cards;
    private int numOfcards;

public Deck(){
    //add 108 cards to deck
cards = new unoCards[108]; 
deckReset();}

public void deckReset(){
unoCards.cardColor[] cardscolor = unoCards.cardColor.values();
numOfcards = 0;
int i,j;
//make 0 cards
for(i=0;i<cardscolor.length-1;i++){
unoCards.cardColor color = cardscolor[i];
cards[numOfcards++]= new unoCards(color, unoCards.cardValue.getcardValue(0));
//make cards 1-9, 2 of each color
for(j=1;j<10;j++){
cards[numOfcards++]=new unoCards(color, unoCards.cardValue.getcardValue(j));
cards[numOfcards++]=new unoCards(color, unoCards.cardValue.getcardValue(j));}
//make special cards
unoCards.cardValue[] cardsvalue = new unoCards.cardValue[]{unoCards.cardValue.drawTwo,unoCards.cardValue.reverse,unoCards.cardValue.skip};
for(unoCards.cardValue value: cardsvalue){
cards[numOfcards++]=new unoCards(color, value);
cards[numOfcards++]=new unoCards(color,value);}
}
//make wild and wilddraw4 cards
unoCards.cardValue[] cardsvalue = new unoCards.cardValue[]{unoCards.cardValue.wildDrawFour,unoCards.cardValue.wild};
for(unoCards.cardValue value: cardsvalue){
for(i=0;i<4;i++){
    cards[numOfcards++]=new unoCards(unoCards.cardColor.wild, value);}}
}
//replace deck with stock
public void replacedeck(ArrayList<unoCards> cards){
    this.cards=cards.toArray(new unoCards[cards.size()]);
    this.numOfcards=this.cards.length;
}
//true if no cards in deck
public boolean isempty(){
return numOfcards==0;}

public void shuffledeck(){
int c = cards.length;
Random random = new Random();
for(int i=0;i<cards.length;i++){
int randomvalue = i + random.nextInt(c-i);
unoCards randomcard = cards[randomvalue];
cards[randomvalue]=cards[i];
cards[i]=randomcard;
}}
public unoCards drawCard() {
if(isempty()){
throw new IllegalArgumentException("No cards in deck.");}
return cards[numOfcards];}

public ImageIcon drawCardImage() throws IllegalArgumentException{
if(isempty()){
throw new IllegalArgumentException("Can't draw card, deck is empty.");}
return new ImageIcon(cards[numOfcards].tostring()+".png");}

public unoCards[] drawCards(int n){
if(n<0){
throw new IllegalArgumentException("Can't draw "+n+"cards.");}
if(n>numOfcards){
throw new IllegalArgumentException("Can't draw "+n+"cards. There are only "+numOfcards+"in deck.");
}
unoCards[] Return = new unoCards[n];
for(int i = 0;i<n;i++){
Return[i]=cards[numOfcards];}
return Return;
}  
}
