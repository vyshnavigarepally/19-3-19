import java.util.*;
import java.io.*;

  class Sort_the_array{
    public static void main(String args[] ) throws Exception {
       Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int k=in.nextInt();
        
       List<List<Integer> > bucket=new ArrayList<>();
        for(int i=0;i<k;i++){
            bucket.add(new ArrayList<>());
        }
       List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<num;i++){
            list.add(in.nextInt());
        }
       for(int i=0;i<num;i++){
           List<Integer> bucket_list=bucket.get(list.get(i)%k);
               bucket_list.add(list.get(i));
               bucket.set(list.get(i)%k,bucket_list);
        }
        for(int i=0;i<k;i++){
           
            Collections.sort(bucket.get(i)); 
        }
       for(int i=0;i<k;i++){
        
            if(bucket.get(i).size()>0){
                
                for(int j:bucket.get(k-1-i)){
                   
                    System.out.print(j+" ");
                }
            }
        }
    }
}