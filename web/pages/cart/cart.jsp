<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
			$(function () {
				$(".updateCount").change(function () {
				var text1=$(this).parent().parent().find("td:first").text();
				var id=$(this).attr("bookId");
					if(confirm("确定要修改["+text1+"]数量为["+this.value+"]吗")){
						location.href="cartServlet?action=updateCount&count="+this.value+"&id="+id;
					}else{
						this.value=this.defaultValue;
					}
				});
			});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

		<%@include file="/pages/common/login_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.shopingCart.items}" var="entry">
			<tr>
				<td>${entry.value.name}</td>
				<td>
					<input class="updateCount"  bookId="${entry.value.id}" type="text" value="${entry.value.count}"  style="width: 80px"/>
				</td>
				<td>${entry.value.price}</td>
				<td>${entry.value.totalPrice}</td>
				<td><a href="cartServlet?action=deleteItem&id=${entry.value.id}" onclick="return f1()">删除</a></td>
			</tr>
			</c:forEach>

		<c:if test="${ empty sessionScope.shopingCart.items}">
			<tr>
				<td colspan="5">
					<a href="index.jsp">亲,当前购物车为空,快和小伙伴去选购商品吧~</a>
				</td>
			</tr>
		</c:if>
		</table>
		<c:if test="${not empty sessionScope.shopingCart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.shopingCart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.shopingCart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="cartServlet?action=clear" onclick="return f()">清空购物车</a></span>
			<span class="cart_span"><a href="client/orderServlet?action=createOrder" >去结账</a></span>
			</c:if>
		</div>
		<c:if test="${not empty sessionScope.bookName}">
		<div class="cart_info">
			<span class="cart_span">亲,<span class="b_count">${sessionScope.bookName}</span>库存只剩<span class="b_price">${sessionScope.bookStock}</span>啦!已为您修改为最大数量</span>
			<% request.getSession().removeAttribute("bookName");%>
			<% request.getSession().removeAttribute("bookStock");%>
			</c:if>
		</div>

	</div>
	<script type="text/javascript">
		function f() {
			return confirm("您确定要清空购物车吗?")
		}
		function f1(){
			return confirm("您确定要删除"+$(this).parent("tr").find("td").eq(0).text()+"吗?")
		}

	</script>

	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>