<%-- 
    Document   : sesfie
    Created on : 2017/07/10, 13:39:01
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            //session取得
            HttpSession hs = request.getSession();
            
            //params取得
            String userName = request.getParameter("name");
            String userGender = request.getParameter("gender");
            String userHobby = request.getParameter("hobby");

            //登録
            hs.setAttribute("Name", userName);
            hs.setAttribute("Gender", userGender);
            hs.setAttribute("Hobby", userHobby);
            
            //変数に代入
            Object n = hs.getAttribute("Name");
            Object g = hs.getAttribute("Gender");
            Object h = hs.getAttribute("Hobby");
            
            //記入なしなら
            if(n == null){
                n = "";
            }
            if(g == null){
                g = "";
            }
            if(h == null){
                h = "";
            }
            
            
            out.print("名前: " + n + "<br>");
            out.print("性別: " + g + "<br>");
            out.print("趣味: " + h + "<br>");
            
            
        %>
    </body>
</html>
