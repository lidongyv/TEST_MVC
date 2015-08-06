package web.mvc.business.impl;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.ProductBean;
import web.mvc.business.iface.ProductBusinessIface;
import web.mvc.dao.iface.BooksDaoIface;

public class ProductBusinessImpl implements ProductBusinessIface {

	private BooksDaoIface bookDao = null;

	public ProductBusinessImpl(BooksDaoIface bookDao) {
		this.bookDao = bookDao;
	}

	public List<ProductBean> getAllProduct(Connection con) {

		return this.bookDao.getAllBooks(con);
	}

	public List<ProductBean> getProByCategory(Connection con, String category) {

		return this.bookDao.findProByCategory(con, category);
	}
	

	public ProductBean getProductById(Connection con, String proId) {

		return this.bookDao.findBookById(con, proId);
	}

	public int updateProById(Connection con, ProductBean bean) {

		return this.bookDao.modifyProById(con, bean);
	}

	public int addNewProduct(Connection con, ProductBean bean) {

		return this.bookDao.insertNewPro(con, bean);
	}

	public int deleteProInfor(Connection con, String proId) {

		return this.bookDao.deleteProInfor(con, proId);
	}
}
