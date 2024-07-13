import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dp;
	static int n;
	static int[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		list = new int[n+1];
		dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			list[i] = Integer.valueOf(st.nextToken())*(-1);
			dp[i] = list[i];
		}
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<i;j++)
				dp[i] = Math.min(dp[i], dp[i-j]+list[j]);
		
		int min = (int)1e9;
		for(int e : dp)
			min = Math.min(min, e);
			
		
		System.out.println((-1)*min);
	}

}
