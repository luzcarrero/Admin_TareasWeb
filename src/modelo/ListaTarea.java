package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOtarea;

public class ListaTarea {
	
	private ArrayList<Tarea> lista;
	
	
	
	public String pintarTablaTarea() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String s="";
		Tarea p =new Tarea();
		s+=
	"<thead class='thead-dark'>"+
	    "<tr>"+
	     " <th scope='col'>"+"id"+"</th>"+
	     " <th scope='col'>"+"Titulo"+"</th>"+
	     " <th scope='col'>"+"Descripcion"+"</th>"+
	     " <th scope='col'>"+"Fecha inicio"+"</th>"+
	     " <th scope='col'>"+"Fecha fin"+"</th>"+
	     " <th scope='col'>"+"Prioridad"+"</th>"+
	     " <th scope='col'>"+"Categoria"+"</th>"+
	     " <th scope='col'>"+"Editar"+"</th>"+
	     " <th scope='col'>"+"Borrar"+"</th>"+
	     " <th scope='col'>"+"Dividir"+"</th>"+
	    "</tr>"+
	 " </thead>"+
	 "<tbody>";

		if(p.listarTareas()!=null) {
	    for(Tarea t: p.listarTareas()){ 	    		   
	    		  s+=t.pintarTarea();  		    
	    }
	
	}
	  
	 s+="</tbody>";	
	 return s;
	}

}
