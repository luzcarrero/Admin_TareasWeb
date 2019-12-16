<%@page import="controlador.altaTareas"%>
<%@page import="dao.DAOtarea"%>
<%@page import="modelo.Tarea"%>
<%@page import="modelo.Subtarea"%>
<%@page import="controlador.AltaSubtareas"%>

<%   	
	Tarea t= new Tarea();
	String  id="0";
	if (request.getParameter("id")!=null) {
		id = request.getParameter("id");						
	}	
	t.buscarID(Integer.parseInt(id));
	
	Subtarea subtarea= new Subtarea();
	String  ids="0";
	if (request.getParameter("id")!=null) {
		id = request.getParameter("id");						
	}	
	
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp" %>

</head>
<body>
<header>
<%@include file="includes/menu.jsp" %>
<style>
.container{

margin:100px auto;
padding:0px auto;
}
</style>
</header>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">
                <form action="AltaSubtareas"  class="form-horizontal" method="post">            
                   <fieldset>
                        <legend class="text-center header"><p>Subtarea de : <%out.print(request.getParameter("tituloP"));%></p></legend>
							<!-- titulo -->
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><span class="glyphicon glyphicon-pencil"></span></span>
                            <div class="col-md-8">
                                <input id="fname" name="titulo" type="text" placeholder="Titulo" class="form-control">
                            </div>                           
                        </div>
                         <!-- descripcion -->
                           <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><span class="glyphicon glyphicon-text-height"></span></span>
                            <div class="col-md-8">
                                <textarea class="form-control" name="descripcion" placeholder="descripción" rows="7"></textarea>
                            </div>
                        </div>
                      
                       <div>
                      <input name="pk_depende" type="hidden" value=<%out.print(request.getParameter("idPadre"));%> class="form-control">
						</div>                		
						
                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Enviar</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<

</body>
</html>