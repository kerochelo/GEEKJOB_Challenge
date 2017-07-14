<%-- 
    Document   : db12
    Created on : 2017/07/13, 13:24:51
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索ページ</title>
        <style>
            li{list-style: none}
        </style>
    </head>
    <body>
        <form action="./db12" method="post">
            <center>
                <h2>下の３つで複合検索できます!</h2>
                <ul>
                    <li>名前:<input type="text" name="name">(例:服部半蔵)</li>
                    <li>年齢:<input type="text" name="age">(例:88)</li>
                    <li>生年月日:<input type="text" name="birthday">(例:1999-01-01)</li>
                </ul>
                    <input type="submit" name="btnSubmit" value="検索">
            </center>
        </form>
    </body>
</html>
