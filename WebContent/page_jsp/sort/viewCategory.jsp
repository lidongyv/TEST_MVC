<%@ page contentType="text/html; charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="web.mvc.bean.*"%>
<%@ page import="java.util.*"%>
<html>
	<head>
		<title>Untitled Document</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>
	<body>
		<center>
			<font color="blue" size=4>你好，${sessionScope.user_name},！</font>
			<h3>
				查看所有的商品类别
			</h3>
			<table width=80% border="1" bgcolor="#ffffcc">
				<tr bgcolor="#009966" bordercolor="#00ff66">
					<td>
						id
					</td>
					<td>
						类别名
					</td>
					<td>
						描述
					</td>
				</tr>
				
				<%
					List<Category> categorys = (List<Category>) session.getAttribute("category");
					Iterator<Category> it = categorys.iterator();
					while (it.hasNext()) {
						Category temp = it.next();
				%>
				<TR bordercolor=green>
					<TD>
					<form name ="form1"action="/TEST_MVC/searchProductByCategory.mis" method =post>
					<input type="hidden" name='categorys' value="{temp.getCatid()}"/>  
						<A href='javascript:document.form1.submit();'>
							<font color=orange><%=temp.getCatid()%></font>
						</A>
						</form>
					</TD>
					<TD><%=temp.getName()%></TD>
					<TD><%=temp.getDesc()%></TD>
				</TR>
				<%
					}
				%>
			</table>
			<a href="page_jsp/adminMain.jsp">返回</a>
		</center>
	</body>
</html>
