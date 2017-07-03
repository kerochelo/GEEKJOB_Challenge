/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author takahirokanno
 */
//シリアライズ化
public class ResultData implements Serializable {
    //カプセル化
    private Date d;
    private String luck;
    
    //コンストラクタ
    public ResultData(){}
    
    //d　getメソッド
    public Date getD(){
        return d;
    }
    //d setメソッド
    public void setD(Date d){
        this.d = d;
    }
    //luck getメソッド
    public String getLuck(){
        return luck;
    }
    //luck setメソッド
    public void setLuck(String luck){
        this.luck = luck;
    }
}
