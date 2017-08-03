<%@page import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataDTO"
        import="java.util.Date"
        import="java.util.Calendar"
        import="java.text.SimpleDateFormat"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    //Date型のbirthdayをyear,month,dayに分ける
    Calendar birthday = Calendar.getInstance();
    birthday.setTime(udd.getBirthday());
    int y = birthday.get(Calendar.YEAR);
    int m = birthday.get(Calendar.MONTH);
    m++;    //実際の月に合わせる
    int d = birthday.get(Calendar.DAY_OF_MONTH);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
        <!--最終確認用表示-->
        <script type="text/javascript">
            function check(){
                if(confirm("情報を更新しますか？"))
                    {return true;}
                else
                    {return false;}
            }
        </script>
    </head>
    <body>
        <form action="UpdateResult" method="POST" onsubmit="return check()">
        名前:
        <input type="text" name="name" value="<%= udd.getName() %>">
        <br><br>

        生年月日:                       
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<% if(y == i){out.print("selected = \"selected\"");} %> ><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(m == i){out.print("selected = \"selected\"");} %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(d == i){out.print("selected = \"selected\"");} %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>" <% if(udd.getType() == i){out.print("checked = \"checked\"");} %>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udd.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment() %></textarea><br><br>
        
        <input type="hidden" name="acs" value="<%=hs.getAttribute("acs")%>"> <!--アクセスチェック用-->
        <input type="submit" name="btnSubmit" value="更新">
    </form>
        <br>
        <!--詳細画面リンク-->
        <%=jh.resultDetail()%>
        <hr>
        <!--ホーム画面リンク-->
        <%=jh.home()%>
    </body>
</html>
