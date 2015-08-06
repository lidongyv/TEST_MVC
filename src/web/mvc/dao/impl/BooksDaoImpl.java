package web.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.mvc.bean.ProductBean;
import web.mvc.dao.iface.BooksDaoIface;
import web.mvc.util.DataBaseConnManager;

public class BooksDaoImpl implements BooksDaoIface {

	public List<ProductBean> getAllBooks(Connection con) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from INFORMATION_TAB";
		List<ProductBean> list = new ArrayList<ProductBean>();

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("productid");
				String category = rs.getString("categoryid");
				String name = rs.getString("name");
				String producer = rs.getString("publisher");
				float price = rs.getFloat("price");
				String des = rs.getString("description");

				ProductBean product = new ProductBean();
				product.setId(id);
				product.setCateid(category);
				product.setName(name);
				product.setPublisher(producer);
				product.setPrice(price);
				product.setDesc(des);

				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ProductBean> findProByCategory(Connection con, String category) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<ProductBean> list = new ArrayList<ProductBean>();
		String sql = "select * from INFORMATION_TAB where categoryid=?";

		try {
			st = con.prepareStatement(sql);
			st.setString(1, category);
			rs = st.executeQuery();
			while (rs.next()) {
				String id = rs.getString("productid");
				String catid = rs.getString("categoryid");
				String name = rs.getString("name");
				String producer = rs.getString("publisher");
				float price = rs.getFloat("price");
				String des = rs.getString("description");

				ProductBean product = new ProductBean();
				product.setCateid(catid);
				product.setPrice(price);
				product.setPublisher(producer);
				product.setId(id);
				product.setName(name);
				product.setDesc(des);

				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closeResultSet(rs);
			DataBaseConnManager.closePreparedStatement(st);
		}
		return list;
	}

	public ProductBean findBookById(Connection con, String proId) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from INFORMATION_TAB where productid=?";
		ProductBean product = new ProductBean();

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, proId);
			rs = pst.executeQuery();
			while (rs.next()) {

				String name = rs.getString("name");
				String producer = rs.getString("publisher");
				float price = rs.getFloat("price");
				String categoryid = rs.getString("categoryid");
				String descn = rs.getString("description");

				product.setCateid(categoryid);
				product.setDesc(descn);
				product.setName(name);
				product.setPrice(price);
				product.setPublisher(producer);
				product.setId(proId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closeResultSet(rs);
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return product;
	}

	public int modifyProById(Connection con, ProductBean bean) {
		PreparedStatement pst = null;
		String sql = "update INFORMATION_TAB set categoryid=?,name=?,publisher=?,price=?,description=? where productid=? ";
		int i = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, bean.getCateid());
			pst.setString(2, bean.getName());
			pst.setString(3, bean.getPublisher());
			pst.setFloat(4, bean.getPrice());
			pst.setString(5, bean.getDesc());
			pst.setString(6, bean.getId());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return i;
	}

	public int insertNewPro(Connection con, ProductBean bean) {
		PreparedStatement pst = null;
		String sql = "insert into INFORMATION_TAB values(?,?,?,?,?,?)";
		int i = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, bean.getId());
			pst.setString(2, bean.getCateid());
			pst.setString(3, bean.getName());
			pst.setString(4, bean.getPublisher());
			pst.setFloat(5, bean.getPrice());
			pst.setString(6, bean.getDesc());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return i;
	}

	public int deleteProInfor(Connection con, String proId) {
		PreparedStatement pst = null;
		String sql = "delete from INFORMATION_TAB where productid=?";
		int b = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, proId);
			b = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnManager.closePreparedStatement(pst);
		}
		return b;
	}
}
