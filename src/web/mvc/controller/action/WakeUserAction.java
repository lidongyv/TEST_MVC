package web.mvc.controller.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

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

public class WakeUserAction {
	public void execute(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{

	    String login_id = request.getParameter("Is_used");
		int j = -1;
		PreparedStatement pst = null;
		Connection con = null;
		try{
		String sql ="update user_infor_tab set is_used =1 where login_id=?";
		con = DataBaseConnManager.getConnection();
		pst = con.prepareStatement(sql);
		System.out.println(login_id);
		pst.setString(1, login_id);
		j = pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DataBaseConnManager.closePreparedStatement(pst);
		}
		
		UserDaoIface userDao = new UserDaoImpl();
		UserBusinessIface ub = new UserBusinessImpl(userDao);
		String sql = "select * from USER_INFOR_TAB where is_used=0";
		List<UserBean> list = ub.getAllUsers(con, sql);
		request.getSession().setAttribute("IS_used", list);
		if(j == 1 ){
		RequestDispatcher rd = request.getRequestDispatcher("page_jsp/products/wakeUserSuccess.jsp");
		rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("page_jsp/products/wakeUserFailed.jsp");
			rd.forward(request, response);
		}
	
	}
}
