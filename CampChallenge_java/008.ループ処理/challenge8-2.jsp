<%-- 
    Document   : challenge8-2
    Created on : 2017/07/03, 13:45:11
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
          float num = 1000;
          
          while(num > 100){
              num /= 2;
          }
        %>
    </body>
</html>
