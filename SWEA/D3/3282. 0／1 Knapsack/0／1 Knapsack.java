import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static int[] V;	//부피
	static int[] C;	//가치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		//int T = 10;
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {			
			initialize(br);
			
			int[][] dp = new int[N+1][K+1];			
			
			for(int i=1;i<N+1;i++)
				for(int j=1;j<K+1;j++)
					if(V[i]>j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(C[i]+dp[i-1][j-V[i]], dp[i-1][j]);
					}

			System.out.printf("#%d %d\n",tc,dp[N][K]);
		}
	}
	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		V = new int[N+1];	//부피
		C = new int[N+1];	//가치
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());

			V[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
		}
	}
}
