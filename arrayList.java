package Assignment;
import java.util.*;

class al
{
	Scanner s=new Scanner(System.in);
	void Add( ArrayList<String> AL)
	{
		
		
		String r=s.next();
		AL.add(r);
		System.out.println("Element added");
	}
	void Remove(ArrayList<String> AL)
	{
		System.out.println("Which position you want to delete:");
		int pos=s.nextInt();
		AL.remove(pos);
		System.out.println("Element removed");
	}
	void Sort(ArrayList<String> AL)
	{
		Collections.sort(AL);
		System.out.println("List sorted");
	}
	void Display(ArrayList<String> AL)
	{
		System.out.println(AL);
	}
	void Reverse(ArrayList<String> AL)
	{
		Collections.reverse(AL);
		System.out.println("List reversed");
	}
}

public class arrayList {

	public static void main(String[] args) {
		
		ArrayList<String> AL = new ArrayList<String>();
		
		AL.add("Pranav");
		AL.add("Paresh");
		AL.add("Prasad");
		AL.add("Ramraj");
		AL.add("Abhishek");
		AL.add("Prajwal");
		
		Scanner sc=new Scanner(System.in);
		al a=new al();
		int cont=1;
		
		while(cont==1)
		{
			System.out.println("What operation you want to do on the list?");
			System.out.println("1.Add\n2.Remove\n3.Sort\n4.Display\n5.Reverse");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				a.Add(AL);
				break;
			case 2:
				a.Remove(AL);
				break;
			case 3:
				a.Sort(AL);
				break;
			case 4:
				a.Display(AL);
				break;
			case 5:
				a.Reverse(AL);
				break;
			}
			
			System.out.print("Do you want tto continue?");
			int temp=sc.nextInt();
			if(temp==1)
			{
				cont=1;
			}
			else
			{
				cont=0;
			}
		}
		sc.close();
	}
	
}
