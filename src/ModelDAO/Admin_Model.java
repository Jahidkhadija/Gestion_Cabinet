package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Admin;
import DAO.Connect;

public class Admin_Model {
	public Connection con;
	public Statement st;
	public Admin_Model(Connect con,Statement st)
	{
		this.con=Connect.get_connexion();
		this.st=st;
	}
	public ResultSet sign_in(String query,Admin d) throws SQLException
	{
		ResultSet s;
		PreparedStatement pr = con.prepareStatement(query);
		pr.setString(1, d.getNom());
		pr.setString(2, d.getCode());
		s=pr.executeQuery();
		return s;
	}
}
