package aplication;

import java.sql.Connection;

import db.DB;

public class Main {

	public static void main(String[] args) {
		//faz a conexão com o banco de dados
		Connection conn = DB.getConnection();
		
		//desconecta o banco de dados
		DB.closeConnection();

	}

}
