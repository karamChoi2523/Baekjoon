import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());
		
		long[] dp = new long[1000001];
		int mod = 1000000009;
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		
		for(int i=5;i<1000001;i++)
			dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%mod;
		
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			int n = Integer.valueOf(br.readLine());
			
			sb.append(dp[n]%mod+"\n");
		}
		System.out.println(sb.toString());
	}

}
