package modelo;

import java.sql.SQLException;

import dao.DAOsubtarea;
import dao.DAOtarea;

public class Subtarea {
	private int id;	
	private int dep;
	private String Titulo;
	private String descripcion;

	public Subtarea() {
		
	}	
	public Subtarea(int id, int dependencia, String titulo, String descripcion) {
		this.id=id;
		this.dep=dependencia;
		this.Titulo=titulo;
		this.descripcion=descripcion;
	}
	public Subtarea(String titulo, String descripcion,int dependencia) {		
		this.Titulo=titulo;
		this.descripcion=descripcion;
		this.dep=dependencia;
	}
	public Subtarea(String titulo, String descripcion) {	
		this.Titulo=titulo;
		this.descripcion=descripcion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDependencia() {
		return dep;
	}
	public void setDependencia(int dependencia) {
		this.dep = dependencia;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void insertar() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			DAOsubtarea.getInstance().insert(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String pintarSubtarea() {
		String s="";
		s+="<th scope='row'>"+getId()+"</th>"+
	  		      "<td>"+getTitulo()+"</td>"+
	  		      "<td>"+getDescripcion()+"</td>"+
	  		      "<td>"+getDependencia()+"</td>"+
	  		      "<td>"+"<a href='AltaSubTareas?accion=showedit&id="+getId()+"'><span class='glyphicon'>&#xe065;</span>"+"</a>"+"</td>"+
	  		      "<td>"+"<a href='AltaSubTareas?accion=borrar&id="+getId()+"'> <span class='glyphicon'>&#xe020;</span>"+"</a>"+"</td>"+
	  		      "<td>"+"<a href='AltaSubTareas?accion=dividir&id="+getId()+"'><span class='glyphicon'>&#xe056;</span>"+"</a>"+"</td>"+
	  			
	  		      "</tr>";	
		return s;
	}
}
