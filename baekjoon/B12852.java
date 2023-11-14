import java.util.Scanner;

public class B12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		int[] record = new int[n+1];
		
		dp[1]=0;
		record[1] = -1;
		
		for(int i=2;i<n+1;i++) {
			dp[i] = dp[i-1]+1;
			record[i] = i-1;
			
			if(i%2==0)
				if(dp[i] > dp[i/2]+1) {
					dp[i] = dp[i/2]+1;
					record[i] = i/2;
				}
			
			if(i%3==0)
				if(dp[i] > dp[i/3]+1) {
					dp[i] = dp[i/3]+1;
					record[i] = i/3;
				}
		}
		
		System.out.println(dp[n]);
		
		int index = n;
		
		for(int i=0;i<=dp[n];i++) {
			System.out.print(index+" ");
			index = record[index];
		}
	}

}
