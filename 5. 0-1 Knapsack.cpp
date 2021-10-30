class Solution
{
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n) 
    { 
       vector<vector<int>> dp(n+1, vector<int> (W+1,0));
       
       for(int i=1; i<dp.size(); i++) {
           for(int j=1; j<dp[0].size(); j++) {
                dp[i][j] = dp[i-1][j];  // agar isko na uthaye to
                
                if(j >= wt[i-1]) {
                    dp[i][j] = max(dp[i][j], dp[i-1][j-wt[i-1]] + val[i-1]);  // agar utha liya to
                }
           }
       }
       
       return dp[n][W];
    }
};