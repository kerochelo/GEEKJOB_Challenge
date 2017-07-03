<%-- 
    Document   : challenge4-1
    Created on : 2017/07/03, 9:58:43
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
            final String FORMER = "groove";
            String hyp = "-";
            final String LATTER = "gear";
            
            out.print(FORMER + hyp + LATTER);
        %>
    </body>
</html>
