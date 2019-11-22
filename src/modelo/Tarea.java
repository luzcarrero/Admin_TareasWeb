package modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import dao.DAOtarea;

public class Tarea {
	private int id;
	private String titulo;	
	private String descripcion;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	private String prioridad;
	private String categoria;
	
	private DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Tarea() {
		
	}
	public Tarea(int id, String titulo, String descripcion,LocalDate fecha_inicio,LocalDate fecha_fin,String prioridad, String categoria) {
			this.id=id;
			this.titulo=titulo;
			this.descripcion=descripcion;
			this.fecha_inicio=fecha_inicio;
			this.fecha_fin=fecha_fin;
			this.prioridad=prioridad;
			this.categoria=categoria;
		}
	public Tarea(String titulo, String descripcion,LocalDate fecha_inicio,LocalDate fecha_fin,String prioridad, String categoria) {
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.fecha_inicio=fecha_inicio;
		this.fecha_fin=fecha_fin;
		this.prioridad=prioridad;
		this.categoria=categoria;
	}
	
	public Tarea(int id, String titulo, String descripcion,String prioridad, String categoria) {
		this.id=id;
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.prioridad=prioridad;
		this.categoria=categoria;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public LocalDate getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public String dameFecha_i() {
		return this.formatear.format(fecha_inicio);
	}
	
	public String dameFecha_fin() {
		return this.formatear.format(fecha_fin);
	}
	
	public void insertar() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			DAOtarea.getInstance().insert(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			DAOtarea.getInstance().delete(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			DAOtarea.getInstance().update(this);
			System.out.println("actualizado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Tarea buscarID(int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Tarea e = null;
		try {
			e = DAOtarea.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.titulo =e.getTitulo();
			this.descripcion =e.getDescripcion();
			this.prioridad = e.getPrioridad();
			this.categoria = e.getCategoria();
		}
		return e;
	}
	

	public ArrayList<Tarea> listarTareas() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ArrayList<Tarea> lista = null;
		try {
			lista = DAOtarea.getInstance().listaTarea();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	

	public String pintarTarea() {
		String s="";
		
		s+="<th scope='row'>"+getId()+"</th>"+
  		      "<td>"+this.getTitulo()+"</td>"+
  		      "<td>"+this.getDescripcion()+"</td>"+
  		      "<td>"+this.getFecha_inicio()+"</td>"+
  		      "<td>"+this.getFecha_fin()+"</td>"+  		      
  		      "<td>"+this.getPrioridad()+"</td>"+
  		      "<td>"+this.getCategoria()+"</td>"+	    		      
  		      "<td>"+"<a href='AltaTareas?accion=showedit&id="+getId()+"'><span class='glyphicon'>&#xe065;</span>"+"</a>"+"</td>"+
  		      "<td>"+"<a href='AltaTareas?accion=borrar&id="+getId()+"'> <span class='glyphicon'>&#xe020;</span>"+"</a>"+"</td>"+
  		      "<td>"+"<a href='AltaSubtareas?idPadre="+getId()+"&tituloP="+getTitulo()+"'><span class='glyphicon'>&#xe056;</span>"+"</a>"+"</td>"+  
  		    "	<td>"+"<a href='ListaSuptareas.jsp'>ver"+"</a>"+"</td>"+  			
 		     
  		      "</tr>";	
	//System.out.println(toString());
		return  s;
	}
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", prioridad=" + prioridad + ", categoria=" + categoria;
	}
	
}
