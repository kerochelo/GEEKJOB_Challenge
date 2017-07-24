<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udbs = (UserDataBeans)hs.getAttribute("udbs");
    //nullチェック変数
    boolean notNull;
    if(udbs != null){
        notNull = true;
    }else{
        notNull = false;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" placeholder="例) 桃浦 金太郎" value="<% if(notNull){out.print(udbs.getName());} %>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value=""><% if(notNull){out.print(udbs.getYear());} %></option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value=""><% if(notNull){out.print(udbs.getMonth());} %></option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value=""><% if(notNull){out.print(udbs.getDay());} %></option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1"<%if(udbs.getTypeNum() == 1 || udbs.getTypeNum() == 0){out.print("checked");}%>>エンジニア<br>
        <input type="radio" name="type" value="2"<%if(udbs.getTypeNum() == 2){out.print("checked");}%>>営業<br>
        <input type="radio" name="type" value="3"<%if(udbs.getTypeNum() == 3){out.print("checked");}%>>その他<br>
        <br>

        電話番号(半角数字と,'-'で区切って記入):<br>
        <input type="text" name="tell" placeholder="例) 012-3456-7890" value="<% if(notNull){out.print(udbs.getTell());} %>" pattern="\d{2,4}-\d{3,4}-\d{3,4}">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" placeholder="例) 我輩は鬼です。"><% if(notNull){out.print(udbs.getComment());} %></textarea>
        <br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <!--トップリンクへ-->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
