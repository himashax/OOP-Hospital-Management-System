package DBConnectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connection;

	
	private DBConnection() {}
		
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
			if(connection == null || connection.isClosed())
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOP_HMS","root","");
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		return connection;
	}
	
}
