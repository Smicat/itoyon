package com.itoyon.mtpro.util.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * 
 * @Description: JDBC工具类
 * @author: Stone
 * @date: 2018年5月20日 下午10:19:29
 */
public class JDBCUtil {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://101.37.161.79:3306/testdb";
	private static final String JDBC_USER = "itest";
	private static final String JDBC_PASSWORD = "_P@ss1234";

	private Connection conn;
	private Statement stmt = null;
	private ResultSet rs = null;

	/**
	 * 
	 * @Title: doConnet @Description: 创建数据库连接 @param @return @param @throws
	 * ClassNotFoundException @param @throws SQLException 设定文件 @return
	 * Connection 返回类型 @throws
	 */
	public Connection doConnet() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		conn = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

		return conn;
	}

	/**
	 * 
	 * @Title: doQuery @Description: 查询 @param @param sql @param @return
	 * 设定文件 @return ResultSet 返回类型 @throws
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
	 * sql @param @return 设定文件 @return int 返回类型 @throws
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
	 * 设定文件 @return int 返回类型 @throws
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
			ResultSet rs = jdbcUtil.doQuery("select count(*) as cnt from t_init_diag;");
			int cnt = 0;
			while (rs.next()) {
				cnt = rs.getInt("cnt");
				System.out.println("t_init_diag表的记录总数为：" + cnt + "条");
			}
			jdbcUtil.doClose();
		}
	}

}
