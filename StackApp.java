package Assignment;
import java.util.*;

import java.util.* ;

class Node1
{
    public char data;
    public Node1 next;
};

class stack
{
    private Node1 top;


    stack()
    {
        top = null;
    }

    public void push(char x)
    {
        Node1 t;
        t = new Node1();
        t.data = x;
        t.next = top;
        top = t;

    }

    public char pop()
    {
        if(top==null)
        {
           System.out.println("stack is empty");
           return 0;
        }
        else
        {
            Node1 p;
            char x;
            p = top;
            x = p.data;
            top = top.next;
            return x;
        }
    }

    public char stackTop()
    {
        if(top==null)
        {
            return '0';
        }
        else
        {
            return top.data ;
        }
    }

    public boolean isEmpty()
    {
        if(top==null)
        {
            return true;
        }   
        else
        {
            return false;
        }
    }

    public void display()
    {
        Node1 p;
        p = top;
        while(p!=null)
        {
            System.out.println(p.data); 
            p = p.next;
        }
        //System.out.println("\n"); 
    }

    // this for all type of operators
    public boolean isOparand(char x)
    {
        if(x=='+' || x=='-' || x=='*' || x=='/' || x=='^' || x=='(' || x==')' )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

//this for universal operator precident
    public int In_Stack_Pre(char x)
    {
        if(x=='+' || x=='-')
        {
            return 2;
        }
        else if(x=='*' || x=='/')
        {
            return 4;
        }
        else if(x=='^')
        {
            return 5;
        }
        else if(x=='(')
        {
            return 0;
        }
        else if(x==')')
        {
            return 0;
        }
        else 
        {
            return -1;
        }

       
      
    }

//this for universal operator precident
    public int Out_Stack_Pre(char x)
    {
        if(x=='+' || x=='-')
        {
            return 1;
        }
        else if(x=='*' || x=='/')
        {
            return 3;
        }
        else if(x=='^')
        {
            return 6;
        }
        else if(x=='(')
        {
            return 7;
        }
        else if(x==')')
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

//this for infix to postfix for universal operators
    public String  InfixToPostfix_Conversion(String infix)
    {
        String postfix = new String();
        int i=0;

        //for(int m=0; m<infix.length()+2; m++)
        while(infix.charAt(i)!= '\0')
        {
            if(isOparand(infix.charAt(i)))
            {
                postfix += infix.charAt(i++);
            }
            else
            {
            	if(isEmpty())
            	{
            		push(infix.charAt(i));
            	}
            	else if(Out_Stack_Pre(infix.charAt(i))>In_Stack_Pre(infix.charAt(i)))
                {
                    push(infix.charAt(i++));
                }
                else if(Out_Stack_Pre(infix.charAt(i)) == In_Stack_Pre(infix.charAt(i)))
                {
                    pop();
                    i++ ;
                }
                else
                {
                    postfix += pop();
                } 
            }
            
        }
    
        while(top!=null)
        {
            postfix += pop();
        }
        postfix += '\0';

        return postfix;
    }
}

class StackApp
{
    public static void main(String []args)
    {
        stack stk = new stack();
        stk.push('#');

        String infix = "a+b" ;
        String postfix = stk.InfixToPostfix_Conversion(infix);
    
        
        System.out.println(postfix);  
        stk.display();
        
     
    } 

}