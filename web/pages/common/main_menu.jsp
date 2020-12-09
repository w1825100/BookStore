<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/20/2020
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="manager/orderServlet?action=list">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
