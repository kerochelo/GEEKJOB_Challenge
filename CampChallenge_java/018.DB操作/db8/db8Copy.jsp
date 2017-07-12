<%-- 
    Document   : db8
    Created on : 2017/07/12, 15:53:49
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>名前検索</title>
    </head>
    <body>
        <form action="./db8" method="post">
            <p>検索したい名前を入力してください</p>
            <p><input type="text" name="name"></p>
            <p><input type="submit" name="btnSubmit" value="検索"></p>
        </form>
    </body>
</html>
