import java.io.*;

public class Main {
    static long[][] dp;
    static int mod = 1000000000;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        dp = new long[n+1][10];
        solution(n);
        
        long answer = 0;
        for(int i=0;i<10;i++) {
        	answer += dp[n][i];
        }
        
    	System.out.println(answer%mod);	
	}

	static void solution(int n) {
		for(int i=1;i<10;i++)
			dp[1][i] = 1;
		
		for(int i=2;i<n+1;i++)
			for(int j=0;j<10;j++) {
				if(j-1>=0)
					dp[i][j]+=dp[i-1][j-1];
				if(j+1<=9)
					dp[i][j]+=dp[i-1][j+1];
				
				dp[i][j]%=mod;
			}
		
	}

}
