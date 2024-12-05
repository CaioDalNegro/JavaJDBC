package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;//declara variavel do tipo Connection
	
	//método para realizar a conexão com o banco
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();//lê as propriedades
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);//tenta de conectar com o banco
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());//tratamento personalizado usando throw
			}
		}
		return conn;
	}
	
	//método para desconectar do banco
	public static void closeConnection() {
		if(conn != null) {//se vc é diferente de null fecha a conexão
			try {
				conn.close();//fecha a conexão
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());//tratamento personalizado
			}
		}
	}
	
	//método para ler as propriedades de conexão
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){//instacia FileInputStream e usa db.properties como parametro
			Properties props = new Properties();//cria um objeto
			props.load(fs);//carrega o obj
			return props;//retorna o obj
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());//força uma nova exception personalizada com base na DbException
		}
	}
	
}
