<%-- 
    Document   : factoring
    Created on : 2017/07/10, 10:27:49
    Author     : takahirokanno
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>result</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String g = request.getParameter("num");
            int n = Integer.parseInt(g);
            int dn = n;
            
            //表示 + 処理
            out.print(n + "の素因数は ");
            
            while(dn > 1){
                if(dn % 2 == 0){
                    out.print("2, ");
                    dn /= 2;
                }else if(dn % 3 == 0){
                    out.print("3, ");
                    dn /= 3;
                }else if(dn % 5 == 0){
                    out.print("5, ");
                    dn /= 5;
                }else if(dn % 7 == 0){
                    out.print("7, ");
                    dn /= 7;
                }else{
                    out.print("余りは" + dn);
                    break;
                }
            }
            
            out.print(" です。");
        %>
            
    </body>
</html>
