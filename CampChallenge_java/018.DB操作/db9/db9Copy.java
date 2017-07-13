/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author takahirokanno
 */
public class db9 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //受け取る
            request.setCharacterEncoding("UTF-8");
            String i = request.getParameter("id");
            String n = request.getParameter("name");
            String t = request.getParameter("tell");
            String a = request.getParameter("age");
            String b = request.getParameter("birth");
            
            int id = Integer.parseInt(i);
            int age = Integer.parseInt(a);
            
            String dri = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "kerochelo";
            String pass = "tkhr8547";
            String state = "insert into profiles values(?, ?, ?, ?, ?)";
            
            Connection db_con = null;
            PreparedStatement db_st;
            int db_data;
            
            try{
                Class.forName(dri).newInstance();
                db_con = DriverManager.getConnection(url, user, pass);
                
                db_st = db_con.prepareStatement(state);
                db_st.setInt(1, id);
                db_st.setString(2, n);
                db_st.setString(3, t);
                db_st.setInt(4, age);
                db_st.setString(5, b);
                
                db_data = db_st.executeUpdate(); 
                out.print(db_data + "人分、追加されました。"); //1
                
                db_st.close();
                db_con.close();
            }
            catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
                out.print("エラーが発生しました。" + e.toString());
            }
            finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }
                    catch(Exception e){
                        System.out.print(e.getMessage());
                    }
                }
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title></title>");            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(db9.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(db9.class.getName()).log(Level.SEVERE, null, ex);
        }
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
