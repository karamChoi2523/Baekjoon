import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int mod = 9901;
		
		int[][] dp = new int[n+1][3];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for(int i=2;i<n+1;i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod;
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
		}
		
		System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%mod);
	}

}
