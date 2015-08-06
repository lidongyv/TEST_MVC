package web.mvc.dao.iface;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.Category;
import web.mvc.bean.ProductBean;

public interface CategoryDaoIface {

	public List<Category> findAllCategories(Connection con);
	
	public List<ProductBean> serachAllCategories(Connection con,String categoryid);
}
