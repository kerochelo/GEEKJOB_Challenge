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
public class db11 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.InstantiationException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String tell = request.getParameter("tell");
            String age = request.getParameter("age");
            String birth = request.getParameter("birth");
            int i = Integer.parseInt(id);
            int a = Integer.parseInt(age);
            
            String dri = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "kerochelo";
            String pass = "tkhr8547";
            String stateUp = "update profiles set name = ?, tell = ?, age = ?, birthday = ? where profileID = ?";
            String stateSe = "select * from profiles where profileID = ?";
            
            Connection con = null;
            PreparedStatement stUp;
            PreparedStatement stSe;
            int dataUp;
            ResultSet dataSe;
            
            try{
                Class.forName(dri).newInstance();
                con = DriverManager.getConnection(url, user, pass);
                
                stUp = con.prepareStatement(stateUp);
                stUp.setString(1, name);
                stUp.setString(2, tell);
                stUp.setInt(3, a);
                stUp.setString(4, birth);
                stUp.setInt(5, i);
                
                dataUp = stUp.executeUpdate();
                out.println("ID:" + i + "のデータを更新しました" + "<br>");
                
                stUp.close();
                
                stSe = con.prepareStatement(stateSe);
                stSe.setInt(1, i);
                
                dataSe = stSe.executeQuery();
                while(dataSe.next()){
                    out.print("名前:" + dataSe.getString("name") + "<br>");
                    out.print("電話番号:" + dataSe.getString("tell") + "<br>");
                    out.print("年齢:" + dataSe.getInt("age") + "<br>");
                    out.print("生年月日:" + dataSe.getInt("birthday") + "<br>");
                }
                
                dataSe.close();
                stSe.close();
                con.close();
            }
            catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
                out.print("エラーが発生しました" + e.toString());
            }
            finally{
                if(con != null){
                    try{
                        con.close();
                    }
                    catch(SQLException e_sql){
                        System.out.print(e_sql.getMessage());
                    }
                }
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>db11</title>");            
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(db11.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(db11.class.getName()).log(Level.SEVERE, null, ex);
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
