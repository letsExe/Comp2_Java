package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonDb {
	
	private static SingletonDb instance=null;

	protected Connection db = null;
	protected Statement stmt = null;
	
	private SingletonDb() {
		connect();
	}
	
	public static SingletonDb getInstance () {
		if (instance==null) instance = new SingletonDb();
		return instance;
	}
	
	public Statement getStatement() {
		return stmt;
	}

	protected void connect ( ) {
		String db_connect_string = "jdbc:mysql://localhost:3306/mydb" +
				"?verifyServerCertificate=false"+
				"&useSSL=false"+
				"&requireSSL=false"+
				"&useTimezone=true"+
				"&serverTimezone=UTC"+
				"&allowPublicKeyRetrieval=true";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (this.db != null)
				this.db.close();
			db = DriverManager.getConnection(db_connect_string, 
					"root", "727303" );
			System.out.println("Conectado? " + !db.isClosed());
			createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void createStatement() throws SQLException {
		if (this.stmt != null)
			this.stmt.close();

		stmt = db.createStatement();
	}
	
	public String toString () {
		try {
			return "Status connection MVC database: " + (instance.db.isClosed()? "closed" : "open");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) {
		new SingletonDb () .connect();
	}

}
