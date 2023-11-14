import java.util.Scanner;

public class B9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int idx=0;idx<t;idx++) {
			int n = sc.nextInt();
			int[][] list = new int[2][n+1];
			
			for(int i=0;i<2;i++)
				for(int j=1;j<n+1;j++)
					list[i][j] = sc.nextInt();
			
			System.out.println(solution(list));
		}
	}

	private static int solution(int[][] list) {
		int n = list[0].length-1;
		int[][] dp = new int[2][n+1];
		dp[0][1] = list[0][1];
		dp[1][1] = list[1][1];
		
		for(int i=2;i<n+1;i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+list[0][i];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+list[1][i];
		}
		
		return Math.max(dp[0][n], dp[1][n]);
	}

}
