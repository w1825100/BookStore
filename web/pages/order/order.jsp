<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
    <script type="text/javascript">
        function f(){
                return confirm("温馨提示:请收到货后再点击签收,避免钱货两空!");
        }
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">我的订单</span>

    <%@include file="/pages/common/login_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>总金额</td>
            <td>状态</td>
            <td>详情</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.orderList}" var="order">
            <tr>
                <td>${order.creatTime}</td>

                <td>${order.price}</td>

                <td>
                    <c:choose>
                        <c:when test="${order.status==0}">
                        未发货
                        </c:when>
                        <c:when test="${order.status==1}">
                            已发货
                        </c:when>
                        <c:otherwise>
                            已签收
                        </c:otherwise>
                    </c:choose>
                </td>

                <td><a href="${pageContext.request.contextPath}/client/orderServlet?action=showOrderByOrderId&orderId=${order.orderId}">查看详情</a></td>
                <c:if test="${order.status!=2}">
                    <td><a  href="${pageContext.request.contextPath}/client/orderServlet?action=receiveOrder&orderId=${order.orderId}" onclick="return f()">签收</a></td>
                </c:if>
                <td><a  href="${pageContext.request.contextPath}/client/orderServlet?action=deleteOrder&orderId=${order.orderId}">删除</a></td>
            </tr>
        </c:forEach>

    </table>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>