<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="web.mvc.util.*,web.mvc.bean.*"%>
<%@ page import="web.mvc.dao.iface.*,web.mvc.dao.impl.*"%>
<%@ page import="web.mvc.business.iface.*,web.mvc.business.impl.*"%>
<%
	Connection con = DataBaseConnManager.getConnection();
	CategoryDaoIface sortDao = new CategoryDaoImpl();
	SortBusinessImpl sb = new SortBusinessImpl();
	sb.setCategoryDao(sortDao);
	
	List<Category> list1 = sb.getAllCategories(con);

	session = request.getSession();
	session.setAttribute("category", list1);


%>

<jsp:forward page="page_jsp/adminMain.jsp"></jsp:forward>