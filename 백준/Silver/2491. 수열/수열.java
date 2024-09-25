import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = Integer.valueOf(st.nextToken());
		
		int[][] dp = new int[n+1][2];	//증가
		int[][] dp2 = new int[n+1][2];	//감소
				
		dp[0][0] = 1;
		dp[0][1] = list[0];
		dp2[0][0] = 1;
		dp2[0][1] = list[0];
		
		for(int i=1;i<n;i++) {
			if(dp[i-1][1]<=list[i])
				dp[i][0] = dp[i-1][0]+1;
			else 
				dp[i][0] = 1;
			
			if(dp2[i-1][1]>=list[i])
				dp2[i][0] = dp2[i-1][0]+1;
			else 
				dp2[i][0] = 1;
			

			dp[i][1] = list[i];
			dp2[i][1] = list[i];
		}
		int max = 0;
		
		for(int i=0;i<n+1;i++) {
			max = Math.max(max, dp[i][0]);
			max = Math.max(max, dp2[i][0]);
		}
		
		System.out.println(max);
	}

}
