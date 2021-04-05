<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/3/21
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
This is MY JSP page.<br>
<form method="post" action="register">
    Username:<input type="text" name="Username" required><br/><br/>
    password:<input type="password" name="password" required minlength="8"><br/><br/>
    Email:<input type="email" name="Email" required><br/><br/>
    Gender:<input type="radio" name="sex" value="Male">male
    <input type="radio" name="sex" value="Female">Female
    <br/><br/>
    Birthdate:<input type="text" name="time" required dataformatas="yyyy-dd-mm"><br/><br/>
    <input type="submit" name="Register" value="Register">
</form>

<%@include file="footer.jsp"%>