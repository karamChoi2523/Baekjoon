import java.util.Scanner;

public class B2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[][] dp = new long[91][2];

		//1, 10, 101/100,
		dp[1][0] = 0;
		dp[1][1] = 1;

		dp[2][0]=1;
		dp[2][1]=0;

		dp[3][0]=1;
		dp[3][1]=1;

		dp[4][0]=2;
		dp[4][1]=1;

		//dp[i][0] = dp[i-1][0]+dp[i-1][1]
		//dp[i][1] = dp[i-1][0]

		for(int i=4;i<91;i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}

		System.out.println(dp[n][0]+dp[n][1]);
	}

}
/*
 //1, 10, 101/100, 
		dp[1]=1;
		dp[2]=1;
		dp[3] = 2;

		for(int i=4;i<91;i++)
			dp[i] = dp[i-1]+dp[i-2];
 */
