package Com.Velocity.Project.Quize;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Student {
	String FirstName;
	String LastName;
	Connection con=null;
	PreparedStatement ps=null;
	void Accept() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the First Name");
		FirstName=sc.next();
		System.out.println("Enter the Last Name");
		LastName=sc.next();
		ConnectionTest CT=new ConnectionTest();
		try
		{
			con=CT.getConnectionDetails();
			ps=con.prepareStatement("insert into StudentInfo(FirstName,LastName) values(?,?)");
			ps.setString(1,FirstName);
			ps.setString(2,LastName);
    	    ps.executeUpdate();
    	    System.out.println("Student Information Store Succesfully ");
    	   
    	    this.getID(FirstName,LastName);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			con.close();
			ps.close();
		}
	}
	
	void getID(String FirstName1,String LastName1) throws SQLException
	{   Connection con=null;
		  
		ConnectionTest CT=new ConnectionTest();
		con=CT.getConnectionDetails();
		PreparedStatement ps=con.prepareStatement("Select S_Id,FirstName,LastName from StudentInfo where "+"FirstName"+"="+"'"+ FirstName1+"'"+ "AND" +" "+"LastName"+"="+"'"+LastName1+"'");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int Stude_ID=rs.getInt(1);
			String Stud_FName=rs.getString(2);
			String Stud_LName=rs.getString(3);
			System.out.println("ID="+Stude_ID+"\t"+"Name:"+Stud_FName+"\t"+Stud_LName);
		} 
		
	}
	
	
	}

