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
<!-- 
<script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
  <script>tinymce.init({selector:'textarea'});</script>
 -->
</head>
<!-- BODY -->
<body>
<header>
<%@include file="includes/menu.jsp" %>
</header>

<div class="container">

  <form action="AltaTareas" method="post">
   <!-- identificador -->
     <input type="hidden" name="id" value='<%if (request.getParameter("id")!=null)out.print(id);%>'>
    <!-- titulo -->
     <label>Titulo</label>
     <input type="text" class="form-control" name="titulo" value='<% if(request.getParameter("id") != null)	
    		 out.print(t.getTitulo()); %>'/>
	<!-- descripcion -->
   <div>
     <label>Descripcion</label>     
    <textarea class="form-control" name="descripcion" id="detalle" required rows="3" placeholder='<% if(request.getParameter("id") != null)	
    		 out.print(t.getDescripcion()); %>'/></textarea>
     </div>
	   <!-- fecha inicio -->
		<div class="col-6">
			  <label>Fecha inicio</label>
			    <input class="form-control" type="date" name="fecha_inicio" value='<% if(request.getParameter("id") != null)	
	    		 out.print(t.getFecha_inicio()); %>'  min="2018-01-01" max="2028-12-31" >
			  </div>
			  
			  <!-- fecha fin -->
			 <div class="col-6">
					<label>Fecha fin</label>
			    <input class="form-control" type="date" name="fecha_fin"value='<% if(request.getParameter("id") != null)	
	    		 out.print(t.getFecha_fin()); %>'   min="2018-01-01" max="2028-12-31" >
			  </div>
			  
    <label>prioridad</label>
     <select class="form-control" name="prioridad">
     <option>1</option>
     <option>2</option>
     <option>3</option>
     </select>
    
     <label>categoria</label>
  
     <select  class="form-control" name="categoria">
     <option>acceso a datos</option>
     <option>programacion</option>
     <option>android</option>
     </select>
     <br>
     <input class="btn" type='submit' placeholder='Enviar' />
     
  </form>
  
 </div>
		

</body>
</html>