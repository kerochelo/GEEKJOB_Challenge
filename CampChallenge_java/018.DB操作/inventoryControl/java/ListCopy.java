/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryControl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author takahirokanno
 */
public class List extends HttpServlet {

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
            
            Connection db_con = null;
            PreparedStatement db_st;
            ResultSet db_data;
            
            //インスタンス生成
            ResultList l = new ResultList();
            
            //登録用配列
            ArrayList<String> proData = new ArrayList<>();
            ArrayList<Integer> totData = new ArrayList<>();
            
            String dri = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "kerochelo";
            String pass = "tkhr8547";
            String state = "select * from products";
            
//            String resultList = "/WEB-INF/jsp/list.jsp";
                                        
            try{    
                //データベース操作　処理
                Class.forName(dri).newInstance();
                db_con = DriverManager.getConnection(url, user, pass);

                db_st = db_con.prepareStatement(state);

                db_data = db_st.executeQuery();
                while(db_data.next()){
                    proData.add(db_data.getString("name"));
                    totData.add(db_data.getInt("total"));
                }
                
                db_data.close();
                db_st.close();
                db_con.close();
                
//                    l.setP(proData);
//                    l.setT(totData);
                
//                request.setAttribute("product", l);

//                RequestDispatcher rdl = request.getRequestDispatcher(resultList);
//                rdl.forward(request, response);
            }
            catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
                out.println("ERROR: " + e.toString());
            }
            finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }
                    catch(SQLException e_sql){
                        System.out.println(e_sql.getMessage());
                    }
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>商品一覧ページ</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>商品一覧</h2>　<h5>商品名(在庫数)</h5>");
            out.println("<ul>");
            for(int i = 0; i < proData.size(); i++){
                    out.println("<li>商品: " + proData.get(i) + " (" + totData.get(i) + ")</li><br>");
                }
            out.println("</ul>");
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
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
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
