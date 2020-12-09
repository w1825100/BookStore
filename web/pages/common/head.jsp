<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/20/2020
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
    String basePath=request.getScheme()
            +"://"+request.getServerName()+
            ":"+request.getServerPort()+
            request.getContextPath()+"/";
    pageContext.setAttribute("basePath",basePath);
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="static/js/jquery-1.7.2.js"></script>