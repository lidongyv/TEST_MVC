package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.bean.ProductBean;
import web.mvc.business.iface.ProductBusinessIface;
import web.mvc.business.impl.ProductBusinessImpl;
import web.mvc.dao.iface.BooksDaoIface;
import web.mvc.dao.impl.BooksDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class ModifyProdAction {

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productid = request.getParameter("productid");
		Connection con = DataBaseConnManager.getConnection();
		BooksDaoIface bookDao = new BooksDaoImpl();
		ProductBusinessIface pb = new ProductBusinessImpl(bookDao);

		ProductBean proBean = pb.getProductById(con, productid);

		request.getSession().setAttribute("modify_bean", proBean);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("page_jsp/products/showModifyProduct.jsp");
		requestDispatcher.forward(request, response);
	}
}
