import java.util.Arrays;
import java.util.Scanner;

public class EfficientMonetaryComposition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = sc.nextInt();
		
		int[] dp = new int[m+1];
		
		Arrays.fill(dp, 10001);
		
		/*
		for(int i=0;i<list[0];i++)
			dp[i] = m;
		
		for(int i=list[0];i<m+1;i++) {
			dp[i]=m;
			
			for(int j=0;j<n;j++)
				if(i-list[j]>=0)
					dp[i] = Math.min(dp[i-list[j]]+1, dp[i]);
		}
		*/
		
		dp[0]=0;
		
		for(int i=0;i<n;i++) {
			for(int j=list[i];j<m+1;j++) {
				if(dp[j-list[i]]!=10001)
					dp[j] = Math.min(dp[j],  dp[j-list[i]]+1);
			}
		}
		
		if(dp[m]==10001)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
	}

}
