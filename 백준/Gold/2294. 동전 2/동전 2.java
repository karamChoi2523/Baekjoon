import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		
		for(int i=0;i<n;i++)
			coins[i] = Integer.parseInt(br.readLine());
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, (int)1e9);
		dp[0] = 0;

		for(int i=0;i<n;i++)
			for(int j=coins[i];j<k+1;j++)
				dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
		
		System.out.println(dp[k]==(int)1e9?-1:dp[k]);
	}
}