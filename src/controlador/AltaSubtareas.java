package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Subtarea;
import modelo.Tarea;

/**
 * Servlet implementation class AltaSubtareas
 */
@WebServlet("/AltaSubtareas")
public class AltaSubtareas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaSubtareas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("formTarea.jsp?idPadre="+request.getParameter("idPadre")+"&tituloP="+request.getParameter("tituloP"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");	
		String dependencia=  request.getParameter("pk_depende");

		Subtarea t = new Subtarea(titulo, descripcion,Integer.parseInt(dependencia));
		try {
			t.insertar();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		response.sendRedirect("listaTarea.jsp");

	}

}
