import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int mod = (int)1e9;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		for(int i=0;i<N+1;i++)
			dp[i][1] = 1;
		
		for(int i=0;i<K+1;i++)
			dp[1][i] = i;
		
		for(int i=2;i<N+1;i++)
			for(int j=2;j<K+1;j++)
				dp[i][j] = (dp[i-1][j]+dp[i][j-1])%mod;
		
		
		System.out.println(dp[N][K]);
	}
}