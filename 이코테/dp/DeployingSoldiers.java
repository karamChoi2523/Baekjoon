import java.util.Scanner;

public class DeployingSoldiers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = sc.nextInt();
		
		int[] dp = new int[n];
		
		dp[0] = list[0];
		
		int pre = list[0];
		int res=0;
		
		for(int i=1;i<n;i++) {
			if(list[i]>pre) {
				int j=0;
				for(;j<i;j++)
					if(list[j]<list[i])
						break;
				if(j!=i) {
					if(dp[j-1]+list[i] > dp[i-1]) {
						res++;
						pre = list[i];
					}
					dp[i] = Math.max(dp[j-1]+list[i], dp[i-1]);
				}else {
					dp[i] = Math.max(list[i], dp[i-1]);
					if(list[i] > dp[i-1]) {
						pre = list[i];
						res += i-1;
					}
				}
			}else {
				dp[i] = dp[i-1]+list[i];
				pre = list[i];
			}
		}
		
		System.out.println(res);
	}
	//lis 알고리즘으로 다시 풀어볼 것.
}
