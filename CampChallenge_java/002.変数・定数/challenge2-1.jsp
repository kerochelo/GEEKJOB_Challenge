<%-- 
    Document   : challenge2-1
    Created on : 2017/07/02, 22:52:28
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
            String name = "菅野隆皓です。";
            String greet = "よろしくお願いいたします。";
            out.print(name + greet);
        %>
    </body>
</html>
