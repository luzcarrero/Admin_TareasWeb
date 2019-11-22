<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>

<%@page import="controlador.altaTareas"%>
<%@page import="dao.DAOtarea"%>
<%@page import="modelo.Tarea"%>

<%   	
	Tarea t= new Tarea();
	String  id="0";
	if (request.getParameter("id")!=null) {
		id = request.getParameter("id");						
	}	
	t.buscarID(Integer.parseInt(id));
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp" %>
</head>
<body>

<header>
<%@include file="includes/menu.jsp" %>
</header>

 <div align="center">
  <h1>Tareas</h1>
  <div>
 
  	<%
  	 	out.print("hola mundo");
  		out.print("\n");
  		out.print(request.getParameter("id"));
  	%>

</div>
  <form action="<%=request.getContextPath()%>/AltaTareas" method="post">
   <table style="with: 80%">
    <tr>
    
    <td>
     <input type="hidden" name="id" id="id" value='<%if (request.getParameter("id")!=null)out.print(id);%>'>
	</td>		
	</tr>	
	<tr>	
      <td>Titulo</td>
     <td><input type="text" name="titulo" value='<% if(request.getParameter("id") != null)	
    		 out.print(t.getTitulo()); %>'/></td>
    </tr>
    <tr>
     <td>Descripcion</td>
     <td>
    <textarea class="form-control" name="descripcion" id="descripcion" required rows="3" placeholder="Escribe una descripción del servidor"></textarea>
     </td>     
    </tr>
  		<tr>
  		<td>fecha inicio</td>
		<td> 
		<input type="date"  name="fecha_inicio" value='<% if(request.getParameter("id") != null)	
    		 out.print(t.getFecha_inicio()); %>' min="2018-01-01" max="2028-12-31"></td>				     
		<td> <input type="date" name="fecha_fin" value='<% if(request.getParameter("id") != null)	
    		 out.print(t.getFecha_fin()); %>'  min="2018-01-01" max="2028-12-31" ></td>
    <tr>
     <td>Prioridad</td>   
     <td>
     <select type="text" name="prioridad" value='<% if(request.getParameter("id") != null)	
    		 out.print(t.getPrioridad()); %>'/>
     <option>1</option>
     <option>2</option>
     <option>3</option>
     </select>
     </td>
    </tr>
    <tr>
     <td>Categoria</td>
     <td>
     <select type="text" name="categoria" value='<% if(request.getParameter("id") != null)	
    		 out.print(t.getCategoria()); %>'/>
     <option>1</option>
     <option>2</option>
     <option>3</option>
     </select>
     </td>
    
    </tr>    
   </table>
   <input type="submit"  name="enviar" value="Guardar"/>
  </form>
 </div>
 				<%
					if (request.getParameter("id")!= null)
						out.print("<a href='altaTareas.jsp?&id=" + t.getId() + "'>Borrar</a>");
				%>
 <div><a href="listaTarea.jsp">cotillear cuantas tareas tengo</a></div>
</body>
</html>