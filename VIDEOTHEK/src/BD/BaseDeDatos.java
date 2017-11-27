package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BaseDeDatos {

	private Connection conexion;
	private static Statement statement;

	/*
	 * metodo que crea una sentencia para acceder a la base de datos
	 */

	public void crearSentencia() {
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * metodo que sirve para conectar con la base de datos
	 */
	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:BaseDeDatosUsuarios.db");
			crearSentencia();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}

	/*
	 * metodo que sirve para cerrar una sentencia
	 */
	public void cerrarSentencia() {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * metodo que sirve para desconectarse de la base de datos
	 */
	public void desconectar() {
		try {
			cerrarSentencia();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// constructor
	public BaseDeDatos() {
		conectar();
	}

	// a partir de aqui, implementaremos los metodos para nuestro proyecto
	// VIDEOTHEK
	/**
	 * Este metodo sirve para saber si el usuario introducido en la ventana
	 * principal esta registrado o no.
	 * 
	 * @param nombre:
	 *            nombre introducido por el usuario
	 * @param contrasenya:
	 *            contrasenya introducida por el usuario
	 * @return : 0 - Si no existe el usuario 1 - Si sí existe el usuario pero la
	 *         contraseña no es correcta 2 - Si el nombre de usuario es correcto
	 *         y la contraseña también pero el correo es incorrecto 
	 */

	public int UsuarioRegistrado(String nombre, String contrasenya) {
		String query = "SELECT * FROM usuario WHERE nombre = '" + nombre + "'";
		int resultado = 0;
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next())// comprobamos si ha devuelto una fila
			{
				String nom = rs.getString("nombre");
				String con = rs.getString("contrasenya");

				if (!nom.equals(nombre))// comprobamos si el nombre obtenido de
										// la base de datos no es igual al del
										// parametro
				{
					resultado = 0;
				}

				else if (!con.equals(contrasenya)) // comprobamos si la
													// contraseña obtenida de la
													// base de datos no es igual
													// al del parametro
				{
					resultado = 1;
				}

				else 
				{
					
					resultado = 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;

	}
	
	/**
	 * Este metodo sirve para registrar los usuarios en la base de datos y así acceder a la plataforma de VIDEOTHEK.
	 * 
	 * @param nombre: El nombre introducido por el usuario
	 * @param contrasenya: La contraseña introducida por el usuario.
	 * @param correo: el correo introducido por el usuario.
	 */
	
	public void registrarUsuario (String nombre, String contrasenya, String correo)
	{
		String query = "INSERT INTO usuario(nombre,contrasenya,correo) VALUES ('"+nombre+"','"+contrasenya+"','"+correo+"')";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Este método sirve para saber si un administrador existe en la base de datos
	 * @param usuario: El nombre de usuario introducido
	 * @param contrasenya: La contraseña introducida.
	 * @return 0 - Si no existe el administrador 1 - Si sí existe el administrador pero la
	 *         contraseña no es correcta 2 - Si el nombre del administrador es correcto
	 *         y la contraseña también
	 */
	public int adminRegistrado(String usuario, String contrasenya)
	{
		String query = "SELECT * FROM administrador WHERE usuario = '"+usuario+"'";
		int resul = 0;
		
			try {
			ResultSet rs = statement.executeQuery(query);
			if(rs.next())//comprobamos si ha devulto una fila
			{
				String usu = rs.getString("usuario");
				String con = rs.getString("contrasenya");
				
				if(!usu.equals(usuario))
				{
					resul = 0;
				}
				
				else if(!con.equals(contrasenya))	
				{
					resul = 1;
				}
				
				else
				{
					resul = 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return resul;
			
	}
	
	
	public String devuelveContrasenya (String correo)
	{
		String query = "SELECT * FROM usuario WHERE correo ='"+correo+"'";
		String contrasenya = "";
		try {
			ResultSet rs = statement.executeQuery(query);
			if(rs.next())
			{
				
					contrasenya = contrasenya + rs.getString("contrasenya");
				
				
			}else
				contrasenya = contrasenya + " no hay contraseña.z<s ";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contrasenya;
		
		
		
	}
	

}
