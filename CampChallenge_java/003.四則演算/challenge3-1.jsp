<%-- 
    Document   : challenge3-1
    Created on : 2017/07/02, 23:39:24
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
            final int BASE = 100;
            int num = 50;
            
            int add = BASE + num;
            int subtra = BASE - num;
            int multi = BASE * num;
            int div = BASE / num;
            
            out.println(add);
            out.println(subtra);
            out.println(multi);
            out.println(div);
        %>
    </body>
</html>
