<div id='container'>
  <div class='signup'>
     <form action="<%=request.getContextPath()%>/AltaUsuario" method="post">
      <input type="hidden" name="id" id="id">	
       <input type='text' name="nombre" placeholder='First:'  />
       <input type='text' name="apellido" placeholder='Last:'  />
       <input type='text' name="mail" placeholder='Email:'  />
       <input type="text" name="clave" placeholder='Password'  />
       <input type='submit' placeholder='Enviar' />
     </form>
  </div>
  
  <div class='whysign'>
    <h1>Organizador de Tareas ++</h1>
    <p>Learning to code is not magic. It is as simply as opening your browser! See in real time the changes you make to HTMl, CSS, JavaScript, HAML, and more!</p>
    <p>Organizate tus actividades: 
      <span>HTML 2</span>
      <span>CSS  0</span>
      <span>JavaScript ¡completado!</span>
    </p>
  </div>
</div>
