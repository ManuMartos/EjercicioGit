package es.altair.canciones.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.canciones.bean.Cancion;

public class CancionDAOImpleJDBC implements CancionDAO {

	public List<Cancion> listarCanciones() {

		List<Cancion> canciones = new ArrayList<Cancion>();

		ConexionDAO.abrirConexion();
		String query = "SELECT * FROM CANCION";

		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Cancion c = new Cancion(resultado.getInt("idCancion"), resultado.getString("nombre"),
						resultado.getInt("duracion"), resultado.getInt("idArtista"));
				canciones.add(c);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ConexionDAO.cerrarConexion();
		return canciones;
	}

	public boolean insertarCancion(Cancion c) {
		int numeroFilas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO CANCION VALUES(null,?,?,?)";
		try {

			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, c.getNombre());
			sentencia.setInt(2, c.getDuracion());
			sentencia.setInt(3, c.getIdArtista());
			sentencia.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return (numeroFilas == 1) ? false : true;
	}

	public boolean actualizarCancion(Cancion c) {
		int numeroFilas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE cancion SET duracion = ? WHERE idCancion = ?";
		try {

			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, (c.getDuracion() + SEGUNDOS));
			sentencia.setInt(2, (c.getIdCancion()));
			numeroFilas = sentencia.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return (numeroFilas == 0) ? false : true;
	}
	
	

	public boolean borrarCancion(int idArtista) {
		
		int numeroFilas = 0;
		String query = "DELETE FROM cancion WHERE idArtista = ?";	
		
		ConexionDAO.abrirConexion();
		
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);
			numeroFilas = sentencia.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(numeroFilas);
		
		ConexionDAO.cerrarConexion();
		
		return (numeroFilas <= 0) ? false : true;
	}

	public List<Cancion> listarCancionArtista(int idArtista) {
		List<Cancion> canciones = new ArrayList<Cancion>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM CANCION WHERE idArtista = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtista);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				Cancion c = new Cancion(resultado.getString("nombre"), resultado.getInt("duracion"),
						resultado.getInt("idArtista"));

				System.out.println(c);
				canciones.add(c);

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return canciones;
	}

	public List<Cancion> listarCancionPaises(String pais) {

		List<Cancion> canciones = new ArrayList<Cancion>();

		ConexionDAO.abrirConexion();
		String query = "SELECT * FROM cancion INNER JOIN artista ON cancion.idArtista = artista.id  where pais = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, pais.toUpperCase().toLowerCase());
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Cancion c = new Cancion(resultado.getInt("idCancion"), resultado.getString("nombre"),
						resultado.getInt("duracion"), resultado.getInt("idArtista"));

				canciones.add(c);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return canciones;
	}

}

