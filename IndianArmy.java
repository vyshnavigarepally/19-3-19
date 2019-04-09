/**
 * Application to help Indian by determining uncovered area
  */
import java.util.*;
import java.io.*;
 
/**
 * class which contains left and right protected boundaries
 *
 */
class ProtectedArea implements Comparable<ProtectedArea>{
	
    long leftBoundary;
    long rightBoundary;
    
    ProtectedArea(long leftBoundary,long rightBoundary)
    {
        this.leftBoundary=leftBoundary;
        this.rightBoundary=rightBoundary;
    }
    
    public int compareTo(ProtectedArea other)
    {
        if(this.leftBoundary<other.leftBoundary)
        {
        	return -1;
        }
        else if(this.leftBoundary>other.leftBoundary)
        {
        	 return 1;
        }
        return 0;
    }
}
 
public class IndianArmy {
	
	 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
 
     /**
      * method which finds unprotected area by Indian army
      */
	static void unProtectedArea(long s,long e,long n) throws Exception
	{
		PriorityQueue<ProtectedArea> p=new PriorityQueue<ProtectedArea>(); 
        long unprotected=e-s;
        
        for(int i=0;i<n;i++)
        {
            String[] cor=br.readLine().split(" ");
            long x=Long.parseLong(cor[0]);
            long power=Long.parseLong(cor[1]);
            p.add(new ProtectedArea(x-power,x+power));
        }
        
        long protectedarea=0;
        while(p.size()>1)
        {
        	ProtectedArea firstsmall=p.remove();
        	ProtectedArea secondsmall=p.remove();
            if(firstsmall.rightBoundary>=secondsmall.leftBoundary)
            {
                p.add(new ProtectedArea(firstsmall.leftBoundary,Math.max(firstsmall.rightBoundary,secondsmall.rightBoundary))); //merge two areas
            }
            else
            {
                p.add(secondsmall);
                if(firstsmall.leftBoundary>e||firstsmall.rightBoundary<s)
                {
                	continue;
                }
                if(firstsmall.leftBoundary<s)
                {
                	firstsmall.leftBoundary=s;
                }
                if(firstsmall.rightBoundary>e)
                {
                	firstsmall.rightBoundary=e;
                }
                protectedarea+=(firstsmall.rightBoundary-firstsmall.leftBoundary); //add to protected area
            }
        }
        if(!p.isEmpty())
        {
        	ProtectedArea firstsmall=p.remove();
          if(!(firstsmall.leftBoundary>e||firstsmall.rightBoundary<s)) 
          {
             if(firstsmall.leftBoundary<s)
             {
        	   firstsmall.leftBoundary=s;
             }
	         if(firstsmall.rightBoundary>e)
	         {
	        	 firstsmall.rightBoundary=e;
	         }
	         protectedarea+=(firstsmall.rightBoundary-firstsmall.leftBoundary);
          }
        }
        bw.write(Long.toString(unprotected-protectedarea));
        br.close();
        bw.close();
	}
	
	/**
	 * Main method which takes input and calls unprotectedArea method
	 */
	public static void main(String[] args) throws Exception {
        long[] input=Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        unProtectedArea(input[1],input[2],input[0]);
    }
}