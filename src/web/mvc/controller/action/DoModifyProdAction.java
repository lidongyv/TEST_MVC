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

public class DoModifyProdAction {

	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String productid = request.getParameter("productId");
		
		String producer = new String(request.getParameter("producer").getBytes("gb2312"),"GBK");
		String name = new String(request.getParameter("name").getBytes("gb2312"),"GBK");
		float price =Float.parseFloat(request.getParameter("price"));
		String descn = new String(request.getParameter("description").getBytes("gb2312"),"GBK");
		String category = request.getParameter("categoryId");
		
		ProductBean  bean = new ProductBean();
		bean.setCateid(category);
		bean.setDesc(descn);
		bean.setId(productid);
		bean.setName(name);
		bean.setPrice(price);
		bean.setPublisher(producer);
		
		Connection con = DataBaseConnManager.getConnection();
		BooksDaoIface bookDao = new BooksDaoImpl();
		ProductBusinessIface pb = new ProductBusinessImpl(bookDao);
		
		int m = pb.updateProById(con, bean);

		if(m==1){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("page_jsp/products/modifyProductSuccess.jsp");
			requestDispatcher.forward(request,response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("page_jsp/products/modifyProductFailed.jsp");
			requestDispatcher.forward(request,response);
		}
	}
}
