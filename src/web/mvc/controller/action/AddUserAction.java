package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.bean.UserBean;
import web.mvc.business.iface.UserBusinessIface;
import web.mvc.business.impl.UserBusinessImpl;
import web.mvc.dao.iface.UserDaoIface;
import web.mvc.dao.impl.UserDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class AddUserAction {
	public void execute(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String login_id = request.getParameter("login_id");
		String login_pwd = request.getParameter("login_pwd");
		String user_name = request.getParameter("user_name");
		String user_sex = request.getParameter("user_sex");
		String user_location = request.getParameter("user_location");
		String user_phone = request.getParameter("user_phone");
		String user_email =request.getParameter("user_email");
		String user_right =request.getParameter("user_right");
		
		UserBean user = new UserBean();
		user.setLogin_id(login_id);
		user.setPwd(login_pwd);
		user.setName(user_name);
		user.setSex(user_sex);
		user.setLocation(user_location);
		user.setPhone(user_phone);
		user.setEmail(user_email);
		user.setUser_right(user_right);
		
		Connection con = DataBaseConnManager.getConnection();
		UserDaoIface userDao =new UserDaoImpl();
		UserBusinessIface ub = new UserBusinessImpl(userDao);
		int j = ub.addNewUser(con,user);
		
		if(j==1){
			request.setAttribute("new_user",user);
			RequestDispatcher rd = request.getRequestDispatcher("page_jsp/products/addUserSuccess.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("page_jsp/products/addUserFailed.jsp");
			rd.forward(request, response);
		}
	}

}
