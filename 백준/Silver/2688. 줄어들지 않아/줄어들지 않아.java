import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		
		long[][] dp = new long[65][10];
		
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=1;i<65;i++)
			dp[i][0] = 1;
		
		for(int i=2;i<65;i++)
			for(int j=1;j<10;j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
			}
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = Integer.valueOf(br.readLine());
			sb.append(Arrays.stream(dp[n]).sum()+"\n");			
		}
		
		System.out.println(sb.toString());
	}
	
}
