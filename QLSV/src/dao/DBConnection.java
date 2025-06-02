package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		 Connection c = null;
		 try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databasename = SinhVien;encrypt=true;trustServerCertificate=true;";
			String user = "thinh";
			String password = "280705";
			try {
				c = DriverManager.getConnection(ConnectionUrl, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c != null)
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
