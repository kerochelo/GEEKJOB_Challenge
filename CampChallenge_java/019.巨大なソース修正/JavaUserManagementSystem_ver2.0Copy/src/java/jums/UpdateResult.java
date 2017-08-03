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
public class UpdateResult extends HttpServlet {

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
        try {
            request.setCharacterEncoding("UTF-8");  //文字コード指定
            //アクセスチェック
            String acscheck = request.getParameter("acs");
            if(acscheck.equals("null") || (Integer)session.getAttribute("acs") != Integer.parseInt(acscheck)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからのデータをjavabeansに格納
            UserDataBeans udbs = new UserDataBeans();
            udbs.setName(request.getParameter("name"));
            udbs.setYear(request.getParameter("year"));
            udbs.setMonth(request.getParameter("month"));
            udbs.setDay(request.getParameter("day"));
            udbs.setType(request.getParameter("type"));
            udbs.setTell(request.getParameter("tell"));
            udbs.setComment(request.getParameter("comment"));
            
            //udbsをDB専用に変換
            UserDataDTO udd = new UserDataDTO();
            udbs.UD2DTOMapping(udd);
            
            
            //idをどうするか → resultdataから取ってくる
            UserDataDTO uddid = (UserDataDTO)session.getAttribute("resultData");
            udd.setUserID(uddid.getUserID());
            
            //DBの情報を更新
            UserDataDAO.getInstance().update(udd);
            
            //アクセスセッションクリア
            session.removeAttribute("acs");
            
            //更新結果画面用にリクエストスコープに登録
            request.setAttribute("udbs", udbs);
            
            //詳細画面反映のためセッション(resultData)を更新(ResultDetailとほぼ同じ処理)
            int id = udd.getUserID();
            uddid.setUserID(id);
            UserDataDTO resultData = UserDataDAO.getInstance().searchByID(uddid);
            session.removeAttribute("resultData");
            session.setAttribute("resultData", resultData);
            
            //検索結果画面反映のためセッション(resultDataList)を更新(SearchResultとほぼ同じ処理)
            UserDataDTO searchData = (UserDataDTO)session.getAttribute("searchData"); 
            
            //全件表示させるために検索入力を初期化しておく用のDTO
//            UserDataDTO foo = new UserDataDTO();
//            foo.setName("");
//            foo.setType(0);
            
            ArrayList<UserDataDTO> resultDataList = UserDataDAO.getInstance().search(searchData);
            session.removeAttribute("resultDataList");
            session.setAttribute("resultDataList", resultDataList);
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
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
