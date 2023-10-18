import java.util.Scanner;

public class B2579 {
	static int max = Integer.MIN_VALUE;
	static int n;
	static int[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list = new int[n+1];
		
		for(int i=1;i<n+1;i++)
			list[i] = sc.nextInt();
		
		solution();
		
	}
	public static void solution() {
		int[] dp = new int[n+1];
		
		dp[1] = list[1];
		if(n>=2)
			dp[2] = list[1]+list[2];
		if(n>=3)
		dp[3] = Math.max(list[1]+list[3], list[2]+list[3]);
		
		for(int i=4;i<n+1;i++) {
			dp[i] = Math.max(dp[i-2]+list[i], dp[i-3]+list[i-1]+list[i]);
		}
		
		System.out.println(dp[n]);
		
	}
}
