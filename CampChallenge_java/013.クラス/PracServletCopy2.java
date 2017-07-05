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
public class PracServlet extends HttpServlet {

    //クラス作成
    class Fbplayer{
        //publicフィールド２つ
        public String name ="";
        public int age = 0;
        
        //publicメソッド作成
        public void setFbplayer (String n, int a){
           this.name = n;
           this.age = a;
        }
        
        //printメソッド
        public void printFbplayer(PrintWriter pw){
            pw.println(name +"<br>");
            pw.println(age + "<br>");
        }
    }
    
    //Fbplayerクラスをextendsしたクラス作成
    class Lefbplayer extends Fbplayer{
        //変数の中身をクリアするパブリックメソッド
        public void clearVar(){
            this.name = "";
            this.age = 0;
        }
        
        
    }
    
    
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PracServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //表示する(確認用)
            //インスタンス作成
            Fbplayer fb1 = new Fbplayer();
            
            fb1.setFbplayer("pabel", 33);
            fb1.printFbplayer(out);
            
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
