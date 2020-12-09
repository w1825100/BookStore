<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		$(function(){
			$("#username").blur(function () {
					var username=this.value;
					$.getJSON("${pageContext.request.contextPath}/userServlet","action=ajaxExists&username="+username,function (data) {
									if(data.exits){
										$("span.errorMsg").text("用户名可用");
									}else{
										$("span.errorMsg").text("该用户名已被注册!");
									}
					});

			});
			$("#sub_btn").click(function(){
			//	获取用户名输入框内容
		var usernameText=$("#username").val();
		var	usernamepatt=/[\u4e00-\u9fa5_a-zA-Z0-9_]{4,10}/;
		if(!usernamepatt.test(usernameText)){
			$("span.errorMsg").text("用户名不合法!");
			return false;
		}
		var passText=$("#password").val();
		var pwdpat=/^\w{5,12}$/;
		if(!pwdpat.test(passText)){
			$("span.errorMsg").text("密码不合法");
			return false;
		}
		if($("#repwd").val()!=$("#password").val()){
			$("span.errorMsg").text("两次密码不一致!");
			return false;
		}
		var emailText =$("#email").val();
		var emailpatt=/^[A-Za-z0-9]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if(!emailpatt.test(emailText)){
			$("span.errorMsg").text("邮箱格式不正确!");
			return false;
		}
		var codeText=$("#code").val();
		codeText=$.trim(codeText);
		if(codeText==""||codeText==null){
			$("span.errorMsg").text("验证码不能为空");
			return false;
		}


			});



		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${Msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
									value="${username}"	  autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										  value="${email}" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img alt="看不清/换一张?" value="${code}" id="imge" src="kaptcha.jpg" style="float: right; width: 95px;height: 45px;margin: auto;">
									<script type="text/javascript">
											$(function () {
														$("#imge").click(function () {
															this.src="kaptcha.jpg?d="+new Date();
														});
											});
									</script>
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>