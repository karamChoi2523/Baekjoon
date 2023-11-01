import java.util.Scanner;

public class B17070 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][][] dp = new int[n][n][3];	//가로,대각선,세로
		int[][] map = new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[i][j]=sc.nextInt();
		
		//가로 : 이전에 가로or대각선 -> [x][y-1][0]+[x][y-1][1]
		//대각선 : 이전 상관x -> [x-1][y-1][0]+[x-1][y-1][1]+[x-1][y-1][2]
		//세로 : 이전에 세로or대각선 -> [x-1][y][1]+[x-1][y][2]
		
		dp[0][1][0]=1;
		
		for(int i=0;i<n;i++)
			for(int j=2;j<n;j++) {	//파이프는 2열부터 놓기 가능
				if(map[i][j]==1)
					continue;
				dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][1];
		
				if(i==0)
					continue;
				dp[i][j][2] = dp[i-1][j][1]+dp[i-1][j][2];
				
				if(map[i-1][j]==1 || map[i][j-1]==1)
					continue;
				dp[i][j][1] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
			}
		System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);
	}

}
