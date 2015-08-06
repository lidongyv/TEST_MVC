<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="web.mvc.bean.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'modifyProduct.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body style="font-size:12px;color:#006699;">

		<center>
		<%--<font color="blue" size=4>你好，${sessionScope.user_name}！</font>--%>
			<h3> 
				如下是你需要修改的商品，请点选后进行修改： 
			</h3>

			<table width=100% border="1" style="font-size:12px;color:#006699;">
				<tr bgcolor="#FFFF99">
					<td align="center">
						id
					</td>
					<td align="center">
						类别
					</td>
					<td align="center">
						名称
					</td>
					<td align="center">
						出厂商
					</td>
					<td align="center">
						价格
					</td>
					<td align="center">
						描述
					</td>
					<td align="center">
						修改
					</td>
				</tr>
				<%!String pid = null;%>
				<%
					List<ProductBean> products = (List<ProductBean>) session.getAttribute("product");
					Iterator<ProductBean> it = products.iterator();
					while (it.hasNext()) {
						ProductBean temp = it.next();
						pid = temp.getId();
				%>
				<form action="/TEST_MVC/modifyProduct_do.mis" method="post">
				<tr>
					<td><%=pid%></td>
					<td><%=temp.getCateid()%></td>
					<td><%=temp.getName()%></td>
					<td><%=temp.getPublisher()%></td>
					<td><%=temp.getPrice()%></td>
					<td><%=temp.getDesc()%></td>
					<input type="hidden" name="productid" value="<%=pid%>" />
					<td>
						<input type=submit name="submit" value="修改">
					</td>
				</tr>
				</form>
				<%
					}
				%>
			</table>

			<a href="page_jsp/adminMain.jsp">返回</a>
		</center>
	</body>
</html>
