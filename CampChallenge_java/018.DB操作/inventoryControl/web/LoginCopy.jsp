<%-- 
    Document   : Login
    Created on : 2017/07/18, 12:36:56
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品在庫管理 ログインページ</title>
        <style>
            header{
                text-align: center;
            }
            main{
                text-align: center;
                
                .login_form{
                    height: 200px;
                }
                .create_form{
                    height: 200px;
                }
            }
            
            footer{
                text-align: center;
            }
        </style>
        <script type="text/javascript">
            function check()
            {
            if(confirm("フォームの内容を登録しますか？")) 
            {return true;}
            else 
            {return false;}
            }
        </script>
        <%
            HttpSession hs = request.getSession(true);
        %>
    </head>
    <body>
        <header>
            <h1>商品在庫管理システム</h1>
        </header>
        <hr>
        <main>
            <p>ログイン</p>
            <%
                Object check = hs.getAttribute("login");
                
                if(check == "miss"){
                    out.println("ログインに失敗しました <br> 再度ログインしてください");
                    hs.setAttribute("login", null);
                }
                
                if(check == "out"){
                    out.println("ログアウトしました");
                    hs.setAttribute("login", null);
                }
            %>
            
            <form class="login_form" action="Login" method="post">
                <p>
                    ユーザー名:<input type="text" name="name" required="">
                </p>
                <p>
                    パスワード:<input type="text" name="pass" required="">
                </p>
                <p>
                    <input type="submit" name="btnSubmit" value="login">
                </p>
            </form>
<!--            <hr>
            <p>ニューユーザー</p>
            <form class="create_form" action="Login" method="post"onsubmit="return check()">
                <p>
                    新規登録名:<input type="text" name="newName" required="入力必須">
                </p>
                <p>
                    パスワード:<input type="text" name="newPass" required="入力必須">
                </p>
                <p>
                    <input type="submit" name="btnSubmitNew" value="create account">
                </p>
            </form>-->
        </main>
        <hr>
        <footer>
            <h3>商品在庫管理システム</h3>
            <h5>create by takahiro</h5>
        </footer>
    </body>
</html>
