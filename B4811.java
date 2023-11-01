import java.util.Scanner;

public class B4811 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] dp = new long[31][31];
		//행:온전한 알약, 열:반쪽 알약
		for(int i=1;i<31;i++)
			dp[0][i]=1;
		
		for(int i=1;i<31;i++)
			for(int j=0;j<30;j++)
				if(j==0)
					dp[i][j] = dp[i-1][j+1];
				else
					dp[i][j] = dp[i][j-1]+dp[i-1][j+1];
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = sc.nextInt();
			
			if(n==0)
				break;
			
			sb.append(dp[n][0]+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
