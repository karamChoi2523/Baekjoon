class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int mod = 1234567;
        
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<n+1;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        
        answer = dp[n];
        
        return answer;
    }
}