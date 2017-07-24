<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udbs = (UserDataBeans)hs.getAttribute("udbs");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if(!(udbs.getName().equals("")) && !(udbs.getYear().equals("")) && !(udbs.getMonth().equals(""))
              && !(udbs.getDay().equals("")) && !(udbs.getTell().equals("")) && !(udbs.getComment().equals(""))){ %>
        <h1>登録確認</h1>
        名前:<%= udbs.getName()%><br>
        生年月日:<%= udbs.getYear()+"年"+udbs.getMonth()+"月"+udbs.getDay()+"日"%><br>
        種別:<%= udbs.getType()%><br>
        電話番号:<%= udbs.getTell()%><br>
        自己紹介:<%= udbs.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力に不備があります</h1>
        <%
            //フォーム不完全部分の表示
            if(udbs.getName().equals("")){
                out.println("'名前' の入力が不完全です<br>");
            }
            if(udbs.getYear().equals("") || udbs.getMonth().equals("") || udbs.getDay().equals("")){
                out.println("'生年月日' の入力が不完全です<br>");
            }
            if(udbs.getTell().equals("")){
                out.println("'電話番号' の入力が不完全です<br>");
            }
            if(udbs.getComment().equals("")){
                out.println("'自己紹介' の入力が不完全です<br>");
            }
            out.println("<br>登録画面に戻り,再入力してください");
       
        } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
    <!--トップリンクへ-->
    <%=JumsHelper.getInstance().home()%>
    </body>
</html>
