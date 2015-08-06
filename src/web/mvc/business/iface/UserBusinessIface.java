package web.mvc.business.iface;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.UserBean;

public interface UserBusinessIface {

	public UserBean getUserInfo(Connection con, String id, String pwd);

	public int addNewUser(Connection con, UserBean user);

	public List<UserBean> getAllUsers(Connection con,String sql);

	public boolean deleteUserById(Connection con, String id);

	public int modifyUser(Connection con, UserBean bean);
}
