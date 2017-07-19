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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author takahirokanno
 */
public class Register extends HttpServlet {

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
            
            request.setCharacterEncoding("UTF-8");
            
            //値取得
            String newPro = request.getParameter("newPro");
            int newTot = Integer.parseInt(request.getParameter("newTot"));
            
            //セッション
            HttpSession hs = request.getSession(true);
            
            Connection db_con = null;
            PreparedStatement db_st;
            int db_data;
            
            String dri = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            String user = "kerochelo";
            String pass = "tkhr8547";
            String state = "insert into products values(?, ?)";
            String path = "/WEB-INF/jsp/main.jsp";
            
            
            
            try{
                Class.forName(dri).newInstance();
                db_con = DriverManager.getConnection(url, user, pass);

                db_st = db_con.prepareStatement(state);
                db_st.setString(1, newPro);
                db_st.setInt(2, newTot);

                db_data = db_st.executeUpdate();

                db_st.close();
                db_con.close();
                
                hs.setAttribute("regis", "ok");
                
                RequestDispatcher rdm = request.getRequestDispatcher(path);
                rdm.forward(request, response);
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
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
