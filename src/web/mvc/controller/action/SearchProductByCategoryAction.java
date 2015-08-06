package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.mvc.bean.ProductBean;
import web.mvc.business.iface.ProductBusinessIface;
import web.mvc.business.impl.ProductBusinessImpl;
import web.mvc.dao.iface.BooksDaoIface;
import web.mvc.dao.iface.CategoryDaoIface;
import web.mvc.dao.impl.BooksDaoImpl;
import web.mvc.dao.impl.CategoryDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class SearchProductByCategoryAction {
public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		Connection con = DataBaseConnManager.getConnection();
		CategoryDaoIface bookDao = new CategoryDaoImpl();
		//ProductBusinessIface pb = new ProductBusinessImpl(bookDao);
		
		String categoryid = request.getParameter("categorys");
		List<ProductBean> list = bookDao.serachAllCategories(con,categoryid);

		HttpSession session = request.getSession();
		session.setAttribute("products", list);
		RequestDispatcher reqDis = request
				.getRequestDispatcher("page_jsp/products/searchProduct.jsp");
		reqDis.forward(request, response);
		
		
	}

}
