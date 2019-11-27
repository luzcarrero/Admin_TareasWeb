package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;


import conexion.DBconnection;

import modelo.Login;

public class DAOlogin {
	private static Connection con=null;
	public static DAOlogin instance =null;
	
	public DAOlogin() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		con = DBconnection.getConnection();
	}
	public static DAOlogin getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new DAOlogin();
		return instance;
	}
	
	public static boolean validate(Login login) throws ClassNotFoundException, SQLException {
        boolean status = false;
            PreparedStatement ps=con.prepareStatement("select * from usuario where nombre = ? and clave = ? ");
            ps.setString(1, login.getUsuario());
            ps.setString(2, login.getClave());

            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            status = rs.next();

       
        return status;
    }
}
