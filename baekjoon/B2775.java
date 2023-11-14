import java.util.Scanner;

public class B2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int[][] dp = new int[15][15];
		
		for(int i=1;i<15;i++)
			dp[0][i]=i;
		
		for(int i=1;i<15;i++)
			for(int j=1;j<15;j++)
				if(j==1)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i][j-1]+dp[i-1][j];
		
		StringBuilder sb = new StringBuilder();
		
		while(t>0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			sb.append(dp[k][n]).append("\n");
			
			t--;
		}
		
		System.out.println(sb.toString());
	}

}
