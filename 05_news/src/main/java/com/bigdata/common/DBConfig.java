package com.bigdata.common;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConfig {
	private static boolean isInited = false; // 是否初始化连接池
	private static DataSource ds;

	public static void init() {
		try {
			InitialContext initialContext = new InitialContext();
			ds = (DataSource) initialContext
					.lookup("java:/comp/env/jdbc/expert");
			isInited = true;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (!isInited) {
			init();
		}
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			init();
			return null;
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement ps,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
