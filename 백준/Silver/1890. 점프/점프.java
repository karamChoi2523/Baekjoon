import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		board = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				board[i][j] = Integer.valueOf(st.nextToken());
		}
		
		dp = new long[n][n];
		
		dp[0][0] = 1;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				int next = board[i][j];
				
				if(i==n-1 && j==n-1)
					continue;
				
				if(j+next<n)
					dp[i][j+next] += dp[i][j];
				if(i+next<n)
					dp[i+next][j] += dp[i][j];
				
			}
		
		System.out.println(dp[n-1][n-1]);
	}
}
