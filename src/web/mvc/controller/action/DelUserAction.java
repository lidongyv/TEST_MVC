package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.business.iface.UserBusinessIface;
import web.mvc.business.impl.UserBusinessImpl;
import web.mvc.dao.iface.UserDaoIface;
import web.mvc.dao.impl.UserDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class DelUserAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		String login_Id = request.getParameter("login_ID");
		
		Connection con = DataBaseConnManager.getConnection();
		UserDaoIface userDao =new UserDaoImpl();
		UserBusinessIface ub = new UserBusinessImpl(userDao);
		
		boolean b = ub.deleteUserById(con, login_Id);

		if(b==true){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("page_jsp/products/deleteUserSuccess.jsp");
			requestDispatcher.forward(request,response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("page_jsp/products/deleteUserFailed.jsp");
			requestDispatcher.forward(request,response);
		}
	}

}
