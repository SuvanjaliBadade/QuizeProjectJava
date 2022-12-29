package Com.Velocity.Project.Quize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Result {
	static int cnt=0;
	Connection con=null;
	PreparedStatement ps=null;
	String FinalGrade;
	
	void StoreResult(int QS_ID,int CNT,String Grade)
	{
		ConnectionTest CT=new ConnectionTest();
		try
		{
			con=CT.getConnectionDetails();
			ps=con.prepareStatement("insert into Result(RS_ID,Marks,Grade) values(?,?,?)");
			ps.setInt(1,QS_ID);
			ps.setInt(2,CNT);
			ps.setString(3,Grade);
			ps.executeUpdate();
		    
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void counter(String FinalAnswer,String Answer)
	{	
		 if(FinalAnswer.equals(Answer))	
		 	 cnt=cnt+1;
	}
	String GenerateGrade(int cnt)
	{
		if(cnt>=8 && cnt<=10)
			return "A";
		else if(cnt>=6 && cnt<8)
			return "B";
		else if(cnt==5)
			return "c";
		else
			return "D";
				
	}
	void CalculateResult()
	{   int S_ID;
     	char Grade;
		ConnectionTest CT=new ConnectionTest();
		try
		{
			con=CT.getConnectionDetails();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the your Id to see Result");
			S_ID=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("select QS_ID,QQ_ID,FinalAnswer,Answer from StudentQuize,QuetionBank where (QS_ID=?)&&(QuetionBank.Q_ID=StudentQuize.QQ_ID)");
			ps.setInt(1, S_ID);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int QS_ID=rs.getInt(1);
				int QQ_ID=rs.getInt(2);
				String FinalAnswer=rs.getString(3);
				String Answer=rs.getString(4);
				this.counter(FinalAnswer, Answer);
			}
			 System.out.println("Your Result Is "+"\n"+"Points Out Of 10 are "+cnt); 
			String FinalGrade= this.GenerateGrade(cnt);	
			System.out.print("Grade:"+FinalGrade);
			this.StoreResult(S_ID,cnt,FinalGrade);
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		Result R=new Result ();
		R.CalculateResult();

	}

}
