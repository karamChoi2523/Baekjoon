import java.util.Scanner;

public class B11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//0~9
		
		int[][] dp = new int[1001][10];
		
		for(int i=0;i<10;i++)
			dp[1][i] = 1;
		
		for(int i=2;i<1001;i++) {
			for(int j=0;j<10;j++)
				for(int k=j;k<10;k++) {
					dp[i][j] = (dp[i][j]+dp[i-1][k])%10007;
				}
		}
		
		int sum=0;
		for(int e : dp[n])
			sum+=e;
		
		System.out.println(sum%10007);
	}

}
