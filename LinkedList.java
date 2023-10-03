package Assignment;

import java.util.*;
class Node
{
	int data;
	Node next;
}
class CreateLinkedList {
	
	Node head;
	public void insert(int data)
	{
		Node node=new Node();
		node.data=data;
		node.next=null;
		if(head==null)
		{
			head=node;
		}
		else 
		{
			Node n=head;
			while(n.next!=null)
			{
				n=n.next;
			}
			n.next=node;
		}
	}
	
	public void insert_beg()
	{
		Scanner sc=new Scanner(System.in);
		
	    System.out.println("Enter the data:");
		int b=sc.nextInt();		
		Node node=new Node();
		node.data=b;
		node.next=null;
		node.next=head;
		head=node;	
		show();
	}
	public void insert_pos()
	{
		Node t1,t2;
		t1=t2=head;
		Scanner sc=new Scanner(System.in);
		Node node=new Node();
		System.out.println("Enter the data:");
		int data=sc.nextInt();
		node.data=data;
		node.next=null;
		System.out.println("Enter the position :");
		int pos=sc.nextInt();
		for(int i=1;i<pos;i++)
		{
			t2=t1;
			t1=t1.next;
		}
	    t2.next=node;
		node.next=t1;
	}
	public void show()
	{
		Node node=head;
		while(node.next!=null)
		{
			System.out.println(node.data);
			node=node.next;
		}
		System.out.println(node.data);
	}
	
	public void delete(int n)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the position of node you want to delete:");
		int del_pos=sc.nextInt();
		if(del_pos==1)
		{
			Node t;
			t=head;
			head=t.next;
			t.next=null;
			System.out.println("Node deleted.");
		}
		
		else if(del_pos==n+1)
		{
			Node t1,t2;
			t1=t2=head;
			while(t1.next!=null)
			{
				t2=t1;
				t1=t1.next;
			}
			t2.next=null;
			System.out.println("Node deleted.");
		}
		else
		{
			Node t1;
			t1=head;
			for(int i=1;i<del_pos-1;i++)
			{
				t1=t1.next;
			}
			t1.next=(t1.next).next;
			System.out.println("Node deleted.");
		}
	}
}
public class LinkedList {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		CreateLinkedList LL=new CreateLinkedList();
		System.out.println("Enter the no. of nodes you want to create:");
		int n=sc.nextInt();
		System.out.println("Enter the data in nodes:");
		for(int i=0;i<n;i++)
		{
			int a=sc.nextInt();
			LL.insert(a);
			a=0;
		}
		boolean P=true;
		while(P)
		{
			System.out.println("1.Insert a node at beggining. \n2.Insert a node at random position.\n3.Insert node at end.\n4.Delete a node.\n5.Display the LL.\n6.Exit.");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				LL.insert_beg();
				break;
				
			case 2:
				LL.insert_pos();
				break;
				
			case 3:
				System.out.println("Enter the data you want to add:");
				int data=sc.nextInt();
				LL.insert(data);
				break;
				
			case 4:
				LL.delete(n);
				break;
				
			case 5:
				LL.show();
				break;
				
			case 6:
				break;
			}
			System.out.println("Do you want to continue ?");
			int ans=sc.nextInt();
			if(ans==1)
			{
				P=true;
			}
			else
			{
				P=false;
			}
		}
	}
}


