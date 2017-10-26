package es.altair.canciones.dao;

import java.util.List;

import es.altair.canciones.bean.Artista;

public interface ArtistaDAO {

	public List<Artista> listarArtistas();

	public boolean insertarArtista(Artista a);

	public boolean actualizar(Artista a);

	public Artista recuperarArtista(int idArtista);

	public boolean borrarArtista(int idArtista);

	public List<Artista> listarEstilos(int idEstilo);
}
