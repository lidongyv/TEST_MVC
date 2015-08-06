<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="web.mvc.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"
				  +request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
		<center>
			<h3>添加用户细则</h3>
			<form action="/TEST_MVC/addUser_do.mis" method="post" name="user">
				<table border="1" bgcolor="#0099CC">
					<tr><td>登陆ID：</td><td><input type="text" name="login_id"></td></tr>
					<tr><td>登录密码：</td><td><input 	type="text" name="login_pwd"></td></tr>
					<tr><td>用户名：</td><td><input 	type="text" name="user_name"></td></tr>
					<tr><td>性别:</td><td><input 	type="text" name="user_sex"></td></tr>
					<tr><td>所在地：</td><td><input 	type="text" name="user_location"></td></tr>
		            <tr><td>电话:</td><td><input 	type="text" name="user_phone"></td></tr>
					<tr><td>邮箱：</td><td><input 	type="text" name="user_email"></td></tr>
					<tr><td>权限等级：</td><td><input 	type="text" name="user_right"></td></tr>

					<tr><td colspan="2" align="center"><input type="submit" value="注册"/></td></tr>
				</table>
			</form>
		</center>
	</body>
</html>