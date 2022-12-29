package Com.Velocity.Project.Quize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quize extends Student {
	String Answer;
	Connection con=null;
	PreparedStatement ps=null;
	void AcceptAnswer(int Q_ID,int S_ID) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Option");
		Answer=sc.next();
		ConnectionTest CT=new ConnectionTest();
		try
		{
			con=CT.getConnectionDetails();
			ps=con.prepareStatement("insert into StudentQuize(QS_ID,QQ_ID,FinalAnswer) values(?,?,?)");
			ps.setInt(1, S_ID);
			ps.setInt(2,Q_ID);
			ps.setString(3,Answer);
		    ps.executeUpdate();
		  
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	void displayQuetion() throws SQLException
    {
   	 ConnectionTest CT=new ConnectionTest();
   	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Your ID");
	int S_ID=sc.nextInt();
		try
		{
			int randNumber;
			con=CT.getConnectionDetails();
			ArrayList<Integer> list = new ArrayList<Integer>(); 
	        for (int i = 1; i <= 10; i++) { 
	            list.add(new Integer(i)); 
	        } 
	        Collections.shuffle(list); 
	        for (int i = 0; i < 10; i++) { 
	        	randNumber=list.get(i);
			PreparedStatement ps=con.prepareStatement("select Q_ID,Quetion,Option1,Option2,Option3,Option4 from QuetionBank where "+"Q_ID"+"="+"'"+randNumber+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int Q_ID=rs.getInt(1);
				String Quetion=rs.getString(2);
				String Option1=rs.getString(3);
				String Option2=rs.getString(4);
				String Option3=rs.getString(5);
				String Option4=rs.getString(6);
				System.out.println("Quetion:"+Quetion);
				System.out.println(Option1);
				System.out.println(Option2);
				System.out.println(Option3);
				System.out.println(Option4);
				this.AcceptAnswer(Q_ID,S_ID);
			}
	
	    }
			System.out.println("Your Quize is Submitted Succesfully !!!!!!!");
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
	
	
}
