<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="web.mvc.bean.*" %>
<%@ page import="java.sql.*"%>
<%@ page import="web.mvc.util.*,web.mvc.bean.*"%>
<%@ page import="web.mvc.dao.iface.*,web.mvc.dao.impl.*"%>
<%@ page import="web.mvc.business.iface.*,web.mvc.business.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"
					+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deleteProduct.jsp' starting page</title>
    
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
   <p>你好！</p>
			<h3>下列是将要被删除的商品，请点击删除</h3>
			
				<table width=100% border="1" bgcolor="#22ff00">
					<tr bgcolor="#ee7733" bordercolor="green">
						<td align="center">id</td><td align="center">类别</td>
						<td align="center">名称</td><td align="center">出厂商</td>
						<td align="center">价格</td><td align="center">描述</td>
						<td align="center">删除</td>
					</tr>
					<%
					Connection con = DataBaseConnManager.getConnection();
					BooksDaoIface bookDao = new BooksDaoImpl();
					ProductBusinessIface pb = new ProductBusinessImpl(bookDao);

					List<ProductBean> list2 = pb.getAllProduct(con);
					session = request.getSession();
					session.setAttribute("product", list2);
					List<ProductBean> products = (List<ProductBean>)session.getAttribute("product");
					if(products!=null)
					{
					Iterator<ProductBean> it=products.iterator();
					while(it.hasNext())
					{
					    ProductBean temp=it.next();
					    String pid = temp.getId();
					%>
					<form action="/TEST_MVC/deleteProduct_do.mis" method=post>
						<tr bordercolor=#990066>
							<td><%=pid %></td>
							<td><%=temp.getCateid()%></td>
							<td><%=temp.getName()%></td>
							<td><%=temp.getPublisher()%></td>
							<td><%=temp.getPrice()%></td>
							<td><%=temp.getDesc()%></td>
							<input type="hidden" name="productid" value="<%=pid%>"/>
							<td><input type=submit name="submit" value="删除"></td>
						</tr>
					</form>
					<%
					}
					}
					%>
				</table>
			
			<a href="page_jsp/adminMain.jsp">返回</a>
		</center>
  </body>
</html>
