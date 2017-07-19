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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author takahirokanno
 */
public class Login extends HttpServlet {

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
            
            //login処理 
            
            //値取得
            request.setCharacterEncoding("UTF-8");
            String userName = request.getParameter("name");
            String userPass = request.getParameter("pass");
            
            //セッション
            HttpSession hs = request.getSession(true);
            
            //データベース変数
            Connection db_con = null;
            PreparedStatement db_st;
            ResultSet db_data;
            
            //文字列変数
            String dri = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "kerochelo";
            String pass = "tkhr8547";
            String stateCheck = "select * from users where name = ?";
            String resultMain = "/WEB-INF/jsp/main.jsp";
            String resultLog = "Login.jsp";
             
            try{
                //データベース操作　処理
                Class.forName(dri).newInstance();
                db_con = DriverManager.getConnection(url, user, pass);

                db_st = db_con.prepareStatement(stateCheck);
                db_st.setString(1, userName);

                db_data = db_st.executeQuery();

                if(db_data.next()){
                    String n_str = db_data.getString("name");
                    String p_str = db_data.getString("password");
                    if(userName.equals(n_str) && userPass.equals(p_str)){
                        hs.setAttribute("login", "ok");

                        db_data.close();
                        db_st.close();
                        db_con.close();

                        //次のページ
                        RequestDispatcher rdm = request.getRequestDispatcher(resultMain);
                        rdm.forward(request, response);
                    }else{
                        hs.setAttribute("login", "miss");

                        db_data.close();
                        db_st.close();
                        db_con.close();

                        //前のページ
                        RequestDispatcher rdl = request.getRequestDispatcher(resultLog);
                        rdl.forward(request, response);
                    }
                }else{
                    hs.setAttribute("login", "miss");

                    db_data.close();
                    db_st.close();
                    db_con.close();

                    //前のページ
                    RequestDispatcher rdl = request.getRequestDispatcher(resultLog);
                    rdl.forward(request, response);
                }
            }
            catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
                System.out.println("ERROR: " + e.toString());
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
            
            //新規登録処理
            
            
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
