package Assignment;

import java.util.*;

class Nodes
{
	int data;
	Nodes next;
	Nodes prev;
}
class create {
	Nodes head;
	public void create_nn(int data)
	{
		Nodes node=new Nodes();
		node.data=data;
		node.prev=null;
		node.next=null;
		if(head==null)
		{
			head=node;
		}
		else
		{
			Nodes n=head;
			while(n.next!=null)
			{
				n=n.next;
			}
			n.next=node;
			node.prev=n;
		}
	}
	public void display_dll()
	{
		Nodes t =head;
		System.out.println("Your created doubly linked list is:");
		while(t!=null)
		{
			System.out.println(t.data);
			t=t.next;
		}
		
	}
	public void ins_pos(int n)
	{
		int position;
		System.out.println("Enter the position you want add the node:");
		Scanner sc=new Scanner(System.in);
		position=sc.nextInt();
		System.out.println("Enter the data you want add in the node:");
		int newdata=sc.nextInt();
		Nodes t1;
		t1=head;
		Nodes node=new Nodes();
		node.data=newdata;
		node.prev=null;
		node.next=null;
		if(position==1)
		{
			node.next=head;
			head.prev=node;
			head=node;
			n=n+1;
		}
		else if(position==n+1)
		{
			while(t1.next!=null)
			{
				t1=t1.next;
			}
			t1.next=node;
			node.prev=t1;
			n=n+1;
		}
		else
		{
			for(int i=1;i<position-1;i++)
			{
				t1=t1.next;
			}
			node.next=t1.next;
			t1.next=node;
			(node.next).prev=node;
			t1.next=node;
			node.prev=t1;
			n=n+1;
		}
	}
	public void delete_node(int n)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the position of node you want to delete:");
		int posi=sc.nextInt();
		
		if(posi==1)
		{
			Nodes t;
			t=head;
			head=t.next;
			(t.next).prev=null;
			t.next=null;
			n=n-1;
		}
		else if(posi==n+1)
		{
			Nodes t1,t2;
			t1=t2=head;
			while(t1.next!=null)
			{
				t2=t1;
				t1=t1.next;
			}
			t2.next=null;
			t1.prev=null;
		}
		else
		{
			Nodes p1,p2;
			p2=p1=head;
			for(int i=1;i<posi;i++)
			{
				p2=p1;
				p1=p1.next;
			}
			p2.next=p1.next;
			(p1.next).prev=p2;
		}
	}
	public void rev_list()
	{
		Nodes l1;
		l1=head;
		while(l1.next!=null)
		{
			l1=l1.next;
		}
		System.out.println("Reversed linked list is: ");
		while(l1.prev!=null)
		{
			System.out.print(l1.data+" ");
			l1=l1.prev;
		}
		System.out.println
		(l1.data);
	}
}
public class DLL{
	public static void main(String[] args)
	{
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter no. of nodes you want to create:");
		int n=ss.nextInt();
		create c=new create();
		System.out.print("Enter data in each node:");
		for(int i=0;i<n;i++)
		{
			int data=ss.nextInt();
			c.create_nn(data);
			data=0;
		}
		boolean t=true;
		while(t) {
		System.out.println("1.Display DLL \n2.Insert new node at a position.\n3.Delete a node.\n4.Reverse the linked list.");
		System.out.print("Enter the operation you want to do..: ");
		int choice=ss.nextInt();
		switch(choice)
		{
		case 1:
			c.display_dll();
			break;
			
		case 2:
			c.ins_pos(n);
			break;
			
		case 3:
			c.delete_node(n);
			break;
			
		case 4:
			c.rev_list();
			break;
		}
		System.out.print("Do you want to continue ?");
		int m=ss.nextInt();
		if(m==1)
		{
			t=true;
		}
		else
		{
			t=false;
		}
		
		}
	}
}