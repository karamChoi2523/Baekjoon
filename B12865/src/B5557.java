import java.util.Scanner;

public class B5557 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = sc.nextInt();
		
		long[][] dp = new long[n][21];	//i번째 수까지 이용할 때 0~20번째 수 만들기 가능?
		
		dp[0][list[0]]=1;
		
		int plus;
		int minus;
		
		for(int i=1;i<n-1;i++) {
			for(int j=0;j<21;j++) {
				if(dp[i-1][j]!=0) {
					plus = j+list[i];
					minus = j-list[i];
					
					if(plus>=0 && plus<=20)
						dp[i][plus]+= dp[i-1][j];
					if(minus>=0 && minus<=20)
						dp[i][minus]+= dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n-2][list[n-1]]);	//마지막 수(n-1)는 정답이 되어야 하니까 제외->n-2
	}

}
