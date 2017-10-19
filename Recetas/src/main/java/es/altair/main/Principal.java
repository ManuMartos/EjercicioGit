package es.altair.main;

import java.util.List;
import java.util.Scanner;

import es.altair.bean.Usuario;
import es.altair.dao.UsuarioDAO;
import es.altair.dao.UsuarioDAOImpleJDBC;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	private static UsuarioDAO uDAO = new UsuarioDAOImpleJDBC();
	
	private static UsuarioDAO recDAO = new UsuarioDAOImpleJDBC();

	public static void main(String[] args) {

		// listadoUsuarios(uDAO);

		// Insertar usuario

		// Usuario usu = new Usuario("Alumno usu", "Apellidos usu", "alumusu",
		// "alumusu123", "alomusu@gmail.com", 1, 1);
		//
		// if (uDAO.insertar(usu)) {
		// System.out.println("Usuario insertado");
		// } else {
		// System.out.println("No se ha podido insertar al usuario");
		// }
		//
		// // Listar, Obtener y actualizar
		//
		// listadoUsuarios();
		//
		// System.out.println("Seleccione Usuario(id): ");
		//
		// int idUsuario = sc.nextInt();
		//
		// Usuario usuAct = uDAO.obtener(idUsuario);
		// if (usuAct != null) {
		//
		// usuAct.setNombre(usuAct.getNombre() + "_EXT");
		//
		// if (uDAO.actualizar(usuAct)) {
		// System.out.println("Usuario actualizado");
		// } else {
		// System.out.println("No se ha podido actualizar al usuario");
		// }
		// } else {
		// System.out.println("Error al obtener el usuario a actualizar");
		// }
		//
		// //BORRADO
		//
		// listadoUsuarios();
		// System.out.println("Seleccione Usuario(ID): ");
		// int idUsuarioB = sc.nextInt();
		//
		// if (uDAO.borrar(idUsuarioB)) {
		// System.out.println("Usuario borrado");
		// }else {
		// System.out.println("No se ha podido borrar al usuario");
		// }
		//
		// //MOSTRAR USUARIOS TIPO 1
		//
		// List<Usuario> usuarios = uDAO.mostrarUsuariosAcceso(1);
		//
		// for (Usuario usuario : usuarios) {
		// System.out.println(usuario);
		// }

		// COMPROBAR CONEXION USUARIOS

		// System.out.println("Login: ");
		// String login = sc.nextLine();
		// System.out.println("Password: ");
		// String password = sc.nextLine();
		//
		// if (uDAO.comprobarSQL1(login, password)) {
		// System.out.println("Login correcto");
		// } else {
		// System.out.println("Login incorrecto");
		// }
		//
		// if (uDAO.comprobarSQL2(login, password)) {
		// System.out.println("Login correcto");
		// } else {
		// System.out.println("Login incorrecto");
		// }

		sc.close();
	}

	private static void listadoUsuarios() {
		List<Usuario> usuarios = uDAO.listarTodos();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

//	private static void listarRecetas() {
//		List<Recetas> recetas = recDAO.
//	}

}
