<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/5
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(request.getAttribute("message")!=null){
        out.println(request.getAttribute("message"));
    }
%>
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }else if(c.getName().equals("cPassword")){
                password=c.getValue();
            }else if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="http://localhost:8080/2019211001000724xuzhihao_war_exploded/login">
    <table>
        <tr> <td>Username:</td> <td><input type="text" name="Username" value="<%=username%>"><br/></td></tr>
        <tr> <td>password:</td> <td><input type="password" name="password" required minlength="8" value="<%=password%>"><br/></td></tr>
        <tr> <td>Remember Me</td> <td><input type="checkbox" name="rememberMe" value="1" <%= rememberMeVal.equals("1")? "checked":""%>/><br/></td></tr>
        <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
    </table>
</form>
<%@include file="footer.jsp"%>>