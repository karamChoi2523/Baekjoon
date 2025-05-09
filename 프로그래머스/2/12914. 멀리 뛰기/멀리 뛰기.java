class Solution {
    static long mod = 1234567;
    public long solution(int n) {
        long answer = 0;
        
        long[] dp = new long[n+1];
        dp[0] = 0;
        if(n>=1)
            dp[1] = 1;
        if(n>=2)
            dp[2] = 2;
        
        for(int i=3;i<n+1;i++)
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        answer = dp[n];
        return answer;
    }
}