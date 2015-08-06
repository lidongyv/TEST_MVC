package web.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;
import web.mvc.bean.Category;
import web.mvc.bean.ProductBean;
import web.mvc.dao.iface.CategoryDaoIface;
import web.mvc.util.DataBaseConnManager;

public class CategoryDaoImpl implements CategoryDaoIface {

	public List<Category> findAllCategories(Connection con) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String sql = "select * from category_book_t";
		List<Category> list = new ArrayList<Category>();

		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while (rst.next()) {
				String catid = rst.getString("catid");
				String name = rst.getString("name");
				String descn = rst.getString("descn");

				Category category = new Category();
				category.setCatid(catid);
				category.setName(name);
				category.setDesc(descn);

				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closeResultSet(rst);
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return list;
	}
	
	public List<ProductBean> serachAllCategories(Connection con,String categoryid) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String sql = "select * from information_tab where categoryid=?";
		List<ProductBean> list = new ArrayList<ProductBean>();

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, categoryid);
			rst = pst.executeQuery();
			while (rst.next()) {
				String productid = rst.getString("productid");
				String categoryId = rst.getString("categoryid");
				String name = rst.getString("name");
				String publisher = rst.getString("publisher");
				float price = rst.getFloat("price");
				String desc = rst.getString("description");

				ProductBean book = new ProductBean();
				book.setId(productid);
				book.setCateid(categoryId);
				book.setName(name);
				book.setPrice(price);
				book.setPublisher(publisher);
				book.setDesc(desc);

				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closeResultSet(rst);
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return list;
	}
}
