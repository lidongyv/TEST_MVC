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
    
    <title>My JSP 'addProduct.jsp' starting page</title>
    
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
			<h3>添加图书细则</h3>
			<form action="/TEST_MVC/addProduct_do.mis" method="post" name="product">
				<table border="1" bgcolor="#0099CC">
					<tr><td>图书编号：</td><td><input type="text" name="productId"></td></tr>
					<tr><td>名称：</td><td><input 	type="text" name="name"></td></tr>
					<tr><td>价格：</td><td><input 	type="text" name="price"></td></tr>
					<tr><td>出版社:</td><td><input 	type="text" name="producer"></td></tr>
					<tr><td>描述：</td><td><input 	type="text" name="description"></td></tr>
					<tr><td>类别：</td><td>
					  <select name="categoryId">				
					<% 
						Collection categorys=(Collection)session.getAttribute("category");
						if (null != categorys){
						Iterator it=categorys.iterator();
						while(it.hasNext())
						{
						    Category temp=(Category)it.next();
							out.println("<option value="+temp.getCatid()+">"+temp.getCatid()+"</option>");
						}
						}
					%>
					</select>
					
					</td></tr>
					<tr><td colspan="2" align="center"><input type="submit" value="提交"/></td></tr>
				</table>
			</form>
		</center>
	</body>
</html>
