import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		if(n==1) {
			System.out.println(arr[0]);
			return;
		}

		int[][] dp = new int[n][2];	//직전 밟 vs 안 밟
		dp[0][0] = arr[0];
		dp[0][1] = arr[0];
		dp[1][0] = arr[0]+arr[1];
		dp[1][1] = arr[1];
		
		for(int i=2;i<n;i++) {
			dp[i][0] = dp[i-1][1]+arr[i];
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1])+arr[i];
		}
		
		System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
	}
}
