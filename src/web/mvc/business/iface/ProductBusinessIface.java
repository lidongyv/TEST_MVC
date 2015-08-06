package web.mvc.business.iface;

import java.sql.Connection;
import java.util.List;

import web.mvc.bean.ProductBean;

public interface ProductBusinessIface {

	public List<ProductBean> getAllProduct(Connection con);

	public List<ProductBean> getProByCategory(Connection con, String category);

	public ProductBean getProductById(Connection con, String proId);

	public int updateProById(Connection con, ProductBean bean);

	public int addNewProduct(Connection con, ProductBean bean);

	public int deleteProInfor(Connection con, String proId);
}
