import java.util.Scanner;

public class B15989 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		int[][] dp = new int[10001][4];
		dp[1][1] = 1;
		
		dp[2][1] = 1;
		dp[2][2] = 1;
		
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
		}
	}

}
