package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static Connection cn;
	private Connect()
	{	
		
	}
	static {
		

		if(cn==null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn= DriverManager.getConnection( "jdbc:mysql://localhost:3306/cabinet","root","");
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
		}
		
		}
		public static Connection get_connexion()
		{
		return cn;
		
	}


}
