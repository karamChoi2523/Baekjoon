import java.io.*;

public class Main {
	static int mod = (int)1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine()) + 1000000;
		
		long[] dp = new long[2000001];
		dp[1000001] = 1;
		
		if(n<1000000) {
			for(int i=999999;i>=n;i--)
				dp[i] = (dp[i+2] - dp[i+1])%mod;
		}else
			for(int i=1000002;i<=n;i++)
				dp[i] = (dp[i-1]+dp[i-2])%mod;

		if(dp[n]<0)
			System.out.println(-1);
		else if(dp[n]==0)
			System.out.println(0);
		else
			System.out.println(1);
		
		System.out.println(Math.abs(dp[n]));
	}

}
