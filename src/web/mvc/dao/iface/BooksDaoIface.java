package web.mvc.dao.iface;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.ProductBean;

public interface BooksDaoIface {

	public List<ProductBean> getAllBooks(Connection con);

	public List<ProductBean> findProByCategory(Connection con, String category);

	public ProductBean findBookById(Connection con, String proId);

	public int modifyProById(Connection con, ProductBean bean);

	public int insertNewPro(Connection con, ProductBean bean);

	public int deleteProInfor(Connection con, String proId);
}
