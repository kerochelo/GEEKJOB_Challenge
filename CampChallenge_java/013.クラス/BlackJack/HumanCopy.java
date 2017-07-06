/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bj.servlet;


import java.util.ArrayList;
/**
 *
 * @author takahirokanno
 */

//抽象クラス
abstract class Human {
    //openクラス(ab/pu) 合計値を返す
    abstract public int open();
    
    //setCardクラス(ab/pu)　引数はArrayList
    abstract public void setCard(ArrayList<Integer> sc);
    
    //checkSumクラス(ab/pu)
    abstract public boolean checkSum();

    //変数myCard 引数はArrayList
    ArrayList<Integer> myCards = new ArrayList<>();
}
