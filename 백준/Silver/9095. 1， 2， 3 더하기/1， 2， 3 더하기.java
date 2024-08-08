import java.io.*;

public class Main {
    static int[] dp;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());
		dp = new int[12];
		
		solution(11);
		
		while(t-->0) {
			int n = Integer.valueOf(br.readLine());
			
			System.out.println(dp[n]);
		}
	}

	static void solution(int n) {
		dp[1] = 1;
		if(n>1) dp[2] = 2;
		if(n>2) dp[3] = 4;
		if(n>3) dp[4] = 7;
		
		for(int i=4;i<n+1;i++)
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		
	}

}
