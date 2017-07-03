<%-- 
    Document   : challenge8-1-3
    Created on : 2017/07/03, 13:31:40
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
            int num = 0;
            
            for(int i = 0; i <= 100; i++){
                num += i;
            }
        %>
    </body>
</html>
