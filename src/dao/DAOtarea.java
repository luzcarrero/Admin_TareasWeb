package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;

import conexion.DBconnection;
import modelo.Tarea;

public class DAOtarea {

	private static Connection con=null;
	public static DAOtarea instance =null;
	
	public DAOtarea() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		con = DBconnection.getConnection();
	}
	public static DAOtarea getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new DAOtarea();
		return instance;
	}

	public static void insert(Tarea n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO tarea (titulo, descripcion, fecha_inicio, fecha_fin, prioridad, categoria) VALUES (?,?,?,?,?,?)");
		ps.setString(1, n.getTitulo());
		ps.setString(2, n.getDescripcion());
		ps.setDate(3,Date.valueOf(n.getFecha_inicio()));
		ps.setDate(4,Date.valueOf(n.getFecha_fin()));
		ps.setString(5, n.getPrioridad());
		ps.setString(6, n.getCategoria());	
		//System.out.println(ps);
		//System.out.println("------------------------------");
		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Tarea> listaTarea() throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("SELECT * from tarea");
		ResultSet rs = ps.executeQuery();

		ArrayList<Tarea> result = new ArrayList<>();
		
		while (rs.next()) {
			result.add(new Tarea(
					rs.getInt("id"), 
					rs.getString("titulo"),
					rs.getString("descripcion"),
					rs.getDate("fecha_inicio").toLocalDate(),
					rs.getDate("fecha_fin").toLocalDate(), 
					rs.getString("prioridad"), 
					rs.getString("categoria"))
					);			
		}
		
		rs.close();
		ps.close();
		return result;
	}

	public static Tarea buscarID(int id) throws SQLException {
		PreparedStatement ps =con.prepareStatement("SELECT * FROM tarea WHERE id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		Tarea result = null;
		if (rs.next()) {
			result = new Tarea(
					rs.getInt("id"), 
					rs.getString("titulo"), 
					rs.getString("descripcion"),
					rs.getDate("fecha_inicio").toLocalDate(),
					rs.getDate("fecha_fin").toLocalDate(), 
					rs.getString("prioridad"), 
					rs.getString("categoria"));
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
		PreparedStatement ps = con.prepareStatement("DELETE FROM tarea WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	public static void update(Tarea n) throws SQLException {
	
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE tarea SET titulo = ?, descripcion = ?, fecha_inicio = ?, fecha_fin = ?, prioridad = ?, categoria = ? WHERE id = ?");
		ps.setString(1, n.getTitulo());
		ps.setString(2, n.getDescripcion());
		ps.setDate(3,Date.valueOf(n.getFecha_inicio()));
		ps.setDate(4,Date.valueOf(n.getFecha_fin()));
		ps.setString(5, n.getPrioridad());
		ps.setString(6, n.getCategoria());		
		ps.setInt(7, n.getId());
		System.out.println("----editar----");
		System.out.println(ps.toString());
			
		ps.executeUpdate();		
		ps.close();
	}
	


}
