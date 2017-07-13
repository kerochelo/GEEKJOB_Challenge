<%-- 
    Document   : db11
    Created on : 2017/07/13, 11:39:46
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新</title>
    </head>
    <body>
        <form action="./db11" method="post">
            <p>更新したいID:<input type="text" name="id" required="入力してください" size="5"></p>
            <p>記入内容</p>
            <p><input type="text" name="name" required="入力してください">[名前(例:管飛マリオ)]</p>
            <p><input type="text" name="tell" required="入力してください">[電話番号(例:090-1111-0000)]</p>
            <p><input type="text" name="age" required="入力してください">[年齢(例:33)]</p>
            <p><input type="text" name="birth" required="入力してください">[生年月日(例:1234-01-01)]</p>
            <input type="submit" name="btnSubmit" value="更新">
        </form>
    </body>
</html>
