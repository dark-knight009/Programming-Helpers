// Required Time Complexity -> O(nlogk).
// For this sorting and then printing the last k elements will also help us
// but it will result in O(nlogn) time complexity. 

//Input--> 6 5 4 1 2 8
//         k = 2
//Output-> 6 8 

import java.util.*;
public class K_Largest_Elements 
{

   public static void main(String[] args)
   {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int[] Ar = new int[n];
       for(int i = 0;i<n;i++)
       {
           Ar[i] = sc.nextInt();
       }
       int k = sc.nextInt();
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i=0;i<n;i++)
       {
           if(i<k)
           {
               pq.add(Ar[i]);
           }
           else 
           {
               if(Ar[i]>pq.peek())
               {
                   pq.remove();
                   pq.add(Ar[i]);
               }
           }
       }
       while(pq.size()>0)
       {
           System.out.println(pq.peek());
           pq.remove();
       }
    }

}