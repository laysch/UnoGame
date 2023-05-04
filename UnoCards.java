/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unogame;

/**
 *
 * @author laila
 */
public class unoCards {
       //color and value cant change
   private final cardColor color;
   private final cardValue value;
   
public unoCards(cardColor color, cardValue value){
   this.color=color;
   this.value=value;}
//get attributes
public cardColor getcardColor(){
return this.color;}

public cardValue getcardValue(){
return this.value;}

public String tostring(){
return color + "_" + value;}
   
enum cardColor{
  red,yellow,blue,green,wild;
  //array cardscolor with cardColor values
  public static final cardColor[] cardscolor = cardColor.values();
  //return value in array
  public static cardColor getcardColor(int i){
  return cardColor.cardscolor[i];}
  
 }
  enum cardValue{
  zero,one,two,three,four,five,six,seven,eight,nine,skip,drawTwo,wildDrawFour,wild,reverse;
  public static final cardValue[] cardsvalue = cardValue.values();
  public static cardValue getcardValue(int i){
  return cardValue.cardsvalue[i];}
}
    
}