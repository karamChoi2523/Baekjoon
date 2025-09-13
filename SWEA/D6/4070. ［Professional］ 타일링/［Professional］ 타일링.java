import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		BigInteger[] dp = new BigInteger[251];
		dp[1] = new BigInteger("1");
		dp[2] =	new BigInteger("3");
		dp[3] = new BigInteger("5");
		dp[4] = new BigInteger("11");
		dp[5] = new BigInteger("21");
		dp[6] = new BigInteger("43");
		
		for(int i=3;i<251;i++){
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.printf("#%d %s\n",tc,dp[N].toString());
		}
	}
}
