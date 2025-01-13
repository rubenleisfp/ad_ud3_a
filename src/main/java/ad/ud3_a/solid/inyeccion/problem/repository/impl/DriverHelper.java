package ad.ud3_a.solid.inyeccion.problem.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para obtener la conexión del driver
 */
public class DriverHelper {

	public static Connection getConnection() throws SQLException { 
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC",
			"root", "castelao");
		return conn;
	}
}
