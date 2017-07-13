<%-- 
    Document   : db10
    Created on : 2017/07/13, 10:58:40
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データの削除</title>
    </head>
    <body>
        <form action="./db10" method="post">
            <p>削除したいデータのIDを入力してください。</p>
            <p>ID:<input type="text" name="delid" required="入力してください!" size="5"></p>
            <input type="submit" name="btnSubmit" value="削除">
        </form>
    </body>
</html>
