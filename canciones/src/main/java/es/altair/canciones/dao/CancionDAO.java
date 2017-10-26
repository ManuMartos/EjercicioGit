package es.altair.canciones.dao;

import java.util.List;

import es.altair.canciones.bean.Cancion;

public interface CancionDAO {

	final int SEGUNDOS = 60;

	public List<Cancion> listarCanciones();

	public boolean insertarCancion(Cancion c);

	public boolean actualizarCancion(Cancion c);

	public boolean borrarCancion(int idArtista);

	public List<Cancion> listarCancionArtista(int idArtista);

	public List<Cancion> listarCancionPaises(String pais);

}
