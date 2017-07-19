<%-- 
    Document   : add
    Created on : 2017/07/18, 17:23:06
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録ページ</title>
        <style>
            header{
                text-align: center;
            }
            main{
                text-align: center;
            }
        </style>
        <script type="text/javascript">
            function check()
            {
            if(confirm("新商品を登録しますか？")) 
            {return true;}
            else 
            {return false;}
            }
        </script>
    </head>
    <body>
        <header>
            <h3>新商品の登録</h3>
        </header>
        <main>
            <div>
                <form action="Register" method="post" onsubmit="return check()">
                    <p>商品名:<input type="text" name="newPro" required=""></p>
                    <p>在庫数:<input type="text" name="newTot" required="" pattern="^[0-9]+$"></p>
                    <p><input type="submit" name="btnSubmit" value="追加"></p>
                </form>
            </div>
        </main>
        <footer>
            
        </footer>
    </body>
</html>
