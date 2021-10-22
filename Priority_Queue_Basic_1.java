
// Addition and deletion of element in Priority Queue is of O(log n) time complexity.
// Getting the peak element of the priority queue is of O(1) time complexity.
// By default the smaller element is given higher priority.

// Input ---> 33 2 5 1 87 96
// Output---> 1 2 5 33 87 96
import java.util.*;
public class Priority_Queue_Basic_1
{
    public static void main(String Args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            pq.add(val);
        }
        while(pq.size()>0)
        {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}