import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());

		int[][] dp = new int[n+1][3];
		int[][] cost = new int[n+1][3];
		
		for(int i=1;i<n+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int j=0;
			while(st.hasMoreTokens()) {
				cost[i][j++] = Integer.valueOf(st.nextToken());
			}
		}
		
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for(int i=2;i<n+1;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
		}
		
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
		
	}
	
}
