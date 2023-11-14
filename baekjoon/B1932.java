import java.util.Scanner;

public class B1932 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] tree = new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<=i;j++)
				tree[i][j]=sc.nextInt();
		
		int[][] dp = new int[n][n];
		
		dp[0][0] = tree[0][0];
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==0)
					dp[i][j] = tree[i][j]+dp[i-1][j];
				
				else if(i==j)
					dp[i][j] = tree[i][j]+dp[i-1][j-1];
				else
					dp[i][j] = tree[i][j]+Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		int max=0;
		for(int e : dp[n-1])
			max = Math.max(max, e);
		
		System.out.println(max);
	}

}
