package aplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM departamento");
			
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "|" + rs.getString("nome"));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
