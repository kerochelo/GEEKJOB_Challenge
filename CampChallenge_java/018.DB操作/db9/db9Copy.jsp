<%-- 
    Document   : db9
    Created on : 2017/07/12, 17:33:26
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録ページ</title>
        <style>
            
        </style>
    </head>
    <body>
        <p>入力して保存ボタンを押してください</p>
        <form action="./db9" method="post">
            <ul>
                <li><input type="text" name="id" required="入力してください">[ID (例: 12 ・半角数字で)]</li>
                <li><input type="text" name="name" required="入力してください">[名前 (例: 田中　太郎)]</li>
                <li><input type="text" name="tell" required="入力してください">[電話番号 (例: 090-1111-2222 ・半角数字で)]</li>
                <li><input type="text" name="age" required="入力してください">[年齢 (例: 20　・半角数字で)]</li>
                <li><input type="text" name="birth" required="入力してください">[生年月日 (例: 2000-01-02) ・半角数字で]</li>
            </ul>
            <input type="submit" name="btnSubmit" value="保存">
        </form>
    </body>
</html>
