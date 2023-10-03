package Assignment;
import java.util.Scanner;

public class Assignment_6 {
			public int front=-1,rear=-1,count=0;
			public int N=5;
			public int orders[]=new int [N];
			
			Assignment_6()
			{
				front=rear-1;
			}
			
				Boolean Enque(int id) {
				if(rear==-1)
		 	{
		 		front=rear=0;
		 		orders[rear]=id;
		 		return true;
			 }
			 else
			 {
			 	int pos=(rear+1)%N;
			 	if(pos==front)
			 	{
			 		System.out.println("\nCafe is Full.Please wait.\n");
			 		return false;
				 }
				 else
				 {
				 	rear=pos;
				 	orders[rear]=id;
				 	return true;
				 }
			 }
			}
			
				void Deque()
				
				{
					if(front==-1)
				 	{
				 		System.out.println("\n No Orders in Cafe.[Cafe is Empty)\n");
				 		return;
					 }
					 else
					 {
						 System.out.println("\n Order No. "+orders[front]+" is processed.\n");
					 	if(front==rear) //only one order
					 	{
					 		front=rear=-1;
						 }
						 else
						 {
						 	front=(front+1)%N;
						 }
					 }
				}
				
				void display()
				 {
				 	int i=0;
				 	if(front==-1)
				 	{
				 		System.out.println("\nCafe is Empty.No orders.\n");
				 		return;
					 }
					 else
					 {
						 System.out.println("Order Id's: \n");
					 	for(i=front; i!=rear; i=((i+1)%N))
					 	{
					 		System.out.println(orders[i]+"  ");
						 }
					 	System.out.println(orders[rear]);
					 }
				 }
			
			public static void main(String[] args) {
				
				// TODO Auto-generated method stub
				int ch,id=0;
				Scanner sc= new Scanner(System.in);
				 
				Assignment_6 q=new Assignment_6();

				do
					
				{	System.out.println("\n\n\n------------------------\nWELCOME TO Cafe\n------------------------\n");
					System.out.println("\n*Menu\n1. Accept order\n2. Serve order\n3. Display orders\n4. Exit");

					System.out.println("\nChoice: ");
					ch=sc.nextInt();

					switch(ch)
					{
					case 1: 
							id++;
							if(q.Enque(id))
							{
								System.out.println("Thank you for order.\nOrder id is : "+id);
								//id=sc.nextInt();
							}
							else
							{
								id--;
							}
							break;

					case 2:{ q.Deque();
							break;}

					case 3: {q.display();
							break;}
					
					}
				}while(ch!=4);
				System.out.println("\nThank You.Keep Visiting.");
				
			

			}

		}
	//}

//}
