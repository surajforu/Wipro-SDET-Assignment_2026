package Sarthak_clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_table {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydata";
		String user = "root";
		String password = "root";

		// Add new column
		String alterSQL = "ALTER TABLE student ADD COLUMN phone varchar(15)";

		// Update values
		String updateSQL1 = "UPDATE student SET phone='9876543210' WHERE rollno=101";
		String updateSQL2 = "UPDATE student SET phone='9123456780' WHERE rollno=102";
		String updateSQL3 = "UPDATE student SET phone='9988776655' WHERE rollno=103";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password);

			System.out.println("Connection Created");

			Statement stmt = con.createStatement();

			// Add column
			stmt.executeUpdate(alterSQL);

			System.out.println("New Column Added");

			// Update records
			stmt.executeUpdate(updateSQL1);
			stmt.executeUpdate(updateSQL2);
			stmt.executeUpdate(updateSQL3);

			System.out.println("Table Updated");

			stmt.close();
			con.close();

		}

		catch(SQLException e) {
			System.out.println(e);
		}

		catch(ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}