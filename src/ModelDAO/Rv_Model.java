package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Rendez_Vous;
import DAO.Connect;

public class Rv_Model {
	public Connection con;
	public Statement st;
	public Rv_Model()
	{
		con=Connect.get_connexion();
		st=null;
	}
	public void Ajouter(String query,Rendez_Vous s) throws SQLException
	{
		PreparedStatement pr=con.prepareStatement(query);
		pr.setInt(1,s.getId_rv());
		pr.setString(2,s.getJour());
		pr.setInt(3,s.getId_cl());
		pr.setInt(4, s.getId_cre());
		pr.execute();
		
	}
	public void Supprimer(String query,int id) throws SQLException
	{
		PreparedStatement pr=con.prepareStatement(query);
		pr.setInt(1,id);
		pr.execute();
	}
	public ResultSet Afficher(String query) throws SQLException
	{
		ResultSet s;
		PreparedStatement pr=con.prepareStatement(query);
		s=pr.executeQuery();
		return s;
	}
	public ResultSet Chercher(String query,int id)throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement pr=con.prepareStatement(query);
		pr.setInt(1,id);
		rs=pr.executeQuery();
		return rs;
	}
	public void Modifier(String s) throws SQLException
	{
		PreparedStatement pr=con.prepareStatement(s);
		pr.execute();
	}

}
