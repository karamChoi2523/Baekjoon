import java.util.Scanner;

public class B2240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int w = sc.nextInt();
		
		int[] tree = new int[t+1];
		int[][][] dp = new int[1001][31][3];	//t, w, 나무번호
		
		for(int i=1;i<=t;i++)
			tree[i] = sc.nextInt();
		
		dp[0][0][1] = 0;
		dp[0][0][2] = 0;
		
		int res=0;
		
		for(int i=1;i<t+1;i++) {
			for(int j=0;j<w+1;j++) {
				if(tree[i]==1) {
					if(j==0) {
						dp[i][j][1] = dp[i-1][j][1]+1;
						continue;
					}
					dp[i][j][1] = Math.max(dp[i-1][j][1],  dp[i-1][j-1][2])+1;
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);
					res = Math.max(dp[i][j][1], dp[i][j][2]);
				}else {
					if(j==0) {
						dp[i][j][1] = dp[i-1][j][1];
						continue;
					}
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1])+1;
					res = Math.max(dp[i][j][1],  dp[i][j][2]);
				}
			}
		}
		System.out.println(res);
	}

}
