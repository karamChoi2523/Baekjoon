import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] W = new int[N+1];	//무게
		int[] V = new int[N+1];	//가치
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++)
			for(int j=1;j<K+1;j++) {
				if(W[i]>j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], V[i]+dp[i-1][j-W[i]]);
			}
		
		System.out.println(dp[N][K]);
	}
}
