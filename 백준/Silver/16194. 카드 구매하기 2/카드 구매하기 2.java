import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
    static int[] dp;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.valueOf(br.readLine());
		arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++)
			arr[i] = Integer.valueOf(st.nextToken());
		
		dp = new int[n+1];
		Arrays.fill(dp, 1000*10000);
		solution(n);
		
		System.out.println(dp[n]);
	}

	static void solution(int n) {
		dp[0] = 0;
		for(int i=1;i<n+1;i++)
			for(int j=1;j<i+1;j++)
				dp[i] = Math.min(dp[i],  dp[i-j]+arr[j]);
	}

}
