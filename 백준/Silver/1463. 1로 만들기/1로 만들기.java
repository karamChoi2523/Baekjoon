import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		dp = new int[X+1];
		Arrays.fill(dp, (int)1e9);
		dp[1] = 0;
		if(X>1) dp[2] = 1;
		if(X>2) dp[3] = 1;
		if(X>3) dp[4] = 2;
		
		int res = sol(X);
		
		System.out.println(res);
	}
	static int sol(int x) {
		if(x==1)
			return 0;
		
		if(dp[x]!=(int)1e9)
			return dp[x];

		if(x%3==0)
			dp[x] = Math.min(dp[x], sol(x/3)+1);
		if(x%2==0)
			dp[x] = Math.min(dp[x], sol(x/2)+1);
		dp[x] = Math.min(dp[x], sol(x-1)+1);
		
		return dp[x];
	}
}
