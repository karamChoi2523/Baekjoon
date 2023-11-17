import java.util.Scanner;

public class Book_Triangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<i+1;j++)
				map[i][j] = sc.nextInt();
		
		dp[0][0] = map[0][0];
		
		for(int i=1;i<n;i++)
			for(int j=0;j<i+1;j++) {
				if(j==0) {
					dp[i][j] = map[i][j]+dp[i-1][j];
				}else if(j==i) {
					dp[i][j] = map[i][j]+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+map[i][j];
				}
			}
		
		int max = dp[n-1][0];
		for(int e : dp[n-1])
			max = Math.max(e, max);
		
		System.out.println(max);
	}

}
