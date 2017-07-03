<%-- 
    Document   : challenge8-1-2
    Created on : 2017/07/03, 13:20:16
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
            String charStr = "";
            
            for(int i = 0; i < 30; i++){
                charStr += 'A';
            }
            
            out.print(charStr);
            
        %>
    </body>
</html>
