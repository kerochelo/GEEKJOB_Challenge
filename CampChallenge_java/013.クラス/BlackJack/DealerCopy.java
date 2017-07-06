/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bj.servlet;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author takahirokanno
 */
class Dealer extends Human {
    
    ArrayList<Integer> cards = new ArrayList<>();
    //合計値用変数
    int ftotal = 0;
    
    //クラス初期処理
    public Dealer(){
        //トランプ52枚分をcardsに追加
        //cards合計数52にするため、4回繰り返す。
        for(int h = 0; h < 4; h++){
            //1~Kを加える(J,Q,K == 10)
            for(int i = 1; i <= 13; i++){
                if(i <= 10){
                    cards.add(i);
                }else{
                    cards.add(10);
                }
            }
        }
        
    }
    
    //dealメソッド作成
    public ArrayList<Integer> deal(){ 
        //返却用ArrayList
        ArrayList<Integer> dl = new ArrayList<>();
        
        //Random rand = new Random(); クラスのフィールドにする L21に移動
        //int renum = rand.nextInt(cards.size()); L50に移動
        
        //(cardsから取得しdlに返却+cardsから減らす)*2
        for(int i = 0; i < 2; i++){
            Random rand = new Random();
            int renum = rand.nextInt(cards.size());
            dl.add(cards.get(renum));
            cards.remove(renum);
        }
        return dl;
    }
    
    //hitメソッド作成
    public ArrayList<Integer> hit(){
        //返却用ArrayList
        ArrayList<Integer> ht = new ArrayList<>();
        
        
        //cardsから取得しhtに返却　と　cardsから減らす
        Random rand = new Random();
        int renum = rand.nextInt(cards.size());
        ht.add(cards.get(renum));
        cards.remove(renum);
        
        return ht;
    }
    
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
        if(ftotal < 17){
            if(ftotal == 11 && myCards.contains(1)){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

}
