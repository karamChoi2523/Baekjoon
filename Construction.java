import java.util.Scanner;

public class Construction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i=3;i<n+1;i++)
			dp[i] = (dp[i-1]+dp[i-2]*2)%796796;
		
		System.out.println(dp[n]%796796);
	}

}
