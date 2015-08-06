package web.mvc.controller.action;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.bean.UserBean;
import web.mvc.dao.iface.UserDaoIface;
import web.mvc.dao.impl.UserDaoImpl;
import web.mvc.util.DataBaseConnManager;

public class UserLoginAction {
	public void execute(HttpServletRequest request,HttpServletResponse response){
		try{
			Connection conn = DataBaseConnManager.getConnection();
			UserDaoIface userDao =new UserDaoImpl();
			
			String id = request.getParameter("login_id");
			String pwd = request.getParameter("password");
			UserBean user = userDao.findUserInfo(conn, id, pwd);
			String is_used = user.getIs_used();
			if(user!=null && is_used.equals("1")){
				request.setAttribute("loid", id);
				//request.getSession().setAttribute("UserBean",user);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("errors","用户名或密码错误");
				RequestDispatcher rd =request.getRequestDispatcher("errors.jsp");
				rd.forward(request, response);
	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
