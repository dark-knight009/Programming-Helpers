import java.util.*;
public class dungeon_gamee {
	static int[][] dp;
	 public  static int calculateMinimumHP(int[][] dungeon) {
	        int m = dungeon.length, n = dungeon[0].length;
	        dp = new int[m][n];
	 
	        dp[m - 1][n - 1] = (dungeon[m - 1][n - 1] > 0 ? 1 : Math.abs(dungeon[m - 1][n - 1]) + 1);

	        for (int j = n - 2; j >= 0; j--) {
	            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
	        }
	        
	        for (int i = m - 2; i >= 0; i--){
	            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
	        }

	        for (int i = m - 2; i >= 0; i--) {
	            for (int j = n - 2; j >= 0; j--) {
	                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j] - dungeon[i][j]
	                                                , dp[i][j + 1] - dungeon[i][j]));
	            }
	        }

	        return dp[0][0];
	    }
    public static void main(String args[])
    {
    	int arr[][]= {{-2,-3,3},{-5,-10,1},{10,30,-5}};
    	for(int i=0;i<arr.length;i++)
        {
       	 for(int j=0;j<arr[0].length;j++)
       	 {
       		 System.out.print(arr[i][j]+" ");
       		 
       	 }
       	 System.out.println();
        }
     calculateMinimumHP(arr);
     for(int i=0;i<arr.length;i++)
     {
    	 for(int j=0;j<arr[0].length;j++)
    	 {
         System.out.print(dp[i][j]+" ");
    }
    	 System.out.println();
     }
    }
}
