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
public class db12 extends HttpServlet {

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
            
            request.setCharacterEncoding("UTF-8");
            
            String name = null;
            int age = 0;
            String birth = null;
            if(!(request.getParameter("name").equals(""))){
                name = request.getParameter("name");
            }
            if(!(request.getParameter("age").equals(""))){
                age = Integer.parseInt(request.getParameter("age"));
            }
            if(!(request.getParameter("birthday").equals(""))){
                birth = request.getParameter("birthday");
            }
            
            String dri = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "kerochelo";
            String pass = "tkhr8547";
            String state = "select * from profiles where name = ? or age = ? or birthday = ?";
            
           
            Connection con = null;
            PreparedStatement st = null;
            ResultSet data = null;
            
            try{
                Class.forName(dri).newInstance();
                con = DriverManager.getConnection(url, user, pass);
                
                st = con.prepareStatement(state);
                //部分一致考慮
                st.setString(1, "%" + name + "%");
                st.setInt(2, age);
                st.setString(3, birth);
                
                
                data = st.executeQuery();
                
                //ヒットしない場合
                if(data.next() == false){
                    out.print("<h2>お探しの情報はありませんでした</h2><br>");
                    out.print("<a href=db12.jsp>");
                    out.print("<button>");
                    out.print("検索画面に戻る");
                    out.print("</button>");
                    out.print("</a>");
                }else{
                while(data.next()){
                    out.print("ID:" + data.getInt("profileID") + "<br>");
                    out.print("名前:" + data.getString("name") + "<br>");
                    out.print("電話番号" + data.getString("tell") + "<br>");
                    out.print("年齢:" + data.getInt("age") + "<br>");
                    out.print("生年月日:" + data.getString("birthday") + "<br> <hr>");
                }
                }
                
                data.close();
                st.close();
                con.close();
            }
            catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
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
            out.println("<title>検索結果</title>");            
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
            Logger.getLogger(db12.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(db12.class.getName()).log(Level.SEVERE, null, ex);
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
