<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./css/estilosLogin.css"/>
<%@include file="includes/head.jsp" %>
</head>
<body>
<header>

<%@include file="includes/menu.jsp" %>
</header>
<div class="row-lg-6">

<form action="LoginUsuarios" style="border:1px  #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label><b>Usuario</b></label>
    <input class="col-3" type="text" placeholder="Enter Usuario" name="nombre" required>

    <label for="psw"><b>Contraseña</b></label>
    <input class="col-3"  type="password" placeholder="Enter Contraseña" name="clave" required>

    
    
    <p>Acepta nuestros Términos y Privacidad.<a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

   
      <input type="submit" class="btn btn-primary" value="enviar">
   
  </div>
</form>
</div>

</body>