package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author hayashi-s
 */
public class DeleteResult extends HttpServlet {

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
        
            //セッションスタート
            HttpSession session = request.getSession();
        try{
            //文字コード指定
            request.setCharacterEncoding("UTF-8");
            
            //不正アクセスチェック
            String acscheck = request.getParameter("acs");
            if(acscheck.equals("null") || (Integer)session.getAttribute("acs") != Integer.parseInt(acscheck)){
                throw new Exception("不正なアクセスです");
            }
            //削除用idをresultDataから取ってくる
            UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
            
            //削除処理
            UserDataDAO.getInstance().delete(udd);

            //アクセスセッションクリア
            session.removeAttribute("acs");
            
            //検索結果画面反映のためセッション(resultDataList)を更新(SearchResultとほぼ同じ処理)
            UserDataDTO searchData = (UserDataDTO)session.getAttribute("searchData");
            ArrayList<UserDataDTO> resultDataList = UserDataDAO.getInstance().search(searchData);
            session.removeAttribute("resultDataList");
            session.setAttribute("resultDataList", resultDataList);
            
            request.getRequestDispatcher("/deleteresult.jsp").forward(request, response);
            
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
