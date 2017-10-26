package es.altair.canciones.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDAO {

	private static Connection conexion;

	public static void abrirConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/canciones?serverTimezone=UTC&autoReconnect=true&useSSL=false","root","martos");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public static void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}

	public static Connection getConexion() {
		return conexion;
	}
}
