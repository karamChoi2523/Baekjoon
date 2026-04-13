import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			dp[n]++;
		}
		
		for(int i=1;i<100001;i++)
			dp[i] += dp[i-1];
		
		long win=0, lose=0, draw=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int n = Integer.parseInt(st.nextToken());
			win += N-dp[n];
			lose += dp[n-1];
			draw += dp[n]-dp[n-1];
		}
		
		System.out.println(win+" "+lose+" "+draw);
	}
}
