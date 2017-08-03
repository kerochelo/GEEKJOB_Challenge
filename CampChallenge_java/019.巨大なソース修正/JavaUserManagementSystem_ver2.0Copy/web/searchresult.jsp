<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)hs.getAttribute("resultDataList");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <%if(udd.size() != 0){%>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録(更新)日時</th>
            </tr>
            <%
                for(UserDataDTO d : udd){
            %>
            <tr>
                <td><a href="ResultDetail?id=<%= d.getUserID()%>"><%= d.getName()%></a></td>
                <td><%= d.getBirthday()%></td>
                <td><%
                        switch(d.getType()){
                            case 1:
                                out.print("営業");
                                break;
                            case 2:
                                out.print("エンジニア");
                                break;
                            case 3:
                                out.print("その他");
                                break;
                        }
                    %></td>
                <td><%= sdf.format(d.getNewDate())%></td>
            </tr>
              <%}%>
        </table>
        <%}else{%>
        <p>検索内容に該当する情報はありませんでした。</p>
        <%}%>
        <br>
        <%=jh.search()%>
        <hr>
    <%=jh.home()%>
    </body>
</html>

