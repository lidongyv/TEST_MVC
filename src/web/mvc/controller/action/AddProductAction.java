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

public class AddProductAction {

	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
		String productid = request.getParameter("productId");
		String publisher = request.getParameter("producer");
		String name = request.getParameter("name");
		float price =Float.parseFloat(request.getParameter("price"));
		String descn = request.getParameter("description");
		String cateid = request.getParameter("categoryId");
		
		ProductBean bean = new ProductBean();
		bean.setId(productid);
		bean.setPublisher(publisher);
		bean.setName(name);
		bean.setPrice(price);
		bean.setDesc(descn);
		bean.setCateid(cateid);
		
		//
		Connection con = DataBaseConnManager.getConnection();
		BooksDaoIface bookDao = new BooksDaoImpl();
		ProductBusinessIface pb = new ProductBusinessImpl(bookDao);
		int j = pb.addNewProduct(con, bean);
		
		if(j==1){
			request.setAttribute("new_pro",bean);
			RequestDispatcher rd = request.getRequestDispatcher("page_jsp/products/addProductSuccess.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("page_jsp/products/addProductFailed.jsp");
			rd.forward(request, response);
		}
	}
}
