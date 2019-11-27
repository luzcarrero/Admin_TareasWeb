package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOtarea;
import dao.DAOusuario;

public class Usuario {
	private int id;
	private String nombre;	
	private String apellido;
	private String mail;
	private String clave;
	
	public Usuario(){
		
	}
	
	public Usuario(int id, String n, String a, String m, String c){
		this.id=id;
		this.nombre=n;
		this.apellido=a;
		this.mail=m;
		this.clave=c;		
	}
	public Usuario( String n, String a, String m, String c){
		
		this.nombre=n;
		this.apellido=a;
		this.mail=m;
		this.clave=c;		
	}
	
	public int getId() {
		return this.id;		
	}
	public void setId(int i) {
		this.id=i;	
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public void insertar() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			DAOusuario.getInstance();
			DAOusuario.insertar(this);
			//System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usuario> obtenerListaUsuarios() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		ArrayList<Usuario> lista = null;
		try {
			lista = DAOusuario.getInstance().listaUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
	}
	public String muestraUsuarios() {
		String s="";
		s+="<th scope='row'>"+getId()+"</th>"+
	  		      "<td>"+getNombre()+"</td>"+
	  		      "<td>"+getApellido()+"</td>"+
	  		      "<td>"+getMail()+"</td>"+
	  		      "<td>"+getClave()+"</td>"+	    		      
	  		      "<td>"+"<a href='AltaTareas?accion=showedit&id="+getId()+"'>Editar"+"</a>"+"</td>"+
	  		      "<td>"+"<a href='AltaTareas?accion=borrar&id="+getId()+"'>Borrar"+"</a>"+"</td>"+
		    "</tr>";
		return s;
			
	}
	
}
