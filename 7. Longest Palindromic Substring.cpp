class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
    
    bool dp[n][n];
    memset(dp,false,sizeof(dp));
    int len = 0;
    string ans = "";
    
    for(int g=0; g<n; g++) {
        for(int i=0,j=g; j<n; i++,j++) {
            if(g == 0) {
                dp[i][j] = true;
            }
            else if(g == 1) {
                if(s[i] == s[j]) dp[i][j] = true;
                else dp[i][j] = false;
            }
            else {
                if(s[i] == s[j] && dp[i+1][j-1] == true) {
                    dp[i][j] = true;
                }
                else dp[i][j] = false;
            }
            
            if(dp[i][j] == true) {
                if(len < g+1) {
                    len = g+1;
                    ans = "";
                    for(int k=i; k<=j; k++) ans += s[k];
                }
                
            }
        }
    }
        
        // Below code is just for printing the dp array
    
//     for(int i=0; i<n; i++) {
//         for(int j=0; j<n; j++) 
//             cout<<dp[i][j]<<" ";
            
//         cout<<"\n";
//     }
        
            
    
        return ans;
    }
};