package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTo {

	private ConnectTo() {
	}
	
	// Чтобы в базу данных вносились данные кириллицей надо в url писать так как ниже
	// jdbc:mysql:///dbname?useUnicode=true&characterEncoding=utf-8
	private static Connection connect;
	public static String url = "jdbc:mysql://df16c637-ec31-45c3-94a3-a5d500dc2cd1.mysql.sequelizer.com/?useUnicode=true&characterEncoding=utf-8";
	public static String user = "kjtorcjnchdwgvwz"; 
	public static String password = "ESUWH6BFXmMpnGg8mJEy8RWJ4BmLbjkShok6mF3B4nSCzhsDkhQPuB4W5j2gSYEM";
				//  data base name:    dbdf16c637ec3145c394a3a5d500dc2cd1
	
	public static String driverName = "com.mysql.jdbc.Driver";

	static {
		try {
			Class.forName(driverName);
			System.out.println("connecting to database...");
			connect = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {

		}
		System.out.println("Connection successfully completed. URL: " + url);
	}

	public static Connection getConnection() {
		return connect;
	}
	
	public static void closeConnection() throws SQLException {
		if (connect == null) {
			connect.close();
		}
	}

}
