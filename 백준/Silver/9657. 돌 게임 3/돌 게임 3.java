import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] dp = new int[n+5];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;		
		dp[4] = 1;
		
		for(int i=5;i<n+1;i++) {
			if(dp[i-1]==2 || dp[i-3]==2 || dp[i-4]==2)
				dp[i] = 1;
			else
				dp[i] = 2;
		}
		
		if(dp[n]==1)
			System.out.println("SK");
		else
			System.out.println("CY");
	}

}
