package es.altair.canciones.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.canciones.bean.Artista;


public class ArtistaDAOImpleJDBC implements ArtistaDAO {

	
	public List<Artista> listarArtistas() {

		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();
		String query = "SELECT * FROM ARTISTA";

		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("id"), resultado.getString("nombre"),
						resultado.getNString("apellidos"), resultado.getInt("idEstilo"), resultado.getInt("edad"),
						resultado.getString("pais"));

				artistas.add(a);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}
		
	public boolean insertarArtista(Artista a) {
		int numeroFilas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO ARTISTA VALUES(null,?,?,?,?,?)";
		try {

			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, a.getNombre());
			sentencia.setString(2, a.getApellidos());
			sentencia.setInt(3, a.getIdEstilo());
			sentencia.setInt(4, a.getEdad());
			sentencia.setString(5, a.getPais());
			sentencia.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return (numeroFilas == 1) ? false : true;
	}

	public boolean actualizar(Artista a) {
		int numeroFilas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE ARTISTA SET nombre = ?, apellidos = ?, idEstilo = ?, edad = ?, pais = ? WHERE id = ?";
		try {

			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, a.getNombre());
			sentencia.setString(2, a.getApellidos());
			sentencia.setInt(3, a.getIdEstilo());
			sentencia.setInt(4, a.getEdad());
			sentencia.setString(5, a.getPais());
			sentencia.setInt(6, a.getId());
			numeroFilas = sentencia.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return (numeroFilas == 0) ? false : true;
	}

	public Artista recuperarArtista(int id) {

		Artista a = null;
		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA WHERE id = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, id);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				a = new Artista(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("apellidos"),
						resultado.getInt("idEstilo"), resultado.getInt("edad"), resultado.getString("pais"));
				
			}
		} catch (SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return a;
	}

	public boolean borrarArtista(int idArtistaBorrar) {
		int numeroFilas = 0;

		ConexionDAO.abrirConexion();

		String query = "DELETE FROM ARTISTA WHERE id = ?";
		try {

			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idArtistaBorrar);

			numeroFilas = sentencia.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return (numeroFilas == 0) ? false : true;
	}

	public List<Artista> listarEstilos(int idEstilo) {

		List<Artista> artistas = new ArrayList<Artista>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM ARTISTA WHERE idEstilo = ?";
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idEstilo);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				Artista a = new Artista(resultado.getInt("id"), resultado.getString("nombre"),
						resultado.getNString("apellidos"), resultado.getInt("idEstilo"), resultado.getInt("edad"),
						resultado.getString("pais"));
				artistas.add(a);
				System.out.println(a);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return artistas;
	}
}
