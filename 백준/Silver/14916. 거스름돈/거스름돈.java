import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] dp = new int[100001];
		
		Arrays.fill(dp, (int)1e9);
		
		dp[2] = 1;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 3;
		dp[7] = 2;
	
		for(int i=8;i<n+1;i++) {
			if(i%2==0)
				dp[i] = Math.min(dp[i],  dp[i-2]+1);					
			if(i%5==0)
				dp[i] = Math.min(dp[i],  dp[i-5]+1);
			
			dp[i] = Math.min(dp[i], dp[i-2]+dp[i-(i-2)]);
			dp[i] = Math.min(dp[i], dp[i-5]+dp[i-(i-5)]);
		}
		if(dp[n]==(int)1e9)
			System.out.println(-1);
		else
			System.out.println(dp[n]);
	}

}
