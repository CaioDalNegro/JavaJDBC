package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import db.DB;

public class Main {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"DELETE FROM departamento "
				+ "WHERE "
				+ "id = ?");

			st.setInt(1, 3);

			int registros = st.executeUpdate();

			System.out.println("Finalizado! Registros alterados: " + registros);

		} catch (SQLException e) {
			System.out.println(e.fillInStackTrace());
		}
		DB.closeStatement(st);
		DB.closeConnection();
	}
}
