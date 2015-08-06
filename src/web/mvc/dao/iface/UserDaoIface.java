package web.mvc.dao.iface;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.UserBean;

public interface UserDaoIface {

	public UserBean findUserInfo(Connection con, String id, String pwd);

	public int insertNewUser(Connection con, UserBean user);

	public List<UserBean> getAllUsersInfor(Connection con,String sql);

	public boolean deleteUserInforById(Connection con, String id);

	public int modifyUserInfor(Connection con, UserBean bean);
}
