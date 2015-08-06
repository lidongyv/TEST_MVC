<%@ page contentType="text/html; charset=gb2312" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="web.mvc.bean.*"%>
<html>
	<head>
		<title>Untitled Document</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>
	<body>
	<%
    	String name = (String)session.getAttribute("user_name");
    	String category=request.getParameter("category");
    %>
		<center>
		<font color="blue" size=4>你好，<%= name%>！</font>
			<h1>查看类别为<font color=red><%=category%></font>的商品</h1>
			<table width=80% border="1" bgcolor="#0099CC">
				<tr bgcolor="#009966" bordercolor="#990066">
					<td>id</td><td>类别</td><td>名称</td><td>出厂商</td><td>价格</td><td>描述</td>
				</tr>
				<%
				List<ProductBean> list= (List)request.getAttribute("productByCategory");
				Iterator<ProductBean> it=list.iterator();
				while(it.hasNext())
				{
				    ProductBean temp=it.next();
				%>
					<tr bordercolor=#990066>
						<td><%=temp.getId()%></td>
						<td><%=temp.getCateid()%></td>
						<td><%=temp.getName()%></td>
						<td><%=temp.getPublisher()%></td>
						<td><%=temp.getPrice()%></td>
						<td><%=temp.getDesc()%></td>
					</tr>
				<%
				}
				%>
			</table>
			<a href="index.jsp">返回</a>
		</center>
	</body>
</html>
