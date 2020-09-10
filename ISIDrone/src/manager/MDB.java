package manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class MDB extends HttpServlet{
	private static Connection connection = null;
        private static String dbName;
        private static String dbIp;
        private static String dbPort;
        private static String dbUsername;
        private static String dbPassword;
	
	public static void connect() throws SQLException, FileNotFoundException, IOException {
		try {
                        Properties properties = new Properties();
                        //properties.load(new FileInputStream("C:\\dev\\devint\\devint_e20\\ISIDrone\\src\\util\\configs.properties"));
                        String fileName = "configs.properties";
                        InputStream input = MDB.class.getClassLoader().getResourceAsStream(fileName);  
                        properties.load(input);
                        
                        dbName = properties.getProperty("DB_NAME");
                        dbIp = properties.getProperty("DB_IP");
                        dbPort = properties.getProperty("DB_PORT");
                        dbUsername = properties.getProperty("DB_USERNAME");
                        dbPassword = properties.getProperty("DB_PASSWORD");
                        
			Class.forName("com.mysql.cj.jdbc.Driver");
                        String mysqlURL = "jdbc:mysql://" + dbIp + ":" + dbPort + "/" + dbName + "?serverTimezone=UTC" ;
			connection = DriverManager.getConnection(mysqlURL, "root", "abc123...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
        
        public static Connection connection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String mysqlURL="jdbc:mysql://127.0.0.1:3306/isidrone?serverTimezone=UTC";
			 connection = DriverManager.getConnection(mysqlURL, "root", "abc123...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
                return connection;
	}
	
	public static ResultSet execQuery(String query) throws IOException {
		PreparedStatement ps = getPS(query);
		ResultSet rs = null;
		try {
			if(ps != null) {
				ps.execute();
				rs = ps.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rs;
	}
	
	public static PreparedStatement getPS(String query) throws IOException {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
			ps = connection.prepareStatement(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static PreparedStatement getPS(String query, int id) throws IOException {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
			if (id == 1)
				ps = connection.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static PreparedStatement getPS(String query, String column) throws IOException {
		return getPS(query, new String[]{column});
	}
	
	public static PreparedStatement getPS(String query, String[] columns) throws IOException {
		PreparedStatement ps = null;
		try { 
			if(connection == null || connection.isClosed())
				connect();
				ps = connection.prepareStatement(query,columns);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ps;
	}
	
	public static void disconnect() {
		try {
			if(connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection = null;
		}
	}
}
