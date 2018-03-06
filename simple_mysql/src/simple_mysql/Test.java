package simple_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

	/* 
	 * 	<Resource name="jdbc/mysql" 
		auth="Container" 
		type="javax.sql.DataSource"
		factory="org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory"
		maxActive="100" 
		maxIdle="30" 
		maxWait="1000"
		username="root" 
		password="root" 
		driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3307/space"

	 */
	public static void main(String[] args) {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3307/space";
			String user = "root";
			String password = "root";
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "select * from members";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + ", " + rs.getString(2));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}

}
