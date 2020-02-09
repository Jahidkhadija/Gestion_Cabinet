package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Creneaux;
import DAO.Connect;

public class Creneaux_Model {
	public Connection con;
	public Statement st;
	public Creneaux_Model()
	{
		con=Connect.get_connexion();
		st=null;
	}
	public ResultSet Afficher(String query) throws SQLException
	{
		ResultSet rs=null;
		PreparedStatement pr=con.prepareStatement(query);
		rs=pr.executeQuery();
		return rs;
		
	}
	public void Ajouter(String query,Creneaux c) throws SQLException
	{
		PreparedStatement pr=con.prepareStatement(query);
		pr.setInt(1, c.getId());
		pr.setInt(2, c.getVersion());
		pr.setInt(3, c.getH_debut());
		pr.setInt(4, c.getM_debut());
		pr.setInt(5, c.getH_fin());
		pr.setInt(6, c.getM_fin());
		pr.setInt(7, c.getId_med());
		pr.execute();
	}
	public ResultSet Chercher(String str,int id) throws SQLException
	{
		ResultSet rs=null;
		PreparedStatement pr=con.prepareStatement(str);
		pr.setInt(1,id);
		rs=pr.executeQuery();
		return rs;
	}
	public void Supprimer(String str,int id)throws SQLException
	{
		PreparedStatement pr=con.prepareStatement(str);
		pr.setInt(1,id);
		pr.execute();
	}
	public void Modifier(String str)throws SQLException
	{
		PreparedStatement pr=con.prepareStatement(str);
		pr.execute();
	}
}
