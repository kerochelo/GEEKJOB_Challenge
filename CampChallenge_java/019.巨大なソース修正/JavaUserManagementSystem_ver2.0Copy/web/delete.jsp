<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="javax.servlet.http.HttpSession"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS削除確認</title>
        <script type="text/javascript">
            function check(){
                if(confirm("本当にこの情報を削除しますか？")){
                    return true;
                }else{
                    return false;
                }
            }
        </script>
    </head>
    <body>
    <h1>削除確認</h1>
    <strong>以下の内容を削除します。よろしいですか？</strong><br><br>
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= jh.exTypenum(udd.getType())%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br><br>
    
    <form action="DeleteResult" method="POST" onsubmit="return check()">
      <input type="hidden" name="acs" value="<%=hs.getAttribute("acs")%>">  <!--アクセス用-->
      <input type="submit" name="YES" value="はい" style="width:100px">
    </form><br>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="いいえ" style="width:100px">
    </form>
    <br><br>
    <%=jh.resultDetail()%>  <!--検索結果画面リンク(必要ない可能性が高いですが)-->
    <hr>
    <%=jh.home()%> <!--ホーム画面リンク-->
    </body>
</html>
