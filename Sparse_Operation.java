package Assignment;
import java.util.* ;

class sparse_opr
{
    private int k=1;
    private int[][] sp = new int[10][3];
    private int[][]spt=new int [10][3];
    private int[] total=new int[10];
    private int[] index=new int[10];
    private int[][] fast_trans=new int[10][3];
    

    public void create_sparse(int row, int col, int [][] mat)
    {
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(mat[i][j] != 0)
                {
                    sp[k][0] = i ;
                    sp[k][1] = j ;
                    sp[k][2] = mat[i][j];
                    k++ ;
                }
            }
        }

        sp[0][0] = row;
        sp[0][1] = col;
        sp[0][2] = (k-1) ;
       
   
    }
    public void display()
    {
        System.out.println("Your sparse matrix is :");

        for(int i=0; i<k; i++)
        {
            System.out.println(sp[i][0] + "\t" + sp[i][1] + "\t" + sp[i][2]);
        }
    }
   
    public  void sim_trans()
    {
        spt[0][1]=sp[0][0];
        spt[0][0]=sp[0][1];
        spt[0][2]=sp[0][2];
       
        int count=1;
        for(int i=0;i<sp[0][1];i++)
        {
            for(int j=1;j<=sp[0][2];j++)
            {
                if(sp[j][1]==i)
                {
                    spt[count][0]=sp[j][1];
                    spt[count][1]=sp[j][0];
                    spt[count][2]=sp[j][2];
                    count++;
                }  
            }
        }
       
       
    }
   public void disp_simt()
    {
         System.out.println("Your simple transpose is :");

        for(int i=0; i<=spt[0][2]; i++)
        {
            System.out.println(spt[i][0] + "\t" + spt[i][1] + "\t" + spt[i][2]);
        }
    }
    
    public void fast_trans()
    {
        int ctr=0;
        fast_trans[0][1]=sp[0][0];
        fast_trans[0][0]=sp[0][1];
        fast_trans[0][2]=sp[0][2];
        for(int i=0;i<sp[0][1];i++)
        {
            total[i]=0;
        }
        
        for(int j=0;j<sp[0][1];j++)
        {
              for(int i=1;i<=sp[0][2];i++)
              {
                  if(sp[i][2]==j)
                  {
                      total[j]++;
                  }
              }
        }
        index[0]=1;
        for(int i=1;i<sp[0][2];i++)
        {
            index[i]=index[i-1]+total[i-1];
        }
        
        for(int i=1;i<=sp[0][2];i++)
        {
            ctr=index[sp[i][1]];
            fast_trans[ctr][1]=sp[i][0];
            fast_trans[ctr][0]=sp[i][1];
            fast_trans[ctr][2]=sp[i][2];
            index[sp[i][1]]++;
            
        }
        
        
        //display fast transpose
         System.out.println("your fast tranpose is:");
        for(int x=0;x<=sp[0][2];x++)
        {
           
            System.out.println(spt[x][0] + "\t" + spt[x][1] + "\t" + spt[x][2]);
        }
    }
    
    
};

public class Sparse_Operation{
    public static void main(String[] args)
    {
        int row, col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        row = sc.nextInt();
        col = sc.nextInt();
       
        int[][] mat = new int[10][10];
        System.out.println("Enter matrix elements : ");

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }

        sparse_opr s = new sparse_opr();
        s.create_sparse(row, col, mat);
        s.display();
        s.sim_trans();
        s.disp_simt();
        s.fast_trans();
        sc.close();
        
       

    }

}
