<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUserSuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		td{
			border-style:solid;
				    border-color:#000000;
				    		border-width:1px;
				    			border-collapse:separate;
				    				margin:3px;
		}
	</style>
  </head>
  
  <body>
		<center>
		<h1><font color=red>|</font>添加成功<font color=red>|</font></h1>
		新用户详细信息如下：
		<table border="0">
			<tr>
				<td>
    				${requestScope.new_user.login_id}</td>
				<td>${requestScope.new_user.pwd}</td>
				<td>${requestScope.new_user.name}</td>
				<td>${requestScope.new_user.sex}</td>
				<td>${requestScope.new_user.location}</td>
				<td>${requestScope.new_user.phone}</td>
			 	<td>${requestScope.new_user.email}</td>
				<td>${requestScope.new_user.user_right}</td>
			</tr>
		</table>
		<a href="page_jsp/adminMain.jsp">返回首页</a>
		</center>
	</body>
</html>
