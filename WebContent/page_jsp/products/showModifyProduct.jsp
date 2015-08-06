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
    
    <title>My JSP 'showModifyProduct.jsp' starting page</title>
    
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
    	<%-- ${sessionScope.modify_bean.name}
    	${sessionScope.modify_bean.cateid}
    	${sessionScope.modify_bean.publisher}
    	${sessionScope.modify_bean.price}
    	${sessionScope.modify_bean.desc}
    	${sessionScope.modify_bean.name}--%>
		<%
			ProductBean pro = (ProductBean)session.getAttribute("modify_bean");
			String name = pro.getName();
			float price = pro.getPrice();
			String producer = pro.getPublisher();
			String productid = pro.getId();
			String descn = pro.getDesc();
			String categoryid = pro.getCateid();
		%>
		<h3>将修改的是：<font size="2" color="orange"><%=name%></font>&nbsp;&nbsp;的细则</h3>
		<form action="/TEST_MVC/to_modifyProduct_do.mis" method="post" name="product">
			<table border="1" bgcolor="#44ffee">
				<tr><td><font size="2" color="gray">图书编号：</font></td>	
					<td><input type="text" name="productId" readonly value="<%=productid%>"></td>
				</tr>
				<tr><td><font size="2" color="gray">名称：</font>	</td>		
					<td><input type="text" name="name" value="<%=name%>"></td>
				</tr>
				<tr><td><font size="2" color="gray">价格：</font>	</td>		
					<td><input type="text" name="price" value="<%=price%>"></td>
				</tr>
				<tr><td><font size="2" color="gray">出版社:</font></td>		
					<td><input type="text" name="producer" value="<%=producer%>"></td>
				</tr>
				<tr><td><font size="2" color="gray">描述：</font>	</td>		
					<td><input type="text" name="description" value="<%=descn%>"></td>
				</tr>
				<tr><td><font size="2" color="gray">类别：</font>	</td>		
					<td><select name="categoryId" >
				<% 
					List<Category> categorys=(List<Category>)session.getAttribute("category");
					
					Iterator<Category> it=categorys.iterator();
					while(it.hasNext()){
						Category temp=it.next();
						String catId = temp.getCatid();
						
						
						if(catId.equals(categoryid)){
							out.println("<option selected value="+catId+">"+catId+"</option>");
						}else{
							out.println("<option value="+catId+">"+catId+"</option>");
						 }
					}
				%>
					</select></td>
				</tr>
				<tr><td colspan="2" align="center"><input type=submit value=提交修改 ></td></tr>
			</table>
		</form>
	</center>
  </body>
</html>
