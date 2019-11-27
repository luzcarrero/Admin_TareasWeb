
package controlador;

import java.io.IOException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DAOtarea;
import modelo.Tarea;

/**
 * Servlet implementation class altaTareas
 */
@WebServlet("/AltaTareas")
public class altaTareas extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @see HttpServlet#HttpServlet()
     */
    public altaTareas() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        super();      
    }
    private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		//System.out.println("Hola Servlet..");
    		
    	String accion = request.getParameter("accion");
    	System.out.println(accion);
    		try {
    			switch (accion) { 
    			case "showedit":
    				showEditar(request, response);
    				break;	
    			case "editar":
    				System.out.println("paso por aqui");
    				editar(request, response);
    				break;
    			case "borrar":
    				eliminar(request, response);
    				break;
    			case "dividir":
    				subtareas(request, response);
    				break;
    			
    			default:
    				System.out.println("Opcion no valida");
    				break;
    			}			
    		} catch (SQLException e) {
    			e.getStackTrace();
    		}
    		
    	
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/htmlUTF-8");
		try {
			this.index(request, response);
		} catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	

	private void subtareas(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		Tarea tarea=DAOtarea.buscarID(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher dispatcher = request.getRequestDispatcher("formTarea.jsp");		
		DAOtarea.insert(tarea);	
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		LocalDate fecha_inicio=LocalDate.parse(request.getParameter("fecha_inicio"),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate fecha_fin=LocalDate.parse(request.getParameter("fecha_fin"),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String prioridad = request.getParameter("prioridad");
		String categoria = request.getParameter("categoria");	
		Tarea t = new Tarea(titulo, descripcion,fecha_inicio,fecha_fin, prioridad, categoria);
		
		if(request.getParameter("id")=="") {
		try {
			t.insertar();					
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {		
			e.printStackTrace();
		}	

	}else {
		try {			
			
			t.setId(Integer.parseInt(request.getParameter("id")));		
			t.update();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
			
		}
		
	}
		
		response.sendRedirect("listaTarea.jsp");

	}
	

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		LocalDate fecha_inicio=LocalDate.parse(request.getParameter("fecha_inicio"),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate fecha_fin=LocalDate.parse(request.getParameter("fecha_fin"),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Tarea t =new Tarea(Integer.parseInt(request.getParameter("id")), request.getParameter("titulo"), request.getParameter("descripcion"),				
				fecha_inicio,fecha_fin,request.getParameter("prioridad"),request.getParameter("categoria"));
		DAOtarea.update(t);
	
		response.sendRedirect("listaTarea.jsp");
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	
		Tarea tarea=DAOtarea.buscarID(Integer.parseInt(request.getParameter("id")));		
		response.sendRedirect("nuevaTarea.jsp?id="+request.getParameter("id"));		
		System.out.println(tarea.toString());	

	}	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Tarea t = null;
		t=DAOtarea.buscarID(Integer.parseInt(request.getParameter("id")));
		DAOtarea.delete(t);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listaTarea.jsp");
		dispatcher.forward(request, response);
		
	}
}

