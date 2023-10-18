import java.io.*;
import java.util.StringTokenizer;

public class B1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n];
		
		dp[0] = list[0];
		
		for(int i=1;i<n;i++)
			dp[i] = Math.max(list[i], dp[i-1]+list[i]);
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
	}
}
