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
class User extends Human {
    
    //合計値用変数
    int ftotal = 0;
    
    
    //setCardメソッド実装
    @Override
    public void setCard(ArrayList<Integer> sc){
        //カード情報をmyCardに追加
        for(int i = 0; i < sc.size(); i++){
            myCards.add(sc.get(i));
        }
    }
    
    //合計値計算だけ用の関数
//    private int cardsTotal(){
//        int total = 0;
//        
//        for(int value : myCards){
//            if(total < 21){
//                total += value;
//            }else{
//                break;
//            }
//        }
//        ftotal = total;
//        return total;
//    }
    
    //openメソッド実装
    @Override
    public int open(){
        int total = 0;
        
        for(int value : myCards){
            if(total < 21){
                total += value;
            }else{
                break;
            }
        }
        ftotal = total;
        return ftotal;
    }
    
    //checkSumメソッド実装　と　1の扱いを含める
    @Override
    public boolean checkSum(){
        if(ftotal < 16){
            if(ftotal == 11 && myCards.contains(1)){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }
}
