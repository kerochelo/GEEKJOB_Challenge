/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.db.servlet;

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
public class db6 extends HttpServlet {

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
            
            Connection db_con = null;
            PreparedStatement db_stDe;
            PreparedStatement db_stDisp;

            int db_deData;
            ResultSet db_dispData;
            
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "kerochelo", "tkhr8547");
                //削除
                db_stDe = db_con.prepareStatement("delete from profiles where profileID = ?");
                db_stDe.setInt(1, 6);
                db_deData = db_stDe.executeUpdate();
                
                db_stDe.close();
                //表示
                db_stDisp = db_con.prepareStatement("select * from profiles");
                db_dispData = db_stDisp.executeQuery();
                while(db_dispData.next()){
                    out.print("profileID:" + db_dispData.getInt("profileID") + "<br>" );
                    out.print("名前:" + db_dispData.getString("name") + "<br>" );
                    out.print("電話番号:" + db_dispData.getString("tell") + "<br>" );
                    out.print("年齢:" + db_dispData.getInt("profileID") + "<br>" );
                    out.print("生年月日:" + db_dispData.getString("birthday") + "<br>" );
                }
                db_dispData.close();
                db_stDisp.close();
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
                    catch(SQLException e_sql){
                        System.out.print(e_sql.getMessage());
                    }
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet db6</title>");            
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
            Logger.getLogger(db6.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(db6.class.getName()).log(Level.SEVERE, null, ex);
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
