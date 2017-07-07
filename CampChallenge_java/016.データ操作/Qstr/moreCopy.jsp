<%-- 
    Document   : more
    Created on : 2017/07/07, 18:46:11
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>more.jsp</title>
    </head>
    <body>
        <%
            //文字コード設定
            request.setCharacterEncoding("UTF-8");
            //データ取得
            String s = request.getParameter("total");
            String k = request.getParameter("count");
            String b = request.getParameter("type");
            //型変換
            int t = Integer.parseInt(s);
            int c = Integer.parseInt(k);
            int type = Integer.parseInt(b);
            //計算(1つあたり)
            int p = t / c;
            //5%計算
            int fip = t / 20;
            //4%計算
            int fop = t / 25;
            //種別わけ表示
            switch(type){
                case 1:
                    out.print("雑貨 - ");
                    break;
                case 2:
                    out.print("生鮮食品 - ");
                    break;
                case 3:
                    out.print("その他 - ");
                    break;
            }
            //値段表示
            out.print("1つあたり" + p + "円です。<br>");
            //ポイント付与
            if(t >= 5000){
                out.print(fip + "%のポイントが付きます！");
            }else if(t >= 3000){
                out.print(fop + "%のポイントが付きます！");
            }else{
                out.print("3000円以上からポイントが付きます！");
            }
        
        %>
    </body>
</html>
