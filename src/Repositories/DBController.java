package Repositories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {

	private final String ipServer = "oracle11g.cin.ufpe.br";
	private final String portServer = "1521";
	private final String nameBD = "Instance01";
	private final String user = "g151if685cc_eq01";
	private final String password = "u1vzpzla";
	
	private Connection connection;
	
	public void createConnection() throws SQLException, ClassNotFoundException {
		Class.forName(" oracle.jdbc.driver.OracleDriver");
		this.connection = DriverManager.getConnection(this.toString(), this.user, this.password);
	}
	
	public void closeConnection() throws SQLException {
		this.connection.close();
	}
	
	public String toString() {
		return "jdbc:oracle:thin:@:" + this.ipServer + this.portServer + this.nameBD;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
}
