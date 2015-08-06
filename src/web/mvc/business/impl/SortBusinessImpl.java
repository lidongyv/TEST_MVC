package web.mvc.business.impl;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.Category;
import web.mvc.business.iface.SortBuinessIface;
import web.mvc.dao.iface.CategoryDaoIface;

public class SortBusinessImpl implements SortBuinessIface {

	private CategoryDaoIface categoryDao = null;

	public CategoryDaoIface getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDaoIface categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> getAllCategories(Connection con) {

		return this.categoryDao.findAllCategories(con);
	}
}
