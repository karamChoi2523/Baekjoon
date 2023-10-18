import java.util.Scanner;

public class B1904 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] dp = new long[1000001];
		
		dp[1] = 1;	//1
		dp[2] = 2;	//00 11
		//n=3, 00이 하나 -> 2+1
		//n=4, 00이 둘 -> 1+3+1
		//n=5, 00이 둘 -> 3+4+1
		//n=6, 00이 셋 -> 1+
		
		//n이 홀수 -> (00최대한 사용)2+(00 개수 하나씩 감소)+1
		//n이 짝수 -> (00최대한 사용)1+(00 개수 하나씩 감소)+1 
		
		for(int i=3;i<=n;i++)
			dp[i] = dp[i-1]%15746+dp[i-2]%15746;
		
		System.out.println(dp[n]%15746);
	}
}
