package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DBconnection;
import modelo.Subtarea;
import modelo.Tarea;

public class DAOsubtarea {

	private static Connection con=null;
	public static DAOsubtarea instance =null;
	
	public DAOsubtarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		con = DBconnection.getConnection();
	}
	public static DAOsubtarea getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new DAOsubtarea();
		return instance;
	}

	public static void insert(Subtarea n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO subtarea (titulo, descripcion, tareaid) VALUES (?,?,?)");
		ps.setString(1, n.getTitulo());
		ps.setString(2, n.getDescripcion());
		ps.setInt(3, n.getDependencia());
		ps.executeUpdate();
		ps.close();
	}
/*
	public ArrayList<Tarea> listaTarea() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * from TareaPrueba");
		ResultSet rs = ps.executeQuery();

		ArrayList<Tarea> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Tarea(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
					rs.getString("prioridad"), rs.getString("categoria")));
		}
		rs.close();
		ps.close();
		return result;
	}

	public static Tarea buscarID(int id) throws SQLException {
		PreparedStatement ps =con.prepareStatement("SELECT * FROM TareaPrueba WHERE id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		Tarea result = null;
		if (rs.next()) {
			result = new Tarea(rs.getInt("id"), rs.getString("titulo"), rs.getString("descripcion"),
					rs.getString("prioridad"), rs.getString("categoria"));
		}
		rs.close();
		ps.close();
		return result;
	}

	public static void delete(Tarea e) throws SQLException {
		delete(e.getId());
	}

	public static void delete(int id) throws SQLException {
		if (id <= 0)
			return;
		PreparedStatement ps = con.prepareStatement("DELETE FROM TareaPrueba WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	public static void update(Tarea n) throws SQLException {
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE TareaPrueba SET titulo = ?, descripcion = ?, prioridad = ?, categoria = ? WHERE id = ?");
		ps.setString(1, n.getTitulo());
		ps.setString(2, n.getDescripcion());
		ps.setString(3, n.getPrioridad());
		ps.setString(4, n.getCategoria());		
		ps.setInt(5, n.getId());
		ps.executeUpdate();
		//System.out.println(ps);
			
		ps.close();
	}
	*/

}
