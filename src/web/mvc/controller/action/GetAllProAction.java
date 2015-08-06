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
import web.mvc.dao.impl.BooksDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class GetAllProAction {
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		Connection con = DataBaseConnManager.getConnection();
		BooksDaoIface bookDao = new BooksDaoImpl();
		ProductBusinessIface pb = new ProductBusinessImpl(bookDao);
		
		List<ProductBean> list = pb.getAllProduct(con);

		HttpSession session = request.getSession();
		session.setAttribute("product", list);
		RequestDispatcher reqDis = request
				.getRequestDispatcher("page_jsp/products/viewProduct.jsp");
		reqDis.forward(request, response);
	}
}
