import java.io.*;

public class Main {
    static int[] dp;
    static int mod = 10007;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.valueOf(br.readLine());
		dp = new int[n+1];
		
		solution(n);
		
		System.out.println(dp[n]%mod);
	}

	static void solution(int n) {
		
		dp[1] = 1;
		if(n>1) dp[2] = 2;
		if(n>2) dp[3] = 3;
		
		for(int i=4;i<n+1;i++)
			dp[i] = (dp[i-1]+dp[i-2])%mod;
		
	}

}
