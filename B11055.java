import java.util.Scanner;

public class B11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] list = new int[n+1];
		
		for(int i=1;i<n+1;i++)
			list[i] = sc.nextInt();
		
		int[] dp = new int[n+1];	//i번째 항이 최댓값인 수열
		
		dp[1] = list[1];
		for(int i=1;i<n+1;i++) {
			dp[i] = list[i];
			
			for(int j=i-1;j>=1;j--)
				if(list[i]>list[j]) {
					dp[i] = Math.max(dp[j]+list[i], dp[i]);
				}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<n+1;i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
	}

}
