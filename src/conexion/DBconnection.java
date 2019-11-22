package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
	private static final String JDBC_URL ="jdbc:mysql://halifaxtraining.es:3306/ciberkaos003";
	private static Connection instance = null;

	private DBconnection() {
	}

	public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "uss003");
			props.put("password", "ratoncita2019");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			instance = DriverManager.getConnection(JDBC_URL,props);
		}
		System.out.println("conectado");
		return instance;
	}

	
}

