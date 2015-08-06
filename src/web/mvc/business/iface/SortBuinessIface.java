package web.mvc.business.iface;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.Category;

public interface SortBuinessIface {
	public List<Category> getAllCategories(Connection con);
}
