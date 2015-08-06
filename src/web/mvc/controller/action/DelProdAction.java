package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.business.iface.ProductBusinessIface;
import web.mvc.business.impl.ProductBusinessImpl;
import web.mvc.dao.iface.BooksDaoIface;
import web.mvc.dao.impl.BooksDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class DelProdAction {
	
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String proId = request.getParameter("productid");
		
		Connection con = DataBaseConnManager.getConnection();
		BooksDaoIface bookDao = new BooksDaoImpl();
		ProductBusinessIface pb = new ProductBusinessImpl(bookDao);
		
		int b = pb.deleteProInfor(con, proId);

		if(b==1){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("page_jsp/products/deleteProductSuccess.jsp");
			requestDispatcher.forward(request,response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("page_jsp/products/deleteProductFailed.jsp");
			requestDispatcher.forward(request,response);
		}
	}
}
