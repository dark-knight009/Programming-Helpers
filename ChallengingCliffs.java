import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class ChallengingCliffs {
	public static void main(String args[]) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		for(int t1=0;t1<t;t1++) {
			int n=fs.nextInt();
			int []arr=new int[n];
			arr=fs.readArray(n);
			ruffleSort(arr);
			//int min=Integer.MAX_VALUE;
			Trip min=new Trip(0,0,Integer.MAX_VALUE);
			for(int i=0;i<arr.length-1;i++) {
				int val=arr[i+1]-arr[i];
				if(val<min.min) {
					min=new Trip(i,i+1,val);
				}
			}
			if(n==2)
			{
				System.out.println(arr[0]+" "+arr[1]);
				continue;
			}
			for(int i=min.j;i<arr.length;i++)
				System.out.print(arr[i]+" ");
			for(int i=0;i<min.j;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}
	}
	static class Trip{
		int min;
		int i;
		int j;
		Trip(int i,int j,int min){
			this.min=min;
			this.i=i;
			this.j=j;
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
