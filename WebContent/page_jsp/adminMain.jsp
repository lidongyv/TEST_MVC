<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="web.mvc.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/html/csstest1.css">
	
  </head>
  
  <body style="font-size:14px;color:#006699;">
    <center>
    <%
    	String time = new Date().toLocaleString();
     %>
     <font color="blue" size=4>你已在<%=time %>登录管理员界面！</font>
     		<hr>
     	    <fieldset style="border:1.5px solid #0033FF;margin-bottom:10px;width:40%">
				<legend><font color="#FF0099">用户管理</font></legend><br><br>
				<a href="page_jsp/products/addUser.jsp">添加用户</a><br>
				<a href="page_jsp/products/deleteUser.jsp">删除用户</a><br>
				<a href="page_jsp/products/wakeUser.jsp">激活用户</a><br>
				<a href="page_jsp/products/frozenUser.jsp">冻结用户</a><br>
			</fieldset>
			<br>
			<hr>
			<br>
			<fieldset style="border:1.5px solid #0033FF;margin-bottom:10px;width:40%">
				<legend><font color="#FF0099">库存商品管理</font></legend><br><br>
				<a href="page_jsp/products/addProduct.jsp">增加商品</a><br>
				<a href="page_jsp/products/deleteProduct.jsp">删除商品</a><br>
				<a href="page_jsp/products/modifyProduct.jsp">更改商品信息</a><br>
				<a href="/TEST_MVC/viewProduct.mis">查看所有商品</a><br>
				<a href="/TEST_MVC/viewCategory.mis">查看所有类别</a><br>
				
				<form action="/TEST_MVC/searchProductByCategory.mis" method=post>
				按类别查询：
				<input type=text name=categorys>
				<input type=submit value="查询">
			</form><br><br>
			</fieldset>
			<br>
			<hr>
		</center>
  </body>
</html>
