package web.mvc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataBaseConnManager {

	public static Connection getConnection() {
		String driver = "org.gjt.mm.mysql.Driver";
		String url = "jdbc:mysql://localhost:3306/test_mvc";
		String user = "root";
		String pwd = "";
		Connection con = null;
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection2() {
		Connection con = null;
		try {
			InitialContext initConx = new InitialContext();
			Context cxt = (Context) initConx.lookup("java:comp/env");
			DataSource ds = (DataSource) cxt.lookup("jdbc/proMIS");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConn(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement pst) {

		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeAll(Connection con, PreparedStatement pst,
			ResultSet rs) {

		if (rs != null && pst != null & rs != null) {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeCon_Pst(Connection con, PreparedStatement pst) {

		if (pst != null && con != null) {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}