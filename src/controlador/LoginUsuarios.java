package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOlogin;
import modelo.Login;

/**
 * Servlet implementation class LoginUsuarios
 */
@WebServlet("/LoginUsuarios")
public class LoginUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hola intento loguearme");
        String username = request.getParameter("nombre");
        String password = request.getParameter("clave");
        Login loginBean = new Login();
        loginBean.setUsuario(username);
        loginBean.setClave(password);
        try {
			System.out.println(DAOlogin.validate(loginBean));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Bloque catch generado automáticamente
			e1.printStackTrace();
		}
        try {
            if (DAOlogin.validate(loginBean)) {
            	
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
            	response.sendRedirect("index.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}
