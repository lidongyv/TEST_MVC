<%@ page contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="web.mvc.bean.*"%>
<%@ page import="java.util.*"%>
<%@ page session="true" %>
<html>
	<head>
		<title>Untitled Document</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>
	<body>
	<% 
    	String name = (String)session.getAttribute("user_name"); 
     %>
		<center>
		<%--<font color="blue" size=4>��ã�<%= name%>��</font> --%>
			<h3>�鿴���е���Ʒ</h3>
			<table width=80% border="1" bgcolor="#006699">
				<tr bgcolor="#009966" bordercolor="#ffffcc">
					<td align="center">id</td>
					<td align="center">���</td>
					<td align="center">����</td>
					<td align="center">������</td>
					<td align="center">�۸�</td>
					<td align="center">����</td>
				</tr>
				
				
				<%
					Collection list =(Collection)session.getAttribute("product");
					Iterator it=list.iterator();
					while(it.hasNext())
					{
					    ProductBean temp=(ProductBean)it.next();
				%>
				<TR bordercolor=#990066>
					<TD><font size="2" color="yellow"><%=temp.getId()%></font></TD>
					<TD><font size="2" color="yellow"><%=temp.getCateid()%></font></TD>
					<TD><font size="2" color="yellow"><%=temp.getName()%></font></TD>
					<TD><font size="2" color="yellow"><%=temp.getPublisher()%></font></TD>
					<TD><font size="2" color="yellow"><%=temp.getPrice()%></font></TD>
					<TD><font size="2" color="yellow"><%=temp.getDesc()%></font></TD>
				</TR>
				<%}%>
			</table>
			<a href="page_jsp/adminMain.jsp">����</a>
		</center>
	</body>
</html>
