/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author takahirokanno
 */
public class BlackJack extends HttpServlet {    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //インスタンス作成
            Dealer dealer = new Dealer();
            User user1 = new User();
            
            //deal分の2枚をsetCardに渡す
            dealer.setCard(dealer.deal());
            out.println("Dealer's first hand is " + dealer.myCards.get(0) + "!<br>");
            
            while(dealer.open() < 17){
                dealer.setCard(dealer.hit());
            }
            
            //user1のカード
            user1.setCard(dealer.deal());
            out.println("User's hand is " + user1.myCards + " - total " + user1.open() +"<br>");
            
            //userが17を超えるまで引き続ける
            while(user1.checkSum() == true){
                user1.setCard(dealer.hit());
                out.println("User hits!<br>");
                out.println("The cards are " + user1.myCards + " - total " + user1.open() + "<br>");
            }
            //勝敗表示
            
            //bust処理
            if(user1.open() > 21){
                out.println("Oh, Buuuust! Unfortunately... User loses.");
            //勝負！    
            }else if(dealer.open() <= 21){
                //dealer bj
                if(dealer.open() == user1.open()){
                    out.println("Dealer - " + dealer.open() + ", User - " + user1.open() + ".<br>");
                    out.println("Draw.");
                }else if(dealer.open() == 21){
                    if(user1.open() == 11 && user1.myCards.contains(1)){
                        out.println("Dealer - 21, User - the 1 converses 11, so 21.<br>");
                        out.println("Draw.");
                    }else{
                        out.println( "Dealer - " + dealer.open() + ". Dealer's hands are Natural BJ! Dealer wins!");
                    }
                }else if(user1.open() == 11 && user1.myCards.contains(1)){
                    out.println( "But the 1 converses 11! User - 21. User's hands are Natural BJ! User wins!");
                }else if(dealer.open() > user1.open()){
                    out.println("Dealer - " + dealer.open() + ", User - " + user1.open() + ".<br>");
                    out.println("Dealer wins!<br>");
                }else{
                    out.println("Dealer - " + dealer.open() + ", User - " + user1.open() + ".<br>");
                    out.println("Congrats on the game! User wins!");
                }
            }else{
                out.println("Dealer - " + dealer.open() + ", User - " + user1.open() + ".<br>");
                out.println("Congrats on the game! User wins!");
            }
            
            
            
            
            //実験用
            //out.println(dealer.myCards.get(1));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BlackJack</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
