package Assignment;

import java.util.*;

class CriterionNotMatch extends RuntimeException{
	
	CriterionNotMatch(String msg)
	{
		System.out.println(msg);
	}
}

public class exceptionhandle {

	public static void main(String[] args) {
		String city,car;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the name of the city:");
		city=s.next();
		System.out.println("Enter the type of vehicle you own:");
		car=s.next();
		
		try {
			if(city=="Pune" || city=="Bangalore" || city=="Chennai" || city=="Mumbai")
			{
				if(car=="4 wheeler"||car=="four wheeler")
				{
					System.out.println("Criterion matches.");
				}
				else
				{
					throw new CriterionNotMatch("Car should be four wheeler");
				}
			}
			else 
			{
				throw new CriterionNotMatch("City is different");
			}
		}
		
		catch(CriterionNotMatch e)
		{
			System.out.println(e);
		}	
	}

}
