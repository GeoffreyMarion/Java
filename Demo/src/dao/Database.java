package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/";
		String dbName = "aviation";
		String user = "root";
		String pwd = "";
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connect = (Connection) DriverManager.getConnection(url + dbName, user, pwd);
				System.out.println("OK for connect");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connect;
	}

}