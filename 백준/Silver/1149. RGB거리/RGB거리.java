import java.util.Scanner;

public class Main {
	static int[][] cost;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		cost = new int[n][3];	//rgb
		dp = new int[n][3];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++)
				cost[i][j] = sc.nextInt();
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		System.out.println(Math.min(paint(n-1, 0), Math.min(paint(n-1, 1), paint(n-1, 2))));
	}

	private static int paint(int n, int color) {
		
		if(dp[n][color]==0) {
			if(color==0)
				dp[n][0] = Math.min(paint(n-1, 1), paint(n-1, 2))+cost[n][0];
			if(color==1)
				dp[n][1] = Math.min(paint(n-1, 0), paint(n-1, 2))+cost[n][1];
			if(color==2)
				dp[n][2] = Math.min(paint(n-1, 0), paint(n-1, 1))+cost[n][2];
		}
		
		return dp[n][color];
	}

}
