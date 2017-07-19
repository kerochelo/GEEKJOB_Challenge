<%-- 
    Document   : main
    Created on : 2017/07/18, 13:41:07
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>メインページ</title>
        <style>
            header{
                text-align: center;
            }
            main{
                text-align: center;
            }
            footer{
                text-align: center;
            }
        </style>
        <%
            HttpSession hs = request.getSession(true);
        %>
    </head>
    <body>
        <header>
            <h1>メインページ</h1>
            <form action="Logout" method="post">
                <input type="submit" name="logout" value="ログアウト">
            </form>
        </header>
        <hr>
        <main>
            <%
                Object check = hs.getAttribute("regis");
                
                if(check == "ok"){
                    out.println("新しく商品が登録されました");
                    hs.setAttribute("regis", null);
                }
            %>
            <h3>商品在庫一覧</h3>
            <form action="List" method="post">
                <input type="submit" name="list" value="在庫一覧へ">
            </form>
            <hr>
            <h3>新規商品登録</h3>
            <form action="Move" method="post">
                <input type="submit" name="register" value="商品を追加">
            </form>
        </main>
        <hr>
        <footer>
            <h5>メインページ</h5>
            <form action="Logout" method="post">
                <input type="submit" name="logout" value="ログアウト">
            </form>
        </footer>
    </body>
</html>
