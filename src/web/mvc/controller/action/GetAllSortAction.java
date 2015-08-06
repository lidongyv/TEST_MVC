package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.mvc.bean.Category;
import web.mvc.business.impl.SortBusinessImpl;
import web.mvc.dao.iface.CategoryDaoIface;
import web.mvc.dao.impl.CategoryDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class GetAllSortAction {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection con = DataBaseConnManager.getConnection();
		CategoryDaoIface sortDao = new CategoryDaoImpl();
		SortBusinessImpl sb = new SortBusinessImpl();
		sb.setCategoryDao(sortDao);

		List<Category> list = sb.getAllCategories(con);

		HttpSession session = request.getSession();
		session.setAttribute("category", list);
		RequestDispatcher reqDis = request
				.getRequestDispatcher("page_jsp/sort/viewCategory.jsp");
		reqDis.forward(request, response);
	}
}
