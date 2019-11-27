package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DBconnection;
import modelo.Usuario;

public class DAOusuario {
	/**
	 * Atributos del usuario
	 */
	public static Connection con=null;
	public static DAOusuario instance=null;
	/**
	 * Método constructor en dnd se instancia la clase conexion
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DAOusuario() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		con=DBconnection.getConnection();
	}
	/**
	 * metodo que indica si la clase esta instanceada
	 * Sí la instancia no existe creamela y muestramela
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static DAOusuario getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new DAOusuario();
		return instance;
	}
	/**
	 * Metodo que inserta un nuevo usuario a la base de datos
	 * @param Usuario usuario
	 * @throws SQLException 
	 */
	public static void insertar (Usuario u) throws SQLException {
		PreparedStatement query = con.prepareStatement("INSERT INTO usuario (nombre, apellido, mail, clave) VALUES (?, ?, ?, ?)");
		// rellenas los campos en la tabla con los textos que recibe
		query.setString(1, u.getNombre());
		query.setString(2, u.getApellido());
		query.setString(3, u.getMail());
		query.setString(4, u.getClave());		
		//System.out.println("IMPRIMO LA QUERY EN EL METODO INSERTAR EN DAO ? --> "+ query);		
		//ejecuto la sentencia
		query.executeUpdate();
		//cierro la sentencia
		query.close();
		
		
	}
	/**
	 * Metodo que retorna una ArrayList con los usuarios
	 * que esten registrados en la Base de Datos
	 * @return lista_usuarios
	 * @throws SQLException
	 */
	public static ArrayList<Usuario> listaUsuarios() throws SQLException{
		//se prepara la consulta ( "con --> variable estatica para la conexion a la DB ")
		PreparedStatement query =con.prepareStatement("SELECT * FROM usuario");
		//esa consulta se almacenara en un tipo de dato ResultSet; 
		ResultSet rs= query.executeQuery();
		//Creacion del tipo Lista usuarios que retornaremos 
		ArrayList<Usuario> us= new ArrayList<Usuario>();
		
		//va leyendo una a una hasta que este vacía
		while(rs.next()) {
				us.add(new Usuario(						
						rs.getInt("id"), 
						rs.getString("nombre"),
						rs.getString("apellido"),						
						rs.getString("mail"), 
						rs.getString("clave"))
						);		
		}	
			query.close();
			rs.close();		
			
		return us;
	}
	
	

}
