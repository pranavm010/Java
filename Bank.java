package Assignment;

interface Rate_of_intrest
{
    float intrest_price(float i);
}

class SBI implements Rate_of_intrest
{
    public float intrest_price(float i)
    {
        return (i*8.4f)/100 ;   
    }
    
}
class HDFC implements Rate_of_intrest
{
    public float intrest_price(float i)
    {
        return (i*7.3f)/100 ;   
    }
}
class ICICI implements Rate_of_intrest
{
    public float intrest_price(float i)
    {
        return (i*9.7f)/100 ;   
    }
}

public class Bank {
    public static void main(String[] args)
    {
       System.out.println("Intrest amount on 5 lakh rupees in different banks. ");
  

       Rate_of_intrest rahul = new SBI();
       System.out.println("intrest amount for sbi bank : " + rahul.intrest_price(500000));
         

       Rate_of_intrest rohit = new HDFC();
       System.out.println("intrest amount for hdfc bank : " + rohit.intrest_price(500000));

       Rate_of_intrest rohan = new ICICI();
       System.out.println("intrest amount for icici bank : " +rohan.intrest_price(500000));
        
	
    }
    
}
