import java.sql.*;

import javax.swing.JOptionPane;
public class DbConnection {

	protected static Connection dbConnector() {
		String currentDir = System.getProperty("user.dir");
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+currentDir+"\\src\\database.sqlite");
			return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	
	}

}
