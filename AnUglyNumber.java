import java.util.Scanner;

public class AnUglyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dp = new int[1001];
		
		int idx2=0,next2=2;
		int idx3=0,next3=3;
		int idx5=0,next5=5;
		
		
		dp[0]=1;
		
		for(int i=1;i<n;i++) {
			dp[i] = Math.min(next2, Math.min(next3, next5));
			
			if(dp[i] == next2) {
				idx2++;
				next2 = dp[idx2]*2;
			}
			if(dp[i]==next3) {
				idx3++;
				next3 = dp[idx3]*3;
			}
			if(dp[i]==next5) {
				idx5++;
				next5 = dp[idx5]*5;
			}
		}
			
		System.out.println(dp[n-1]);
	}

}
