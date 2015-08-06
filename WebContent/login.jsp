<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Login</title>
</head>
<body>

<form id="form" name="form" method="post" action="/TEST_MVC/userlogin.mis">
<center>
<table width="315" border ="1">
	<tr>
		<td>Login_id:</td>
		<td><input type ="text" name="login_id"/></td> <!-- 用户名称输入文本框 -->
	</tr>
	<tr>
		<td>PassWord:</td>
		<td><input type ="password" name="password"/></td> <!-- 用户密码输入文本框 -->
		
	</tr>
	
	<tr>
		<td align="left">Others</td>
		<td bgcolor="#FFFFFF"><label> <!-- 提交按钮预注册信息 -->
		<input type="submit" name="Sumit" value="login" onClick="return check()"/>
		<input type="reset" name="Sumit2" value="reset"/>
		<a href = "registerUser.jsp">register</a>
		</label></td>
		
</table>
</center>
</form>
</body>
</html>