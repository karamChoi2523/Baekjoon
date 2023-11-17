import java.util.Scanner;

public class MakeToOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[30001];
		
		for(int i=2;i<n+1;i++) {
			dp[i] = dp[i-1]+1;
			
			if(i%5==0)
				dp[i] = Math.min(dp[i], dp[i/5]+1);
			if(n%3==0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(n%2==0)
				dp[i] = Math.min(dp[i], dp[i/2]+1);
		}
		System.out.println(dp[n]);
	}

}
