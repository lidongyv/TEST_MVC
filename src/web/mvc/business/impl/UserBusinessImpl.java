package web.mvc.business.impl;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.UserBean;
import web.mvc.business.iface.UserBusinessIface;
import web.mvc.dao.iface.UserDaoIface;

public class UserBusinessImpl implements UserBusinessIface {

	private UserDaoIface userDao = null;

	public UserBusinessImpl(UserDaoIface userDao) {
		this.userDao = userDao;
	}

	public UserBean getUserInfo(Connection con, String id, String pwd) {

		return this.userDao.findUserInfo(con, id, pwd);
	}

	public int addNewUser(Connection con, UserBean user) {

		return this.userDao.insertNewUser(con, user);
	}

	public List<UserBean> getAllUsers(Connection con,String sql) {

		return this.userDao.getAllUsersInfor(con,sql);
	}

	public boolean deleteUserById(Connection con, String id) {

		return this.userDao.deleteUserInforById(con, id);
	}

	public int modifyUser(Connection con, UserBean bean) {

		return this.userDao.modifyUserInfor(con, bean);
	}
}
