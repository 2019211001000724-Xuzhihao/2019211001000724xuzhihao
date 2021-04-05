<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/5
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post" action="http://localhost:8080/2019211001000724xuzhihao_war_exploded/login">
    Username:<input type="text" name="Username" required><br/><br/>
    password:<input type="password" name="password" required minlength="8"><br/><br/>
    <input type="submit" name="login" value="login">
</form>

<%@include file="footer.jsp"%>