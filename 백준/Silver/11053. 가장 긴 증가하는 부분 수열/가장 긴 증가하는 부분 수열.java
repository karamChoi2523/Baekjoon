import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] dp = new int[n+1];	//각 인덱스(단계)에서의 그 값이 마지막일 때 최대 길이
		
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		
		dp[0]=1;
		
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}

}
