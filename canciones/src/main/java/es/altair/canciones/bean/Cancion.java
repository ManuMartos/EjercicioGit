package es.altair.canciones.bean;

public class Cancion {

	private int idCancion;
	private String nombre;
	private int duracion;
	private int idArtista;
	
	public Cancion() {
		super();
	}

	public Cancion(String nombre, int duracion, int idArtista) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.idArtista = idArtista;
	}

	public Cancion(int idCancion, String nombre, int duracion, int idArtista) {
		super();
		this.idCancion = idCancion;
		this.nombre = nombre;
		this.duracion = duracion;
		this.idArtista = idArtista;
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	@Override
	public String toString() {
		return "Cancion [idCancion=" + idCancion + ", nombre=" + nombre + ", duracion=" + duracion + "segundos" + ", idArtista="
				+ idArtista + "]";
	}
	
	
}
