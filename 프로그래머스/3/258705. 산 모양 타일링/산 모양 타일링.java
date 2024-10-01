class Solution {
    static int[][] dp;
	static int mod = 10007;
    public int solution(int n, int[] tops) {
        int answer = 0;
       
        dp = new int[n][2];	//마지막이 마름모타일 X | O
        dp[0][0] = tops[0]+2;
        dp[0][1] = 1;
        
        for(int i=1;i<n;i++) {
        	dp[i][0] = (dp[i-1][0]*(tops[i]+2)+dp[i-1][1]*(tops[i]+1))%mod;
        	dp[i][1] = (dp[i-1][0]+dp[i-1][1])%mod;
        }
        
        return answer = (dp[n-1][0]+dp[n-1][1])%mod;
    }
}