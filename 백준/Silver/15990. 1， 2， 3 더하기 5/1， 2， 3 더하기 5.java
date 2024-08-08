import java.io.*;

public class Main {
    static long[][] dp;
    static int mod = 1000000009;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        dp = new long[100001][4];
        solution(100000);
        
        int t = Integer.valueOf(br.readLine());
        while(t-->0) {
        	int n = Integer.valueOf(br.readLine());
    		System.out.println((dp[n][1]+dp[n][2]+dp[n][3])%mod);
        }		
	}

	static void solution(int n) {
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i=4;i<n+1;i++) {
			dp[i][1] = (dp[i-1][2]+dp[i-1][3])%mod;
			dp[i][2] = (dp[i-2][1]+dp[i-2][3])%mod;
			dp[i][3] = (dp[i-3][1]+dp[i-3][2])%mod;
		}
	}

}
