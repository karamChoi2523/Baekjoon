import java.util.*;

class Solution {
    static int[][] dp;
    static int mod = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        dp = new int[n+1][m+1];
        for(int[] e : puddles){
            dp[e[1]][e[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(dp[i][j]==-1){
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i==1 && j==1) continue;
                                
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%mod;
            }
        }
        answer = dp[n][m];
        
        return answer;
    }
}