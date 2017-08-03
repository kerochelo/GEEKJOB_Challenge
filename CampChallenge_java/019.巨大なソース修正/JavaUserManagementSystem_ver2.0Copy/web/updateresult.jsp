<%@page import="jums.JumsHelper" 
        import="jums.UserDataBeans"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udbs = (UserDataBeans)request.getAttribute("udbs");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%=udbs.getName()%><br>
        生年月日:<%=udbs.getYear()%> / <%=udbs.getMonth()%> / <%=udbs.getDay()%><br>
        種別:<%=jh.exTypenum(udbs.getType())%><br>
        電話番号:<%=udbs.getTell()%><br>
        自己紹介:<%=udbs.getComment()%><br>
        以上の内容で更新しました。<br>
        <br>
        <!--詳細画面リンク-->
        <%= jh.resultDetail()%>
        <br>
        <!--検索結果画面リンク-->
        <%= jh.searchResult()%>
        <hr>
        <!--ホーム画面リンク-->
    <%= jh.home()%>
    </body>
</html>
