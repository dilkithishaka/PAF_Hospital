package db;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	

		
	public static Connection connect() {
			
		
			Connection con = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitaldb", "root", "root");
				// For testing
				System.out.print("DB_connected_Successfully ");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		
	}
		
	}


