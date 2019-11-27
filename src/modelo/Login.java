package modelo;

import java.io.Serializable;

public class Login implements Serializable{

	/**
	 * atributos "usuario, y clave"
	 */
	private String usuario;
    private String clave;
    
	private static final long serialVersionUID = -2863504733407250122L;
	
		public Login() {
			
		}
	    public String getUsuario() {
	        return this.usuario;
	    }

	    public void setUsuario(String username) {
	        this.usuario = username;
	    }

	    public String getClave() {
	        return this.clave;
	    }
	    
	    public void setClave(String clave) {
	    	this.clave=clave;
	    }
	    

}
