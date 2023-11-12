import java.util.Scanner;

public class GoldMine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		while(t>0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] map = new int[n][m];
			int[][] dp = new int[n][m];
			
			
			//m이나 n이 1일 경우 따로 처리

			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					map[i][j] = sc.nextInt();
			
			for(int i=0;i<n;i++)
			dp[i][0] = map[i][0];

			for(int j=1;j<m;j++)
				for(int i=0;i<n;i++) {
					if(i==0)
						dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j-1])+map[i][j];
					else if(i==n-1)
						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1])+map[i][j];
					else {
						int max = Math.max(dp[i][j-1], dp[i+1][j-1]);
						max = Math.max(max, dp[i-1][j-1]);
						dp[i][j] = max+map[i][j];
					}
				}


			int max=dp[0][m-1];
			for(int i=0;i<n;i++)
				max = Math.max(max, dp[i][m-1]);

			sb.append(max).append("\n");

			t--;
		}

		System.out.println(sb.toString());
	}

}
