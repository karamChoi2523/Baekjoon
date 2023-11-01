import java.util.Scanner;

public class B2293 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coin = new int[n+1];
		int[] dp = new int[k+1];
		
		for(int i=0;i<n;i++)
			coin[i] = sc.nextInt();
		
		dp[0]=1;
		for(int i=0;i<n;i++)
			for(int j=1;j<=k;j++)
				if(j>=coin[i])
					dp[j]+=dp[j-coin[i]];
		//dp[3]_1¿ø&2¿ø = dp[3]_1¿ø+dp[1]
		
		System.out.println(dp[k]);
	}

}
