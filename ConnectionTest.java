package Com.Velocity.Project.Quize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
class ConnectionTest{
	Connection con=null;
	public Connection getConnectionDetails()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Quize1","root","root");
	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return con;
	}	
}