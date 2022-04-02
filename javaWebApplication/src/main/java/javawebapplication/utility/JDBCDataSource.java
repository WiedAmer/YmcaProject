package javawebapplication.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {
	
//	public static void main(String[] args) {
//		ResourceBundle rb = ResourceBundle.getBundle("JavaWebApp.System");
//		String url = rb.getString("url");
//		System.out.println("Data Base URL is:" + url);
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javawebtut", "root", "fender");
//			System.out.println(con);
//			Statement stmt = con.createStatement();
//			stmt.executeUpdate("insert into user(name, pass) values ('codebyn', 'Codebun@123')");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	 /**
     * JDBC Database connection pool ( DCP )
     */
    private static JDBCDataSource datasource;
    private JDBCDataSource() {
    }
    private ComboPooledDataSource cpds = null;
    /**
     * Create instance of Connection Pool
     *
     * @return
     */
    public static JDBCDataSource getInstance() {
        if (datasource == null) {
            ResourceBundle rb = ResourceBundle.getBundle("javawebapp.System");
            datasource = new JDBCDataSource();
            datasource.cpds = new ComboPooledDataSource();
            try {
                datasource.cpds.setDriverClass(rb.getString("driver"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            datasource.cpds.setJdbcUrl(rb.getString("url"));
            datasource.cpds.setUser(rb.getString("username"));
            datasource.cpds.setPassword(rb.getString("password"));
            datasource.cpds.setInitialPoolSize(new Integer((String) rb .getString("initialPoolSize")));
            datasource.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
            datasource.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
            datasource.cpds.setMaxIdleTime(DataUtility.getInt(rb.getString("timeout")));
            datasource.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));
        }
        return datasource;
    }
    /**
     * Gets the connection from ComboPooledDataSource
     *
     * @return connection
     */
    public static Connection getConnection() throws Exception {
        return getInstance().cpds.getConnection();
    }
    /**
     * Closes a connection4
     *
     * @param connection
     * @throws Exception
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
    
//    public static void main(String[] args) {
//    	JDBCDataSource jdbc = new JDBCDataSource();
//    	try {
//    		Connection con = jdbc.getConnection();
//    		System.out.println(con);
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}
//    	
//    }
}
