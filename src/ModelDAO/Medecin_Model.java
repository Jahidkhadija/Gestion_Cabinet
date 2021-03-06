package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Classes.Medecin;
import DAO.Connect;

public class Medecin_Model {
	public Connection con;
	public Statement st;
	public Medecin_Model()
	{
		con=Connect.get_connexion();
		st=null;
	}
	public void Ajouter(String query,Medecin c) throws SQLException
	{
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1,c.getId_med());
		pr.setInt(2,c.getVersion());
		pr.setString(3,c.getTitre());
		pr.setString(4,c.getNom());
		pr.setString(5,c.getPrenom());
		pr.execute();
	}
	public void Modifier (String query) throws SQLException
	{
		PreparedStatement pr = con.prepareStatement(query);
		pr.executeUpdate();
	}
	public void Supprimer (String query ,int i) throws SQLException
	{
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1,i);
		pr.execute();
	}
	public ResultSet Afficher(String query) throws SQLException
	{
		ResultSet s;
		PreparedStatement pr = con.prepareStatement(query);
		s=pr.executeQuery();
		return s;
		
	}
	public ResultSet Rechercher(String query, int id) throws SQLException
	{
		ResultSet s;
		PreparedStatement pr = con.prepareStatement(query);
		pr.setInt(1, id);
		s=pr.executeQuery();
		return s;
	}
}
