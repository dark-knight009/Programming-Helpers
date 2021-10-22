package Practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class BoatsCompetition {
	public static void main(String args[]) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		for(int t1=0;t1<t;t1++) {
			int n=fs.nextInt();
			int []arr=new int[n];
			arr=fs.readArray(n);
			int []store=new int[101];
			int maxpairs=Integer.MIN_VALUE;
			for(int totalweight=2;totalweight<store.length;totalweight++) {
				int []count=new  int[101];
				int pair=0;
				for(int val:arr) {
					if(totalweight>val&&count[totalweight-val]!=0)
					{
						pair++;
						count[totalweight-val]--;
					}
					else
						count[val]++;
				}
				maxpairs=Math.max(maxpairs, pair);
			}
			System.out.println(maxpairs);
		}
	}
	private static int[] readArray(int n) {
		// TODO Auto-generated method stub
		return null;
	}

static final Random random=new Random();
	
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
}
}
