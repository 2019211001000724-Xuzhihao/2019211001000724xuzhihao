<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/4/11
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h2>Welcome to My Online Shop Home Page.</h2>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size=30/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="search"/>
</form>
<%@include file="footer.jsp"%>