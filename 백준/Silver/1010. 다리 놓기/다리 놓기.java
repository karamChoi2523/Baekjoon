import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		
		for(int i=0;i<30;i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		
		for(int i=2;i<30;i++)
			for(int j=1;j<30;j++)
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
		
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());

			//int res = combi(m,n);
			System.out.println(dp[m][n]);
		}
	}

	private static int combi(int n, int r) {
		if(dp[n][r] > 0)
			return dp[n][r];
		
		if(n==r || r==0)
			return dp[n][r] = 1;
		
		return combi(n-1, r-1)+combi(n-1,r);
	}

}
