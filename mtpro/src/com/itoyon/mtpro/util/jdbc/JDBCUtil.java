package com.itoyon.mtpro.util.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.itoyon.mtpro.util.properties.PropertiesUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 
 * @Description: JDBC工具类
 * @author: Stone
 * @date: 2018年5月20日 下午10:19:29
 */
public class JDBCUtil {
	String jdbcDriver;
	String jdbcURL;
	String jdbcUser;
	String jdbcPasswd;
	Connection conn;
	Statement stmt = null;
	ResultSet rs = null;

	public JDBCUtil() {
		jdbcDriver = PropertiesUtil.getProperty("JDBC_DRIVER");
		jdbcURL = PropertiesUtil.getProperty("JDBC_URL");
		jdbcUser = PropertiesUtil.getProperty("JDBC_USER");
		jdbcPasswd = PropertiesUtil.getProperty("JDBC_PASSWORD");
	}

	/**
	 * 
	 * @Title: doConnet @Description: 创建数据库连接 @param @return @param @throws
	 *         ClassNotFoundException @param @throws SQLException 设定文件 @return
	 *         Connection 返回类型 @throws
	 */
	public Connection doConnet() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
		conn = (Connection) DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPasswd);

		return conn;
	}

	/**
	 * 
	 * @Title: doQuery @Description: 查询 @param @param sql @param @return
	 *         设定文件 @return ResultSet 返回类型 @throws
	 */
	public ResultSet doQuery(String sql) {
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("数据库连接异常！");
			e.printStackTrace();
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return rs;
	}

	/**
	 * 
	 * @Title: doSaveOrUpdate @Description: 插入、修改或修改 @param @param
	 *         sql @param @return 设定文件 @return int 返回类型 @throws
	 */
	public int doSaveOrUpdate(String sql) {
		int num = 0;
		Statement stmt = null;

		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("数据库连接异常！");
			e.printStackTrace();
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return num;
	}

	/**
	 * 
	 * @Title: doCount @Description: 统计记录数 @param @param sql @param @return
	 *         设定文件 @return int 返回类型 @throws
	 */
	public int doCount(String sql) {
		int num = 0;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("数据库连接异常！");
			e.printStackTrace();
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return num;
	}

	public void doClose() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			System.out.println("关闭数据库连接异常！");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBCUtil jdbcUtil = new JDBCUtil();
		Connection connection = jdbcUtil.doConnet();

		if (!connection.isClosed()) {
			ResultSet rs = jdbcUtil.doQuery("select now() as currTime;");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currTime;
			while (rs.next()) {
				currTime = sdf.format(rs.getTimestamp("currTime"));
				System.out.println("数据库当前时间为：\n" + currTime);
			}
			jdbcUtil.doClose();
		}
	}

}
