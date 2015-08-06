package web.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.mvc.bean.UserBean;
import web.mvc.dao.iface.UserDaoIface;
import web.mvc.util.DataBaseConnManager;

public class UserDaoImpl implements UserDaoIface {

	public UserBean findUserInfo(Connection con, String id, String pwd) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from USER_INFOR_TAB where login_id=? and login_pwd=?";
		UserBean user = new UserBean();
		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, id);

			pst.setString(2, pwd);

			rs = pst.executeQuery();

			while (rs.next()) {
				String loginid = rs.getString(2);
				String loginpwd = rs.getString(3);
				String name = rs.getString(4);
				String sex = rs.getString(5);
				String location = rs.getString(6);
				String phone = rs.getString(7);
				String email = rs.getString(8);
				String right = rs.getString(9);
				String isused = rs.getString(10);

				user.setEmail(email);
				user.setLocation(location);
				user.setLogin_id(loginid);
				user.setName(name);
				user.setPhone(phone);
				user.setPwd(loginpwd);
				user.setSex(sex);
				user.setUser_right(right);
				user.setIs_used(isused);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closeResultSet(rs);
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return user;
	}

	public int insertNewUser(Connection con, UserBean user) {
		String sql = "insert into USER_INFOR_TAB values (id,?,?,?,?,?,?,?,?,1)";
		//String sql = "insert into USER_INFOR_TAB values (?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		int i = 0;

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getLogin_id());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getName());
			pst.setString(4, user.getSex());
			pst.setString(5, user.getLocation());
			pst.setString(6, user.getPhone());
			pst.setString(7, user.getEmail());
			pst.setString(8, user.getUser_right());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return i;
	}

	public List<UserBean> getAllUsersInfor(Connection con,String sql) {
		/*
		 * id number(3) primary key not null, login_id varchar2(8) , login_pwd
		 * varchar2(6), user_name varchar2(18), user_sex varchar2(10),
		 * user_location varchar2(20), user_phone varchar2(12), user_email
		 * varchar2(25), user_right varchar2(1)
		 */

		PreparedStatement pst = null;
		ResultSet rs = null;
		List<UserBean> userList = new ArrayList<UserBean>();

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setLogin_id(rs.getString("login_id"));
				user.setPwd(rs.getString("login_pwd"));
				user.setName(rs.getString("user_name"));
				user.setSex(rs.getString("user_sex"));
				user.setLocation(rs.getString("user_location"));
				user.setPhone(rs.getString("user_phone"));
				user.setEmail(rs.getString("user_email"));
				user.setUser_right(rs.getString("user_right"));
				//user.setIs_used(rs.getString(10));

				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closeResultSet(rs);
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return userList;
	}

	public boolean deleteUserInforById(Connection con, String id) {
		String sql = "delete from USER_INFOR_TAB where login_id=?";
		PreparedStatement pst = null;
		int a = 0;
		boolean b = false;

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			a = pst.executeUpdate();
			if (a == 1) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closePreparedStatement(pst);
			DataBaseConnManager.closeConn(con);
		}
		return b;
	}

	/*
	 * login_id varchar2(8) , login_pwd varchar2(6), user_name varchar2(18),
	 * user_sex varchar2(10), user_location varchar2(20), user_phone
	 * varchar2(12), user_email varchar2(25), user_right varchar2(1)
	 */
	public int modifyUserInfor(Connection con, UserBean bean) {
		String sql = "update USER_INFOR_TAB set login_pwd=?,user_name=?,user_sex=?,user_location=?,user_phone=?,user_email=?,user_right=? where login_id=?";

		PreparedStatement pst = null;
		int a = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, bean.getPwd());
			pst.setString(2, bean.getName());
			pst.setString(3, bean.getSex());
			pst.setString(4, bean.getLocation());
			pst.setString(5, bean.getPhone());
			pst.setString(6, bean.getEmail());
			pst.setString(7, bean.getUser_right());
			pst.setString(8, bean.getLogin_id());
			a = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closePreparedStatement(pst);
			DataBaseConnManager.closeConn(con);
		}
		return a;
	}
}
