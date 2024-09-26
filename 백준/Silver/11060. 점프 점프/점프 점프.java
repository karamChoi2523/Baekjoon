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
		
		int[] dp = new int[n];
		Arrays.fill(dp, (int)1e9);
		
		dp[0] = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<list[i]+1;j++)
				if(i+j<n)
					dp[i+j] = Math.min(dp[i+j], dp[i]+1);
		}
		
		System.out.println(dp[n-1]==(int)1e9?-1:dp[n-1]);
	}
}
