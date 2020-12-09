
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>

    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="${pageContext.request.contextPath}/client/orderServlet?action=showMyOrder">我的订单</a>
    <a href="${pageContext.request.contextPath}/userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp" >返回</a>
</div>