package Com.Velocity.Project.Quize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Results {
	Connection con=null;
	PreparedStatement ps=null;
	void perticularResult()
	{
		int S_ID;
		ConnectionTest CT=new ConnectionTest();
		try
		{
			con=CT.getConnectionDetails();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Id to Display Result");
			S_ID=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("select S_ID,RS_ID,Marks,Grade,FirstName,LastName from StudentInfo,Result where ((RS_ID=?)&&(StudentInfo.S_ID=Result.RS_ID))");
			ps.setInt(1, S_ID);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int S_ID1=rs.getInt(1);
				int RS_ID=rs.getInt(2);
				int Marks=rs.getInt(3);
				String Grade=rs.getString(4);
				String FirstName=rs.getString(5);
				String LastName=rs.getString(6);
				System.out.println("Student ID:"+RS_ID);
				System.out.println("First Name:"+FirstName);
				System.out.println("Last Name"+LastName);
				System.out.println("Marks:"+Marks);
				System.out.println("Grade:"+Grade);
				
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	void AllResult()
	{
		ConnectionTest CT=new ConnectionTest();
		try
		{
			con=CT.getConnectionDetails();
			PreparedStatement ps=con.prepareStatement("select S_ID,RS_ID,Marks,Grade,FirstName,LastName from StudentInfo,Result where StudentInfo.S_ID=Result.RS_ID");
			ResultSet rs=ps.executeQuery();
			System.out.println("All Results:");
			while(rs.next())
			{
				int S_ID1=rs.getInt(1);
				int RS_ID=rs.getInt(2);
				int Marks=rs.getInt(3);
				String Grade=rs.getString(4);
				String FirstName=rs.getString(5);
				String LastName=rs.getString(6);
				System.out.println("Student ID:"+RS_ID+"\t"+"First Name:"+FirstName+"\t"+"Last Name"+LastName+"\t"+"Marks:"+Marks+"\t\t"+"Grade:"+Grade);
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
