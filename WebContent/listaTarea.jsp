<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>

<%@page import="controlador.altaTareas"%>
<%@page import="modelo.Tarea"%>
<%@page import="modelo.ListaTarea"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp" %>
</head>
<body>
<header>
<%@include file="includes/menu.jsp" %>
</header>
<section>
			<div class="container">
				<h1>Lista Tareas</h1>
				<table class="table">
					<%
					ListaTarea ta = new ListaTarea();
					String muestra = ta.pintarTablaTarea();						
					%>
					<%=muestra%>					
				</table>
				
			</div>
		</section>
		
</body>
</html>