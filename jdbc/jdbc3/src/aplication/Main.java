package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Main {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();
			
//			st = conn.prepareStatement("INSERT INTO vendedor " 
//			+ "(nome, email, dataNascimento, salarioBase, idDepartamento)" 
//			+ "VALUES " 
//			+ "(?, ?, ?, ?, ?)");
			
//			st = conn.prepareStatement("INSERT INTO vendedor " 
//			+ "(nome, email, dataNascimento, salarioBase, idDepartamento)" 
//			+ "VALUES " 
//			+ "(?, ?, ?, ?, ?)",
//			Statement.RETURN_GENERATED_KEYS);
//			
//			st.setString(1, "Caio");
//			st.setString(2, "Caio@gmail.com");
//			st.setDate(3, new java.sql.Date(sdf.parse("12/08/2005").getTime()));
//			st.setDouble(4, 3000.0);
//			st.setInt(5, 1);
			
			st = conn.prepareStatement("INSERT INTO departamento (nome) VALUES ('D1'), ('D1')",
					Statement.RETURN_GENERATED_KEYS);
			
			int registros = st.executeUpdate();
			
			System.out.println("Finalizado! Registros alterados: " + registros);
			
			if(registros > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Finalizado! Id = " + id);
				}
			}
			else {
				System.out.println("Nenhum registro alterado!");
			}

	}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
//		catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
