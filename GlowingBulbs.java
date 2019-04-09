//import java.util.*;
import java.io.*;
class GlowingBulbs{
    static long primes[];
    static int len=0;
    static long binarySearch(long k,String s)
    {
        long low=1;
        long high=(long)Math.pow(10,18);
        while(low<high)
        {
            long mid=low+(high-low)/2;
            if(valid(mid,k,s))
            high=mid;
            else
            low=mid+1;
        }
        return low;
    }
    
    static long glowingnumber(long n,int curpos,long denom,int l)
    {
        if(curpos==len)
        return 0;
        long include=0;
        long nextdenom=denom*primes[curpos];
        include=glowingnumber(n,curpos+1,nextdenom,l+1)+((long)(Math.pow(-1,l+1)))*(n/nextdenom);
        long exclude=glowingnumber(n,curpos+1,denom,l);
        return include+exclude;
    }
    
    static boolean valid(long mid,long k,String s)
    {
        long glowno=glowingnumber(mid,0,1,1);
        if(glowno>=k)
        return true;
        return false;
    }
    
    public static void main(String args[] ) throws Exception {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
         int t=Integer.parseInt(br.readLine());
         for(int i=0;i<t;i++)
         {
             String s=br.readLine();
             long k=Long.parseLong(br.readLine());
             primes=new long[12];
             len=0;
             for(int j=0;j<s.length();j++)
             {
                 if(s.charAt(j)=='1')
                 primes[len++]=j+1;
             }
             bw.write(Long.toString(binarySearch(k,s)));
             bw.newLine();
         }
         br.close();
         bw.close();
    }
}