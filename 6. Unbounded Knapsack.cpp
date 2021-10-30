class Solution{
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[W+1] = {0};
        
        for(int i=1; i<=W; i++) {
            for(int j=0; j<N; j++) {
                if(i - wt[j] >= 0) {
                    dp[i] = max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        
        return dp[W];
    }
};