import java.io.*;

public class Main {
    static long[][] dp;
    static long[] d;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        dp = new long[91][2];
        d = new long[91];
        
        //solution();
        //System.out.println(dp[n][0]+dp[n][1]);
        
        solution2();
        System.out.println(d[n]);
	}

	static void solution() {
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		
		for(int i=2;i<91;i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
	}
	
	static void solution2() {
		d[1] = 1;
		for(int i=2;i<91;i++)
			d[i] = d[i-1]+d[i-2];
	}
}
