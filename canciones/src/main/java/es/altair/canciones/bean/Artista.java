package es.altair.canciones.bean;

public class Artista {

	private int id;
	private String nombre;
	private String apellidos;
	private int idEstilo;
	private int edad;
	private String pais;
	
	public Artista() {
		super();
	}

	public Artista(int id, String nombre, String apellidos, int idEstilo, int edad, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idEstilo = idEstilo;
		this.edad = edad;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdEstilo() {
		return idEstilo;
	}

	public void setIdEstilo(int idEstilo) {
		this.idEstilo = idEstilo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", idEstilo=" + idEstilo
				+ ", edad=" + edad + ", pais=" + pais + "]";
	}
	
	
}
