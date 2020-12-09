<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">订单详情</span>

    <%@include file="/pages/common/login_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>编号</td>
            <td>商品名</td>
            <td>数量</td>
            <td>单价</td>
            <td>总价</td>
            <td>订单号</td>
        </tr>

            <c:forEach items="${requestScope.orderItemList}" var="item" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${item.name}</td>

                <td>${item.count}</td>

                <td>
                        ${item.price}
                </td>
                <td>
                        ${item.totalPrice}
                </td>
                <td>
                        ${item.orderId}
                </td>

            </tr>
    </c:forEach>

    </table> <div class="cart_info">
                 <button style="margin-bottom:10px" onclick="f()">返回上一级</button>
    <script type="text/javascript">
        function f(){
          history.back();
        }
    </script>
            </div>


</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>