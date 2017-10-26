package es.altair.canciones.main;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import es.altair.canciones.bean.Artista;
import es.altair.canciones.bean.Cancion;
import es.altair.canciones.dao.ArtistaDAO;
import es.altair.canciones.dao.ArtistaDAOImpleJDBC;
import es.altair.canciones.dao.CancionDAO;
import es.altair.canciones.dao.CancionDAOImpleJDBC;

public class App {

	private static Scanner input = new Scanner(System.in);
	private static ArtistaDAO artDAO = new ArtistaDAOImpleJDBC();
	private static CancionDAO canDAO = new CancionDAOImpleJDBC(); 

	public static void main(String[] args) {

		int opcion = 0;
		int opcionMostrar = 0;
		boolean valida = false;

		do {
			opcion = menu();

			switch (opcion) {
			case 1:
				//Añade canciones y artistas
				do {
					System.out.println("***************************");
					System.out.println("* 1 - Añadir Artista      *");
					System.out.println("* 2 - Añadir Cancion      *");
					System.out.println("***************************");
					System.out.println("Introducir opcion: ");
					opcionMostrar = input.nextInt();

				} while (opcionMostrar < 1 || opcionMostrar > 2);

				if (opcionMostrar == 1) {
					Artista nuevoArt = new Artista();

					do {
						System.out.println("Introducir Nombre del artista");
						nuevoArt.setNombre(input.nextLine());
						valida = Pattern.matches("[A-Za-z0-9]+", nuevoArt.getNombre());
					} while (valida == false);

					do {
						System.out.println("Introducir Apellido del artista");
						nuevoArt.setApellidos(input.nextLine());
						valida = Pattern.matches("[A-Za-z0-9]+", nuevoArt.getApellidos());
					} while (valida == false);

					do {
						System.out.println("*******************");
						System.out.println("* 1 - Pop         *");
						System.out.println("* 2 - Rock        *");
						System.out.println("* 3 - Flamenco    *");
						System.out.println("* 4 - Electronic  *");
						System.out.println("* 5 - Disco       *");
						System.out.println("* 6 - Clasica     *");
						System.out.println("* 7 - Jazz        *");
						System.out.println("* 8 - Funk        *");
						System.out.println("* 9 - Rumba       *");
						System.out.println("*******************");
												
						System.out.println("Introducir ID estilo del artista");
						nuevoArt.setIdEstilo(input.nextInt());
					} while (nuevoArt.getIdEstilo() < 1 || nuevoArt.getIdEstilo() > 9);

					do {
						System.out.println("Introducir edad del artista");
						nuevoArt.setEdad(input.nextInt());
					} while (nuevoArt.getEdad() <= 0);

					do {
						System.out.println("Introducir pais del artista");
						nuevoArt.setPais(input.nextLine());
						valida = Pattern.matches("[A-Za-z]+",nuevoArt.getPais());
					} while (valida == false);

					artDAO.insertarArtista(nuevoArt);

				} else if (opcionMostrar == 2) {
					Cancion cancionNueva = new Cancion();

					do {
						System.out.println("Introducir nombre de la Cancion");
						cancionNueva.setNombre(input.nextLine());
						valida = Pattern.matches("[A-Z a-z]+", cancionNueva.getNombre());
						System.out.println(cancionNueva.getNombre());
					} while (valida == false);

					do {
						System.out.println("Introducir duracion de la cancion en segundos");
						cancionNueva.setDuracion(input.nextInt());
					} while (cancionNueva.getDuracion() < 0);

					do {
						
						artDAO.listarArtistas();
						//Muestro los artistas
						System.out.println(artDAO.listarArtistas());
						
						System.out.println("Introducir ID Artista");
						cancionNueva.setIdArtista(input.nextInt());
					} while (cancionNueva.getIdArtista() < 0);

					canDAO.insertarCancion(cancionNueva);

				}
				break;
			case 2:
				// Muestra artista por idEstilo
				artDAO.listarArtistas();
				
				System.out.println("*******************");
				System.out.println("* 1 - Pop         *");
				System.out.println("* 2 - Rock        *");
				System.out.println("* 3 - Flamenco    *");
				System.out.println("* 4 - Electronic  *");
				System.out.println("* 5 - Disco       *");
				System.out.println("* 6 - Clasica     *");
				System.out.println("* 7 - Jazz        *");
				System.out.println("* 8 - Funk        *");
				System.out.println("* 9 - Rumba       *");
				System.out.println("*******************");
				System.out.println();
				System.out.println("Introducir ID Estilo para listar por estilos");
				opcionMostrar = input.nextInt();
				artDAO.listarEstilos(opcionMostrar);

				break;
			case 3:
				// Muestra todas las canciones de un artista
				artDAO.listarArtistas();
				//Muestro los artistas
				System.out.println(artDAO.listarArtistas());
				System.out.println();
				System.out.println("Introducir ID Artista para listar sus canciones");
				opcionMostrar = input.nextInt();
				canDAO.listarCancionArtista(opcionMostrar);

				break;
			case 4:
				// Actualiza la edad de un artista
				artDAO.listarArtistas();
				System.out.println(artDAO.listarArtistas());
				System.out.println();
				System.out.println("Introducir ID artista para a modificar su edad: ");
				opcionMostrar = input.nextInt();
				Artista artUpdate = artDAO.recuperarArtista(opcionMostrar);
				if (artUpdate != null) {

					do {
						System.out.println("Introducir nueva edad: ");
						artUpdate.setEdad(input.nextInt());
					} while (artUpdate.getEdad() <= 0);

					if (artDAO.actualizar(artUpdate)) {
						System.out.println("Actualizado");
					} else {
						System.out.println("No Actualizado");
					}

				} else {
					System.out.println("Error el usuario no se encuentra en la BD");
				}

				break;
			case 5:
				// Actualiza la duracion de canciones
				String pais;
				
				do {
					System.out.println("Introducir pais para actualizar canciones: ");
					pais = input.nextLine().toUpperCase().toLowerCase();
					valida = Pattern.matches("[A-Za-z]+", pais);
				} while (valida == false);
				
				List<Cancion> cancUpdate = canDAO.listarCancionPaises(pais);

				if (!cancUpdate.isEmpty()) {
					for (Cancion can : cancUpdate) {
						if (canDAO.actualizarCancion(can)) {
							System.out.println("Realizado");
							canDAO.listarCanciones();
						} else {
							System.out.println("No Realizado");
						}
					}
				} else {
					System.out.println("No se ha encontrado ninguno");
				}

				break;
			case 6:
				// Borrar todas las canciones de un artista (solo las canciones el artista no lo toca)
				
				System.out.println("Introducir ID Artista para borrar todas sus canciones: ");
				if (canDAO.borrarCancion(input.nextInt())) {
					System.out.println("Canciones Borradas");
				} else {
					System.out.println("No se han podido borrar las canciones.");
				}
				break;
			case 7:
				// Muestra todos los artistas y sus canciones (si las tiene)
				System.out.println();
				System.out.println("                 ******************************************");
				System.out.println("                 *               Biblioteca               *");
				System.out.println("                 ******************************************");
				for (int i = 0; i < artDAO.listarArtistas().size(); i++) {

					System.out.println(artDAO.listarArtistas().get(i));
					canDAO.listarCancionArtista(i + 1);
					System.out.println();
				}
				break;

			default:
				break;
			}

		} while (opcion != 0);

		input.close();
	}

	public static int menu() {
		int opcion = 0;
		do {
			System.out.println("************************************************");
			System.out.println("*                App Canciones                 *");
			System.out.println("************************************************");
			System.out.println("*  1 - Añadir Cancion Artista                  *");
			System.out.println("*  2 - Mostrar Artista por Estilo              *");
			System.out.println("*  3 - Mostrar todas las canciones por artista *");
			System.out.println("*  4 - Actualizar edad del artista             *");
			System.out.println("*  5 - Actualizar duracion de las canciones    *");
			System.out.println("*  6 - Borrar todas las canciones de un artista*");
			System.out.println("*  7 - Mostrar Todo                            *");
			System.out.println("*  0 - Salir de la App                         *");
			System.out.println("************************************************");

			System.out.println("Introducir opcion: ");
			opcion = input.nextInt();
		} while (opcion < 0 || opcion > 7);

		return opcion;
	}

}

