package datab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Connection conn = DriverManager.getConnection(db_connect_string,
                 //db_userid, db_password);
        Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost" +
        	    ";integratedSecurity=true;");
        System.out.println("connected");
        Statement statement = conn.createStatement();
        String queryString1="Use FCM";
        statement.execute(queryString1);
        String queryString = "select * from alert";
        ResultSet rs = statement.executeQuery(queryString);
        while (rs.next()) {
           System.out.println(rs.getString(2));
        }
        String queryString2 = "Insert into Audit (AuditEventID, UserID, Created, Property) values ( 156, 1, '2018-02-23 14:29:06.3303723', CONVERT(xml, '<properties>a</properties>'))";//'<properties> <property name="RoleCatagory">investigator</property> <property name="Success">True</property> </properties>'))";
        statement.executeUpdate(queryString2);
        String queryString3 = "Update Audit SET AuditEventID=208 where ID=2413";
        statement.executeUpdate(queryString3);
	}
}