import java.util.Arrays;
import java.util.Scanner;

public class B2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[5001];
		
		dp[3] = 1;
		dp[4] = -1;
		dp[5] = 1;
		
		for(int i=5;i<n+1;i++) {
			if(i%5==0)
				dp[i] = i/5;
			else if(i%5==1 || i%5==3)
				dp[i] = i/5+1;
			else if(i%5==2 || i%5==4)
				dp[i] = i/5+2;
			
			if(i==4 || i==7)
				dp[i]=-1;
		}
		
		System.out.println(dp[n]);
	}

}
