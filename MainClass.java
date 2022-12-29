package Com.Velocity.Project.Quize;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		Quize quize=new Quize();
		quize.Accept();
		quize.displayQuetion();
		
		Result R=new Result ();
		System.out.println("Are you interested for result Enter Yes or No");
        String result=sc.next();
        if(result.equalsIgnoreCase("Yes"))
        {
		R.CalculateResult();
        }
        else
        	System.out.println("!!!!!!!!!!!!! Thank You!!!!!!!!!!!!!!");
		
        Results R1=new Results();
        System.out.println("Are you interested for result Enter Yes or No");
        String str=sc.next();
        if(str.equalsIgnoreCase("Yes"))
        {
      	  System.out.println("For All result type ALL and for prticular student Enter the ID");
            String str1=sc.next();
            if(str1.equalsIgnoreCase("All"))
          	   R1.AllResult();
            else
          	  R1.perticularResult();
         }
        else
      	  System.out.println("!!!!!!!!Thank You!!!!!!!!!!");
        
        

	}

}
