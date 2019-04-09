import java.util.*;
class TestClass
{
       int rod_cut(int rod_length)
       {
            int c=0;
            if(rod_length==1 || rod_length==2)
                return 0;
            while(rod_length>2)
            {
                rod_length=special_rod(rod_length);
                    c++;
            }
            return c;
       }
       int special_rod(int len)
       {
            int len1;
            len1=len-1;
            return (len1/2);
       }
}
class Rodcutting{
    public static void main(String args[] ) throws Exception {
        
        
            Scanner sc=new Scanner(System.in);
            int q=sc.nextInt();
            TestClass tc=new TestClass();
            for(int i=1;i<=q;i++)
            {
                int rod_length=sc.nextInt();
                int res=tc.rod_cut(rod_length);
                System.out.println(res);
            }
     }
}
