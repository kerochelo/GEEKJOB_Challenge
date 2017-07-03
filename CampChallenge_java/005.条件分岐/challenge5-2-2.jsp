<%-- 
    Document   : challenge5-2-2
    Created on : 2017/07/03, 10:55:46
    Author     : takahirokanno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
             char obj = '!';
            
               switch(obj){
                   case 'A':
                       out.print("英語");
                       break;
                   case 'あ':
                       out.print("日本語");
                       break;
                   default:
                       out.print("");
                       break;
               }
        %>
    </body>
</html>
