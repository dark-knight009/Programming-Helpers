import java.io.*;
import java.util.*;

public class Merge_K_Sorted_Lists 
{
    public static class Pair implements Comparable<Pair>
    {
        int li;
        int di;
        int val;
        Pair(int li, int di, int val)
        {
            this.li = li;
            this.di = di;
            this.val = val;
        }
        
        public int compareTo(Pair obj)
        {
            return (this.val - obj.val);
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0;i<lists.size();i++)
      {
          List<Integer> li = lists.get(i);
        //   System.out.println(li.get(0));
          Pair rp = new Pair(i,0,li.get(0));
          pq.add(rp);
      }
      while(pq.size()>0)
      {
          Pair tp = pq.remove();
          rv.add(tp.val);
          tp.di++;
          if(tp.di<lists.get(tp.li).size())
          {
              tp.val = lists.get(tp.li).get(tp.di);
              pq.add(tp);
          }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}